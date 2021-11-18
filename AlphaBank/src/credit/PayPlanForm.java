package credit;

import java.util.ArrayList;

import dataconnecter.DBConnecter;
import deposit.idString;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PayPlanForm {

	DBConnecter DB = new DBConnecter();
	 @FXML
	 TableView <payplan> Tab;
	 @FXML
	 ChoiceBox<idString> contract;
	 @FXML 
	 TableColumn <payplan,String>num,base,perc,isOver;
	 
	 idString[] clients;
	 payplan[] pp;
	 @FXML
	 private void check(ActionEvent event) throws Exception{
		 try {
		 String id = DB.executeCommand("SELECT id FROM alphabank.creditcontractsview where idNum = '"+contract.getValue().getName()+"';").get(0)[0];
		 ArrayList<String[]> ret = DB.executeCommand("SELECT * FROM alphabank.paymentplan where idcontract = '"+id+"';");
		 pp = new payplan[ret.size()];
		 for(int i =0; i< ret.size(); i++) {
			 pp[i] = new payplan(ret.get(i));
		 }
		 Tab.setItems(FXCollections.observableArrayList(pp));
		 num.setCellValueFactory(new PropertyValueFactory<payplan, String>("num"));
		 base.setCellValueFactory(new PropertyValueFactory<payplan, String>("base"));
		 perc.setCellValueFactory(new PropertyValueFactory<payplan, String>("perc"));
		 isOver.setCellValueFactory(new PropertyValueFactory<payplan, String>("payd"));
		 }catch(Exception e) {}
	 }
	 @FXML
	 private void Upd(ActionEvent event) throws Exception{
		 ArrayList<String[]> ret = DB.executeCommand("SELECT id,IDNum FROM alphabank.client;");
			clients = new idString[ret.size()];
			for(int i = 0; i<clients.length;i++) {
				clients[i] = new idString(ret.get(i)[0],ret.get(i)[1]);
			}
			contract.setItems(FXCollections.observableArrayList(clients));
	 }
	 public class payplan{
		 private String num,base,perc,payd;
		 public payplan(String[] n) {
			 num = n[4];
			 base = n[2];
			 perc= n[3];
			 payd = n[5].equals("1")?"Да":"Нет"; 
		 }

		public String getNum() {
			return num;
		}

		public void setNum(String num) {
			this.num = num;
		}

		public String getPerc() {
			return perc;
		}

		public void setPerc(String perc) {
			this.perc = perc;
		}

		public String getBase() {
			return base;
		}

		public void setBase(String base) {
			this.base = base;
		}

		public String getPayd() {
			return payd;
		}

		public void setPayd(String over) {
			this.payd = over;
		}
		 
	 }
}
