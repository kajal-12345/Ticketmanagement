package Ticketmanagement;

import java.util.ArrayList;

public class Movies {
String movie_name;
int movie_id;
String screen_no;
String movie_date;
//int ticket_id;
 ArrayList<Ticket> ticket = new ArrayList<Ticket>();
Movies(String movieName,int movieId,String movie_date,String screen_no ,ArrayList<Ticket> ticket){
	this.movie_name = movieName;
	this.movie_id = movieId;
	this.movie_date = movie_date;
	this.screen_no = screen_no;
}
}
