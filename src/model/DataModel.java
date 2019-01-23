package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataModel {
	
	private ObservableList<Trade> tradesPassed = FXCollections.observableArrayList();
	public ObservableList<Trade> getTradesPassed(){
		return this.tradesPassed;
	}
	
	private ObservableList<MarketMaker> marketMakers = FXCollections.observableArrayList();
	public ObservableList<MarketMaker> getMarkerMakers(){
		return this.marketMakers;
	}
	
	
	private ArrayList<ETFQuote> etfQuotes = new ArrayList<ETFQuote>();
	private ArrayList<TWClient> twClients = new ArrayList<TWClient>();
	
	private ETFQuote etfQuoteChosen;
	public ETFQuote getEtfQuotChosen() {return this.etfQuoteChosen;}
	private TWClient twClientChosen;
	public TWClient getTwClientChosen() {return this.twClientChosen;}
	
	private ObservableList<MarketMaker> marketMakersChosen;
	public void setMarketMakersChosen(ObservableList<MarketMaker> marketMakersChosen) {this.marketMakersChosen = marketMakersChosen;}
	
	private Margin marginChosenBid;
	public void setMarginChosenBid(Margin marginChosenBid) {this.marginChosenBid = marginChosenBid;}
	private Margin marginChosenAsk;
	public void setMarginChosenAsk(Margin marginChosenAsk) {this.marginChosenAsk = marginChosenAsk;}
	private Margin marginChosen;
	public void setMarginChosen(Margin marginChosen) {this.marginChosen = marginChosen;}
	
	private int numberOfQuote = 30;
	private double[] permittedQuoteBid;
	private double[] permittedQuoteAsk;
	private double[] permittedQuote;

	private Double randomQuoteBid;
	private Double randomQuoteAsk;
	private Double randomQuote;

	private MarketMaker randomMMBid;
	private MarketMaker randomMMAsk;
	private MarketMaker randomMM;
	
	private String[] ways = {"ask", "bid", "2"};
	private String wayChosen;
	public void setWayChosen(String wayChosen) {this.wayChosen= wayChosen;}
	public String getWayChosen() {return this.wayChosen;}
	
	private Integer quantityChosen;
	public Integer getQuantityChosen() {return this.quantityChosen;}
	private Integer quantityMin = 10000;
	private Integer quantityMax = 100000;

	private boolean accepted = false;
	private boolean declined = false;
	public void setAccepted(boolean accepted) {this.accepted = accepted;}
	public void setDeclined(boolean declined) {this.declined = declined;}
	
	public DataModel(){
		addData();
	}
	
	private void addData() {
		marketMakers.add(new MarketMaker("MM0", "Market Maker 0", "Description 0", true));
		marketMakers.add(new MarketMaker("MM1", "Market Maker 1", "Description 1", true));
		marketMakers.add(new MarketMaker("MM2", "Market Maker 2", "Description 2", true));
		marketMakers.add(new MarketMaker("MM3", "Market Maker 3", "Description 3", true));
		marketMakers.add(new MarketMaker("MM4", "Market Maker 4", "Description 4", true));
		marketMakers.add(new MarketMaker("MM5", "Market Maker 5", "Description 5", true));
		marketMakers.add(new MarketMaker("MM6", "Market Maker 6", "Description 6", false));
		marketMakers.add(new MarketMaker("MM7", "Market Maker 7", "Description 7", false));
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);
		try {
			tradesPassed.add(new Trade(0, marketMakers.get(0), "CTW0", "Client TW 0", "bid", "ETF_Ticker_0", "ETF Name 0", 10000, 120.31, 1203100.0, 1, "CT", 100.0, formatter.parse("2019-01-20 10:00:00"), true));
			tradesPassed.add(new Trade(1, marketMakers.get(0), "CTW1", "Client TW 1", "ask", "ETF_Ticker_1", "ETF Name 1", 1000, 90.52, 90520.0, 2, "CT", 20.0, formatter.parse("2019-01-20 11:00:00"), true));
			tradesPassed.add(new Trade(2, marketMakers.get(1), "CTW1", "Client TW 1", "2", "ETF_Ticker_2", "ETF Name 2", 10000, 50.23, 5023000.0, 2, "BP", 230.0, formatter.parse("2019-01-20 15:00:00"), false));
		} catch(Exception e){
			
		}
		
		etfQuotes.add(new ETFQuote("ETF_Ticker_0", "ETF Name 0", 120.27));
		etfQuotes.add(new ETFQuote("ETF_Ticker_1", "ETF Name 1", 90.50));
		etfQuotes.add(new ETFQuote("ETF_Ticker_2", "ETF Name 2", 50.20));
		etfQuotes.add(new ETFQuote("ETF_Ticker_3", "ETF Name 3", 254.8));
		etfQuotes.add(new ETFQuote("ETF_Ticker_4", "ETF Name 4", 207.04));
		
		twClients.add(new TWClient("CTW0", "Client TW 0"));
		twClients.add(new TWClient("CTW1", "Client TW 1"));
		twClients.add(new TWClient("CTW2", "Client TW 2"));
		twClients.add(new TWClient("CTW3", "Client TW 3"));
		twClients.add(new TWClient("CTW4", "Client TW 4"));
	}
	
	public void chooseTWClient(){
		int randomNum = ThreadLocalRandom.current().nextInt(0,this.twClients.size());
		this.twClientChosen = twClients.get(randomNum);
	}
	
	public void chooseETFQuote(){
		int randomNum = ThreadLocalRandom.current().nextInt(0,this.etfQuotes.size());
		this.etfQuoteChosen = etfQuotes.get(randomNum);
	}
	
	public void chooseWay(){
		int randomNum = ThreadLocalRandom.current().nextInt(0,this.ways.length);
		this.wayChosen = ways[randomNum];
	}
	
	public void chooseQuantity(){
		quantityChosen = ThreadLocalRandom.current().nextInt(this.quantityMin, this.quantityMax);
	}

	
	public void generateListOfQuote(double[] permittedQuote) {
		permittedQuote = new double[this.numberOfQuote];
		double quote = this.etfQuoteChosen.getQuote();
		double minQuote = quote-(this.numberOfQuote/2*0.01);
		
		for(int i = 0; i<this.numberOfQuote;i++) {
			permittedQuote[i] = minQuote + i*0.01;
		}
	}
	
	
	public boolean clientShooted() {
		 try {
            //assuming it takes 10 seconds to complete the task
            Thread.sleep(10000);
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
	}
	
	
	public void generateRandomQuoteAndMM(MarketMaker randomMM, Double randomQuote, double[] permittedQuote) {
		int randomQuoteIndex = ThreadLocalRandom.current().nextInt(0,this.numberOfQuote);
		int randomMMIndex = ThreadLocalRandom.current().nextInt(0,this.marketMakersChosen.size());
		
		randomQuote = permittedQuote[randomQuoteIndex];
		randomMM = marketMakersChosen.get(randomMMIndex);
	}
	
	public void simulateQuoteByMM() {
		while(!accepted && !declined) {
			if(this.wayChosen.equals("2") || this.wayChosen.equals("bid"))
				generateRandomQuoteAndMM(randomMMBid, randomQuoteBid, permittedQuoteBid);
			if(this.wayChosen.equals("2") || this.wayChosen.equals("ask"))
				generateRandomQuoteAndMM(randomMMAsk, randomQuoteAsk, permittedQuoteAsk);
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void realWay() {
		if(this.wayChosen.equals("2")) {
			int randomNum = ThreadLocalRandom.current().nextInt(0,this.ways.length-1);
			this.wayChosen = ways[randomNum];
		}
		if(wayChosen.equals("bid")) {
			this.marginChosen = marginChosenBid;
		}
		else if(wayChosen.equals("ask")) {
			this.marginChosen = marginChosenAsk;
		}
	}
	
	public void addCurrendTrade() {
		Date dateTrade = new Date();
		Double nominal = null;
		if(quantityChosen != null && randomQuote!=null)
			nominal= quantityChosen*randomQuote;
		
		Trade trade = new Trade();
		trade.setIdTrade(tradesPassed.size());
		trade.setMarketMaker(randomMM);
		trade.setIdClientTW(twClientChosen==null?null:twClientChosen.getId());
		trade.setNameClient(twClientChosen==null?null:twClientChosen.getName());
		trade.setWay(wayChosen);
		trade.setTicker(etfQuoteChosen==null?null:etfQuoteChosen.getId());
		trade.setEtfName(etfQuoteChosen==null?null:etfQuoteChosen.getName());
		trade.setQuantity(quantityChosen);
		trade.setQuote(randomQuote);
		trade.setNominal(nominal);
		trade.setMargin(marginChosen==null?null:marginChosen.getMargin());
		trade.setTypeMargin(marginChosen==null?null:marginChosen.getTypeMargin());
		trade.setMarginValue(calculateMarginValue(nominal, marginChosen==null?null:marginChosen.getTypeMargin(), marginChosen==null?null:marginChosen.getMargin()));
		trade.setDateTrade(dateTrade);
		trade.setDone(accepted);
		
		tradesPassed.add(trade);
	}

	public Double calculateMarginValue(Double nominal, String typeMargin, Integer margin) {
		if(typeMargin != null && margin != null && nominal != null) {
			if(typeMargin.equals("CT"))
				return margin*0.01*nominal;
			else if(typeMargin.equals("BP"))
				return margin*0.00001*nominal;
		}
		return null;
	}
}
