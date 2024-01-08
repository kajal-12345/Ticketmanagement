package Ticketmanagement;

import java.util.Scanner;

public class UserLogin {
	String name;
	String pass;
	static int current_user;
	Scanner sc = new Scanner(System.in);
public void login() {
	System.out.println("Enter name");
	 name = sc.next();
	System.out.println("Enter password");
	 pass = sc.next();
	if(checkCredential()) {
		System.out.println("login sucessful!");
	}
	else {
		System.out.println("invalid username or password");
		MainClass mainClass = new MainClass();
		mainClass.userChoice();
	}
}
public   boolean checkCredential() {
	boolean checkCredential = false ;
	for(int i = 0 ; i < MainClass.userList.size();i++) {
		if(MainClass.userList.get(i).getUserName().equals(name) && MainClass.userList.get(i).getPassword().equals(pass)) {
			checkCredential = true;
			current_user = i;
		}		

	}
	return checkCredential;
}

}

