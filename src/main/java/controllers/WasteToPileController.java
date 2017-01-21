package controllers;

import models.Card;
import models.Game;
import models.Pile;
import models.Rank;
import models.State;
import utils.LimitedIntDialog;

public class WasteToPileController extends OperationController{
	
	public WasteToPileController(Game game){
		super(game);
	}
	
	public boolean moveWasteToPile(){
		if (!this.getWaste().isEmpty()){
			int dest = new LimitedIntDialog("A que escalera?", 1, 7).read() - 1;
			Card card = this.getWaste().peekCard();
			Pile pile = this.getPiles().get(dest);
			
			if (suitablePile(pile, card)){
				pile.pushCard(this.getWaste().popCard());
				return true;
			}else{
				errorReport.generalError();
				return false;
			}
		}else{
			errorReport.specificError("ERROR: Los descartes están vacíos");
			return false;
		}
	}
	
	public boolean suitablePile(Pile pile, Card card){
		if (pile.isEmpty()){
			if (card.getRank() == Rank.KING)
				return true;
		}else{
			if (card.getRank() != Rank.KING){
				Card destCard = pile.peekCard();
				if (card.isNextRank(destCard) && !card.sameColor(destCard))
					return true;
			}
		}
		return false;
	}
	
	@Override
	public void setState() {
		this.setState(State.SELECT_OPTION);
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}

}
