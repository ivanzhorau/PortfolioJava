package Client;

import Server.Command;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;

public class SelectChatControl {
	@FXML
	WebView W0,W1,W2,W3,W4,W5,W6;
	WebView[] W = new WebView[7];
	@FXML
	private void getChat(ActionEvent event){
		Services.rp.setCom(Command.getChats);
		Services.Send();
		W[0]=W0;
		W[1]=W1;
		W[2]=W2;
		W[3]=W3;
		W[4]=W4;
		W[5]=W5;
		W[6]=W6;
		String[] infs = Services.rp.getChats();
		for(int i=0; i<W.length && i<infs.length;i++) {
			final int j = i;
			infs[i] = Services.css + infs[i];
			W[i].getEngine().loadContent(infs[i]);
			W[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					int chatId = Services.rp.getIds()[j];
					Services.rp.setChatId(chatId);
					Services.rp.setChatInfo(Services.rp.getChats()[j]);
					try {
						new ChatClass();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
	}
}
