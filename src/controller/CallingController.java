package controller;

import java.util.ArrayList;

import org.controlsfx.control.CheckListView;

import config.Helper;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.DataModel;
import model.ETFQuote;
import model.Margin;
import model.MarketMaker;
import model.TWClient;

public class CallingController {
	
	
	@FXML private CheckListView<MarketMaker> checkListView;
	@FXML private Label fromLabel, quantityLabel, etfNameLabel, wayLabel, bidMarginLabel, askMarginLabel, marginTypeLabel;
	@FXML private HBox askHBox, bidHBox;
	@FXML private MenuButton marginMenuButton;
	@FXML private MenuItem bpMenuItem, ctMenuItem;
	

	private Main main;
	private DataModel model;
	private Stage stage;
	
	private TWClient twClientChosen;
	private Integer quantityChosen;
	private ETFQuote etfQuoteChosen;
	private String wayChosen;

	private ObservableList<MarketMaker> marketMakers;
	
	private Margin marginChosenBid = new Margin("CT", 1);
	private Margin marginChosenAsk = new Margin("CT", 1);
	
	public void setMain(Main main, Stage stage) {
		this.main = main;
		this.model = main.getDataModel();
		this.stage = stage;
		
		this.marketMakers = Helper.copyMarketMakers(this.model.getMarkerMakers());
		initializeAttributs();
		initializeCheckListView();
		fillCallingDetails();
	}
	
	
	private void initializeAttributs() {
		twClientChosen = this.model.getTwClientChosen();
		quantityChosen = this.model.getQuantityChosen();
		etfQuoteChosen = this.model.getEtfQuotChosen();
		wayChosen = this.model.getWayChosen();
	}
	
	
	private void fillCallingDetails() {
		fromLabel.setText(twClientChosen.getName());
		quantityLabel.setText(quantityChosen.toString());
		etfNameLabel.setText(etfQuoteChosen.getId() + " " + etfQuoteChosen.getName());
		wayLabel.setText(wayChosen);
		if(wayChosen.equals("bid"))
			askHBox.setVisible(false);
		else if(wayChosen.equals("ask"))
			bidHBox.setVisible(false);
			
	}
	
	
	private void initializeCheckListView() {
        
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
	public void declineCalling() {
		model.addCurrendTrade();
		stage.close();
	}
	
	@FXML
	public void acceptCalling() {
		this.model.setMarginChosenAsk(marginChosenAsk);
		this.model.setMarginChosenBid(marginChosenBid);
		this.model.setMarketMakersChosen(marketMakers);
	}
	
	@FXML
	public void handleChangeMarginBid(Event event) {
		Button btn = (Button) event.getSource();
		switch(btn.getText()) {
			case "-":
				if(marginChosenBid.getMargin()>0) {
					marginChosenBid.setMargin(marginChosenBid.getMargin() - 1);
					bidMarginLabel.setText(marginChosenBid.getMargin().toString());
				}
				break;
			case "+":
				marginChosenBid.setMargin(marginChosenBid.getMargin() + 1);
				bidMarginLabel.setText(marginChosenBid.getMargin().toString());
				break;
		}
	}
	
	@FXML
	public void handleChangeMarginAsk(Event event) {
		Button btn = (Button) event.getSource();
		switch(btn.getText()) {
		case "-":
			if(marginChosenAsk.getMargin()>0) {
				marginChosenAsk.setMargin(marginChosenAsk.getMargin() - 1);
				askMarginLabel.setText(marginChosenAsk.getMargin().toString());
			}
			break;
		case "+":
			marginChosenAsk.setMargin(marginChosenAsk.getMargin() + 1);
			askMarginLabel.setText(marginChosenAsk.getMargin().toString());
			break;
		}
	}
	
	@FXML
	public void handleMenuButton(Event event) {
		MenuItem menuItem = (MenuItem) event.getSource();
		String margin = "CT";
		if(menuItem.getId().equals("ctMenuItem")) {
			margin = "CT";
		}
		else if(menuItem.getId().equals("bpMenuItem")) {
			margin = "BP";
		}
		marginTypeLabel.setText(margin);
		marginChosenAsk.setTypeMargin(margin);
		marginChosenBid.setTypeMargin(margin);
	}
	
}
