package org.java.milestonetwo.gestoreeventi;

import java.util.List;

public class EventProgram {
	
	private String title;
	private List<Event> eventList;
	
	public EventProgram(String title, List<Event> eventList) {
		this.title = title;
		this.eventList = eventList;		
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

}
