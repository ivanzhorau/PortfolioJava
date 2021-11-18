package Server;


import Client.Services;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;

public class ServWindControl {
	int IdChat = 0;
	private ServerClass serv = new ServerClass();
	@FXML
	private TextField chatName, chatAva;
	@FXML
	WebView W0,W1,W2,W3,W4,W5,W6,W01;
	WebView[] W = new WebView[7];
	@FXML
	private void getChat(ActionEvent event){
		W[0]=W0;
		W[1]=W1;
		W[2]=W2;
		W[3]=W3;
		W[4]=W4;
		W[5]=W5;
		W[6]=W6;
		String[] infs = DataManipulator.getChatsInf();
		int[] ids = DataManipulator.getChatsIs();
		for(int i=0; i<W.length;i++) W[i].getEngine().loadContent("");
		for(int i=0; i<W.length && i<infs.length;i++) {
			final int j = i;
			infs[i] = Services.css + infs[i];
			W[i].getEngine().loadContent(infs[i]);
			W[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					int chatId = ids[j];
					IdChat = (chatId);
					W01.getEngine().loadContent(infs[j]);
				}
			});
		}
	}

	@FXML
	private void StartServ(ActionEvent event){
		serv.start();
	}
	@FXML
	private void AddChat(ActionEvent event){
		String s ="<ci>\r\n" + 
				"	<img src=\""+chatAva.getText()+"\" width=\"40\" height=\"50\">\r\n" + 
				"\r\n" + 
				"	<addtext><h3>"+chatName.getText()+"</h3>\r\n" +  
				"</addtext>\r\n" + 
				"</ci>";
		DataManipulator.addChat(s);
		getChat(event);
	}
	@FXML
	private void DelChat(ActionEvent event){
		
		DataManipulator.delChat(IdChat);
		getChat(event);
	}
	@FXML
	private void UpdChat(ActionEvent event){
		String s ="<ci>\r\n" + 
				"	<img src=\""+chatAva.getText()+"\" width=\"40\" height=\"50\">\r\n" + 
				"\r\n" + 
				"	<addtext><h3>"+chatName.getText()+"</h3>\r\n" +  
				"</addtext>\r\n" + 
				"</ci>";
		DataManipulator.updChat(IdChat,s);
		getChat(event);
	}
}
