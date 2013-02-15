import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * A utility class that converts a string date to a Calendar date and vice versa
 *
 */

public class DateConverter {
	
	//Calendar date to String date
	public static String date2String(Calendar date) {
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String result = myFormat.format(date.getTime());
		return result;
	}
	
	//String date to Calendar date
	public static Calendar string2Date(String stringDate) {
		if (stringDate == null) {
			throw new NullPointerException ("The date is null");
		}
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			Date date = null;
		try {
			date = myFormat.parse(stringDate);
			
		}
		catch (ParseException ex) {
			ex.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		if (date!=null) {
			calendar.setTime(date);
		}
		return calendar;
	}
}	