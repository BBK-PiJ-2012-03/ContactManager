import java.util.*;

public class MeetingTest {

	
	private Map<Integer, FutureMeeting> futureMeetings = new HashMap<Integer, FutureMeeting>();
	private Map<Integer, Contact> savedContacts = new HashMap<Integer, Contact>();
	
	public static void main(String[] args){
		MeetingTest script = new MeetingTest();
		script.launch();
	}
	private int Year = 0;
	
	public void launch() {
		Set<Contact> mySet = new HashSet<Contact>();
		Contact john = new ContactImpl(1, "John");
		Contact mary = new ContactImpl(2, "Mary");
		Contact sofia = new ContactImpl(3, "Sofia");
		mySet.add(john);
		mySet.add(mary);
		mySet.add(sofia);
		
		Calendar cal1 = Calendar.getInstance();
		
		ContactManagerImpl yo = new ContactManagerImpl();
		yo.addNewContact("John", "malakas");
		yo.addNewContact("Mary", "mounara");
		yo.addNewContact("Sofia", "mpazo");
		
		/**Iterator iterator = mySet.iterator();   
		while (iterator.hasNext()){  
			Object val = iterator.next();  
			System.out.println(val);  
		}  
		*/
		
		
	
		Set<Contact> mySet2 = yo.getContacts(1,2);
		for (Contact contact : mySet2) {
			System.out.println(contact.getName() + contact.getId());
		}
		
		//yo.addFutureMeeting(mySet,cal1);
		
		
		
		//Calendar myCal = new GregorianCalendar(); 
		//myCal.set(1989,5,18);
		
		//PastMeeting myMeeting = new PastMeetingImpl(1, myCal, mySet, "f2");
		//System.out.println("The meeting's ID is " + myMeeting.getId());
		
		//System.out.println("bawavwa " + myMeeting.getNotes() + "24224" );
		
		
		
		
		
		//System.out.println(myCal.get(Year));
		
		//Contact[] myArray = new Contact[10];
		//myArray = mySet.toArray();
		//System.out.println(myArray.toString());
		
		
	}	
	
	

}