package kr.or.dgit.thisisjavafx.view_controll;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ViewController implements Initializable {
	@FXML private ListView<Phone> listView;
	@FXML private TableView<Phone> tableView;
	@FXML private ImageView imageView;
	private ObservableList<Phone> phoneList;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		phoneList = FXCollections.observableArrayList(
				new Phone("갤럭시S1", "phone01.png"),
				new Phone("갤럭시S2", "phone02.png"),
				new Phone("갤럭시S3", "phone03.png"),
				new Phone("갤럭시S4", "phone04.png"),
				new Phone("갤럭시S5", "phone05.png"),
				new Phone("갤럭시S6", "phone06.png"),
				new Phone("갤럭시S7", "phone07.png"));
		
		initListView();
		initTableView();
	}

	private void initTableView() {
		TableColumn<Phone, ?> tcSmartPhone = tableView.getColumns().get(0);
		tcSmartPhone.setCellValueFactory(new PropertyValueFactory<>("smartPhone"));
		tcSmartPhone.setStyle("-fx-alignment: CENTER;");
		
		TableColumn<Phone, ?> tcImage = tableView.getColumns().get(1);
		tcImage.setCellValueFactory(new PropertyValueFactory<>("image"));
		tcImage.setStyle("-fx-alignment: CENTER;");
		
		tableView.setItems(phoneList);
		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Phone>() {
			@Override
			public void changed(ObservableValue<? extends Phone> observable, Phone oldValue, Phone newValue) {
				if (newValue != null) {
					imageView.setImage(new Image(getClass().getResource("images/"+newValue.getImage()).toString()));
				}
			}
		});
	}

	private void initListView() {
		listView.setItems(phoneList);
		
		listView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				tableView.getSelectionModel().select(newValue.intValue());
				tableView.scrollTo(newValue.intValue());
			}
		});
	}

	public void handleBtnOkAction(ActionEvent event) {
		Phone item = listView.getSelectionModel().getSelectedItem();
		System.out.printf("Selected Phone[%s, %s]%n", item.getSmartPhone(), item.getImage());
		
		Phone tvItem = tableView.getSelectionModel().getSelectedItem();
		System.out.printf("Selected Phone[%s, %s]%n", tvItem.getSmartPhone(), tvItem.getImage());
	}
	
	public void handleBtnCancelAction(ActionEvent event) {
		Platform.exit();
	}
}
