package views;

import controllers.*;
import models.State;

public class GameView implements OperationControllerVisitor{
	
	public void interact(OperationController controller) {
		assert controller != null;
		controller.accept(this);}
		

	@Override
	public void visit(StartController startController) {
		startController.setState();
	}
	
	@Override
	public void visit(OptionInputController optionInputController) {
		if (optionInputController.isGameFinished()){
			optionInputController.setState(State.EXIT);
		}else{
			optionInputController.setState();
			new BoardView(optionInputController).showAllParts();
			optionInputController.setOption(new MenuView().readOptionMenu());
		}
	}

	@Override
	public void visit(DeckToWasteController deckToWasteController) {
		deckToWasteController.setState();
		deckToWasteController.moveDeckToWaste();
	}

	@Override
	public void visit(WasteToDeckController wasteToDeckController) {
		wasteToDeckController.setState();
		wasteToDeckController.moveWasteToDeck();
	}

	@Override
	public void visit(ExitController exitController) {
		exitController.setState();
		System.out.println("Bye!");
	}

	@Override
	public void visit(FoundationToPileController foundationToPileController) {
		foundationToPileController.setState();
		foundationToPileController.moveFoundationToPile();
	}

	@Override
	public void visit(PileToFoundationController pileToFoundationController) {
		pileToFoundationController.setState();
		pileToFoundationController.movePileToFoundation();
	}

	@Override
	public void visit(PileToPileController pileToPileController) {
		pileToPileController.setState();
		pileToPileController.movePileToPile();
	}

	@Override
	public void visit(TurnUpCardInPileController turnUpCardInPileController) {
		turnUpCardInPileController.setState();
		turnUpCardInPileController.turnUpCardInPile();
	}

	@Override
	public void visit(WasteToFoundationController wasteToFoundationController) {
		wasteToFoundationController.setState();
		wasteToFoundationController.moveWasteToFoundation();
	}

	@Override
	public void visit(WasteToPileController wasteToPileController) {
		wasteToPileController.setState();
		wasteToPileController.moveWasteToPile();
	}
}
