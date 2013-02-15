import java.util.Calendar;
import java.util.Set;

/**
* A class to represent meetings
*
* Meetings have unique IDs, scheduled date and a list of participating contacts
*/

public class MeetingImpl implements Meeting {
	private int ID;
	private Calendar date;
	private Set<Contact> mySet;
	
	public MeetingImpl(int ID, Set<Contact> mySet, Calendar date) {
		this.ID = ID;
		this.mySet = mySet;
		this.date = date;	
	}
	
	/**
	* Returns the id of the meeting.
	*
	* @return the id of the meeting.
	*/

	public int getId() {
		return ID;
	}
	
	/**	
	* Return the date of the meeting.
	*
	* @return the date of the meeting.
	*/

	public Calendar getDate() {
		return date;
	}
	
	/**
	* Return the details of people that attended the meeting.
	*
	* The list contains a minimum of one contact (if there were
	* just two people: the user and the contact) and may contain an
	* Arbitrary number of them.
	*
	* @return the details of people that attended the meeting.
	*/

	public Set<Contact> getContacts() {
		return mySet;
	}
}	
		