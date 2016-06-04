import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.cinchapi.concourse.Concourse;
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
		
		Iterator it = id.iterator();
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
		
		/*String word = concourse.get("word", 2);
		String meaning = concourse.get("meaning", 2);
		String usage = concourse.get("usage", 2);
		
		System.out.println("Word is "+word);
		System.out.println("Meaning is "+meaning);
		System.out.println("Usage is "+usage);*/
		Set<Long> words = concourse.find("wordId", Operator.GREATER_THAN_OR_EQUALS, 1);
		/*int id = concourse.get("wordId",1);
		System.out.println(id);*/
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
		
		//concourse.get 
		//Set<Long> words = concourse.find("wordId", Operator.GREATER_THAN_OR_EQUALS, 1);
		//System.out.println(words.size());
		
	}

	@Override
	public boolean addWord(String word, String meaning, String usage) {
		// TODO Auto-generated method stub
		Set<Long> words = concourse.find("wordId", Operator.GREATER_THAN_OR_EQUALS, 0);
		int newseq = words.size();
		
		
		
		concourse.add("word", word,newseq);
		concourse.add("meaning", meaning,newseq);
		concourse.add("usage", usage,newseq);
		concourse.add("wordId", newseq,newseq);
		
		return true;
	}
	
	
	

}
