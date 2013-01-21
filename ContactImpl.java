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
	
	@Override
    public boolean equals(Object obj) {
       if (obj == null) {
        return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ContactImpl contact = (ContactImpl) obj;
		if (this.ID != contact.getId()) {
			return false;
		}
		if (!this.name.equals(contact.getName())) {
			return false;
		}
		if (!this.notes.equals(contact.getNotes())) {
			return false;
		}
		return true;
	}
	
}	
		
	