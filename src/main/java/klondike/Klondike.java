package klondike;

import views.GameView;
import controllers.Logic;
import controllers.OperationController;

public class Klondike {
	private Logic logic;
	private GameView view;
	
	public Klondike(){
		logic = new Logic();
		view = new GameView();
	}
	
	public void play(){
		OperationController controller;
		do{
			controller = logic.getOperationController();
			if(controller != null){
				view.interact(controller);
			}
		}while (controller != null);
	}

	public static void main(String[] args) {
		new Klondike().play();
	}
}
