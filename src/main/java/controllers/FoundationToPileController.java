package controllers;

import models.Card;
import models.Foundation;
import models.Game;
import models.Pile;
import models.Rank;
import models.State;
import utils.LimitedIntDialog;

public class FoundationToPileController extends OperationController{
	
	public FoundationToPileController(Game game){
		super(game);
	}
	
	public void moveFoundationToPile(){
		int origin = new LimitedIntDialog("De que palo?", 1, 4).read() -1;
		int dest = new LimitedIntDialog("A que escalera?", 1, 7).read() -1;
		Foundation foundOrigin = this.getFoundations().get(origin);
		Pile pileDest = this.getPiles().get(dest);
		
		if (!foundOrigin.isEmpty()){
			if (suitablePileFromFoundation(pileDest, foundOrigin.peekCard())){
				pileDest.pushCard(foundOrigin.popCard());
			}else{
				errorReport.generalError();
			}
		}else{
			errorReport.specificError("ERROR: Palo vacio");
		}
	}
	
	public boolean suitablePileFromFoundation(Pile pile, Card card) {
			if (pile.isEmpty()) {
				if (card.getRank() == Rank.KING){
					return true;
				}else{
					return false;
				}
			}else{
				if (pile.peekCard().isTurnedUp()){
					if (card.getRank() != Rank.KING) {
						Card destCard = pile.peekCard();
						if (card.isNextRank(destCard) && !card.sameColor(destCard))
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
