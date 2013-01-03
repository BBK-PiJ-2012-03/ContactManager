import java.util.Calendar;
import java.util.*;
import java.util.Date;
public class MeetingTest {
	public static void main(String[] args){
		MeetingTest script = new MeetingTest();
		script.launch();
	}

	public void launch() {
		Set<Contact> mySet;
		mySet = new HashSet<Contact>();
		Contact john = new ContactImpl(1, "John");
		Contact mary = new ContactImpl(2, "Mary");
		Contact sofia = new ContactImpl(3, "Sofia");
		mySet.add(john);
		mySet.add(mary);
		mySet.add(sofia);
		
		Meeting myMeeting = new MeetingImpl(1, "dokimh", mySet);
		System.out.println("The meeting's ID is " + myMeeting.getId());
		
		
		
		//Contact[] myArray = new Contact[10];
		//myArray = mySet.toArray();
		//System.out.println(myArray.toString());
		
		
	}	

}