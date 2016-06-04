
public interface GREWords {

	public void showWordDetails(String word);
	
	public boolean addWord(String word, String meaning, String usage,int groupId);
	
	public void showAllWords();
	
	public void createGroups();
}
