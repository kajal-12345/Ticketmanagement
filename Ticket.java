package Ticketmanagement;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Ticket {
	String movie_name;
	int movie_id;
	double ticket_price;
	int ticket_id;
	int seat_no;
	String date ;
	String movie_time;
//	String screen_no;
	 ArrayList<Integer>  seatNo = new ArrayList<Integer> ();
	
	Ticket(int ticket_id,String movie_name,int movie_id,double ticket_price,int seat_no){
		this.movie_name = movie_name;
		this.movie_id = movie_id;
		this.ticket_price = ticket_price;
		this.ticket_id = ticket_id;
		this.seat_no = seat_no;
//		this.screen_no = screen_no;
	}
	Ticket(int ticket_id,String movie_name,int movie_id,double ticket_price,String date,String movie_time,ArrayList<Integer>  seatNo){
		this.movie_name = movie_name;
		this.movie_id = movie_id;
		this.ticket_price = ticket_price;
		this.ticket_id = ticket_id;
		this.seatNo = seatNo;
		this.date = date;
		this.movie_time = movie_time;
	}
}
