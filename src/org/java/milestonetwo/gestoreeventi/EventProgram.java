package org.java.milestonetwo.gestoreeventi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class EventProgram {
	
	private String title;
	private List<Event> eventList;
	private int size = eventList.size();
	
	public EventProgram(String title, List<Event> eventList) {
		this.title = title;
		this.eventList = new ArrayList<Event>();		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Event> getEventList() {
		return eventList;
	}

	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
	}

	public void addEventToList(Event eventToAdd) {
		this.eventList.add(eventToAdd);
	}
	
	public void getEventsInADate(String date) throws ParseException {
		Date dateToParse = new SimpleDateFormat("dd-MM-yyyy").parse(date);
		date = new SimpleDateFormat("E, dd MMMM yyyy").format(dateToParse.getTime());
		
		boolean areThereEvents = false;
		
		for (Event event : this.eventList) {
			if (date.equals(event.getDate())) {
				areThereEvents = true;
			} 
		}		
			if (areThereEvents == true) {
				System.out.println("The events at " + date + " are:");
				for (Event event : this.eventList) {
					if (date.equals(event.getDate())) {
						System.out.println(event.toString());
					}
			}
			}
			else {
				System.out.println("There are no event at " + date);
			}		
		
	}
	
	public String howManyEvents() {
		return "There are " + this.size + " events in program";
	}
	
	public void emptyList() {
		if (size > 0) {
			this.eventList.clear();
			System.out.println("You cancelled all the events");
		} else {
			System.out.println("There are no events in program!");
		}
	}
	
	public void listOrderedByDate() {
		ArrayList arrayOfDates
		for (Event event : this.eventList) {
			event.getDate();
		}
		
		
		this.eventList.stream().sorted().toList();
	}
}
