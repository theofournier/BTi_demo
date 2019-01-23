package model;

public class MarketMaker {
	
	private String idMarketMaker;
	private String name;
	private String description;
	private Boolean selected;
	
	
	public MarketMaker(String idMarketMaker, String name, String description, Boolean selected) {
		super();
		this.idMarketMaker = idMarketMaker;
		this.name = name;
		this.description = description;
		this.selected = selected;
	}


	public String getIdMarketMaker() {
		return idMarketMaker;
	}


	public void setIdMarketMaker(String idMarketMaker) {
		this.idMarketMaker = idMarketMaker;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Boolean getSelected() {
		return selected;
	}


	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
	
	

}
