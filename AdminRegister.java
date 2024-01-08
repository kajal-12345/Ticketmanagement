package Ticketmanagement;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class AdminRegister {
	String userName;
	String password;
	String email_id;
	String phone_no;
	static double wallet;
	
	Scanner sc = new Scanner(System.in);
	public  void setuserName() {	
		this.userName = sc.next();
	}
	public void setPassword() {	
		this.password = sc.next();
	}

	public void setEmail() {
		this.email_id = sc.next();
	}
	public void setPhone_no() {
		this.phone_no = sc.next();
	}
	public   boolean isValidPassword() {
//		String password = this.password;
		String regex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&])(?=\\S+$).{8,20}";
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(password);
		boolean matchfound = matcher.find();
		return matchfound;
	}

	public  boolean isValidEmail() {
//		String email = this.email_id;
		String regex ="^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(email_id);
		boolean matchfound = matcher.find();
		return matchfound;
	}

	public  boolean isValidPh() {
//		String phone_number = this.phone_no;
		String regex = "\\d{10}";
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(phone_no);
		boolean matchfound = matcher.find();
		return matchfound;
	}

	public void register() {
		boolean isValidPassword = true;
		System.out.println("enter user name:");
	       setuserName();		
		do {
			System.out.println("enter password");
			   setPassword();
			if(isValidPassword()) {
				isValidPassword = false;
			}	
			else {
				System.out.println("weak password!!");
			}
		}while(isValidPassword);
		boolean isValidEmail = true;
		do {
			System.out.println("enter email-id");
			   setEmail();
			if(isValidEmail()) {
				isValidEmail = false;
			}	
			else {
				System.out.println("invalid email format!!");
			}
		}while(isValidEmail);
		boolean isValidPhone = true;
		do {
			System.out.println("enter phone-no");
			  setPhone_no();
			if(isValidPh() && phone_no.length() == 10) {
				isValidPhone = false;
			}	
			else {
				System.out.println("invalid phone number!!");
			}
		}while(isValidPhone);
	}
	
	public void addUser() {
		Admin user = new Admin(userName, password, email_id, phone_no,wallet);
		boolean isUserExist = false;
		for(Admin x : MainClass.admin) {
			if(x.getUserName()==userName) {
				System.out.println("user already exist!");
				isUserExist = true;
			}
		}
		if(!isUserExist) {
			MainClass.admin.add(user);
            System.out.println("account created");
		}
	}
	public void create_admin() {
		MainClass.admin.add(new Admin("kajal","Kajal@123","kajal@gmail.com","1234",0));
		MainClass.admin.add(new Admin("sejal","sejal@123","sejal@gmail.com","1234",0));

	}
public void getUser() {
	for(Admin x : MainClass.admin) {
		System.out.println(x.getUserName());
	}
}
}
