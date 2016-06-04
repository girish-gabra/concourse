import java.util.Scanner;

public class ManageUser {

	public void addUser(String userID, String password)
	{
		//
	}
	
	
	public boolean validateUser(String userID, String password)
	{
		return true;
	}
	
	
	public void showOptions()
	{
		Scanner s = new Scanner(System.in);
		char input = 'Y';
		do
		{
			System.out.println("1. Word Details");
			System.out.println("2. Show All Words");
			System.out.println("3. Add Word");
			ConcourseGRE cg = new ConcourseGRE();
			int ch = Integer.parseInt(s.nextLine());
			switch(ch)
			{
			
				case 1:	System.out.println("Enter word");
						String word = s.nextLine();
						cg.showWordDetails(word);
						break;
				
				case 2: cg.showAllWords();
						break;		
				
				case 3:	System.out.println("Enter word");
						String word1 = s.nextLine();
						System.out.println("Enter meaning");
						String meaning = s.nextLine();
						System.out.println("Enter usage");
						String usage = s.nextLine();
						cg.addWord(word1, meaning, usage);		
						break;
						
				default: System.out.println("Invalid option");
			
			
			}
			
			System.out.println("Do you want to continue ? (Y for yes. Any other key to exit) ");
			input = s.nextLine().charAt(0);
			
			
		}while(input=='Y'||input=='y');
		
		
	}
	
}
