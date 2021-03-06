import java.util.Calendar;
import java.util.Set;

/**
* A meeting that was held in the past.
*
* It includes your notes about what happened and what was agreed.
*/

public class PastMeetingImpl extends MeetingImpl implements PastMeeting {
	private String notes;
	
	public PastMeetingImpl(int ID, Set<Contact> mySet, Calendar date, String notes) {
		super(ID, mySet, date);
		this.notes = notes;
	}

	/**
	* Returns the notes from the meeting.
	*
	* If there are no notes, the empty string is returned.
	*
	* @return the notes from the meeting.
	*/
	
	public String getNotes() {
		return notes;
	}
}	