package Ticketmanagement;

import java.util.ArrayList;

public class User {
	private String userName ;
	private String password;
	private String email_id;
	private String phone_no;
	 double wallet;
ArrayList <Ticket> buyTicket  = new ArrayList<Ticket>();
	User(String userName,String password,String email_id,String phone_no, double wallet,ArrayList <Ticket> buyTicket){
		this.setUserName(userName);
		this.setPassword(password);
		this.setEmail_id(email_id);
		this.setPhone_no(phone_no);
		this.wallet = wallet;
		this.buyTicket = buyTicket;
	}

	public void setPhone_no(String phone_no) {

		this.phone_no = phone_no;
	}

	public void setEmail_id(String email_id) {
		this.email_id = 	email_id;		
	}

	public void setPassword(String password) {
		this.password = 	password;		
	}

	public void setUserName(String userName) {
		this.userName = 		userName;	
	}

	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}


}
