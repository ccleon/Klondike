package models;

public enum Suit {
	
	HEARTS("h"),
	DIAMONDS("d"),
	CLUBS("c"),
	SPADES("s");
	private String value;
	
	private Suit (String value){
		this.value = value;
	}
	
	public String getSuit(){
		return value;
	}
}
