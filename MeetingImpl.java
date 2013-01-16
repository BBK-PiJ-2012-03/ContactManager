import java.util.Calendar;
import java.util.Set;
public class MeetingImpl implements Meeting {
	private int ID;
	private Calendar date;
	private Set<Contact> mySet;
	public String notes;
	
	public MeetingImpl(int ID, Calendar date, Set<Contact> mySet) {
		this.ID = ID;
		this.date = date;
		this.mySet = mySet;
		this.notes = "";
	}

	public int getId() {
		return ID;
	}

	public Calendar getDate() {
		return date;
	}

	public Set<Contact> getContacts() {
		return mySet;
	}
}	
		