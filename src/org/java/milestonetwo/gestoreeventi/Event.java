package org.java.milestonetwo.gestoreeventi;
import java.util.Calendar;


public class Event {
	
	//instance variables
	private String title;
	private Calendar date;
	private int totalSeats;
	private int reservedSeats;
	private int availableSeats;
	
	
	//constructor	
	public Event (String title, Calendar date, int totalSeats) {
		this.title = title;
		this.reservedSeats = 0;
		this.totalSeats = totalSeats;		
		this.date = date;
		this.availableSeats = totalSeats - reservedSeats;	
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
		
		return day + "-" + month + "-" + year;
	}
		 
	

	public boolean setDate(Calendar date) {
		if (date.after(Calendar.getInstance())) {	
			this.date = date;
			return true;
			} else {
			return false;
			}
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public int getReservedSeats() {
		return reservedSeats;
	}
	
	public int getAvailableSeats() {
		return availableSeats;
	}
	
	public String getStringAvailableSeats() {				
		
		if (availableSeats > 1) {
			return "There are still " + availableSeats + " available seats.";
		} else if (availableSeats == 1) {
			return "There is only one seat left!";			
		} else {
			return "There are no more seats left.";
		}
}
		
	
	
	public int reserveSeat(int seatsToReserve) {
					
			if (availableSeats > 0) {
				reservedSeats += seatsToReserve;
				availableSeats = totalSeats - reservedSeats;
				return this.getAvailableSeats();
			} else {
				return 0;
			}
			
			
				
	}
	
	
	public int cancelReservation(int seatsToCancel) {
		if (seatsToCancel > 0 && seatsToCancel <= reservedSeats) {
			reservedSeats -= seatsToCancel;
			availableSeats = totalSeats - reservedSeats;
			return this.getAvailableSeats();
		} else {
			return 0;
		}
		
	}
	
	
	@Override
	public String toString() {
		return this.getDate() + " - " + this.title;
	}
	
	
	
}
