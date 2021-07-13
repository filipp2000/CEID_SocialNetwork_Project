package users;

import java.util.ArrayList;
import java.util.Scanner;

public class Wall extends Message{

protected ArrayList<Message> messages;
	
	public Wall () {
		super();
		messages = new ArrayList<Message>();
	}
	
		
	public void insertMess(Message mess) {
		messages.add(mess);
		
	}
	
	public void showMessages() {
		if(messages.size() != 0) {
		
			for(int i=0; i<messages.size(); i++) {
				System.out.println((i+1) + ")" + messages.get(i));
			}
		}
		else System.out.println("The wall has no posts yet!");
	}
	
	
	
	public String toString() {
		return super.toString();
		
	}
}
