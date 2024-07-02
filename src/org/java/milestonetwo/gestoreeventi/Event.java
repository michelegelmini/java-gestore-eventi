package org.java.milestonetwo.gestoreeventi;
import java.util.Calendar;

public class Event {
	
	//instance variables
	private String title;
	private Calendar date;
	private int totalSeats;
	private int reservedSeats;
	
	//constructor
	public Event (String title, Calendar date, int totalSeats) {
		this.title = title;
		this.reservedSeats = 0;
		if (this.totalSeats >= 1) {
			this.totalSeats = totalSeats;	
		}
		this.date = date;
		
	}

	//getters and setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		int day = date.get(Calendar.DAY_OF_MONTH);
		int month = date.get(Calendar.MONTH) + 1; 
		int year = date.get(Calendar.YEAR);
		
		return "L'evento sarà in data: " + day + "-" + month + "-" + year;
	}
		 
	

	public void setDate(Calendar date) {
		while (!(date.after(Calendar.getInstance()))) {
			System.out.println("Non hai inserito una data valida, riprova");
		}
		this.date = date;
		
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public int getReservedSeats() {
		return reservedSeats;
	}
	
	
	
	
	
}
