package org.java.milestonetwo.gestoreeventi;

import java.time.LocalTime;
import java.util.Calendar;

public class Concert extends Event {
	
	private double price;
	private LocalTime startingTime;

	public Concert(String title, Calendar date, int totalSeats) {
		super(title, date, totalSeats);
		
	}
	
	public Concert(String title, Calendar date, int totalSeats, double price, LocalTime startingTime) {
		super(title, date, totalSeats);
		// TODO Auto-generated constructor stub
		this.price = price;
		this.startingTime = startingTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalTime getStartingTime() {
		return startingTime;
	}

	public void setStartingTime(LocalTime startingTime) {
		this.startingTime = startingTime;
	}
	


	public String getFormattedPrice() {
		return String.format("%,.2f", this.getPrice());
		
	}

	@Override
	public String toString() {
		return super.toString() + "\n" + "The concert will start at " + this.getStartingTime() + "\n" + "The price is: € " + this.getFormattedPrice(); 
	}

}
