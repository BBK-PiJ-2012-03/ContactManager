import java.util.*;
import java.lang.*;

public class MeetingTest {

	
//	private Map<Integer, FutureMeeting> futureMeetings = new HashMap<Integer, FutureMeeting>();
//	private Map<Integer, Contact> savedContacts = new HashMap<Integer, Contact>();
	
	public static void main(String[] args){
		MeetingTest script = new MeetingTest();
		script.launch();
	}
	
	
	public void launch() {
/** 	Set<Contact> mySet = new HashSet<Contact>();
		
		String date = "12/02/2013 00:49";
		String date2 = "05/01/2012 19:00";
		Calendar futureDate = DateConverter.string2Date(date);
		Calendar pastDate = DateConverter.string2Date(date2);
		
		
		ContactManagerImpl yo = new ContactManagerImpl();
		yo.addNewContact("John", "malakas");
		yo.addNewContact("Mary", "alwaysLate");
		yo.addNewContact("Sofia", "mpazo");
		
		
		mySet = yo.getContacts(2,3);
	
		Set<Contact> mySet2 = yo.getContacts(1,2);
		
		yo.addFutureMeeting(mySet2, futureDate);
		
		yo.addNewPastMeeting(mySet, pastDate, "deal eklise");
		
		
		
		
		FutureMeeting myFut = yo.getFutureMeeting(1);
		
		Calendar testDate = myFut.getDate();
		
		System.out.println(DateConverter.date2String(testDate));
		
		yo.flush();
		
	
	*/
	
	ContactManagerImpl yo = new ContactManagerImpl();
	
	Contact bob = new ContactImpl(4, "bob");

		yo.addNewContact("bob", "malakas");
		
		String date3 = "12/09/2013 00:15";
		
		Set<Contact> mySet = new HashSet<Contact>();
		
		mySet = yo.getContacts(2,4);
		
		
		Calendar futureDate = DateConverter.string2Date(date3);
		yo.addFutureMeeting(mySet, futureDate);
			
		yo.flush();
		
	


		
	
		
		
	}	
	
	

}