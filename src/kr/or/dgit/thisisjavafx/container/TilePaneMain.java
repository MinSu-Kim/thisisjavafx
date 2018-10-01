package kr.or.dgit.thisisjavafx.container;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class TilePaneMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		TilePane root = FXMLLoader.load(getClass().getResource("TitlePaneMain.fxml"));
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("TilePane");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
