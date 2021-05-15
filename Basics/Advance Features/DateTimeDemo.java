import java.util.*;
import java.time.*;

public class DateTimeDemo
{
	public static void main(String args[])
	{
		//Date d1 = new Date();
		//d1.setTime(-3234242323l);	
		//System.out.println(d1);
		//System.out.println(d1.getMonth());

		LocalDate date = LocalDate.now();
		System.out.println(date);
		int dd = date.getDayOfMonth();
		int mm = date.getMonthValue();
		int yy = date.getYear();

		System.out.printf("%d-%d-%d", dd, mm, yy);

		System.out.println("\n\n-----------------\n");

		LocalTime time = LocalTime.now();
		System.out.println(time);		
		int hr = time.getHour();
		int mn = time.getMinute();
		int sc = time.getSecond();
		int nn = time.getNano();
		System.out.printf("%d Hours:%d Minutes:%d Seconds.%d Nano Seconds", hr, mn, sc, nn);
	}
}