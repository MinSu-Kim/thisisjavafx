package kr.or.dgit.thisisjavafx.input_controll;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControllMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
//		Parent root = FXMLLoader.load(getClass().getResource("ButtonController.fxml"));
		Parent root = FXMLLoader.load(getClass().getResource("InputController.fxml"));
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("버튼 컨트롤");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
