package users;

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Main {

	public static void main(String[] args) {
		
		
		Network net = new Network();
		Menu menu = new Menu();
		
		 User user1 = new User("Filipp", "filip@gmail.com");
		 User user2 = new User("Kostas", "kost@gmail.com");
		 User user3 = new User("Dimitris", "mitsos@gmail.com");
		 User user4 = new User("Giorgos", "george@gmail.com");
		 User user5 = new User("John" , "john@gmail.com");
		 User user6 = new User("Marios" , "marios@gmail.com");
		 
		 menu.register(user1);	
	     menu.register(user2);
	     menu.register(user3);
		 menu.register(user4); 
		 menu.register(user5);
		 menu.register(user6);
	
		
		 
		 menu.runMenu();
	}
}

