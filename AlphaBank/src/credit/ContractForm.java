package credit;


import java.util.ArrayList;

import dataconnecter.DBConnecter;
import deposit.idString;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ContractForm {
	DBConnecter DB = new DBConnecter();
	@FXML
    TextField PInp,NowInp,SumInp;
	@FXML
	ChoiceBox <idString> ClInp, CrdtInp;
	@FXML
	DatePicker StartInp, EndInp;
	@FXML
	TableView<Contracts> ClientTab;
	@FXML
	TableColumn<Contracts, Integer> id;
	@FXML
    TableColumn<Contracts, String> ClTab, CrdtTab, StartTab, EndTab, NowTab, PTab;
	@FXML
    TableColumn<Contracts, Double> SummTab,PercTab;
    idString[] Client,Crdt;
    Contracts[] contracts;
    
    
	@FXML
	private void Add(ActionEvent event) throws Exception{
		try {
		boolean norm = true;
		String percent = PInp.getText();
		String now = NowInp.getText();
		String sum = SumInp.getText();
		if(percent.length()!=13) {norm = false;}
		if(now.length()!=13) {norm = false;}
		if(!(percent.matches("[0-9]*"))) norm=false;
		if(!(now.matches("[0-9]*"))) norm=false;
		Double.parseDouble(sum);
		String client = String.valueOf(ClInp.getValue().getId());
		String crdt = String.valueOf(CrdtInp.getValue().getId());
		String start = StartInp.getValue().getYear()+"-"+StartInp.getValue().getMonth().getValue()+"-"+StartInp.getValue().getDayOfMonth();
		String end = EndInp.getValue().getYear()+"-"+EndInp.getValue().getMonth().getValue()+"-"+EndInp.getValue().getDayOfMonth();
		int pmnts = (EndInp.getValue().getYear() - StartInp.getValue().getYear())*12 + (EndInp.getValue().getMonth().getValue() - StartInp.getValue().getMonth().getValue());
		if(pmnts <=5) {norm = false;}
		if(!norm) throw new Exception();
		
		
		DB.executeCommand("INSERT INTO `alphabank`.`bills` (`deposit`, `name`,`kredit`) VALUES ('0', '"+now+"','0');");
		DB.executeCommand("INSERT INTO `alphabank`.`bills` (`deposit`, `name`,`kredit`) VALUES ('0', '"+percent+"','0');");
		String idnow = DB.executeCommand("SELECT id FROM alphabank.bills where `name`='"+now+"';").get(0)[0];
		String idpercent = DB.executeCommand("SELECT id FROM alphabank.bills where `name`='"+percent+"';").get(0)[0];
		DB.executeCommand("INSERT INTO `alphabank`.`clientbills` (`idklient`, `idcurrent`, `idpercent`) VALUES ('"+client+"', '"+idnow+"', '"+idpercent+"');");
		String idclientbills = DB.executeCommand("SELECT id FROM alphabank.clientbills where idklient='"+client+"' and idcurrent='"+idnow+"' and idpercent='"+idpercent+"';").get(0)[0];
		DB.executeCommand("INSERT INTO `alphabank`.`creditcontract` (`idclientbills`, `idcredit`, `start`, `end`, `allpayments`, `payments`, `cash`) VALUES ('"+idclientbills+"', '"+crdt+"', '"+start+"', '"+end+"',  '"+pmnts+"','0', '"+sum+"');");
		
		Upd(event);
		
		int idcrcontr = contracts[contracts.length-1].getId();
		boolean isAnn = contracts[contracts.length-1].getIsAnnuitet();
		double summ = contracts[contracts.length-1].getCash();
		double perc = contracts[contracts.length-1].getPerc();
		if(isAnn) {
			double mps = perc/12/100;
			double K = mps*Math.pow(1+mps, pmnts)/(Math.pow(1+mps, pmnts)-1);
			double A = K*summ;
			double C = summ/pmnts;
			double P = A-C;
			for(int i = 0; i<pmnts;i++) {
				DB.executeCommand("INSERT INTO `alphabank`.`paymentplan` (`idcontract`, `totek`, `toperc`, `numofpay`, `ispayd`) VALUES ('"+idcrcontr+"', '"+C+"', '"+P+"', '"+(i+1)+"', '0');");
			}
		}else {
			double Sn = summ;
			double b = summ/pmnts;
			for(int i = 0; i<pmnts; i++) {
				Sn=summ - b*i;
				double P = Sn*perc/12/100;
				DB.executeCommand("INSERT INTO `alphabank`.`paymentplan` (`idcontract`, `totek`, `toperc`, `numofpay`, `ispayd`) VALUES ('"+idcrcontr+"', '"+b+"', '"+P+"', '"+(i+1)+"', '0');");
			}
		}
		}catch(Exception e){Alert(AlertType.ERROR,"Ошибка","Проверьте введённые данные","");}
		Upd(event);
	}
	@FXML
	private void Upd(ActionEvent event) throws Exception{ 
		ArrayList<String[]> ret = DB.executeCommand("SELECT id,IDNum FROM alphabank.client;");
		Client = new idString[ret.size()];
		for(int i = 0; i<Client.length;i++) {
			Client[i] = new idString(ret.get(i)[0],ret.get(i)[1]);
		}
		ret = DB.executeCommand("SELECT id,name FROM alphabank.credits;");
		Crdt = new idString[ret.size()];
		for(int i = 0; i<Crdt.length;i++) {
			Crdt[i] = new idString(ret.get(i)[0],ret.get(i)[1]);
		}
		ClInp.setItems(FXCollections.observableArrayList(Client));
		CrdtInp.setItems(FXCollections.observableArrayList(Crdt));
		ret = DB.executeCommand("SELECT * FROM alphabank.creditcontractsview;");
		contracts = new Contracts[ret.size()/2];
		for(int i = 0; i<ret.size(); i+=2) {
			contracts[i/2] = new Contracts(Integer.parseInt(ret.get(i)[0]),ret.get(i)[1],ret.get(i)[2],ret.get(i)[3],ret.get(i)[4],ret.get(i)[5],ret.get(i+1)[6],Double.parseDouble(ret.get(i)[7]),Double.parseDouble(ret.get(i)[8]),ret.get(i)[9].equals("1"));
		}
		ClientTab.setItems(FXCollections.observableArrayList(contracts));
		id.setCellValueFactory(new PropertyValueFactory<Contracts, Integer>("id"));
		ClTab.setCellValueFactory(new PropertyValueFactory<Contracts, String>("client"));
		CrdtTab.setCellValueFactory(new PropertyValueFactory<Contracts, String>("credit"));
		StartTab.setCellValueFactory(new PropertyValueFactory<Contracts, String>("start"));
		EndTab.setCellValueFactory(new PropertyValueFactory<Contracts, String>("end"));
		NowTab.setCellValueFactory(new PropertyValueFactory<Contracts, String>("now"));
		PTab.setCellValueFactory(new PropertyValueFactory<Contracts, String>("percent"));
		SummTab.setCellValueFactory(new PropertyValueFactory<Contracts, Double>("cash"));
		PercTab.setCellValueFactory(new PropertyValueFactory<Contracts, Double>("perc"));
		
	}
	public void Alert(AlertType type,String title, String header, String content) { //вывад паведамленьня аб памылцы
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}
}
