package java8.examples;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.previousOrSame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class NewDateTImeExample {

	public static void main(String[] args) {
		LocalDateTime timePoint = LocalDateTime.now();     // The current date and time
		LocalDate.of(2012, Month.DECEMBER, 12); // from values
		LocalDate.ofEpochDay(150);  // middle of 1970
		LocalTime.of(17, 18); // the train I took home today
		LocalTime.parse("10:15:30"); // From a String
		
		
		LocalDate theDate = timePoint.toLocalDate();
		Month month = timePoint.getMonth();
		int day = timePoint.getDayOfMonth();
		timePoint.getSecond();
		
		// Set the value, returning a new object
		LocalDateTime thePast = timePoint.withDayOfMonth(
		    10).withYear(2010);

		/* You can use direct manipulation methods, 
		    or pass a value and field pair */
		LocalDateTime yetAnother = thePast.plusWeeks(
		    3).plus(3, ChronoUnit.WEEKS);
		
		
		LocalDateTime foo = timePoint.with(lastDayOfMonth());
//		LocalDateTime bar = timePoint.with(previousOrSame(ChronoUnit.WEDNESDAY));

		// Using value classes as adjusters
		timePoint.with(LocalTime.now()); 

		LocalTime time = LocalTime.now();
		LocalTime truncatedTime = time.truncatedTo(ChronoUnit.SECONDS);
	}

}
