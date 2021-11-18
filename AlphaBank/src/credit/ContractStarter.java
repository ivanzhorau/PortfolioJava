package credit;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ContractStarter extends Application {
	private AnchorPane app;
	public ContractStarter() throws Exception {
		start(new Stage());
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
	FXMLLoader loader = new FXMLLoader();
	loader.setLocation(Main.class.getResource("ContractTable.fxml"));
	app = (AnchorPane)loader.load();
	primaryStage.setScene(new Scene(app));
	primaryStage.setTitle("Клиенты");
	primaryStage.show();
	
}
}
