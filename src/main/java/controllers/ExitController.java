package controllers;

import models.Game;
import models.State;

public class ExitController extends OperationController{
	
	public ExitController (Game game){
		super(game);
	}
	
	public void setState(){
		this.setState(State.EXIT);
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}
}
