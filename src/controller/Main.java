package controller;
	
import java.io.IOException;
import java.util.Date;

import org.controlsfx.control.CheckListView;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.DataModel;
import model.MarketMaker;
import model.Trade;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private DataModel model;
	private Stage primaryStage;
	public DataModel getDataModel() {
		return this.model;
	}
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.model = new DataModel();
		
		mainWindow();
	}
	
	public void mainWindow() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/MainWindowView.fxml"));
			AnchorPane pane = loader.load();
			
			Scene scene = new Scene(pane);
			
			MainWindowController mainWindowController = loader.getController();
			mainWindowController.setMain(this);
						
			primaryStage.setScene(scene);
			primaryStage.show();
		
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void tradeDetailsWindow(Trade trade) {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/TradeDetailsView.fxml"));
			AnchorPane pane = loader.load();
			
			Scene scene = new Scene(pane);
			Stage stage = new Stage();
			
			TradeDetailsController tradeDetailsController = loader.getController();
			tradeDetailsController.setMain(this, trade);
						
			stage.setScene(scene);
			stage.show();
		
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void settingsWindow() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/SettingsView.fxml"));
			AnchorPane pane = loader.load();
			
			Scene scene = new Scene(pane);
			Stage stage = new Stage();
			
			SettingsController settingsController = loader.getController();
			settingsController.setMain(this, stage);
			
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.show();
		}
		catch(IOException e) {
			e.printStackTrace();			
		}
	}
	
	public void addMarketMakerWindow() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/AddMarketMakerView.fxml"));
			AnchorPane pane = loader.load();
			
			Scene scene = new Scene(pane);
			Stage stage = new Stage();
			
			AddMarketMakerController addMarketMakerView = loader.getController();
			addMarketMakerView.setMain(this, stage);
							
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.showAndWait();
		}
		catch(IOException e) {
			e.printStackTrace();			
		}
	}
	
	public void callingWindow() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/CallingView.fxml"));
			AnchorPane pane = loader.load();
			
			Scene scene = new Scene(pane);
			Stage stage = new Stage();
			
			CallingController callingController = loader.getController();
			callingController.setMain(this, stage);
							
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.show();
		}
		catch(IOException e) {
			e.printStackTrace();			
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	 
}
