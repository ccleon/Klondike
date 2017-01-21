package controllers;

import models.Game;
import models.State;
import java.util.List;
import models.Deck;
import models.Waste;
import models.Foundation;
import models.Pile;
import models.Suit;

public abstract class Controller {
	protected Game game;
	
	protected Controller (Game game){
		assert game != null;
		this.game = game;
	}
	
	protected Game getGame(){
		return game;
	}
	
	protected State getState(){
		return game.getState();
	}
	
	protected abstract void setState();
	
	public void setState (State state){
		assert state != null;
		game.setState(state);
	}
	
	public Deck getDeck(){
		return game.getDeck();
	}
	
	public Waste getWaste(){
		return game.getWaste();
	}
	
	public List<Foundation> getFoundations(){
		return game.getFoundations();
	}
	
	public List<Pile> getPiles(){
		return game.getPiles();
	}
	
	public Foundation getFoundation(Suit suit){
		return game.getFoundation(suit);
	}

}
