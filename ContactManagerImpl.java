import java.util.Calendar;
import java.util.List;
import java.util.Set;

public class ContactManagerImpl {
	int meetingCount = 0;

	int addFutureMeeting(Set<Contact> contacts, Calendar date) {
		meetingCount++;
		Meeting futureMeet = new FutureMeetingImpl(meetingCount, date, contacts);


















}