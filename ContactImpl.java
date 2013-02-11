//The implementation of Contact Interface

public class ContactImpl implements Contact {
	private int ID;
	private String name;
	private String notes;
	
	public ContactImpl(int ID, String name) {
		this.ID = ID;
		this.name = name;
		this.notes = null;
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
		if (notes == null) {
			notes = note;
		}
		else {
		notes = notes + ". " + note;
		}
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
	//Created hashCode method with Eclpise's help
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		return result;
	}
	
}	
		
	