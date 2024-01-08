package Ticketmanagement;

public class Admin {
private String userName ;
private String password;
private String email_id;
private String phone_no;
private	static double wallet;
	
       public Admin(String userName,String password,String email_id,String phone_no, double wallet){
 	   this.setUserName(userName);
 	   this.setPassword(password);
 	   this.setEmail_id(email_id);
 	   this.setPhone_no(phone_no);
 	   Admin.wallet = wallet;
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public String getPhone_no() {
//		return phone_no;
//	}
public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

//	public String getEmail_id() {
//		return email_id;
//	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	}
