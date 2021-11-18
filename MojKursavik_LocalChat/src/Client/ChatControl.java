package Client;

import Server.Command;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;

public class ChatControl {
	private String s ="";
	@FXML
	TextArea MessageText;
	@FXML
	TextField InsertCode,Width,Heidth, Text;
	@FXML
	WebView ChatView,MessageView;	
	
	public void Start() {
		ChatView.getEngine().loadContent(Services.css+Services.rp.getChatInfo());
		getLastMess();
	}
	public void getLastMess() {
		Services.rp.setCom(Command.getAllMessages);
		Services.Send();
		String[] mess= Services.rp.getNewMessages();
		String allMes ="";
		for(String f:mess) {
			allMes=f+allMes ;
		}
		MessageView.getEngine().loadContent(Services.css+allMes);
		
	}
	
	@FXML
	private void InsImg(ActionEvent event) {
		String z = "<img src=\""+InsertCode.getText()+"\" width=\""+Width.getText()+"\" height=\""+Heidth.getText()+"\">\n";
		s+=z;
	}
	@FXML
	private void InsHref(ActionEvent event) {
		String z = "<a href=\""+InsertCode.getText()+"\">"+Text.getText()+"</a>\n";
		s+=z;
	}
	@FXML
	private void Send(ActionEvent event) {
		s=MessageText.getText()+s;
		s=Services.rp.getUserInfo() + s+"</addtext>\r\n" + 
				"	</ui>";
		Services.rp.setMessage(s);
		Services.rp.setCom(Command.sendMessage);
		Services.Send();
		getLastMess();
		ClearIns(event);
	}
	@FXML
	private void ClearIns(ActionEvent event) {
		s="";
		MessageText.setText("");
		Text.setText("");
		InsertCode.setText("");
		Width.setText("");
		Heidth.setText("");
	}
	@FXML
	private void getMess(MouseEvent event) {
		getLastMess();
	}
	
}
