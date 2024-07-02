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
		
		if (this.totalSeats <= 1) {
			this.totalSeats = totalSeats;	
		} else {
			System.out.println("Non hai inserito un numero di posti valido");
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
		
		return day + "-" + month + "-" + year;
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
	
	public int getAvailableSeats() {
		return totalSeats - reservedSeats;
	}
	
	public void reserveSeat() {
		int availableSeats = totalSeats;			
		if (availableSeats > 0) {
			reservedSeats += 1;
			availableSeats = totalSeats - reservedSeats;
		}
		
		if (availableSeats > 1) {
			System.out.println("Grazie per aver prenotato!" + "\n" + "Ci sono ancora " + availableSeats + " posti disponibili.");
		} else if (availableSeats == 1) {
			System.out.println("C'è solo un ultimo posto disponibile!");			
		} else {
			System.out.println("Non ci sono più posti disponibli.");
		}
	}
	
	public void cancelReservation() {
		reservedSeats -= 1;
		System.out.println("La tua prenotazione è annullata");
	}
	
	@Override
	public String toString() {
		return "L'evento " + this.title + " sarà in data: " + this.getDate();
	}
	
	
	
}
