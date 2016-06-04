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
			System.out.println("1. Find Meaning");
			System.out.println("2. Show All Words");
			System.out.println("3. Add Word");
			System.out.println("4. List Words of a Group");
			ConcourseGRE concourseGRE = new ConcourseGRE();
			concourseGRE.createGroups();
			//concourseGRE.displayGroups();
			int ch = Integer.parseInt(s.nextLine());
			switch(ch)
			{
			
				case 1:	System.out.println("Enter word");
						String word = s.nextLine();
						concourseGRE.showWordDetails(word);
						break;
				
				case 2: concourseGRE.showAllWords();
						break;		
				
				case 3:	System.out.println("Enter word");
						String word1 = s.nextLine();
						System.out.println("Enter meaning");
						String meaning = s.nextLine();
						System.out.println("Enter usage");
						String usage = s.nextLine();
						
						concourseGRE.displayGroups();
						System.out.println("Enter the corresponding groupid");
						int groupid = Integer.parseInt(s.nextLine());
						concourseGRE.addWord(word1, meaning, usage,groupid);		
						break;
						
				case 4: concourseGRE.displayGroups();
						int gid = Integer.parseInt(s.nextLine());
						concourseGRE.displayGroupWise(gid);
						break;	
						
				default: System.out.println("Invalid option");
			
			
			}
			
			System.out.println("Do you want to continue ? (Y for yes. Any other key to exit) ");
			input = s.nextLine().charAt(0);
			
			
		}while(input=='Y'||input=='y');
		
		
	}
	
}
