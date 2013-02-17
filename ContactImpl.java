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

	/**
	* Returns the ID of the contact.
	*
	* @return the ID of the contact.
	*/
	
	public int getId() {
		return ID;
	}
	
	/**
	* Returns the name of the contact.
	*
	* @return the name of the contact.
	*/

	public String getName() {
		return name;
	}
	
	/**
	* Returns our notes about the contact, if any.
	*
	* If we have not written anything about the contact, the empty
	* string is returned.
	*
	* @return a string with notes about the contact, maybe empty.
	*/

	public String getNotes() {
		return notes;
	}
	
	/**	
	* Add notes about the contact.
	*
	* @param note the notes to be added
	*/
	
	public void addNotes(String note) {
		if (notes == null) {
			notes = note;
		}
		else {
		notes = notes + ". " + note;
		}
	}	
	
	//Ovverride equals method
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
	//Override hashCode method too
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