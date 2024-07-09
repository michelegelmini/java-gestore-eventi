package org.java.milestonetwo.gestoreeventi;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

public class Main {

	public static void main(String[] args) {	
		EventProgram newProgram = new EventProgram("Events", null);
				
				//loop to manage the eventlist
				while(true) {
				int eventListChoice = 0;
				do {
					Scanner scanner = new Scanner(System.in);
					System.out.println("-----------------------------------------");
					System.out.println("Please select one option: " + "\n" + 
										"1: Create new event" + "\n" + 
										"2: See the whole event program" + "\n" + 
										"3: See events in a date" + "\n" + 
										"4: See how many events are in program" + "\n" + 
										"5: Empty event list" + "\n" + 
										"6: See event list ordered by date" + "\n" +
										"7: Exit");
					
				
						eventListChoice = scanner.nextInt();
						scanner.nextLine();
						
						switch (eventListChoice) {
						case 1:
							newProgram.addEventToList(addEvent());
							
						case 2:
							System.out.println(newProgram.getEventList());
							break;
						
						case 3: 
												
							do {
								System.out.println("Which date you want to check? [dd-MM-yyyy]");
								String date = scanner.nextLine();	
									try {
										newProgram.getEventsInADate(date);
										break;	
									} catch(Exception e) {
										System.out.println("Invalid input, try again");
										continue;
									}
								
							} while (true);
							
							break;
							
						case 4:
							System.out.println(newProgram.howManyEvents());
							break;
							
						case 5:
							newProgram.emptyList();
							break;
							
						case 6:	
							newProgram.listOrderedByDate();
							break;
							
						case 7:
							System.out.println("Thanks, bye");
							scanner.close();
							break;
							
						default:
							continue;
						}
							
						
					
				} while (eventListChoice != 7);
				
		}
	}
		
			
		
		
	
	public static Event addEvent(){

		// TODO Auto-generated method stub
		
		String eventTitle;
		int eventSeats;
		Calendar eventCalendar = new GregorianCalendar();
		eventCalendar = Calendar.getInstance();
		Scanner scanner = new Scanner(System.in);
		
		
				//insert event title
				System.out.println("---------------------------------------------------");
				System.out.println("You're about to create an event" + "\n" + "What will be the event title?");
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
					try {
						Date dateToParse = new SimpleDateFormat("dd-MM-yyyy").parse(eventDate);
						eventCalendar.setTime(dateToParse);
						testEvent.setDate(eventCalendar);
			
							if (!(testEvent.isValidDate(eventCalendar))) {
									System.out.println("The event can't take place in the past, try again");
								}		
						
					} catch (Exception e) {
						System.out.println("Invalid input, try again");
						continue;
					}
					
				} while (!(testEvent.isValidDate(eventCalendar)));
				
				
				//ask if the event is a concert	
				System.out.println("Is your event a concert?" + "\n" + "1: Yes" + "\n" + "2: No");
				int yn = 0;
				while (yn == 0) {
					String isConcert = scanner.nextLine();
					if (isConcert.toLowerCase().equals("yes") || isConcert.toLowerCase().equals("y") ||isConcert.equals("1")) {
						
						System.out.println("How much will it cost?");
						double concertPrice = scanner.nextDouble();
						System.out.println("At what thime will it start? [00:00]");
						String concertStartingTime = scanner.next();
						
						testEvent = new Concert(eventTitle, eventCalendar, eventSeats, concertPrice, LocalTime.parse(concertStartingTime));
						
						yn = 1;
						
					} else if (isConcert.toLowerCase().equals("no") || isConcert.toLowerCase().equals("n") || isConcert.equals("2")) {
						yn = 1;	
					}
				}
				
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
					 		
					 		if (testEvent.getAvailableSeats() >= 1) {
					 			
					 			System.out.println("How many seats would you like to reserve?");
					 			int seatsToReserve = scanner.nextInt();	
					 		
						 			if (!(testEvent.canYouReserveSeat(seatsToReserve))) {
							 			do{
							 				System.out.println("Please insert a valid number.");
							 				seatsToReserve = scanner.nextInt();					 											 		
							 				
								 		} while (!(testEvent.canYouReserveSeat(seatsToReserve)));
						 			} 
						 			
						 			testEvent.reserveSeat(seatsToReserve);
						 			if (seatsToReserve == 1) {	
										System.out.println("Thanks, you have reserved a seat!" + "\n");
									} else if (seatsToReserve >= 2) {
										System.out.println("Thanks, you have reserved " + seatsToReserve + " seats! ");
									}
			
					 		} 
					 			System.out.println(testEvent.getStringAvailableSeats());
					 			break;
					 		
					 	
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
					 				System.out.println("You cancelled a seat reservation.");
					 			} else {
								System.out.println("You cancelled " + seatsToCancel +" seats reservations.");
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
		
		
				return testEvent;
	}
			
	}

	
		
	
	

		
	
		 
	

