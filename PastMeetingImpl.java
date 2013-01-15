public class PastMeetingImpl implements PastMeeting {
	public PastMeetingImpl(int ID, String date, Set<Contact> mySet) {
		super(int ID, Calendar date, Set<Contact> mySet);
	}

	public String getNotes() {
		return notes;
	}
}	