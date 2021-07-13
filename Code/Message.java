package users;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Message {
	
	private User creator;
	private Date date;
	private SimpleDateFormat sdf;
	private String text; 
	private int like;
	
	protected ArrayList<ReplyMessage> replyMess;
	
	public Message() {
		text = "";
		date = new Date();
		sdf = new SimpleDateFormat();
		replyMess = new ArrayList<ReplyMessage>();
	}
	
	public Message(User creator,String text) {
		this.text = text;
		this.creator = creator;
		date = new Date();
		sdf = new SimpleDateFormat();
		replyMess = new ArrayList<ReplyMessage>();
		like = 0;
	}

	
	
	public void addReply(ReplyMessage rmess) {
		replyMess.add(rmess);
	}
	
	public String setText() {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a post to be published on the wall: ");
		String post = input.nextLine();
		text = post;
		return text;
		
	}
	
	public void showReplies() {
		
		if(replyMess.size() != 0) {
		                                  
			for(int i = 0; i<replyMess.size(); i++) {
			System.out.println((i+1) + ")" + replyMess.get(i)); 
			}
		}
		else {
			System.out.println("The message has no replies yet.");
		}
	}
	
	public void putLike() {
		like++;
	}
	
	public String getText() {
		return text;
		
	} 
	
	public String getCreator() {
		return creator.getUsername();
	}
	
	public String toString () {
	
		return creator.getUsername()+":  " + text +"    ," + sdf.format(date) +"  Likes: " +like +"\n" +replyMess.toString();
		
	}
	
}
