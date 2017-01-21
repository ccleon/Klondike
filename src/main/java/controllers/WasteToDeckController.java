package controllers;

import models.Game;
import models.State;

public class WasteToDeckController extends OperationController{
	
	public WasteToDeckController(Game game){
		super(game);
	}
	
	public boolean moveWasteToDeck(){
		if (this.getDeck().isEmpty()){
			while(!this.getWaste().isEmpty()){
				this.getDeck().pushCard(this.getWaste().popCard());
			}
			return true;
		}else{
			errorReport.generalError();
			return false;
		}
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
