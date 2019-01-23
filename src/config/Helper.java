package config;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.MarketMaker;

public class Helper {

	
	
	public static ObservableList<MarketMaker> copyMarketMakers(ObservableList<MarketMaker> marketMakers){
		ArrayList<MarketMaker> temp = new ArrayList<MarketMaker>();
		for (MarketMaker marketMaker : marketMakers) {
			temp.add(new MarketMaker(marketMaker.getIdMarketMaker(), marketMaker.getName(), marketMaker.getDescription(), marketMaker.getSelected()));
		}
		
		return FXCollections.observableArrayList(temp);
	}
}
