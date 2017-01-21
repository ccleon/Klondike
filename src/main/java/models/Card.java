package models;

public class Card {
	
	private Rank rank;
	private Suit suit;
	private Color color;
	private boolean turnedUp;

	public Card (Rank rank, Suit suit){
		this.rank = rank;
		this.suit = suit;
		this.turnedUp = false;
		if (suit.equals(Suit.CLUBS) || suit.equals(Suit.SPADES)){
			this.color = Color.BLACK;
		}else{
			this.color = Color.RED;
		}
	}
	
	public Rank getRank(){
		return rank;
	}
		
	public Suit getSuit(){
		return suit;
	}
	
	public String getColor (){
		return color.getColor();
	}
	
	public boolean isTurnedUp(){
		return turnedUp;
	}
	
	public void setTurnedUp (boolean turnedUp){
		this.turnedUp = turnedUp;
	}
	
	public boolean sameColor (Card card){
		return card.getColor() == color.getColor();
	}
	
	public boolean sameSuit (Card card){
		return card.getSuit() == suit;
	}
	
	public boolean isNextRank (Card card){
		assert card != null;
		return rank.nextRank() == card.getRank();
	}
	
	public boolean isPreviousRank (Card card){
		assert card != null;
		return rank.previousRank() == card.getRank();
	}
	
	@Override
	public String toString (){
		return "[" + rank.getRank() + ", " + suit.getSuit() + "]";
	}
}
