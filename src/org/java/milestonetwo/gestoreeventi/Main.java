package org.java.milestonetwo.gestoreeventi;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

public class Main {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		String eventTitle;
		int eventSeats;
		Calendar eventCalendar = new GregorianCalendar();
		eventCalendar = Calendar.getInstance();
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
					System.out.println("The event should have at least 10 seats!");
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
				
					if (!(testEvent.isValidDate(eventCalendar))) {
							System.out.println("The event can't take place in the past, try again");
						}							
			} while (!(testEvent.isValidDate(eventCalendar)));
			
			
			
			System.out.println("You created the event:" + "\n" + testEvent.toString());
			//testEvent.reserveSeat(10);
			System.out.println(testEvent.getStringAvailableSeats());
			

				
			System.out.println("Is your event a concert?" + "\n" + "1: Yes" + "\n" + "2: No");
			int yn = 0;
			while (yn == 0) {
				String isConcert = scanner.nextLine();
				if (isConcert.equals("Yes") || isConcert.equals("Y") ||isConcert.equals("1")) {
					System.out.println("At what thime will it start?");
					String concertStartingTime = scanner.next();
					System.out.println("How much will it cost?");
					double concertPrice = scanner.nextDouble();
					
					testEvent = new Concert(eventTitle, eventCalendar, eventSeats, concertPrice, LocalTime.parse(concertStartingTime));
					
					yn = 1;
				} else if (isConcert.equals("No") || isConcert.equals("N") || isConcert.equals("2")) {
					yn = 1;	
				}
			}
			
			
			//loop to reserve or cancel a seat
			int choice;						
			do {
				System.out.println("-----------------------------------------");
				System.out.println("What do you want to do now?" + "\n" + "1: Reserve some seats" + "\n" + "2: Cancel reservations" + "\n" + "3: Exit");
				choice = scanner.nextInt();
				scanner.nextLine();		
			
				 switch(choice) {
				 	case 1: 
				 		if (testEvent.getAvailableSeats() >= 1) {
				 			
				 			System.out.println("How many seats would you like to reserve?");
				 			int seatsToReserve = scanner.nextInt();	
				 		
					 			if (seatsToReserve > testEvent.getAvailableSeats()) {
						 			do{
						 				System.out.println("Please insert a valid number.");
						 				seatsToReserve = scanner.nextInt();					 											 		
							 		} while (seatsToReserve > testEvent.getAvailableSeats());
					 			} 
				 			
					 			 if (seatsToReserve == 1) {	
					 				testEvent.reserveSeat(seatsToReserve);
									System.out.println("Thanks, you have reserved a seat!" + "\n" + testEvent.getStringAvailableSeats());
								} else if (seatsToReserve > 1) {
									testEvent.reserveSeat(seatsToReserve);
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
				 			
				 			if (seatsToCancel == 1) {
				 				System.out.println("You cancelled " + seatsToCancel +" seat.");
				 			} else {
							System.out.println("You cancelled " + seatsToCancel +" seats.");
				 			}
				 			
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

		
	
		 
	

