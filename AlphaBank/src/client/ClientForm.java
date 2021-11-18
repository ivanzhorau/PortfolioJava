package client;

import java.sql.Date;
import java.util.ArrayList;

import dataconnecter.DBConnecter;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
public class ClientForm{
	@FXML
	TableView<Client> tab;
	@FXML
	TableColumn<Client, Integer> idrow;
	@FXML
	TableColumn<Client, String> snamerow, namerow, fnamerow, spassrow,npassrow;
	@FXML
	TableColumn<Client, Date> bdayrow;
	@FXML
	TextField emailinpt,snameinpt,incomeinpt,mphoneinpt,hphoneinpt,adressinpt,bplaceinpt,idnuminpt,vydaninpt,npassinpt,spassinpt,fnameinpt,nameinpt;;
	@FXML
	CheckBox reservistinpt,pensinpt;
	@FXML
	DatePicker bdayinpt;
	@FXML
	ChoiceBox<Town> town;
	@FXML
	ChoiceBox<Citisenship>quirites;
	@FXML
	ChoiceBox<Marital> status;
	@FXML
	ChoiceBox<Disability> disab;
	
	Town[] polis;
	Marital[] marit;
	Disability[] dis;
	Citisenship[] quirit;
	DBConnecter DB = DBConnecter.getInstance(); 
	Client[]client;
	int idselected;
	@FXML 
	private void SelectItem(MouseEvent event) throws Exception{
		Client c = tab.getSelectionModel().getSelectedItem();
		idselected = c.getId();
		snameinpt.setText(c.getSurname());
		nameinpt.setText(c.getName());
		fnameinpt.setText(c.getFname());
		bdayinpt.setValue( c.getBday().toLocalDate());;
		spassinpt.setText(c.getSpass());
		npassinpt.setText(c.getNpass());
		vydaninpt.setText(c.getVydan());
		idnuminpt.setText(c.getIdNum());
		bplaceinpt.setText(c.getbPlace());
		adressinpt.setText(c.getAdress());
		hphoneinpt.setText(c.gethPhone());
		mphoneinpt.setText(c.getmPhone());
		emailinpt.setText(c.getEMail());		
		pensinpt.setSelected(c.isPensioner());
		incomeinpt.setText(String.valueOf(c.getIncome()));
		reservistinpt.setSelected(c.isReservist());
		int i =0;
		for(;!polis[i].getName().equals(c.getTown()) && i<polis.length;i++);
		town.setValue(polis[i]);
		i =0;
		for(;!marit[i].getStatus().equals(c.getMarital()) && i<marit.length;i++);
		status.setValue(marit[i]);
		i =0;
		for(;!quirit[i].getCitisen().equals(c.getCitisen()) && i<quirit.length;i++);
		quirites.setValue(quirit[i]);
		i =0;
		for(;!dis[i].getType().equals(c.getDisability()) && i<dis.length;i++);
		disab.setValue(dis[i]);
		
	}
	@FXML
	private void DelClient(ActionEvent event) throws Exception{
		DB.executeCommand("call alphabank.delClient("+idselected+");");
		updt();
	}
	private void AddUpt(int addupt) { 
		try {
			boolean norm = true;
			String sname = snameinpt.getText();
			String name = nameinpt.getText();
			String fname = fnameinpt.getText();
			if((sname+name+fname).contains("/.:!@#$%^&*(\")_+|}{';,1234567890-~`")) {norm=false;}
			String bDay = bdayinpt.getValue().getYear()+"-"+bdayinpt.getValue().getMonth().getValue()+"-"+bdayinpt.getValue().getDayOfMonth();
			String spass = spassinpt.getText().toUpperCase();
			if(spass.length()!=2) norm=false;
			String npass = npassinpt.getText();
			if(!(npass.matches("[0-9]*"))) norm=false;
			String vydan = vydaninpt.getText();
			String idnum = idnuminpt.getText().toUpperCase();
			if(!(idnum.matches("\\d\\d\\d\\d\\d\\d\\d\\D\\d\\d\\d\\D\\D\\d"))) norm=false;
			String bplace = bplaceinpt.getText();
			String adress = adressinpt.getText();
			String hphone = hphoneinpt.getText();
			if(!(hphone.matches("\\d\\d\\d\\d\\d"))) norm=false;
			String mphone = mphoneinpt.getText();
			if(!(mphone.matches("\\D\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d"))) norm=false;
			String email = emailinpt.getText();		
			String pnsnr = pensinpt.isSelected()?"1":"0";
			String incm = incomeinpt.getText();
			Double.parseDouble(incm);
			String reservist = reservistinpt.isSelected()?"1":"0";
			String townl = String.valueOf(town.getValue().getId());
			String maritall = String.valueOf(status.getValue().getId());
			String citisen = String.valueOf(quirites.getValue().getId());
			String disability = String.valueOf(disab.getValue().getId());
			if(!norm) throw new Exception();
			if(addupt==1)
			DB.executeCommand("call alphabank.updClient('"+sname+"', '"+name+"', '"+fname+"', '"+bDay+"', '"+spass+"', '"+npass+"', '"+vydan+"', '"+idnum+"', "
				+ "'"+bplace+"', '"+adress+"', '"+hphone+"', '"+mphone+"', '"+email+"', "+pnsnr+","+incm+" ,"+ reservist+", "+townl+"," +maritall+","+citisen +"," +disability+","+idselected+");");
			else
			DB.executeCommand("call alphabank.insertClient('"+sname+"', '"+name+"', '"+fname+"', '"+bDay+"', '"+spass+"', '"+npass+"', '"+vydan+"', '"+idnum+"', "
				+ "'"+bplace+"', '"+adress+"', '"+hphone+"', '"+mphone+"', '"+email+"', "+pnsnr+","+incm+" ,"+ reservist+", "+townl+"," +maritall+","+citisen +"," +disability+");");
			updt();
			}catch(Exception e){Alert(AlertType.ERROR,"Ошибка","Проверьте введённые данные","");}
	}
	@FXML
	private void UpdClient(ActionEvent event){
		AddUpt(1);
	}
	public void Alert(AlertType type,String title, String header, String content) { 
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}
	@FXML
	private void AddClient(ActionEvent event){
		AddUpt(0);
	}
	private void updt() {
		ArrayList<String[]> al = DB.executeCommand("select * from alphabank.clientview;");
		client = new Client[al.size()];
		for(int i =0; i<client.length;i++) {
			client[i] = new Client(al.get(i));
		};
		al = DB.executeCommand("select * from alphabank.towns;");
		polis = new Town[al.size()];
		for(int i =0; i<polis.length;i++) {
			polis[i] = new Town(al.get(i));
		};
		town.setItems(FXCollections.observableArrayList(polis));
	
		al = DB.executeCommand("select * from alphabank.marital;");
		marit = new Marital[al.size()];
		for(int i =0; i<marit.length;i++) {
			marit[i] = new Marital(al.get(i));
		};
		status.setItems(FXCollections.observableArrayList(marit));
		
		al = DB.executeCommand("select * from alphabank.citizenship;");
		quirit = new Citisenship[al.size()];
		for(int i =0; i<quirit.length;i++) {
			quirit[i] = new Citisenship(al.get(i));
		};
		quirites.setItems(FXCollections.observableArrayList(quirit));
		
		al = DB.executeCommand("select * from alphabank.disability;");
		dis = new Disability[al.size()];
		for(int i =0; i<dis.length;i++) {
			dis[i] = new Disability(al.get(i));
		};
		disab.setItems(FXCollections.observableArrayList(dis));
		tab.setItems(FXCollections.observableArrayList(client));
		namerow.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
		fnamerow.setCellValueFactory(new PropertyValueFactory<Client, String>("fname"));
		spassrow.setCellValueFactory(new PropertyValueFactory<Client, String>("spass"));
		npassrow.setCellValueFactory(new PropertyValueFactory<Client, String>("npass"));
		idrow.setCellValueFactory(new PropertyValueFactory<Client, Integer>("id"));
		snamerow.setCellValueFactory(new PropertyValueFactory<Client, String>("surname"));
		bdayrow.setCellValueFactory(new PropertyValueFactory<Client, Date>("bday"));
	}
	@FXML
	private void UpdateTable(ActionEvent event) throws Exception{
		updt();
	}
}
