package kr.or.dgit.thisisjavafx.container;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FlowPaneMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		FlowPane root = FXMLLoader.load(getClass().getResource("FlowPane.fxml"));
		
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("FlowPane");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
