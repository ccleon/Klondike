package controllers;

import models.Foundation;
import models.Game;
import models.State;

public class OptionInputController extends OperationController{
	private int menuOption;
	
	public OptionInputController (Game game){
		super (game);
	}
	
	public void setOption(int menuOption){
		this.menuOption = menuOption;
	}
	
	public int getOption(){
		return menuOption;
	}
	
	public boolean isGameFinished() {
		for (Foundation foundation : this.getFoundations()) {
			if (foundation.size() != 12){
				return false;
			}
		}
		return true;
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}

	@Override
	public void setState() {
		this.setState(State.IN_GAME);
	}

}
