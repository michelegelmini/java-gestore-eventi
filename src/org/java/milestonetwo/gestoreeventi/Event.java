package org.java.milestonetwo.gestoreeventi;
import java.text.SimpleDateFormat;
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
		return new SimpleDateFormat("E, dd MMMM yyyy").format(date.getTime());
	}
		 
	public void setDate(Calendar date) {
			this.date = date;
			
	}
	
	public boolean isValidDate(Calendar date) {
		if (date.after(Calendar.getInstance())) {	
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
		
	public boolean canYouReserveSeat(int seatsToReserve) {
		if (seatsToReserve > 0 && seatsToReserve <= availableSeats) {
			return true;
		} else {
			return false;
		}
	}
	
	public int reserveSeat(int seatsToReserve) {	
		
				reservedSeats += seatsToReserve;
				availableSeats = totalSeats - reservedSeats;
				return this.getAvailableSeats();
					
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
