package controllers;

public interface OperationControllerVisitor {
	void visit(StartController startController);
	void visit(DeckToWasteController deckToWasteController);
	void visit(WasteToDeckController wasteToDeckController);
	void visit(ExitController exitController);
	void visit(FoundationToPileController foundationToPileController);
	void visit(PileToFoundationController pileToFoundationController);
	void visit(PileToPileController pileToPileController);
	void visit(TurnUpCardInPileController turnUpCardInPileController);
	void visit(WasteToFoundationController wasteToFoundationController);
	void visit(WasteToPileController wasteToPileController);
	void visit(OptionInputController optionInputController);
}
