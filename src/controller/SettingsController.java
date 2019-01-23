package controller;

import java.util.ArrayList;
import java.util.List;

import org.controlsfx.control.CheckListView;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.DataModel;
import model.MarketMaker;

public class SettingsController {
	
	@FXML CheckListView<MarketMaker> checkListView;
	
	private Main main;
	private Stage stage;
	private DataModel model;
	
	public void setMain(Main main, Stage stage) {
		this.main = main;
		this.stage = stage;
		this.model = this.main.getDataModel();
		initializeCheckListView();
	}
	
	private void initializeCheckListView() {
		ObservableList<MarketMaker> marketMakers = model.getMarkerMakers();
        
		// Create the CheckListView with the data 
		 checkListView.setItems(marketMakers);
		 
		 checkListView.setCellFactory(lv -> new CheckBoxListCell<MarketMaker>(checkListView::getItemBooleanProperty) {
	            @Override
	            public void updateItem(MarketMaker marketMaker, boolean empty) {
	                super.updateItem(marketMaker, empty);
	                setText(marketMaker == null ? "" : marketMaker.getName() + ", " + marketMaker.getDescription());
	                for(int i = 0; i<marketMakers.size();i++) {
		       			 if(marketMakers.get(i).getSelected())
		       				 checkListView.getCheckModel().check(i);
		       		 }
	            }
	        });
		 
		 
		       
		 // and listen to the relevant events (e.g. when the selected indices or 
		 // selected items change).
		 checkListView.getCheckModel().getCheckedIndices().addListener(new ListChangeListener<Integer>() {
			 @Override
	            public void onChanged(javafx.collections.ListChangeListener.Change<? extends Integer> c) {
	                while (c.next()) {
	                    if (c.wasAdded()) {
	                        for (int i : c.getAddedSubList()) {
	                        	checkListView.getItems().get(i).setSelected(true);
	                        }
	                    }
	                    if (c.wasRemoved()) {
	                        for (int i : c.getRemoved()) {
	                        	checkListView.getItems().get(i).setSelected(false);
	                        }
	                    }
	                }
	            }
		 });
	}
	
	
	
	@FXML
	public void closeWindow() {
		this.stage.close();
	}
	
	@FXML
	public void openWindowAddMarketMaker() {
		this.main.addMarketMakerWindow();
	}
}
