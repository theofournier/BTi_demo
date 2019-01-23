package model;

public class ETFQuote {
	
	private String id;
	private String name;
	private Double quote;
	
	public ETFQuote(String id, String name, Double quote) {
		super();
		this.id = id;
		this.name = name;
		this.quote = quote;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getQuote() {
		return quote;
	}

	public void setQuote(Double quote) {
		this.quote = quote;
	}

	
	

}
