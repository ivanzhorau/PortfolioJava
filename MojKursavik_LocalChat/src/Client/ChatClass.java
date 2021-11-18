package Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ChatClass   extends Application{
	private AnchorPane app;
	public ChatClass() throws Exception {
	
		start(new Stage());
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("ChatWindow.fxml"));
		app = (AnchorPane)loader.load();
		primaryStage.setScene(new Scene(app));
		loader.<ChatControl>getController().Start();
		String s = Services.rp.getUserInfo().split("<h4>")[1];
		s=s.split("</h4>")[0];
		primaryStage.setTitle(s);
		primaryStage.show();
	}	
		
}
