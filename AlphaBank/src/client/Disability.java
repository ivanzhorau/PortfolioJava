package client;

public class Disability {
	private int id;
	private String type;
	
	public Disability(String[] arg) {
		id = Integer.parseInt(arg[0]);
		type = arg[1]; 
	}
	public Disability() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return type;
	}

}
