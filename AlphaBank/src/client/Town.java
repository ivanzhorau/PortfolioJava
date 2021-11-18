package client;

public class Town {
	private int id;
	private String name;
	
	public Town(String[] arg) {
		id = Integer.parseInt(arg[0]);
		name = arg[1]; 
	}
	public Town() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return name;
	}
}
