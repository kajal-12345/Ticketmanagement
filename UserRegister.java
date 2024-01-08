package Ticketmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegister {
String userName;
String password;
String email_id;
String phone_no;
double wallet;
Scanner sc = new Scanner(System.in);
public  void setuserName() {	
	userName = sc.next();
}
public void setPassword() {	
	password = sc.next();
}

public void setEmail() {
	email_id = sc.next();
}
public void setPhone_no() {
	phone_no = sc.next();
}
public   boolean isValidPassword() {
	String regex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&])(?=\\S+$).{8,20}";
	Pattern p = Pattern.compile(regex);
	Matcher matcher = p.matcher(password);
	boolean matchfound = matcher.find();
	return matchfound;
}

public  boolean isValidEmail() {
	String regex ="^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";
	Pattern p = Pattern.compile(regex);
	Matcher matcher = p.matcher(email_id);
	boolean matchfound = matcher.find();
	return matchfound;
}

public  boolean isValidPh() {
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
public void adduser() {
	User user = new User(userName, password, email_id, phone_no,wallet,new ArrayList<Ticket>());
	boolean isUserExist = false;
	for(User x : MainClass.userList) {
		if(x.getUserName()==userName) {
			System.out.println("user already exist!");
			isUserExist = true;
		}
	}
	if(!isUserExist) {
		MainClass.userList.add(user);
		UserLogin.current_user = MainClass.userList.indexOf(user);
        System.out.println("account created");
	}
}
public void create_user() {
	MainClass.userList.add(new User("allen","allen123","allen@gmail.com","1234",0,new ArrayList<Ticket>()));
	MainClass.userList.add(new User("kelvin","kelvin123","kelvin@gmail.com","1234",0,new ArrayList<Ticket>()));
}

}
