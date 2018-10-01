package kr.or.dgit.thisisjavafx.input_controll;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class InputController implements Initializable {
	@FXML private TextField txtTitle;
	@FXML private PasswordField txtPassword;
	@FXML private ComboBox<String> comboPublic; 
	@FXML private DatePicker dateExit;
	@FXML private TextArea txtContent;
	@FXML private Button btnReg;
	@FXML private Button btnCancel;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comboPublic.setItems(FXCollections.observableArrayList("공개","비공개"));
	}

	public void handleBtnRegAction(ActionEvent event) {
		String title = txtTitle.getText();
		String password = txtPassword.getText();
		String strPublic = comboPublic.getValue();
		LocalDate localDate = dateExit.getValue();
		String content = txtContent.getText();
		String str = String.format("title : %s%n"
				+ "password : %s%n"
				+ "공개유무 : %s%n"
				+ "시각 : %tF%n"
				+ "내용: %s", title, password, strPublic, localDate, content);
		System.out.println(str);
	}
	
	public void handleBtnCancelAction(ActionEvent event) {
		Platform.exit();
	}
}
