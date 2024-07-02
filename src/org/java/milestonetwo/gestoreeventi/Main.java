package org.java.milestonetwo.gestoreeventi;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Event concertone = new Event("primomaggio", new GregorianCalendar(2024, 9, 5), 500);
		
		 
		System.out.println(concertone.getDate());
		 
	}

}
