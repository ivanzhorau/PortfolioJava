package client;

public class Marital {
	private int id;
	private String status;
	
	public Marital(String[] arg) {
		id = Integer.parseInt(arg[0]);
		status = arg[1]; 
	}
	public Marital() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return status;
	}
}
