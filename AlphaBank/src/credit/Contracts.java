package credit;

public class Contracts {
	private int id;
	private String client,credit,start,end,now,percent;
	private double cash,perc;
	private boolean isAnnuitet;
	public Contracts(int id, String client,String credit, String start,String end,String now,String percent,double cash,double perc, boolean isAnnuitet) {
			this.id=id;
			this.client=client;
			this.credit=credit;
			this.start=start;
			this.end=end;
			this.now=now;
			this.percent=percent;
			this.cash=cash;
			this.perc=perc;
			this.isAnnuitet=isAnnuitet;
			
			
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean getIsAnnuitet() {
		return isAnnuitet;
	}
	public void setIsAnnuitet(boolean isAnnuitet) {
		this.isAnnuitet = isAnnuitet;
	}
	public double getPerc() {
		return perc;
	}
	public void setPerc(double perc) {
		this.perc = perc;
	}
	public double getCash() {
		return cash;
	}
	public void setCash(double cash) {
		this.cash = cash;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getPercent() {
		return percent;
	}
	public void setPercent(String percent) {
		this.percent = percent;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getNow() {
		return now;
	}
	public void setNow(String now) {
		this.now = now;
	}
}
