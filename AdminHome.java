package Ticketmanagement;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminHome {
	static ArrayList<Movies> movies = new ArrayList<Movies>();
	public void addMovie() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter movie name");
		String movie_name = sc.next();
		System.out.println("Enter movie time");
		String movie_time = sc.nextLine();
		System.out.println("Enter movie id");
		try {
			int  movie_id = sc.nextInt();
			boolean isAlreadyExist =  false;
			for(int x = 0 ; x < movies.size();x++) {
				if(movies.get(x).movie_id == movie_id) {
					isAlreadyExist = true;
					break;
				}
				
			}

			if(movie_id > 0) {
				if(!isAlreadyExist) {
					Movies movie = new Movies(movie_name,movie_id,movie_time,"s"+movie_id,new ArrayList<Ticket>());
					movies.add(movie);
					System.out.println("added");
					for(int i = 0 ; i < 100 ; i++) {
						if(i<50) {
							Ticket tickets = new Ticket(i,movie_name,movie_id,250,i+1);
							movie.ticket.add(tickets);
						}
						else {
							Ticket tickets = new Ticket(i,movie_name,movie_id,150,i+1);
							movie.ticket.add(tickets);
						}
					}
				}else {
					System.out.println("id already exist!");
				}

			}else {
				System.out.println("invalid id");
				addMovie();
			}

		}catch(InputMismatchException e) {
			System.out.println("invalid data type!");
			addMovie();
		}
	}

	public void add_movie() {
		Movies movie1 = new Movies("pushpa",1,"11Am - 1pm","s1",new ArrayList<Ticket>());
		movies.add(movie1);
		Movies movie2 =   new Movies("kantara",2,"12pm - 2pm","s2",new ArrayList<Ticket>());
		movies.add(movie2);
		for(int i = 0 ; i < 100 ; i++) {
			if(i<50) {
				Ticket tickets = new Ticket(i,"pushpa",1,250, i+1);
				movie1.ticket.add(tickets);
			}
			else {
				Ticket tickets = new Ticket(i,"pushpa",1,150,i+1);
				movie1.ticket.add(tickets);
			}
		}
		for(int i = 0 ; i < 100 ; i++) {
			if(i<50) {
				Ticket tickets = new Ticket(i,"kantara",2,250, i+1);
				movie2.ticket.add(tickets);
			}
			else {
				Ticket tickets = new Ticket(i,"kantara",2,150,3);
				movie2.ticket.add(tickets);
			}
		}
		//		   System.out.println("added");
	}

	public void home() {
		System.out.println("movie id"+"     "+"movie name");
		for(int i = 0 ; i <movies.size();i++) {
			System.out.println(movies.get(i).movie_id+"            "+movies.get(i).movie_name);
		}
	}
	public void adminPage() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 0:Home");
		System.out.println("Enter 1:add movies");
		System.out.println("Enter 2:wallet");
		System.out.println("Enter 3:logout");
		try {
			int input = sc.nextInt();
			switch(input) {
			case 0:home();
			adminPage();
			break;
			case 1:addMovie();
			adminPage();
			break;
			case 2:AdminWallet adminWallet =  new AdminWallet();
			System.out.println(adminWallet.getWallet());
			adminPage();
			break;
			case 3:Logout logout = new Logout();
			logout.logout();
			break;
			default:System.out.println("invalid input");
			adminPage();
			}
		}catch(InputMismatchException e) {
			System.out.println("invalid data type");
			adminPage();
		}
	}
}
