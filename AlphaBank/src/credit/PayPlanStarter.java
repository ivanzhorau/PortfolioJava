package credit;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PayPlanStarter extends Application {
			private AnchorPane app;
			public PayPlanStarter() throws Exception {
				start(new Stage());
			}
			@Override
			public void start(Stage primaryStage) throws Exception {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("PayPlan.fxml"));
			app = (AnchorPane)loader.load();
			primaryStage.setScene(new Scene(app));
			primaryStage.setTitle("План платежей");
			primaryStage.show();
			}
}
