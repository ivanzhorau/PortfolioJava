package credit;

import java.util.ArrayList;

import dataconnecter.DBConnecter;
import deposit.idString;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class CreditForm {
	DBConnecter DB = new DBConnecter();
	@FXML
	ChoiceBox <idString> ClInp;
	
	@FXML
	TableView<Bills> tab;
	@FXML
	TableColumn<Bills,Integer> idTab;
	@FXML
	TableColumn<Bills,Double> nowDTab,nowKTab,percDTab,percKTab;
	@FXML
	TableColumn<Bills,String> clTab,crdtTab;
	@FXML
	TableColumn<Bills,Double> pmntTab;
	@FXML
	TextField KassaD,SFRBD, KassaK,SFRBK, summ; 
	
	idString[] clients;
	Bills[] bills;
	@FXML
	private void Upd(ActionEvent event) throws Exception{ 
		ArrayList<String[]> ret = DB.executeCommand("SELECT id,IDNum FROM alphabank.client;");
		clients = new idString[ret.size()];
		for(int i = 0; i<clients.length;i++) {
			clients[i] = new idString(ret.get(i)[0],ret.get(i)[1]);
		}
		ClInp.setItems(FXCollections.observableArrayList(clients));
		ret = DB.executeCommand("SELECT * FROM alphabank.crbillsview;");
		bills = new Bills[ret.size()/2];
		for(int i = 0; i<ret.size();i+=2) {
			bills[i/2] = new Bills(ret.get(i)[0],ret.get(i)[1],ret.get(i)[2],
					ret.get(i)[3],ret.get(i)[4],ret.get(i)[5],ret.get(i)[6],ret.get(i)[7],ret.get(i)[8],
					ret.get(i)[9],ret.get(i)[10],ret.get(i)[11],ret.get(i)[12],ret.get(i+1)[11],ret.get(i+1)[12]);
			bills[i/2].setPayplan(DB.executeCommand("SELECT * FROM alphabank.paymentplan where idcontract='"+bills[i/2].getId()+"';"));
		}

		tab.setItems(FXCollections.observableArrayList(bills));
		idTab.setCellValueFactory(new PropertyValueFactory<Bills, Integer>("id"));
		nowDTab.setCellValueFactory(new PropertyValueFactory<Bills, Double>("debetT"));
		nowKTab.setCellValueFactory(new PropertyValueFactory<Bills, Double>("kreditT"));
		percDTab.setCellValueFactory(new PropertyValueFactory<Bills, Double>("debetP"));
		percKTab.setCellValueFactory(new PropertyValueFactory<Bills, Double>("kreditP"));
		clTab.setCellValueFactory(new PropertyValueFactory<Bills, String>("idNum"));
		crdtTab.setCellValueFactory(new PropertyValueFactory<Bills, String>("cName"));
		pmntTab.setCellValueFactory(new PropertyValueFactory<Bills, Double>("pm"));
		ret = DB.executeCommand("SELECT * FROM alphabank.bills where `name` = 'checkout' or `name` = 'SFRB';");
		KassaD.setText(ret.get(0)[1]);
		KassaK.setText(ret.get(0)[3]);
		SFRBD.setText(ret.get(1)[1]);
		SFRBK.setText(ret.get(1)[3]);
		
	}
	public void Alert(AlertType type,String title, String header, String content) { //вывад паведамленьня аб памылцы
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}
	@FXML
	private void Reg(ActionEvent event) throws Exception{
		new ContractStarter();
	}
	@FXML
	private void amortisation(ActionEvent event) throws Exception{
		try {
			ArrayList<String[]> ret = DB.executeCommand("SELECT * FROM alphabank.bills where id=1");
			double kasD = Double.parseDouble(ret.get(0)[1]);
			double kasK = Double.parseDouble(ret.get(0)[3]);
			Bills Do = null;
			int idklient = (ClInp.getValue().getId());
			double sum = Double.parseDouble(summ.getText());
			for(int i = 0; i<bills.length;i++) {
				if(bills[i].getIdklient()==idklient) {
					Do = bills[i];
					break;
				}
			}
			double P = Double.parseDouble(Do.getPayplan().get(Do.getPaym())[3]);
			double B = Double.parseDouble(Do.getPayplan().get(Do.getPaym())[2]);
			if(sum<B+P) throw new Exception();
			sum = B+P;
			kasD+=sum;
			kasK-=sum;
			Do.setDebetP(Do.getDebetP()+P);
			Do.setDebetT(Do.getDebetT()+B);
			DB.executeCommand("UPDATE `alphabank`.`bills` SET `deposit` = '"+Do.getDebetT()+"' WHERE (`id` = '"+Do.getIdcurrent()+"');");
			DB.executeCommand("UPDATE `alphabank`.`bills` SET `deposit` = '"+Do.getDebetP()+"' WHERE (`id` = '"+Do.getIdpercent()+"');");
			DB.executeCommand("UPDATE `alphabank`.`bills` SET `deposit` = '"+kasD+"' WHERE (`id` = '1');");
			DB.executeCommand("UPDATE `alphabank`.`bills` SET `kredit` = '"+kasK+"' WHERE (`id` = '1');");
			DB.executeCommand("UPDATE `alphabank`.`creditcontract` SET `isstarted` = '1' WHERE (`id` = '"+Do.getId()+"');");
			DB.executeCommand("UPDATE `alphabank`.`paymentplan` SET `ispayd` = '1' WHERE (`idcontract` = '"+Do.getId()+"' and `numofpay` ='"+(Do.getPaym()+1)+"');");
			DB.executeCommand("UPDATE `alphabank`.`creditcontract` SET `payments` = '"+(Do.getPaym()+1)+"' WHERE (`id` = '"+Do.getId()+"');");

		
				
		}catch(Exception e) {Alert(AlertType.ERROR,"Ошибка","Проверьте введённые данные","");}
		Upd(event);
	}
	@FXML
	private void getCredit(ActionEvent event) throws Exception{
		try {
		ArrayList<String[]>	ret = DB.executeCommand("SELECT * FROM alphabank.bills where id=2");
		double SFRBD = Double.parseDouble(ret.get(0)[1]);
		int idklient = (ClInp.getValue().getId());
		ret = DB.executeCommand("SELECT * FROM alphabank.bills where id=1");
		double kasD = Double.parseDouble(ret.get(0)[1]);
		double kasK = Double.parseDouble(ret.get(0)[3]);
		Bills Do = null;
		for(int i = 0; i<bills.length;i++) {
			if(bills[i].getIdklient()==idklient) {
				Do = bills[i];
				break;
			}
		}
		boolean isstarted = DB.executeCommand("SELECT (isstarted) FROM alphabank.creditcontract where id = "+Do.getId()+";").get(0)[0].equals("1");
		if(isstarted) {throw new Exception();}
		SFRBD-=Do.getCash();
		Do.setDebetT(Do.getDebetT()+Do.getCash());
		Do.setKreditT(Do.getKreditT()-Do.getCash());
		kasD+=Do.getCash();
		kasK-=Do.getCash();
		DB.executeCommand("UPDATE `alphabank`.`bills` SET `deposit` = '"+Do.getDebetT()+"' WHERE (`id` = '"+Do.getIdcurrent()+"');");
		DB.executeCommand("UPDATE `alphabank`.`bills` SET `kredit` = '"+Do.getKreditT()+"' WHERE (`id` = '"+Do.getIdcurrent()+"');");
		DB.executeCommand("UPDATE `alphabank`.`bills` SET `deposit` = '"+SFRBD+"' WHERE (`id` = '2');");
		DB.executeCommand("UPDATE `alphabank`.`bills` SET `deposit` = '"+kasD+"' WHERE (`id` = '1');");
		DB.executeCommand("UPDATE `alphabank`.`bills` SET `kredit` = '"+kasK+"' WHERE (`id` = '1');");
		DB.executeCommand("UPDATE `alphabank`.`creditcontract` SET `isstarted` = '1' WHERE (`id` = '"+Do.getId()+"');");
		}catch(Exception e) {Alert(AlertType.ERROR,"Ошибка","Кредит уже взят или не оформлен","");}
		Upd(event);
	}
	@FXML
	private void checkCred(ActionEvent event) throws Exception{
		new PayPlanStarter();
	}
	@FXML
	private void endDay(ActionEvent event) throws Exception{
		for(int i = 0; i<bills.length;i++) {
			ArrayList<String[]>	ret = DB.executeCommand("SELECT * FROM alphabank.bills where id=2");
			double SFRBK = Double.parseDouble(ret.get(0)[3]);
			
			Bills Do = bills[i];
			if(Do.getAllpm()!=Do.getPaym()) {
			double perc = Double.parseDouble(Do.getPayplan().get(Do.getPaym())[4])/30;	
				Do.setKreditP(Do.getKreditP()-perc);
				SFRBK+=perc;
				DB.executeCommand("UPDATE `alphabank`.`bills` SET `kredit` = '"+(SFRBK)+"' WHERE (`id` = '2');");
				DB.executeCommand("UPDATE `alphabank`.`bills` SET `kredit` = '"+(Do.getKreditP())+"' WHERE (`id` = '"+Do.getIdpercent()+"');");
			
			}else {
				boolean isstarted = DB.executeCommand("SELECT (isstarted) FROM alphabank.creditcontract where id = "+Do.getId()+";").get(0)[0].equals("1");
				if(isstarted) {
					DB.executeCommand("UPDATE `alphabank`.`bills` SET `kredit` = '"+(SFRBK+Do.getCash())+"' WHERE (`id` = '2');");
					DB.executeCommand("UPDATE `alphabank`.`bills` SET `kredit` = '"+(Do.getKreditP()-Do.getCash())+"' WHERE (`id` = '"+Do.getIdpercent()+"');");
				}
			}
		}
		Upd(event);
	}
}
