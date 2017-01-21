package models;

public class Foundation extends CardStack{
	private Suit suit;
	
	public Foundation(Suit suit){
		super();
		this.suit = suit;
	}
	
	public boolean sameSuit(Card card){
		return card.getSuit() == suit;
	}
	
	public Suit getSuit (){
		return suit;
	}
	
	@Override
	public String toString(){
		if (this.cardStack.isEmpty()){
			return "Palo " + suit.toString() + ": <vacio>"; 
		}else{
			return "Palo " + suit.toString() + ": " + super.toString();
		}
	}
}
