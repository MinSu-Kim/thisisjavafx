package kr.or.dgit.thisisjavafx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

public class BtnHandlerController implements Initializable {
	@FXML private Button btn1;
	@FXML private Button btn2;
	@FXML private Button btn3;
	@FXML private Label label;
	@FXML private Slider slider;
	@FXML private TextArea textArea1;
	@FXML private TextArea textArea2;
	@FXML private AnchorPane anchor;
	@FXML private Circle circle;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btn1.setOnAction(event -> handleBtn1Action(event));
		btn2.setOnAction(event -> handleBtn1Action(event));
		String lblStr = label.getText();
		slider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				label.setText(String.format("%s%nFont Size : %s", lblStr, newValue.intValue()));
				label.setFont(new Font(newValue.doubleValue()));
			}
		});
		
		Bindings.bindBidirectional(textArea1.textProperty(), textArea2.textProperty());
		
		circle.centerXProperty().bind(Bindings.divide(anchor.widthProperty(), 2));
		circle.centerYProperty().bind(Bindings.divide(anchor.heightProperty(), 2));
	}

	private void handleBtn1Action(ActionEvent event) {
		Button btn = (Button) event.getSource();
		System.out.printf("id : %s %s, %s%n", btn.getId(), btn.getText(), " 클릭");
	}

	public void handleBtn3Action(ActionEvent event) {
		Button btn = (Button) event.getSource();
		System.out.printf("id : %s %s, %s%n", btn.getId(), btn.getText(), " 클릭");
	}
}
