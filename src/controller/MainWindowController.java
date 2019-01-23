package controller;

import java.util.Date;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DataModel;
import model.Trade;

public class MainWindowController {
	
	@FXML private TableView<Trade> tableView;
	@FXML private TableColumn<Trade, String> companyColumn;
	@FXML private TableColumn<Trade, Double> nominalColumn;
	@FXML private TableColumn<Trade, Integer> quantityColumn, marginColumn;
	@FXML private TableColumn<Trade, Boolean> doneColumn;
	@FXML private TableColumn<Trade, Date> dateColumn;
	

	private Main main;
	private DataModel model;
	
	public void initialize() {
		companyColumn.setCellValueFactory(new PropertyValueFactory<Trade, String>("nameClient"));
		nominalColumn.setCellValueFactory(new PropertyValueFactory<Trade, Double>("nominal"));
		quantityColumn.setCellValueFactory(new PropertyValueFactory<Trade, Integer>("quantity"));
		marginColumn.setCellValueFactory(new PropertyValueFactory<Trade, Integer>("margin"));
		doneColumn.setCellValueFactory(new PropertyValueFactory<Trade, Boolean>("done"));
		dateColumn.setCellValueFactory(new PropertyValueFactory<Trade, Date>("dateTrade"));
	}
	
	public void setMain(Main main) {
		this.main = main;
		this.model = this.main.getDataModel();
		
		tableView.setItems(model.getTradesPassed());
		tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showDetailWindow(newValue));
	}
	
	
	public void showDetailWindow(Trade trade) {
		main.tradeDetailsWindow(trade);
	}
	
	@FXML
	public void showSettingsWindow() {
		main.settingsWindow();
	}
	
	@FXML
	public void startDemo1() {
		this.model.chooseTWClient();
		this.model.chooseETFQuote();
		this.model.chooseWay();
		this.model.chooseQuantity();
		main.callingWindow();
	}
}
