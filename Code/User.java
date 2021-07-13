package users;

import java.util.ArrayList;
import java.util.Scanner;


public class User extends Wall{

	
		protected User currentUser;
		protected User receiver;
		
			
		private String username;
		private String email;
		
		private Wall wall;
		
		protected ArrayList<User> users;
		protected ArrayList<User> friendList;
		protected ArrayList<User> pendingFriendList;
		protected ArrayList<User> notFriendUserList;
		
		
		public User(String username, String email) {

			this.username = username;
			this.email = email;
			
			receiver = new User();
			
			friendList = new ArrayList<User>();
			pendingFriendList = new ArrayList<User>();
			notFriendUserList = new ArrayList<User>();
			
			wall = new Wall();
		
			
		}
		
		//Default constr.
		
		public User() {

			friendList = new ArrayList<User>();
			pendingFriendList = new ArrayList<User>();
			notFriendUserList = new ArrayList<User>();
			
		}		
	
		
		public void showWall() {
			showMessages();
		}
		
		
		public void like() {
			receiver.showMessages();
			System.out.println("Choose the post you want to like: ");
			try {
				int i = (chooseFromLists() - 1);
				receiver.messages.get(i).putLike();
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Out of bounds: " + e.getMessage());
			}
		}
		
		
		public boolean canPost() {
       
			if(friendList.size() !=0 ) {
				showFriendList();
				return true;
			}
			else if(friendList.size() == 0) {
				System.out.println("Friend list is empty.");
				return false;
			}
			else {
				System.out.println("An unknown error has occured!");
				return false;
			}
		}
		
		public void chooseFriendsWall() {
			
			
			System.out.println("Choose the friend you want to see his wall: ");
			try {
				int i = (chooseFromLists() -1);
				friendList.get(i).showWall();
					
				//	currWall= friendList.get(i);
				receiver = friendList.get(i);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Out of bounds: " + e.getMessage());
			
			}		
		
		}	
		
		
		
		public void createMessage(User user) {
		
			Message mes = new Message(user,setText());
			messages.add(mes);
			
		}
	
		public void createReply(User user) {
		//	currWall.showMessages();
			receiver.showMessages();
			System.out.println("Choose the number of the message you want to reply: "); 
			try {
				int i = (chooseFromLists() -1) ;
				ReplyMessage rpl = new ReplyMessage(user,setText());
				//currWall.messages.get(i).addReply(rpl);
				receiver.messages.get(i).addReply(rpl);
		  } catch (IndexOutOfBoundsException e) {
				System.out.println("Out of bounds: " + e.getMessage());
			}
			
			
		}
		
		
		
		
		
		public void sendFriendReq() {
			try {
				receiver = chooseFromNotFriendList();
			if( receiver.equals(currentUser)) {
				
				System.out.println("That is you!");
			}
			
			else if(!currentUser.friendList.contains(receiver) ) {
				receiver.pendingFriendList.add(currentUser);
				currentUser.notFriendUserList.remove(receiver);
				System.out.println("Friend Request was sent!");
			}
			
			else System.out.println( receiver.getUsername()+" is already your friend");
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Out of bounds: " + e.getMessage());
			}
	}
		
		
		public int chooseFromLists() {
			Scanner input = new Scanner(System.in); 
			
			int number = 0;
			boolean isNumber;
			
			
			do {
			
					if(input.hasNextInt()) {
						number =input.nextInt();
						isNumber =true;
					}
					else {
						System.out.println("Invalid choice.Try again!");
						isNumber =false;
						input.next();
					}
				
			} while(!isNumber);
			return number;
			
		}
		
	
		public User chooseFromNotFriendList() {
			showNotFriendList();
			System.out.println("Choose the number of the user you want:");
			int i =chooseFromLists();
			receiver = notFriendUserList.get(i-1);
									
			return receiver;
				
		}
		
			
	
		public void acc_rejFrReq() {
			
		if(currentUser.showPendingFrList()) {
			System.out.println("Choose the friend request you want to accept or reject: ");
			int i = chooseFromLists();
			
			boolean isString = false;
			Scanner input = new Scanner(System.in);
			
						
			do {
				System.out.println("Accept or Reject this friend request?");
				String word = input.next();
					
				if(word.equals("accept")) {
					
					try {
							currentUser.friendList.add(currentUser.pendingFriendList.get(i - 1));
							receiver = currentUser.pendingFriendList.get(i-1);
							receiver.friendList.add(currentUser);
							currentUser.pendingFriendList.remove(i-1);
							//currentUser.notFriendUserList.remove(i-1);
							
							
							System.out.println("User added to your friend list!");
							isString =true;
						} catch (IndexOutOfBoundsException e) {
							
							System.out.println("Out of bounds: " + e.getMessage());
							isString =true;
						}
						
				}
				
				else if(word.equals("reject")){
					
					currentUser.pendingFriendList.remove(i-1);
					System.out.println("Friend request was rejected!");
					isString =true;
				}
				else {
					System.out.println("Invalid input.Try again!");
					isString =false;
				//	input.next();
				}
				
			}  while(!isString);
						
		}	
		else if(!showPendingFrList())
			System.out.println("You have no friend requests yet.");		
		
			
		}
			
		
		public void showFriendList() {
		
			if(friendList.size() != 0) {
				try {
					for(int i=0; i<friendList.size(); i++) 
					System.out.println((i+1)+") "+friendList.get(i));
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Array index out of bounds!!");
				}
			}
			else System.out.println("Friend list is empty!");
		}
		
		public boolean showPendingFrList() {
		
			if(pendingFriendList.size() != 0) {
				
			try {	
				for(int i=0; i<pendingFriendList.size(); i++) 
				System.out.println((i+1)+") "+pendingFriendList.get(i));
			
				} catch (IndexOutOfBoundsException e) {
				System.out.println("Out of bounds: "+ e.getMessage());
			}
			return true;
		}
		    
				return false;
		}
		
		
		public void showNotFriendList() {
			
		//	notFriendUserList.remove(currentUser);
			
		if(notFriendUserList.size() != 0) {
			
			for(int i=0; i<notFriendUserList.size(); i++) {
				System.out.println((i+1)+") "+notFriendUserList.get(i));
			}
		} 
		else System.out.println("List is empty!");
	}
		
		
		//Deletes friend number form friends list. User must be presented with numbered friends list first and decide the index.
		public void removeFriend(int index)
		{
			if(friendList.size()!=0) {
			   friendList.remove(index-1);   
			   System.out.println("Friend was successfully removed!");
		    }
			
			else if(friendList.size() == 0) { //Test to see if friends list is empty.
				System.out.println("There are no friends in your list!");
			}
		}
		
		
		
		public void seeFriendsWall() { 
			showFriendList();
			System.out.println("Choose the friend you want to post to his wall: ");
			int i = chooseFromLists();
			
	//		friendList.get(i).showWall();
			
			
		}
		
		
		
		
		public void setEmail(String email) {
			this.email = email;
		}

		public String getUsername() {
			return username;
		}

		
		public String toString() {
			return  "Username: " + username + " , Email: " + email;
		}

		
		public void insertFr(User e) {
			friendList.add(e);
		}
	

}


