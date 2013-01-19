//The implementation of Contact Interface

public class ContactImpl implements Contact {
	private int ID;
	private String name;
	private String notes;
	
	public ContactImpl(int ID, String name) {
		this.ID = ID;
		this.name = name;
		this.notes = "";
	}

	public int getId() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public String getNotes() {
		return notes;
	}
	
	public void addNotes(String note) {
		notes = notes + "\n" + note;
	}	
}	
		
	