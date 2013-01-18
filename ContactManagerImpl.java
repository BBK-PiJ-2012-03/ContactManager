import java.util.Calendar;
import java.util.Set;
import java.util.HashSet;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;

public class ContactManagerImpl {
	private int meetingCount = 0;
	private Map<Integer, PastMeeting> pastMeetings = new HashMap<Integer, PastMeeting>();
	private Map<Integer, FutureMeeting> futureMeetings = new HashMap<Integer, FutureMeeting>();
	private Map<Integer, Contact> savedContacts = new HashMap<Integer, Contact>();

	public int addFutureMeeting(Set<Contact> contacts, Calendar date) {		
		//Check if any contact is unknown / non-existent
		for (Contact contact : Set<Contact> contacts) {
			if (!savedcontacts.contansValue(contact)) {
				throw new IllegalArgumentEcxeption ("Contact " + contact.getName() + " is unknown / non-existent")
			}	
		}
		//Check given date is in the future
		Calendar rightNow = Calendar.getInstance();
		if (date.compareTo(rightNow) < 0 {
			throw new IllegalArgumentEcxeption("Date given is NOT a future date");
		
		//Create the meeting
		meetingCount++;
		FutureMeeting futureMeet = new FutureMeetingImpl(meetingCount, date, contacts);
		
		//Add the meeting to my Map of futureMeetings
		futureMeetings.put(futureMeet);
		
		//Finally return the meeting's id
		return futureMeet.getId();
		
	}	

	public PastMeeting getPastMeeting(int id) {
		//Check if there is a meeting with that ID happening in the future
		if (futureMeetings.containsKey(id) {
			throw new IllegalArgumentEcxeption("Error, there is a meeting with that ID happening in the future");
		}
		//According to HashMap's get() method Documentation, null is returned if the map contains no mapping for the key
		//Hence, I dont have to check separately if there is a meeting with this id
		return pastMeetings.get(id);
	}

	public FutureMeeting getFutureMeeting(int id) {
		//Check if there is a meeting with that ID happening in the past
		if (pastMeetings.containsKey(id) {
			throw new IllegalArgumentEcxeption("Error, there is a meeting with that ID happening in the past");
		}
		//According to HashMap's get() method Documentation, null is returned if the map contains no mapping for the key
		//Hence, I dont have to check separately if there is a meeting with this id
		return futureMeetings.get(id);
	}
	
	public Meeting getMeeting(int id) {
		//Check if the meeting is a PastMeeting
		if(pastMeetings.get(id)!= null) {
			return pastMeetings.get(id);
		}
		//If its not then its either a futureMeeting or no meeting(which means it will return null)
		else {
			return futureMeetings.get(id);
		}
	}	
	
	
















}