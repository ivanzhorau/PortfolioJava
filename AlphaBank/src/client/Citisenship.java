package client;

public class Citisenship {
	private int id;
	private String citisen;
	
	public Citisenship(String[] arg) {
		id = Integer.parseInt(arg[0]);
		citisen = arg[1]; 
	}
	public Citisenship() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCitisen() {
		return citisen;
	}
	public void setCitisen(String citisen) {
		this.citisen = citisen;
	} 
	@Override
	public String toString() {
		return citisen;
	}
}
