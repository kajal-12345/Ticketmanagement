package Ticketmanagement;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {
	public static ArrayList <Admin> admin = new ArrayList<Admin>();
	static ArrayList <User>  userList = new ArrayList<User>();
	public void adminChoice() {
		AdminHome adminHome = new AdminHome();
		System.out.println("Enter 0 for login");
		System.out.println("Enter 1 for register");
		Scanner sc = new Scanner (System.in);
		try {
			int input = sc.nextInt();
			switch(input) {
			case 1:AdminRegister adminregister = new AdminRegister();
			adminregister.register();
			adminregister.addUser();
			adminHome.adminPage();
			//			adminregister.getUser();
			break;
			case 0:AdminLogin adminLogin = new AdminLogin();
			adminLogin.login(); 
			adminHome.adminPage();
			break;
			default:System.out.println("invalid input");
			adminChoice();
			}

		}catch(InputMismatchException e) {
			System.out.println("invalid data type!");
			            adminChoice();
		}
	}
	public void userChoice() {
		Scanner sc = new Scanner(System.in);
		UserHome userHome = new UserHome();
		System.out.println("Enter 0 for login");
		System.out.println("Enter 1 for register");
		try {
			int input = sc.nextInt();
			switch(input) {
			case 1:UserRegister userRegister = new UserRegister();
			userRegister.register();
			userRegister.adduser();
			userHome.userPage();
			break;
			case 0:UserLogin userLogin = new UserLogin();
			userLogin.login();
			userHome.userPage();
			break;
			default:System.out.println("wrong input");
			userChoice();
			break;
			}

		}catch(InputMismatchException e) {
			System.out.println("invalid data type!");
			userChoice();
		}
	}
	public void AccountTypeChoice() {
            Scanner sc = new Scanner(System.in);
		System.out.println("Enter 0 for admin account");
		System.out.println("Enter 1 for user account");
		try {
			int input = sc.nextInt();
			switch(input){
			case 0:adminChoice();
			break;
			case 1: userChoice();
			break;
			default:System.out.println("invalid input");
			AccountTypeChoice();
			break;
			}
		}catch(InputMismatchException e) {
			System.out.println("invalid data type!");
							AccountTypeChoice();
		}


	}
	public static void main(String[] args) {
		AdminRegister adminregister = new AdminRegister();
		adminregister.create_admin();
		UserRegister userRegister  = new UserRegister();
		userRegister.create_user();
				AdminHome adminHome  =  new AdminHome();
			adminHome.add_movie();
		MainClass mainClass = new MainClass();
		mainClass.AccountTypeChoice();

		//	userHome.home();

	}
}
