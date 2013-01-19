import java.util.*;

//A class that implements the interface Comparator, overriding the compare method to compare 2 Meetings by their dates
public class SortByDate implements Comparator<Meeting>{
	
	@Override
	public int compare(Meeting m1, Meeting m2) {
		return m1.getDate().compareTo(m2.getDate());
	}
}