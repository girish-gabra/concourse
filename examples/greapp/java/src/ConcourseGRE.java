import java.util.Iterator;
import java.util.Set;

import com.cinchapi.concourse.Concourse;
import com.cinchapi.concourse.Link;
import com.cinchapi.concourse.thrift.Operator;

public class ConcourseGRE implements GREWords {

	
	private final Concourse concourse = Concourse.connect();
	
	@Override
	public void showWordDetails(String word) {
		// TODO Auto-generated method stub
		
		Set<Long> id = concourse.find("word", Operator.EQUALS, word);
		
		if(id.size()<=0){
			System.out.println("Word Not Found");
			return;
		}
		
		Iterator<Long> it = id.iterator();
		long seq = 0;
		
		
		while(it.hasNext())
		{
			seq = (long) it.next(); 
		}
		
		System.out.println("Word: "+concourse.get("word",seq));
		System.out.println("Meaning: "+concourse.get("meaning",seq));
		System.out.println("Usage: "+concourse.get("usage",seq));
		/*concourse.find("word",word)*/
		
	}
	
	public void showAllWords()
	{
		
		/*fetch the set containing all words*/
		Set<Long> words = concourse.find("wordId", Operator.GREATER_THAN_OR_EQUALS, 1);
		if(words.size()>0){
			System.out.println("Displaying All Records:");
			for(int i=1; i<=words.size();i++)
			{
				String word = concourse.get("word",i);
				System.out.println(word);
			}
		}else{
			System.out.println("No Words Present");
		}
	
	}

	@Override
	public boolean addWord(String word, String meaning, String usage,int groupId) {
		// TODO Auto-generated method stub
		Set<Long> words = concourse.find("wordId", Operator.GREATER_THAN_OR_EQUALS, 0);
		int newseq = words.size();
		
		concourse.stage();
		try{
		concourse.add("word", word,newseq);
		concourse.add("meaning", meaning,newseq);
		concourse.add("usage", usage,newseq);
		concourse.add("wordId", newseq,newseq);
		
		concourse.link("wordgroup",groupId,newseq);
		
		}
		catch(Exception e){
			System.out.println("Error while adding the word");
			concourse.abort();
			return false;
		}
		concourse.commit();
		return true;
	}
	
	
	public void createGroups()
	{
		concourse.add("groups","Emotions", 1);
		concourse.add("groups","Extremes", 2);
		concourse.add("groups","Places and Spaces", 3);
		concourse.add("groups","Society and Organization", 4);
		concourse.add("groups","Others", 5);
		
	}
	
	
	public void displayGroups()
	{
		for(int i=1;i<=5;i++){
			System.out.println(i+". "+concourse.get("groups", i));
		}
		
	}
	
	public void displayGroupWise(int groupid)
	{
		
		Set<Link> words = concourse.select("wordgroup",groupid);
		
		if(words.size()==0){
			System.out.println("No Words in this group");
			return;
		}
		
		for(Object link: words)
		{
			long id = ((Link)link).longValue();
			String word = concourse.get("word",id);
			System.out.println(word);
		}
		
		
	}
	
}
