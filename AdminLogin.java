package Ticketmanagement;

import java.util.Scanner;

public class AdminLogin {
	String name;
	String password;
	public  void login() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter user name");
		name = sc.next();
		System.out.println("Enter password");
		password = sc.next();
		if(checkCredential()) {
			System.out.println("login sucessful!");
		}
		else {
			System.out.println("invalid username or password");
			MainClass mainClass = new MainClass();
			mainClass.adminChoice();
		}
	}
	public   boolean checkCredential() {
		boolean checkCredential = false ;
		for(int i = 0 ; i < MainClass.admin.size();i++) {
			if(MainClass.admin.get(i).getUserName().equals(name) && MainClass.admin.get(i).getPassword().equals(password)) {
				checkCredential = true;
			}		

		}
		return checkCredential;
	}
}
