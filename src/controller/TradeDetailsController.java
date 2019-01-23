package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Trade;

public class TradeDetailsController {
	
	@FXML private Label numberTradeLabel, doneLabel, dateLabel, fromLabel, quantityLabel, etfNameLabel, wayLabel, marketMakerLabel, priceLabel, totalLabel, marginLabel, profitValueLabel;

	private Main main;
	private Trade trade;
	
	public void setMain(Main main, Trade trade) {
		this.main = main;
		this.trade = trade;
		if(trade != null)
			fillTradeDetails();
	}
	
	public void fillTradeDetails() {
		numberTradeLabel.setText(numberTradeLabel.getText() + " " + trade.getIdTrade());
		doneLabel.setText(trade.getDone()?"DONE":"FAIL");
		dateLabel.setText(trade.getDateTrade().toString());
		fromLabel.setText(trade.getNameClient());
		quantityLabel.setText(trade.getQuantity().toString());
		etfNameLabel.setText(trade.getEtfName());
		wayLabel.setText(trade.getWay());
		marketMakerLabel.setText(trade.getMarketMaker() == null?null:trade.getMarketMaker().getName());
		priceLabel.setText(trade.getQuote()==null?null:trade.getQuote().toString());
		totalLabel.setText(trade.getNominal()==null?null:trade.getNominal().toString());
		marginLabel.setText(trade.getMargin()==null?"":trade.getMargin().toString() + " " + trade.getTypeMargin());
		profitValueLabel.setText(trade.getMarginValue()==null?null:trade.getMarginValue().toString());
	}
	
	
}
