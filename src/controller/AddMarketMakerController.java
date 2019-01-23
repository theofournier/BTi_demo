package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.MarketMaker;

public class AddMarketMakerController {
	
	private Main main;
	private Stage stage;
	
	@FXML private TextField idField, nameField;
	@FXML private TextArea descriptionField;
	
	
	public void setMain(Main main, Stage stage) {
		this.main = main;
		this.stage = stage;
	}
	
	@FXML
	private void saveNewMarketMaker() {
		MarketMaker marketMaker = new MarketMaker(idField.getText(), nameField.getText(), descriptionField.getText(), false);
		main.getDataModel().getMarkerMakers().add(marketMaker);
		
		idField.clear();
		nameField.clear();
		descriptionField.clear();
	}
	
	@FXML
	private void cancel() {
		this.stage.close();
	}

}
