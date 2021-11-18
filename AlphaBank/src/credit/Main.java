package credit;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application{//Vaniok, blać, nie zabudź što heta tolki časovaje rašeńnie, zrabi jašče adnu formu 
		private AnchorPane app;
		public static void main(String[] args) {
			launch(args);
		}
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("CreditTable.fxml"));
		app = (AnchorPane)loader.load();
		primaryStage.setScene(new Scene(app));
		primaryStage.setTitle("Клиенты");
		primaryStage.show();
		
	}
}

