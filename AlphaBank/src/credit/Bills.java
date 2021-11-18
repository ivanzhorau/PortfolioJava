package credit;

import java.util.List;

public class Bills {
	private int id,idklient,idcurrent,idpercent,allpm,paym,pm;
	private String idNum,start,end,cName;
	private double debetT,kreditT,cash,debetP,kreditP;
	
	private List<String[]> payplan;
	public Bills(String id,String idklient,String idcurrent,String idpercent,String idNum,String start,String end, String cash,String allpm,String paym,String cName,String debetT,String kreditT,String debetP,String kreditP) {
		this.id=Integer.parseInt(id);
		this.idklient=Integer.parseInt(idklient);
		this.idcurrent=Integer.parseInt(idcurrent);
		this.idpercent=Integer.parseInt(idpercent);
		this.allpm=Integer.parseInt(allpm);
		this.paym = Integer.parseInt(paym);
		this.idNum=idNum;
		this.start=start;
		this.end=end;
		this.cName=cName;
		this.debetT=Double.parseDouble(debetT);
		this.kreditT=Double.parseDouble(kreditT);
		this.cash=Double.parseDouble(cash);
		this.debetP=Double.parseDouble(debetP);
		this.kreditP=Double.parseDouble(kreditP);
		setPm(this.allpm-this.paym);
	}
	
	public int getAllpm() {
		return allpm;
	}
	public void setAllpm(int allpm) {
		this.allpm = allpm;
	}
	public int getIdpercent() {
		return idpercent;
	}
	public void setIdpercent(int idpercent) {
		this.idpercent = idpercent;
	}
	public int getIdklient() {
		return idklient;
	}
	public void setIdklient(int idklient) {
		this.idklient = idklient;
	}
	public int getPaym() {
		return paym;
	}
	public void setPaym(int paym) {
		this.paym = paym;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdcurrent() {
		return idcurrent;
	}
	public void setIdcurrent(int idcurrent) {
		this.idcurrent = idcurrent;
	}
	public String getCName() {
		return cName;
	}
	public void setCName(String cName) {
		this.cName = cName;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getIdNum() {
		return idNum;
	}
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	
	public double getDebetT() {
		return debetT;
	}
	public void setDebetT(double debetT) {
		this.debetT = debetT;
	}
	public double getKreditT() {
		return kreditT;
	}
	public void setKreditT(double kreditT) {
		this.kreditT = kreditT;
	}
	public double getDebetP() {
		return debetP;
	}
	public void setDebetP(double debetP) {
		this.debetP = debetP;
	}
	public double getKreditP() {
		return kreditP;
	}
	public void setKreditP(double kreditP) {
		this.kreditP = kreditP;
	}
	public List<String[]> getPayplan() {
		return payplan;
	}
	public void setPayplan(List<String[]> payplan) {
		this.payplan = payplan;
	}
	public double getCash() {
		return cash;
	}
	public void setCash(double cash) {
		this.cash = cash;
	}
	public int getPm() {
		return pm;
	}
	public void setPm(int pm) {
		this.pm = pm;
	}
}
