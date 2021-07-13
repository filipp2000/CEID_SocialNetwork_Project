package users;

import java.util.ArrayList;
import java.util.Scanner;


public class Network extends User{
	
	public Network() {
		
		super();
		currentUser = new User();
		users = new ArrayList<User>();
		
	}	

	
	public void login() {
		Scanner input = new Scanner(System.in);
		
		boolean loop=true;
		
		while(loop) {
			
			System.out.println("Login: ");  
			String name =input.nextLine();
			
			if(identifyUser(name)) {
				
				loop=false;

			}
		else if(identifyUser(name) == false) 
			System.out.println("User does not exist.Try again.");
			
		}
		
	}
	
		
	public boolean identifyUser(String name) {
		
		for(int i=0; i<users.size(); i++) {
			
			if(users.get(i).getUsername().equals(name)) {
				currentUser=users.get(i);
				
				return true;
			}
	}
	 return false;
		
	}
		
	
	

	public void showUserList() {
		
		System.out.println("Current user: " + getCurrUser());
		
		for(int i=0; i<users.size(); i++) {
					System.out.println((i+1)+") "+users.get(i));
				}
			
	} 
	
	
	
	
	public void deleteUser(int index) {
		
			if(users.size()!=0) {
			   users.remove(index-1); 
			}
			
			else if(users.size() == 0) {
				System.out.println("There are no users in your list!");
			}

	}
	
	public void register(User user) {
		users.add(user);
		notFriendUserList.add(user);
		
	
	}

	
	public User getCurrUser() {
		return currentUser;
	}
	
	
}
