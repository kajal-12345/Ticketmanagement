package Ticketmanagement;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserHome {
	static int movie_index;
	static char seats[] = new char[100];
	static int  reserved_seats;
	double payable_amount;
	public void home() {
		System.out.println("Movie id       "+"movie name");
		for(int index = 0 ; index <AdminHome.movies.size();index++) {
			System.out.println(AdminHome.movies.get(index).movie_id+"             "+AdminHome.movies.get(index).movie_name);
		}
		System.out.println("Enter movie id to reserve seats");
		boolean isvalidId = false;
		try {
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();

			for(int index = 0 ; index < AdminHome.movies.size();index++) {
				if(input == AdminHome.movies.get(index).movie_id) {
					movie_index = index;
					isvalidId = true;
					for(int i = 0 ;i < seats.length;i++) {

						if(i%10 == 0) {
							System.out.print("\n");

						}
						if(AdminHome.movies.get(movie_index).ticket.get(i).seat_no == 0) {
							System.out.print(seats[i]+" ");
						}
						else {
							System.out.print(i+1+" ");
						}
					}
					System.out.println();
				}
			}	

		}catch(InputMismatchException e) {
			System.out.println("invalid input type!");
			home();
		}

		//	home();
		if(!isvalidId) {
			System.out.println("wrong movie id!");
		}else{
			boolean isHouseFull = true;
			for(int i = 0 ; i < AdminHome.movies.get(movie_index).ticket.size() ; i++) {
				if(AdminHome.movies.get(movie_index).ticket.get(i).seat_no != 0) {
					isHouseFull = false;
				}
			}
			if(!isHouseFull) {
				try {
					System.out.println("Enter 1 to reserve seats");
					System.out.println("Enter 0 to go back");
					Scanner sc1 = new Scanner(System.in);
					int value = sc1.nextInt();
					switch(value) {
					case 1:book_movie();
					break;
					case 0:userPage();
					break;
					default:System.out.println("invalid input!");
					}
				}catch(InputMismatchException e) {
					System.out.println("invalid data type!");
					home();
				}
			}else {
				System.out.println("house full!");
			}

		}

	}
	public void cancel_ticket() {
		show_ticket();
		Scanner sc = new Scanner(System.in);
		boolean isValidData = false;
		try {
			System.out.println("Enter movie id to cancel ticket");
			int id = sc.nextInt();
			System.out.println("Enter ticket_id to cancel");
			int ticket_id = sc.nextInt();

			for(Ticket x : MainClass.userList.get(UserLogin.current_user).buyTicket) {
				if(x.movie_id == id && x.ticket_id == ticket_id) {
					reserved_seats = MainClass.userList.get(UserLogin.current_user).buyTicket.indexOf(x);
					System.out.println();
					for(Integer i : MainClass.userList.get(UserLogin.current_user).buyTicket.get(reserved_seats).seatNo) {
						AdminHome.movies.get(movie_index).ticket.get(i.intValue()-1).seat_no = i.intValue();
						//						System.out.println(i.intValue());
					}
					double return_money = x.ticket_price-x.ticket_price*0.3;
					//										System.out.println(return_money);
					//					AdminHome.movies.get(movie_index).ticket.get(seat_no-1).seat_no = seat_no;
					AdminRegister.wallet = AdminRegister.wallet - return_money;
					MainClass.userList.get(UserLogin.current_user).wallet +=return_money;
					MainClass.userList.get(UserLogin.current_user).buyTicket.remove(x);
					isValidData = true;
					break;
				}

			}


		}catch(InputMismatchException e) {
			System.out.println("invalid input!");
			cancel_ticket();
		}


		if(!isValidData) {
			System.out.println("invalid data");
			cancel_ticket();

		}
	}
	public void book_movie() {
		ArrayList <Integer> seatno = new ArrayList<Integer>();
		System.out.println("Enter seat-no to reserve seats");
		try {
			Scanner sc = new Scanner(System.in);
			int seat_no = sc.nextInt();
			if(seat_no > 100 || seat_no <= 0) {
				System.out.println("invalid seat no");
				book_movie();
			}
			else {
				System.out.println("how many seats you want to reserve?");
				int qty = sc.nextInt();
				boolean isalreadyReserved = false;
				for(int i = 0 ; i < AdminHome.movies.get(movie_index).ticket.size();i++) {

					try{
						int j = seat_no-1;
						while(j<seat_no-1+qty && j <= 100) {
							if(	AdminHome.movies.get(movie_index).ticket.get(j).seat_no == 0) {
								isalreadyReserved =  true;
							}
							++j;
						}
						//						
					}catch(IndexOutOfBoundsException e) {
						System.out.println("please choose valid seats");
						book_movie();
						break;
					}

				}
				if(isalreadyReserved) {
					System.out.println("already reserved");
				}
				else {
					if(seat_no-1+qty  <= 100  && qty!=0) {
						//				

						if(MainClass.userList.get(UserLogin.current_user).wallet >=AdminHome.movies.get(movie_index).ticket.get(seat_no-1).ticket_price) {
							boolean isValidInput = true;

							//							System.out.println("you have to pay total "+payable_amount +"Rs." );
							do {
								Scanner sc1 = new Scanner(System.in);
								System.out.println("Enter 1 to pay ");
								System.out.println("Enter 0 to go back");

								try {
									int input = sc1.nextInt();
									if(input == 1) {
										isValidInput = false;
										int j = seat_no-1;
										payable_amount = 0;
										//										seatno.clear();
										while(j < seat_no-1 + qty && j < 100) {
											payable_amount += AdminHome.movies.get(movie_index).ticket.get(j).ticket_price;
											AdminHome.movies.get(movie_index).ticket.set(j,
													new Ticket(AdminHome.movies.get(movie_index).ticket.get(j).ticket_id,
															AdminHome.movies.get(movie_index).ticket.get(j).movie_name,
															AdminHome.movies.get(movie_index).ticket.get(j).movie_id,
															AdminHome.movies.get(movie_index).ticket.get(j).ticket_price,
															0));

											seatno.add(j+1);
											//											System.out.println(j);
											j++;
											if(j==100) {
												j = j-1;
												break;
											}
											//								             System.out.println(j);
										}
											DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
										   LocalDateTime now = LocalDateTime.now();  
										MainClass.userList.get(UserLogin.current_user).buyTicket.add(new Ticket(
												AdminHome.movies.get(movie_index).ticket.get(j).ticket_id,
												AdminHome.movies.get(movie_index).ticket.get(j).movie_name,
												AdminHome.movies.get(movie_index).ticket.get(j).movie_id,
												payable_amount,
												dtf.format(now),
												AdminHome.movies.get(movie_index).movie_date,
												seatno));

										//										
										System.out.println(payable_amount);
										if(MainClass.userList.get(UserLogin.current_user).wallet >= payable_amount) {
											MainClass.userList.get(UserLogin.current_user).wallet -= payable_amount;
											AdminRegister.wallet = AdminRegister.wallet + payable_amount;
											System.out.println("payment sucessful!");
										}else {
											System.out.println("insufficient balance");
											UserWallet userWallet =  new UserWallet();
											userWallet.wallet();
										}
										for(int i = 0 ; i < seats.length;i++) {
											if(AdminHome.movies.get(movie_index).ticket.get(seat_no-1).seat_no == 0) {
												seats[i] = 'B';
											}
										}			
									}
									else if(input == 0) {
										isValidInput = false;
										userPage();
									}
									else {
										System.out.println("invalid input");
									}

								}catch(InputMismatchException e) {
									System.out.println("invalid data type!");
								}
							}while(isValidInput);
						}
						else {
							System.out.println("insufficient balance!");
							//							UserWallet userWallet =  new UserWallet();
							//							userWallet.wallet();
						}

					}
					//					else {
					//						System.out.println("you can choose seats from 1 to 100 only!");
					//						book_movie();
					//						
					//						
					//					}
				}

			}
		}catch(IndexOutOfBoundsException e) {
			System.out.println("invalid seatno");
			book_movie();
		}
		catch(InputMismatchException e) {
			System.out.println("invalid data type!");
			book_movie();
		}
	}
	public void show_ticket() {
		//	
		System.out.println("ticket_id  "+"movie id    "+"movie name     "
				+"ticket price      "+"booking date         "+"movie time        "+"screen no"+"    seat no    ");

		for(Ticket x : MainClass.userList.get(UserLogin.current_user).buyTicket ) {
			System.out.println(x.ticket_id+ "             "+x.movie_id+"           "+x.movie_name+"          "+x.ticket_price+
					"         "+x.date+"     "+x.movie_time+"           "+"s"+x.movie_id+"           "+ x.seatNo);
			//			seatno.clear();
		}
		System.out.println();
	}	
	public void userPage() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1:Home");
		System.out.println("Enter 2:wallet");
		System.out.println("Enter 3:show ticket");
		System.out.println("Enter 4:cancel ticket");
		System.out.println("Enter 5:logout");
		try {
			int input = sc.nextInt();
			switch(input) {
			case 1:
				home();
				userPage();
				break;
			case 2:UserWallet userWallet = new UserWallet();
			userWallet.wallet();
			userPage();
			break;
			case 3:show_ticket();
			userPage();
			break;
			case 4:cancel_ticket();
			userPage();
			break;
			case 5:Logout logout = new Logout();
			logout.logout();
			break;
			default:System.out.println("invalid input");
			userPage();
			}

		}catch(InputMismatchException e) {
			System.out.println("invalid data type!");
			userPage();
		}
	}
}
