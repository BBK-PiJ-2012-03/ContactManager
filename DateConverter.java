import java.util.*;
import java.text.*;
public class DateConverter {
	
	public static String date2String(Calendar date) {
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String result = myFormat.format(date.getTime());
		return result;
	}
	
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
