
public class Crimer {
	private int crimer_id;
	private String name;
	private String address;
	public Crimer(int crimer_id, String name, String address) {
		super();
		this.crimer_id = crimer_id;
		this.name = name;
		this.address = address;
	}
	public Crimer() {
		super();
	}
	
	
	public int getCrimer_id() {
		return crimer_id;
	}
	public void setCrimer_id(int crimer_id) {
		this.crimer_id = crimer_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	

}
