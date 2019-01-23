package model;

import java.util.Date;

public class Trade {

	private Integer idTrade;
	private MarketMaker marketMaker;
	private String idClientTW;
	private String nameClient;
	private String way;
	private String ticker;
	private String etfName;
	private Integer quantity;
	private Double quote;
	private Double nominal;
	private Integer margin;
	private String typeMargin;
	private Double marginValue;
	private Date dateTrade;
	private Boolean done;
	
	public Trade() {
		
	}
	
	
	public Trade(Integer idTrade, MarketMaker marketMaker, String idClientTW, String nameClient, String way,
			String ticker, String etfName, Integer quantity, Double quote, Double nominal, Integer margin,
			String typeMargin, Double marginValue, Date dateTrade, Boolean done) {
		super();
		this.idTrade = idTrade;
		this.marketMaker = marketMaker;
		this.idClientTW = idClientTW;
		this.nameClient = nameClient;
		this.way = way;
		this.ticker = ticker;
		this.etfName = etfName;
		this.quantity = quantity;
		this.quote = quote;
		this.nominal = nominal;
		this.margin = margin;
		this.typeMargin = typeMargin;
		this.marginValue = marginValue;
		this.dateTrade = dateTrade;
		this.done = done;
	}


	public Integer getIdTrade() {
		return idTrade;
	}


	public void setIdTrade(Integer idTrade) {
		this.idTrade = idTrade;
	}


	public MarketMaker getMarketMaker() {
		return marketMaker;
	}


	public void setMarketMaker(MarketMaker marketMaker) {
		this.marketMaker = marketMaker;
	}


	public String getIdClientTW() {
		return idClientTW;
	}


	public void setIdClientTW(String idClientTW) {
		this.idClientTW = idClientTW;
	}


	public String getNameClient() {
		return nameClient;
	}


	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}


	public String getWay() {
		return way;
	}


	public void setWay(String way) {
		this.way = way;
	}


	public String getTicker() {
		return ticker;
	}


	public void setTicker(String ticker) {
		this.ticker = ticker;
	}


	public String getEtfName() {
		return etfName;
	}


	public void setEtfName(String etfName) {
		this.etfName = etfName;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Double getQuote() {
		return quote;
	}


	public void setQuote(Double quote) {
		this.quote = quote;
	}


	public Double getNominal() {
		return nominal;
	}


	public void setNominal(Double nominal) {
		this.nominal = nominal;
	}


	public Integer getMargin() {
		return margin;
	}


	public void setMargin(Integer margin) {
		this.margin = margin;
	}


	public String getTypeMargin() {
		return typeMargin;
	}


	public void setTypeMargin(String typeMargin) {
		this.typeMargin = typeMargin;
	}


	public Double getMarginValue() {
		return marginValue;
	}


	public void setMarginValue(Double marginValue) {
		this.marginValue = marginValue;
	}


	public Date getDateTrade() {
		return dateTrade;
	}


	public void setDateTrade(Date dateTrade) {
		this.dateTrade = dateTrade;
	}


	public Boolean getDone() {
		return done;
	}


	public void setDone(Boolean done) {
		this.done = done;
	}
	
	
	
}
