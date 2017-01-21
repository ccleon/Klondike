package models;

public enum Color {
	
	BLACK("b"),
	RED("r");
	private String color;
	
	private Color(String color){
		this.color = color;
	}
	
	public String getColor(){
		return color;
	}

}
