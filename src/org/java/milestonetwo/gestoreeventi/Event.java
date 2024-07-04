package org.java.milestonetwo.gestoreeventi;
import java.util.Calendar;
import java.util.Scanner;

public class Event {
	
	//instance variables
	private String title;
	private Calendar date;
	private int totalSeats;
	private int reservedSeats;
	
	
	//constructors
	public Event() {
	
	}
	
	public Event (String title, Calendar date, int totalSeats) {
		this.title = title;
		this.reservedSeats = 0;
		this.totalSeats = totalSeats;		
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
		
		return day + "-" + month + "-" + year;
	}
		 
	

	public void setDate(Calendar date) {
			this.date = date;
			}

	public int getTotalSeats() {
		return totalSeats;
	}

	public int getReservedSeats() {
		return reservedSeats;
	}
	
	public int getIntAvailableSeats() {
		return totalSeats - reservedSeats;
	}
	
	public String getAvailableSeats() {
		int availableSeats = totalSeats - reservedSeats;			
				
		if (availableSeats > 1) {
			return "There are still " + availableSeats + " available seats.";
		} else if (availableSeats == 1) {
			return "There is only one seat left!";			
		} else {
			return "There are no more seats left.";
		}
}
		
	
	
	public void reserveSeat(int seatsToReserve) {
		
			int availableSeats = totalSeats;			
			if (availableSeats > 0) {
				reservedSeats += seatsToReserve;
				availableSeats = totalSeats - reservedSeats;
			} else {
				System.out.println("Please insert a valid number.");
			}
			
			if (availableSeats > 1 && seatsToReserve == 1) {
				System.out.println("Thanks, you have reserved a seat!" + "\n" + this.getAvailableSeats());
			} else if (seatsToReserve > 1) {
				System.out.println("Thanks, you have reserved " + seatsToReserve + " seats! " + this.getAvailableSeats());
			}
				
//			} else if (availableSeats == 1) {
//				System.out.println(this.getAvailableSeats());			
//			} else {
//				System.out.println(this.getAvailableSeats());
//			}
	}
	
	
	public void cancelReservation(int seatsToCancel) {
	
		
		reservedSeats -= seatsToCancel;
		
		System.out.println("Your reservation was canceled.");
		System.out.println(this.getAvailableSeats());
	}
	
	
	@Override
	public String toString() {
		return this.getDate() + " - " + this.title;
	}
	
	
	
}
