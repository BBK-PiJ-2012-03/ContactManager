import java.util.Calendar;
import java.util.*;
import java.util.Date;
public class MeetingTest {
	public static void main(String[] args){
		MeetingTest script = new MeetingTest();
		script.launch();
	}
	private int Year = 0;
	
	public void launch() {
		Set<Contact> mySet;
		mySet = new HashSet<Contact>();
		Contact john = new ContactImpl(1, "John");
		Contact mary = new ContactImpl(2, "Mary");
		Contact sofia = new ContactImpl(3, "Sofia");
		mySet.add(john);
		mySet.add(mary);
		mySet.add(sofia);
		
		Calendar myCal = new GregorianCalendar(); 
		myCal.set(1989,1,18);
		
		Meeting myMeeting = new MeetingImpl(1, myCal, mySet);
		System.out.println("The meeting's ID is " + myMeeting.getId());
		
		
		
		System.out.println(myCal.get(Year));
		
		
		//Contact[] myArray = new Contact[10];
		//myArray = mySet.toArray();
		//System.out.println(myArray.toString());
		
		
	}	

}