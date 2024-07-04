package org.java.milestonetwo.gestoreeventi;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String eventTitle;
		int eventSeats;
		GregorianCalendar eventCalendar = new GregorianCalendar();
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		
		try (Scanner scanner = new Scanner(System.in)){
			while (true) {
			
			//insert event title
			System.out.println("Hi! You're about to create an event" + "\n" + "What will be the event title?");
			eventTitle = scanner.nextLine();
			
			
			//insert date with check validity
			boolean validDate;
			do { 
				//scanning user input
				//year
				System.out.println("When it's going to be? " + "\n" + "Year: ");
				int eventYear = scanner.nextInt();
					if (eventYear < currentYear) {
						do {
						System.out.println("The event can't take place in the past, try again");
						System.out.println("Please, insert a valid year: ");
						eventYear = scanner.nextInt();
					} while (eventYear < currentYear);
					}
				
				//month
				System.out.println("Month: ");
				int eventMonth = scanner.nextInt();
					if (eventMonth > 12) {
						do {
								System.out.println("Please, insert a valid month: ");
								eventMonth = scanner.nextInt();
							} while (eventMonth > 12); 
						}
				
				//day
					int eventDay;
					boolean validDay;
					YearMonth date = YearMonth.of(eventYear, eventMonth);
				do {	
					System.out.println("giorno: ");
					eventDay = scanner.nextInt();
					validDay = date.isValidDay(eventDay);

						if (!(validDay)) {
							System.out.println("Please, insert a valid day: ");
							eventDay = scanner.nextInt();
							validDay = date.isValidDay(eventDay);
							} 
					} while (!(validDay));
				
				//assign user input to event calendar
				eventCalendar.set(eventYear, eventMonth - 1, eventDay);
				
				//date validation
				validDate = eventCalendar.after(Calendar.getInstance());
				
				
				
				if (!(validDate)){
					System.out.println("The event can't take place in the past, try again");
				}
				
			} while (!(validDate));
			
			//insert event available seats
			do {
			System.out.println("How many seats there will be?");
			eventSeats = scanner.nextInt();
				if (eventSeats < 10) {
					System.out.println("The event shoul have at least 10 seats!");
				}
			
			} while (eventSeats < 10);
			
			Event testEvent = new Event(eventTitle, eventCalendar, eventSeats);
			
			System.out.println("You created the event:" + "\n" + testEvent.toString());
			//System.out.println("For now there are " + testEvent.getAvailableSeats() + " seats available.");
			
			//reserving seats
			System.out.println("How many seats would you like to reserve?");
			int seatsToReserve = scanner.nextInt();
			if (seatsToReserve < 0 ) {
				do {					
				System.out.println("Please insert a valid number.");
				seatsToReserve = scanner.nextInt();
				} while (seatsToReserve < 0);
			}
			testEvent.reserveSeat(seatsToReserve);	
			
			
			//System.out.println("For now there are " + testEvent.getAvailableSeats() + " seats available.");
			
			System.out.println("-----------------------------------------");
			System.out.println(testEvent.getIntAvailableSeats());
			System.out.println(testEvent.getReservedSeats());
			System.out.println("-----------------------------------------");
			
			
			
			int choiche;
						
			do {
				System.out.println("What do you want to do now?" + "\n" + "1: Reserve more seats" + "\n" + "2: Cancel reservation" + "\n" + "3: Exit");
				choiche = scanner.nextInt();
				scanner.nextLine();
				
				if (choiche > 3) {
					break;
				}
				
			
				 switch(choiche) {
				 	case 1: 
				 		if (testEvent.getIntAvailableSeats() > 1) {
				 		System.out.println("How many seats would you like to reserve?");
				 		seatsToReserve = scanner.nextInt();
				 		testEvent.reserveSeat(seatsToReserve);
				 		break;
				 		} else {
				 			System.out.println(testEvent.getAvailableSeats());
				 		}
				 	
				 	case 2:
				 		if (testEvent.getIntAvailableSeats() == testEvent.getTotalSeats()) {
				 			System.out.println("There are no seats to cancel!");
				 			break;
				 		} else {
				 		System.out.println("How many seats reservation would you like to cancel?");
				 		int seatsToCancel = scanner.nextInt();
				 		if (seatsToCancel < 0 || (seatsToCancel < testEvent.getIntAvailableSeats() && seatsToCancel < testEvent.getTotalSeats())) {
							do {					
							System.out.println("Please insert a valid number.");
							seatsToCancel = scanner.nextInt();
							} while (seatsToCancel < 0);
						}
						testEvent.cancelReservation(seatsToCancel);
				 		break;
				 		}
				 		
				 	case 3:
				 		System.out.println("Your reservation is completed, thank you. Bye!");
				 		break;
				 		
				 	default:
				 		continue;
				 } 
				
				
			 
			} while (choiche != 3);
		
	
			
			
		}
		}
		
	
		 
	}

}
