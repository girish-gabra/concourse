import java.util.Scanner;

import com.cinchapi.concourse.Concourse;
public class App {

	public static void main(String[] args) {
		
	
		//Concourse concourse = Concourse.connect();
		Scanner s = new Scanner(System.in);
		
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("3. Exit");
			int ch = Integer.parseInt(s.nextLine());
			switch(ch)
			{
				case 1: System.out.println("Enter username");
						String userID = s.nextLine();
						System.out.println("Enter password");
						String password = s.nextLine();
						ManageUser manageUser = new ManageUser();
						if(manageUser.validateUser(userID, password)){
							manageUser.showOptions();
						}else{
							System.out.println("Invalid credentials");
						}
						break;
				
				case 2: break;
				
				case 3: break;
				
				default: System.out.println("Invalid choice");
			}

		s.close();
	
		
	}
}
