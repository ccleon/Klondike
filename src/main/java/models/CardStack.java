package models;

import java.util.Stack;
import java.util.Collections;

public class CardStack {
	protected Stack<Card> cardStack;
	
	public CardStack(){
		cardStack = new Stack<Card>();
	}
	
	public void shuffle(){
		Collections.shuffle(cardStack);
	}
	
	public int size(){
		return this.cardStack.size();
	}
	
	public boolean isEmpty(){
		return this.cardStack.empty();
	}
	
	public Card popCard(){
		return this.cardStack.pop();
	}
	
	public void pushCard(Card card){
		this.cardStack.push(card);
	}
	
	public Card peekCard(){
		return this.cardStack.peek();
	}
	
	public void turnDownAll (){
		for (Card card : this.cardStack){
			card.setTurnedUp(false);
		}
	}
	
	public Stack<Card> getVisibleCards(){
		Stack<Card> stack = new Stack<Card>();
		stack.addAll(cardStack);
		Stack<Card> visibleCards = new Stack<Card>();
		
		for(int i=0; i<this.size(); i++){
			Card topCard = stack.peek();
			if (topCard.isTurnedUp()){
				visibleCards.push(stack.pop());
			}
		}
		return visibleCards;
	}
	
	public String toString(){
		if (cardStack.empty()){
			return "[ ]";
		}else{
			String stackString = "";
			for (int i=0; i<cardStack.size(); i++){
				if (i== cardStack.size() -1 && !cardStack.get(i).isTurnedUp()){
					stackString += "[X, X]";
				}else if (cardStack.get(i).isTurnedUp()){
					stackString += cardStack.get(i).toString();
				}else{
					stackString += "[";
				}
			}
			return stackString;
		}
	}
}
