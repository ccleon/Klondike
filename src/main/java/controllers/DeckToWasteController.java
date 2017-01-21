package controllers;

import models.Card;
import models.Game;
import models.State;

public class DeckToWasteController extends OperationController{
	
	public DeckToWasteController(Game game){
		super(game);
	}
	
	public void moveDeckToWaste(){
		if(this.getDeck().isEmpty()){
			errorReport.specificError("ERROR: La baraja está vacía");
		}else{
			this.getWaste().turnDownAll();
			if (this.getDeck().size() < 3){
				moveCardsToWaste(this.getDeck().size());
			}else{
				moveCardsToWaste(3);
			}
		}
	}
	
	public void moveCardsToWaste(int quantity){
		for (int i=0; i<quantity; i++){
			Card card = this.getDeck().popCard();
			card.setTurnedUp(true);
			this.getWaste().pushCard(card);
		}
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}
	
	@Override
	public void setState() {
		this.setState(State.SELECT_OPTION);
	}
}
