package Client;

import Server.Command;
import Server.RecievePackage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegAutControl {
	@FXML
	private TextField log, nik, ava;
	@FXML
	private PasswordField pass;
	@FXML
	private void Registr(ActionEvent event){
		
			Services.rp = new RecievePackage();
			Services.rp.setCom(Command.registration);
			Services.rp.setLogin(log.getText());
			Services.rp.setPass(pass.getText());
			String userInfo="<ui>\r\n" + 
					"	<img src=\""+ava.getText()+"\" width=\"40\" height=\"50\">\r\n" + 
					"\r\n" + 
					"	<addtext><h4>"+nik.getText()+"</h4>";
			Services.rp.setUserInfo(userInfo);
			Services.Send();
				
			if(Services.rp.getCom() == Command.registrationSuccesful)
				Services.Alert(AlertType.INFORMATION, "Rehistracyja paśpiachovaja", "Rehistracyja paśpiachovaja", "");
			else
				Services.Alert(AlertType.ERROR, "Rehistracyja nie paśpiachovaja", "Rehistracyja nie paśpiachovaja", "");
		
	}
	@FXML
	private void Autor(ActionEvent event) throws Exception{
		Services.rp = new RecievePackage();
		Services.rp.setCom(Command.autorisation);
		Services.rp.setLogin(log.getText());
		Services.rp.setPass(pass.getText());
		Services.Send();

		if(Services.rp.getCom() == Command.autorisationSuccesful) {
			Services.Alert(AlertType.INFORMATION, "Aŭtaryzacyja paśpiachovaja", "Aŭtaryzacyja paśpiachovaja", "");
			new SelectChatClass();
		}
		else
			Services.Alert(AlertType.ERROR, "Aŭtaryzacyja nie paśpiachovaja", "Aŭtaryzacyja nie paśpiachovaja", "");
	}
}

