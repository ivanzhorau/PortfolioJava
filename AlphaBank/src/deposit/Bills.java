package deposit;

public class Bills {
	private int id,idklient,idcurrent,idpercent;
	private String idNum,start,end,dName,vName;
	private boolean isUrgent;
	private double debetT,kreditT,debetP,kreditP,percent,toBYN;
	
	public Bills(String id, String idklient, String idcurrent, String idpercent,
			 String idNum, String start, String end, String dName, String isUrgent, String percent, 
			 String vName, String toBYN,String depositT, String kreditT,String depositP, String kreditP) {
		this.id = Integer.parseInt(id);
		this.idklient = Integer.parseInt(idklient);
		this.idcurrent = Integer.parseInt(idcurrent);
		this.idpercent = Integer.parseInt(idpercent);
		this.idNum = idNum;
		this.start=start;
		this.end=end;
		this.dName=dName;
		this.vName=vName;
		this.isUrgent = isUrgent.equals("1");
		this.debetT = Double.parseDouble(depositT);
		this.kreditT = Double.parseDouble(kreditT);
		this.debetP = Double.parseDouble(depositP);
		this.kreditP = Double.parseDouble(kreditP);
		this.percent = Double.parseDouble(percent);
		this.toBYN = Double.parseDouble(toBYN);
	}
	
	public int getIdpercent() {
		return idpercent;
	}
	public void setIdpercent(int idpercent) {
		this.idpercent = idpercent;
	}
	public int getIdcurrent() {
		return idcurrent;
	}
	public void setIdcurrent(int idcurrent) {
		this.idcurrent = idcurrent;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdklient() {
		return idklient;
	}
	public void setIdklient(int idklient) {
		this.idklient = idklient;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getDName() {
		return dName;
	}
	public void setDName(String dName) {
		this.dName = dName;
	}
	public String getVName() {
		return vName;
	}
	public void setVName(String vName) {
		this.vName = vName;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getIdNum() {
		return idNum;
	}
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	public boolean isIsUrgent() {
		return isUrgent;
	}
	public void setIsUrgent(boolean isUrgent) {
		this.isUrgent = isUrgent;
	}
	public double getToBYN() {
		return toBYN;
	}
	public void setToBYN(double toBYN) {
		this.toBYN = toBYN;
	}
	public double getPercent() {
		return percent;
	}
	public void setPercent(double percent) {
		this.percent = percent;
	}

	public double getDebetT() {
		return debetT;
	}

	public void setDebetT(double depositT) {
		this.debetT = depositT;
	}

	public double getKreditT() {
		return kreditT;
	}

	public void setKreditT(double kreditT) {
		this.kreditT = kreditT;
	}

	public double getKreditP() {
		return kreditP;
	}

	public void setKreditP(double kreditP) {
		this.kreditP = kreditP;
	}

	public double getDebetP() {
		return debetP;
	}

	public void setDebetP(double depositP) {
		this.debetP = depositP;
	}
	
}
