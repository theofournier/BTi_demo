package model;

public class Margin {
	
	private String typeMargin;
	private Integer margin;
	
	public Margin(String typeMargin, Integer margin) {
		super();
		this.typeMargin = typeMargin;
		this.margin = margin;
	}

	public String getTypeMargin() {
		return typeMargin;
	}

	public void setTypeMargin(String typeMargin) {
		this.typeMargin = typeMargin;
	}

	public Integer getMargin() {
		return margin;
	}

	public void setMargin(Integer margin) {
		this.margin = margin;
	}
	
	

}
