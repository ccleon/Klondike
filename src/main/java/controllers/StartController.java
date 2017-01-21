package controllers;

import models.Game;
import models.State;

public class StartController extends OperationController{
	
	protected StartController (Game game){
		super(game);
	}
	
	public void setState(){
		assert this.getState() == State.INITIAL;
		this.setState(State.SELECT_OPTION);
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}

}
