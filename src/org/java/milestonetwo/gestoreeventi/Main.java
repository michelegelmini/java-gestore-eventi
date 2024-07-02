package org.java.milestonetwo.gestoreeventi;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String eventTitle;
		int eventSeats;
		GregorianCalendar eventCalendar = new GregorianCalendar();
		
		try (Scanner scanner = new Scanner(System.in)){
			
			//insert event title
			System.out.println("Ciao! Stai per creare il tuo evento!" + "\n" + "Come si chiamerà?");
			eventTitle = scanner.nextLine();
			
			
			//insert date with check validity
			boolean validDate;
			do { 
				//scanning user input
				System.out.println("Inseriamo la data in cui si terrà: " + "\n" + "anno: ");
				int eventYear = scanner.nextInt();
				System.out.println("mese: ");
				int eventMonth = scanner.nextInt();
					if (eventMonth > 12) {
						do {
								System.out.println("Inserisci un mese valido: ");
								eventMonth = scanner.nextInt();
							} while (eventMonth > 12); 
						}
				System.out.println("giorno: ");
				int eventDay = scanner.nextInt();
					if (eventDay > 31) {
						do {
								System.out.println("Inserisci un giorno valido: ");
								eventDay = scanner.nextInt();
							} while (eventDay > 31); 
						}
				
				//assign user input to event calendar
				eventCalendar.set(eventYear, eventMonth - 1, eventDay);
				
				//date validation
				validDate = eventCalendar.after(Calendar.getInstance());
				if (!(validDate)){
					System.out.println("L'evento non può essere nel passato, riprova");
				}
				
			} while (!(validDate));
			
			//insert event available seats
			do {
			System.out.println("Quanti posti ci saranno?");
			eventSeats = scanner.nextInt();
				if (eventSeats < 0) {
					System.out.println("L'evento deve avere almeno un posto!");
				}
			
			} while (eventSeats < 0);
			
			Event testEvent = new Event(eventTitle, eventCalendar, eventSeats);
			
			System.out.println("Congratulazioni! Hai creato l'evento!" + "\n" + testEvent.toString());
			System.out.println("Al momento ci sono " + testEvent.getAvailableSeats() + " posti disponibili.");
			
		}
		 
		
	
		 
	}

}
