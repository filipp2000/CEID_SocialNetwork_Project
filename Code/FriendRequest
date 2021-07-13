package users;

public class FriendRequest extends User{

		private User receiver;
		private User sender;
		private boolean state;
		
		
		public FriendRequest(User sender , User receiver) {
			sender= currentUser;
			this.receiver =receiver;
			state = false;

		}		
		
		
		public void showReqState() {
			if (state) 
				System.out.println("Accepted!");
		
			else if(!state) 
				System.out.println("Rejected!");
			
			else System.out.println("Pending!");
		}
		
		public User getSender() {
			return sender;
		}
		
		
}
