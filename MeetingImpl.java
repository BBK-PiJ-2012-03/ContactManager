import java.util.Calendar;
import java.util.Set;
public class MeetingImpl implements Meeting {
	private int ID;
	String date; //k kala to date, einai MONO TO DAY OF MONTH TO VAZW ETSI GIA DOKIMH
	//Create a Calendar object with the default time zone and locale
	private Set<Contact> mySet;
	private String notes;
	
	public MeetingImpl(int ID, String date, Set<Contact> mySet) {
		this.ID = ID;
		this.date = date;
		this.mySet = mySet;
		this.notes = "";
	}

	public int getId() {
		return ID;
	}

	public Calendar getDate() {
		Calendar rightNow = Calendar.getInstance();
		return(rightNow.getTime());
	}

	public Set<Contact> getContacts() {
		return mySet;
	}
}	
		