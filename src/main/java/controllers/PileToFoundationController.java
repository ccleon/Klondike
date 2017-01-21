package controllers;

import models.Card;
import models.Foundation;
import models.Game;
import models.Pile;
import models.Rank;
import models.State;
import utils.LimitedIntDialog;

public class PileToFoundationController extends OperationController{
	
	public PileToFoundationController(Game game){
		super(game);
	}
	
	public void movePileToFoundation(){
		int origin = new LimitedIntDialog("De que escalera?", 1, 7).read() -1;
		Pile pile = this.getPiles().get(origin);
		
		if (!pile.isEmpty()){
			Card card = pile.peekCard();
			if (card.isTurnedUp()){
					Foundation foundation = this.getFoundation(card.getSuit());
					if (suitableSuitFromPile(card)){
						foundation.pushCard(pile.popCard());
					}else{
						errorReport.generalError();
					}
			}else{
				errorReport.specificError("ERROR: La carta no está volteada");
			}
		}else{
			errorReport.specificError("ERROR: La escalera está vacía");
		}
	}
	
	public boolean suitableSuitFromPile(Card card){
		Foundation foundation = this.getFoundation(card.getSuit());
		if (card.getRank() == Rank.ACE && foundation.isEmpty()){
			return true;
		}else{
			if (!foundation.isEmpty()){
				Rank previous = card.getRank().previousRank();
				if (previous == foundation.peekCard().getRank()){
					return true;
				}
			}
		}
		return false;
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
