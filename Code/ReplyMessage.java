package users;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReplyMessage extends Message{

	private Date date;
	private SimpleDateFormat sdf;
	
	
	public ReplyMessage(User creator,String text) {
		super(creator,text);
		date = new Date();
		sdf = new SimpleDateFormat();
	}
	
	@Override
	public String setText() {
		return super.setText();
	}
	
	
	public String toString () {
		return "Reply by "+ getCreator()+":  " + getText()+ "   ,"+sdf.format(date); 
	}

}
