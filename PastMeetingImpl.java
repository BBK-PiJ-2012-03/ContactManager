import java.util.Calendar;
import java.util.Set;
public class PastMeetingImpl extends MeetingImpl implements PastMeeting {
	public PastMeetingImpl(int ID, Calendar date, Set<Contact> mySet) {
		super(ID, date, mySet);
	}

	public String getNotes() {
		return notes;
	}
}	