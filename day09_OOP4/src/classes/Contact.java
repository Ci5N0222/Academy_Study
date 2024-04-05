package classes;

public class Contact {

	private String id;
	private String name;
	private int phone;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public Contact(String id, String name, int phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}
	
	public Contact() {
		super();
	}
	
	
	
	
}
