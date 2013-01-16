import java.util.Calendar;
import java.util.Set;
public class FutureMeetingImpl extends MeetingImpl implements FutureMeeting  {

	public FutureMeetingImpl(int ID, Calendar date, Set<Contact> mySet) {
		super(ID, date, mySet);
	}
}