package UtilityClasses;

public class DataPOJO {

	
	private String id;
	private String email;
	private String first_name;
	private String last_name;
	private String avatar;
	@Override
	public String toString() {
		return "DataPOJO [id=" + id + ", email=" + email + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", avatar=" + avatar + ", getId()=" + getId() + ", getEmail()=" + getEmail() + ", getFirst_name()="
				+ getFirst_name() + ", getLast_name()=" + getLast_name() + ", getAvatar()=" + getAvatar()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public String setEmail(String email) {
		this.email = email;
		return email;
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
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
}
