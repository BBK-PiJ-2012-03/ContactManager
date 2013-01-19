import java.util.*;
import java.io.IOException;


public class ContactManagerImpl {
	private int meetingCount = 0;
	private int contactCount = 0;
	private Map<Integer, PastMeeting> pastMeetings = new HashMap<Integer, PastMeeting>();
	private Map<Integer, FutureMeeting> futureMeetings = new HashMap<Integer, FutureMeeting>();
	private Map<Integer, Contact> savedContacts = new HashMap<Integer, Contact>();

	public int addFutureMeeting(Set<Contact> contacts, Calendar date) {		
		//Check if any contact is unknown / non-existent
		contacts = new HashSet<Contact>(contacts);
		for (Contact contact : contacts) {
			if (!savedContacts.containsValue(contact)) {
				throw new IllegalArgumentException ("Contact " + contact.getName() + " is unknown / non-existent");
			}	
		}
		//Check given date is in the future
		Calendar rightNow = Calendar.getInstance();
		if (date.compareTo(rightNow) < 0) {
			throw new IllegalArgumentException("Date given is NOT a past date");
		}
		//Create the meeting
		meetingCount++;
		FutureMeeting futureMeet = new FutureMeetingImpl(meetingCount, contacts, date);
		
		//Add the meeting to my Map of futureMeetings
		futureMeetings.put(futureMeet.getId(),futureMeet);
		
		//Finally return the meeting's id
		return futureMeet.getId();
		
	}	

	public PastMeeting getPastMeeting(int id) {
		//Check if there is a meeting with that ID happening in the future
		if (futureMeetings.containsKey(id)) {
			throw new IllegalArgumentException("Error, there is a meeting with that ID happening in the future");
		}
		//According to HashMap's get() method Documentation, null is returned if the map contains no mapping for the key
		//Hence, I dont have to check separately if there is a meeting with this id
		return pastMeetings.get(id);
	}

	public FutureMeeting getFutureMeeting(int id) {
		//Check if there is a meeting with that ID happening in the past
		if (pastMeetings.containsKey(id)) {
			throw new IllegalArgumentException("Error, there is a meeting with that ID happening in the past");
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
	
	public List<Meeting> getFutureMeetingList(Contact contact) {
		//Check if contact is unknown / non-existent
			if (!savedContacts.containsValue(contact)) {
				throw new IllegalArgumentException ("Contact " + contact.getName() + " is unknown / non-existent");
			}
		//Create a new Meeting List copying my futureMeetings Map.
		List<Meeting> contactMeetings = new LinkedList<Meeting>(futureMeetings.values());
		
		//Removing all meetings that are not with the desired contact
		for (Meeting meeting : contactMeetings) {
			if(!meeting.getContacts().contains(contact)) {
				contactMeetings.remove(meeting);
			}
		}
		
		//Now sort the contactMeetings list chronologically
		Collections.sort(contactMeetings, new SortByDate());
		
		return contactMeetings;
	}
	
	public List<Meeting> getFutureMeetingList(Calendar date) {
		
		//Create a new Meeting List copying my futureMeetings Map.
		List<Meeting> dateMeetings = new LinkedList<Meeting>(futureMeetings.values());
		
		//Removing all meetings that are not with the desired contact
		for (Meeting meeting : dateMeetings) {
			if(!meeting.getDate().equals(date)) {
				dateMeetings.remove(meeting);
			}
		}
		
		//Now sort the dateMeetings list chronologically
		Collections.sort(dateMeetings, new SortByDate());
		
		return dateMeetings;
	}
	
	public List<PastMeeting> getPastMeetingList(Contact contact) {
		//Check if contact is unknown / non-existent
			if (!savedContacts.containsValue(contact)) {
				throw new IllegalArgumentException ("Contact " + contact.getName() + " is unknown / non-existent");
			}
		//Create a new Meeting List copying my pastMeetings Map.
		List<PastMeeting> contactMeetings = new LinkedList<PastMeeting>(pastMeetings.values());
		
		//Removing all meetings that are not with the desired contact
		for (PastMeeting meeting : contactMeetings) {
			if(!meeting.getContacts().contains(contact)) {
				contactMeetings.remove(meeting);
			}
		}
		
		//Now sort the pastMeetings list chronologically
		Collections.sort(contactMeetings, new SortByDate());
		
		return contactMeetings;
	}
	
	public void addNewPastMeeting(Set<Contact> contacts, Calendar date, String text) {		
		//Check if date is null
		if (date == null) {
			throw new NullPointerException ("The date is null");
		}
		//Check if text is null
		if (text == null) {
			throw new NullPointerException ("The text is null");
		}
		//Check if the list of contacts is Empty
		if (contacts.size() == 0) {
			throw new IllegalArgumentException("The list of contacts you entered is Empty");
		}
		//Check if any contact is unknown / non-existent
		contacts = new HashSet<Contact>(contacts);
		for (Contact contact : contacts) {
			if (!savedContacts.containsValue(contact)) {
				throw new IllegalArgumentException ("Contact " + contact.getName() + " is unknown / non-existent");
			}	
		}
		//Check given date is in the past
		Calendar rightNow = Calendar.getInstance();
		if (date.compareTo(rightNow) > 0) {
			throw new IllegalArgumentException("Date given is NOT a future date");
		}
		//Create the meeting
		meetingCount++;
		PastMeeting pastMeet = new PastMeetingImpl(meetingCount, contacts, date, text);
		
		//Add the meeting to my Map of futureMeetings
		pastMeetings.put(pastMeet.getId(), pastMeet);
	}	
	
	public void addMeetingNotes(int id, String text) {
		//Check if the notes entered are null
		if (text == null) {
			throw new NullPointerException ("The notes you entered are null");
		}
		//Check if the meeting with this id is past or future meeting
		
		//A) It is a pastMeeting, so i want to add the new notes to it
		if (pastMeetings.containsKey(id)) {  
			PastMeeting meeting = pastMeetings.get(id);
			String finalNotes = (meeting.getNotes() + "\n" + text);
			//Recreat the meeting with the new notes
			meeting = new PastMeetingImpl(meeting.getId(), meeting.getContacts(), meeting.getDate(), finalNotes);
			//Remove the old meeting from my pastMeetings map
			pastMeetings.remove(id);
			//Add the meeting with the new notes
			pastMeetings.put(id, meeting);
		}
		
			
		
		
		//Check if a meeting with this id exists either as a past or a future meeting
		if (!pastMeetings.containsKey(id) && !futureMeetings.containsKey(id)) {
			throw new IllegalArgumentException("A meeting with this id does NOT exist");
		}
	}	
		
		
		
		
		
		
	public void addNewContact(String name, String notes) {
		//Check if name is null
		if (name == null) {
			throw new NullPointerException ("The name you entered is null");
		}
		
		//Check if notes are null
		if (notes == null) {
			throw new NullPointerException ("The notes you entered are null");
		}
		
		//Create new Contact
		contactCount++;
		Contact contact = new ContactImpl(contactCount, name);
		
		//Add the notes
		contact.addNotes(notes);
		
		//Finally add the newContact to the savedContacts Map
		savedContacts.put(contactCount,contact);
	}	
		
	public Set<Contact> getContacts(int... ids) {
		//Creat the set of contacts to be returned
		Set<Contact> contacts = new HashSet<Contact>();
		
		//Check if any of the IDs does not correspond to a real contact
		for (int id : ids) {
			if(!savedContacts.containsKey(id)) {
				throw new IllegalArgumentException ("Contact with id " + id + " does not correspond to a real contact");
			}
		//Now add the to set the Contacts that have an id specified in the arguments	
			else contacts.add(savedContacts.get(id));
		}	
		
		//Finally return the set
		return contacts;
	}	
		
	public Set<Contact> getContacts(String name) {
	
		//Check if the parameter name is null
		if (name == null) {
			throw new NullPointerException ("The name to search for is null");
		}	
			
		//Create the set of contacts to be returned
		Set<Contact> contacts = new HashSet<Contact>();
		
		//Search for contacts that contain the name given in my savedContacts Map and then add them to the new Set
		for (Contact contact : savedContacts.values()) {
			if (contact.getName().contains(name)) {
				contacts.add(contact);
			}
		}
			return contacts;
	}		
		
		
	


}












