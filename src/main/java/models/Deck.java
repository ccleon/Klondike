package models;

public class Deck extends CardStack{
	
	public Deck (){
		super();
		Rank[] ranks = Rank.values();
		Suit[] suits = Suit.values();
		for (Rank rank : ranks){
			for (Suit suit : suits){
				cardStack.add(new Card(rank, suit));
			}
		}
		this.shuffle();
	}
	
	@Override
	public String toString(){
		if (cardStack.isEmpty()){
			return "<vacio>";
		}else{
			return "[X,X]";
		}
	}

}
