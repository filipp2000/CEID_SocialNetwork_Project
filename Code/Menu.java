package users;


import java.util.Scanner;

public class Menu extends Network{
	
	private boolean exit;
	
	
	
	public Menu() {
		
		exit =false;
		
	}	
																												
	
	public void runMenu() {
		login();
		printHeader();
		while(!exit) {
			printMenu();
			int choice = getInput();
			
			performAction(choice);
		}
	}
	
	

	public void printHeader() {
		System.out.println("+------------------------------+");
		System.out.println("|         Welcome to our       |");
		System.out.println("|  Social Network application  |");
		System.out.println("+------------------------------+");
	}
	
	public void printMenu() {
	
		System.out.println("+==============================+"); 
		System.out.println("1) See your wall\n"
				          +"2) See friend's wall\n"
				          +"3) Send friend request\n"
				          +"4) See friend requests\n"
				          +"5) See my friends\n"
			              +"6) Back\n"
			              +"7) Logout\n"
			              +"8) Close program\n");
	}
	
	
	
	
	public int getInput() {
		Scanner in = new Scanner(System.in);
		int choice =-1;
		while(choice < 1 || choice > 8) {
			try {
				System.out.println("Enter your choice: ");
			    choice = Integer.parseInt(in.nextLine());
			   }
			catch (NumberFormatException e) {
				System.out.println("Invalid selection.Please try again.");
			}
		}
		return choice;
		
	}
	
	public int getInput2() {
		Scanner in = new Scanner(System.in);
		int choice =-1;
		while(choice < 1 || choice > 3) {
			try {
				System.out.println("Enter your choice: ");
			    choice = Integer.parseInt(in.nextLine());
			   }
			catch (NumberFormatException e) {
				System.out.println("Invalid selection.Please try again.");
			}
		}
		return choice;
		
	}
	
	
	
	
	public void performAction(int choice) {
		
		
		
		switch (choice) {

		

		case 1: 

			currentUser.showWall();
			break;

		case 2:
			
			if(currentUser.canPost()) {
				
			currentUser.chooseFriendsWall();
				
			System.out.println("\nWhat would you like to do:  ");
			

			System.out.println("1) Post a message ");

			System.out.println("2) Reply to a message ");

			System.out.println("3) Like a post ");


			int Choice = getInput2();

			

			if (Choice==1){

				receiver.createMessage(currentUser);

			}

			else if (Choice==2) {

				createReply(currentUser);
				

			}

			else if (Choice==3) {

				like();

			}

			else {

				System.out.println("You didn't choose anything ");

			}
		}
			
			break;

		case 3:
		
			sendFriendReq();
			
			
			break;

		case 4:
		
			acc_rejFrReq();
			
			break;
			
		case 5:

			currentUser.showFriendList();
			
			 
			break;

		case 6:
			
			showNotFriendList();
			
			break;
		
		case 7:

			runMenu();
			break;
		
		case 8:
			
			exit =true;
			System.out.println("Thank you for using our application!");
			break;
			
		default: 
			System.out.println("An unkown error has occured!");

		}
	}
	
	
}
