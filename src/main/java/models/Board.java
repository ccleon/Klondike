package models;

import java.util.List;
import java.util.ArrayList;

public class Board {
	public Deck deck;
	public Waste waste;
	public List<Foundation> foundations;
	public List<Pile> piles;
	
	public Board (){
		deck = new Deck();
		waste = new Waste();
		foundations = new ArrayList<Foundation>();
		piles = new ArrayList<Pile>();
		initFoundations();
		initPiles();
	}
	
	public void initFoundations(){
		foundations.add(new Foundation(Suit.CLUBS));
		foundations.add(new Foundation(Suit.DIAMONDS));
		foundations.add(new Foundation(Suit.HEARTS));
		foundations.add(new Foundation(Suit.SPADES));
	}
	
	public void initPiles(){
		for (int i=0; i<7; i++){
			piles.add(new Pile(i+1));
		}
		cardsToPiles();
	}
	
	public void cardsToPiles(){
		int stop = 1;
		for (Pile pile : piles){
			for(int i=0; i<stop; i++){
				pile.pushCard(deck.popCard());
			}
			stop++;
			pile.turnUpFirstCard();
		}
	}
	
	public Deck getDeck(){
		return deck;
	}
	
	public Waste getWaste(){
		return waste;
	}
	
	public List<Foundation> getFoundations(){
		return foundations;
	}
	
	public Foundation getFoundation(Suit suit){
		for (Foundation founds : this.getFoundations()){
			if(founds.getSuit() == suit){
				return founds;
			}
		}
		return null;
	}
	
	public List<Pile> getPiles(){
		return piles;
	}

}
