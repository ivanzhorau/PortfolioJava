package client;

import java.sql.Date;

public class Client {
	private int id;
	private String surname,name,fname,spass,npass,vydan,idNum,bPlace,adress,hPhone,mPhone,EMail;
	private boolean pensioner,reservist;
	private String town;
	private String marital;
	private String  citisen;
	private String disability;
	private double income;
	private Date bday;
	
	public Client(String[] args) {
		id = Integer.parseInt(args[0]);
		surname = args[1];
		name= args[2];
		fname= args[3];
		bday= Date.valueOf(args[4]);
		spass= args[5];
		npass= args[6];
		vydan= args[7];
		idNum= args[8];
		bPlace= args[9];
		adress= args[10];
		hPhone= args[11];
		mPhone= args[12];
		EMail= args[13];
		pensioner= args[14].equals("1");
		income= Double.parseDouble(args[15]);
		reservist= args[16].equals("1");
		town=(args[17]);
		marital=(args[18]);
		disability=(args[19]);
		citisen=(args[20]);
		
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdNum() {
		return idNum;
	}
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getSpass() {
		return spass;
	}
	public void setSpass(String sPass) {
		this.spass = sPass;
	}
	public String gethPhone() {
		return hPhone;
	}
	public void sethPhone(String hPhone) {
		this.hPhone = hPhone;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fName) {
		this.fname = fName;
	}
	public String getmPhone() {
		return mPhone;
	}
	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}
	public String getNpass() {
		return npass;
	}
	public void setNpass(String nPass) {
		this.npass = nPass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEMail() {
		return EMail;
	}
	public void setEMail(String eMail) {
		EMail = eMail;
	}
	public String getbPlace() {
		return bPlace;
	}
	public void setbPlace(String bPlace) {
		this.bPlace = bPlace;
	}
	public String getVydan() {
		return vydan;
	}
	public void setVydan(String vydan) {
		this.vydan = vydan;
	}
	public boolean isPensioner() {
		return pensioner;
	}
	public void setPensioner(boolean pensioner) {
		this.pensioner = pensioner;
	}
	public boolean isReservist() {
		return reservist;
	}
	public void setReservist(boolean reservist) {
		this.reservist = reservist;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getMarital() {
		return marital;
	}
	public void setMarital(String marital) {
		this.marital = marital;
	}
	public String getCitisen() {
		return citisen;
	}
	public void setCitisen(String citisen) {
		this.citisen = citisen;
	}
	public String getDisability() {
		return disability;
	}
	public void setDisability(String disability) {
		this.disability = disability;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public Date getBday() {
		return bday;
	}
	public void setBday(Date bDay) {
		this.bday = bDay;
	} 
}
