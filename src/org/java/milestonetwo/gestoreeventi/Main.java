package org.java.milestonetwo.gestoreeventi;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		String eventTitle;
		int eventSeats;
		Calendar eventCalendar = new GregorianCalendar();
//		eventCalendar = Calendar.getInstance();
		Scanner scanner = new Scanner(System.in);
	
		
	while(true) {
			
		try {
			
			//insert event title
			System.out.println("Hi! You're about to create an event" + "\n" + "What will be the event title?");

			eventTitle = scanner.nextLine();
						
			//insert event available seats
			do {
			System.out.println("How many seats there will be?");
			eventSeats = scanner.nextInt();
			scanner.nextLine();
				if (eventSeats < 10) {
					System.out.println("The event shoul have at least 10 seats!");
				}
			
			} while (eventSeats < 10);
			
			Event testEvent = new Event(eventTitle, eventCalendar, eventSeats);
			
			//insert event date
			do {
				
				System.out.println("When it's going to be? [dd-MM-yyyy]");
				String eventDate = scanner.nextLine();	
				Date thedate = new SimpleDateFormat("dd-MM-yyyy").parse(eventDate);
				eventCalendar.setTime(thedate);
				testEvent.setDate(eventCalendar);
				
					if (!(testEvent.setDate(eventCalendar))) {
							System.out.println("The event can't take place in the past, try again");
						}
					
							
			} while (!(testEvent.setDate(eventCalendar)));
			
			
			
			System.out.println("You created the event:" + "\n" + testEvent.toString());
			System.out.println(testEvent.getStringAvailableSeats());
				
			
			
			//loop to reserve or cancel a seat
			int choice;						
			do {
				System.out.println("-----------------------------------------");
				System.out.println("What do you want to do now?" + "\n" + "1: Reserve some seats" + "\n" + "2: Cancel reservations" + "\n" + "3: Exit");
				choice = scanner.nextInt();
				scanner.nextLine();		
			
				 switch(choice) {
				 	case 1: 
				 		if (testEvent.getAvailableSeats() > 1) {
					 		System.out.println("How many seats would you like to reserve?");
					 		int seatsToReserve = scanner.nextInt();
					 		testEvent.reserveSeat(seatsToReserve);
					 			
					 			if (seatsToReserve > testEvent.getAvailableSeats()) {
					 				System.out.println("There are not that much seats to reserve!");
					 			} else if (testEvent.getAvailableSeats() > 1 && seatsToReserve == 1) {
									System.out.println("Thanks, you have reserved a seat!" + "\n" + testEvent.getStringAvailableSeats());
								} else if (seatsToReserve > 1) {
									System.out.println("Thanks, you have reserved " + seatsToReserve + " seats! " + testEvent.getStringAvailableSeats());
								}
					 		break;
				 		} else {
				 			System.out.println(testEvent.getStringAvailableSeats());
				 			break;
				 		}
				 	
				 	case 2:
				 		if (testEvent.getAvailableSeats() == testEvent.getTotalSeats()) {
				 			System.out.println("There are no seats to cancel!");
				 			break;
				 		} else {
				 		System.out.println("How many seats reservation would you like to cancel?");
				 		int seatsToCancel = scanner.nextInt();
				 			if (testEvent.cancelReservation(seatsToCancel) == 0) {
				 				do {					
								System.out.println("Please insert a valid number.");
								seatsToCancel = scanner.nextInt();
								} while (testEvent.cancelReservation(seatsToCancel) == 0);
								
				 			} 
							System.out.println("You cancelled " + seatsToCancel +" seats.");
							System.out.println(testEvent.getStringAvailableSeats());
						}
				 		
				 		break;
				 		
				 		
				 	case 3:
				 		System.out.println("Your reservation is completed, thank you. Bye!");
				 		break;
				 		
				 	default:
				 		continue;
				 } 
				
				
			 
			} while (choice != 3);		
			
		}
			catch (Exception e) {
				System.err.println("Invalid input, try again.");
				scanner.nextLine();
				
			
		}
	}
		
			
		
	}
	}

		
	
		 
	

