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
	
	public int getAvailableSeats() {
		return totalSeats - reservedSeats;
	}
	
	public void reserveSeat(int seatsToReserve) {
		try (Scanner scanner = new Scanner(System.in)) {
			int availableSeats = totalSeats;			
			if (availableSeats > 0) {
				reservedSeats += seatsToReserve;
				availableSeats = totalSeats - reservedSeats;
			}
			
			if (seatsToReserve < 0) {
				do {					
				System.out.println("Please insert a valid number.");
				seatsToReserve = scanner.nextInt();
				} while (seatsToReserve < 0);
			}
		
			
			if (availableSeats > 1 && seatsToReserve == 1) {
				System.out.println("Thanks, you have reserved a seat!" + "\n" + "There are still " + availableSeats + " available seats.");
			} else if (availableSeats > 1 && seatsToReserve > 1) {
				System.out.println("Thanks, you have reserved" + seatsToReserve + " seats! " + "\n" + "There are still " + availableSeats + " available seats.");
			} else if (availableSeats == 1) {
				System.out.println("There is only one seat left!");			
			} else {
				System.out.println("There are no more seats left.");
			}
	}
	}
	
	public void cancelReservation(int seatsToCancel) {
		try (Scanner scanner = new Scanner(System.in)){
		if (seatsToCancel < 0) {
			do {					
			System.out.println("Please insert a valid number.");
			seatsToCancel = scanner.nextInt();
			} while (seatsToCancel < 0);
		}
		reservedSeats -= seatsToCancel;
		
		System.out.println("Your reservation was canceled.");
	}
	}
	
	@Override
	public String toString() {
		return this.getDate() + " - " + this.title;
	}
	
	
	
}
