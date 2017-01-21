package controllers;

import models.Game;
import models.State;


public class MenuOptionController extends Controller{

	public MenuOptionController (Game game){
		super (game);
	}
	
	public OperationController getOperationMenu(int option){
		switch(option){
			case 1:
				return new DeckToWasteController(game);
			case 2:
				return new WasteToDeckController(game);
			case 3:
				return new WasteToFoundationController(game);
			case 4:
				return new WasteToPileController(game);
			case 5:
				return new PileToFoundationController(game);
			case 6:
				return new PileToPileController(game);
			case 7:
				return new FoundationToPileController(game);
			case 8:
				return new TurnUpCardInPileController(game);
			case 9:
				return new ExitController(game);
			default:
				this.setState();
				break;
		}
		return null;
	}
	
	@Override
	public void setState() {
		this.setState(State.EXIT);
	}	
}
