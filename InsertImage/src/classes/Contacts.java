package classes;


public class Contacts {

	private int contact_id;
	private String first_name , last_name;
	private byte[] photo;
	private String bass64;
	
	
	
	public String getBass64() {
		return bass64;
	}
	public void setBass64(String bass64) {
		this.bass64 = bass64;
	}
	public int getContact_id() {
		return contact_id;
	}
	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	
	
	
}
