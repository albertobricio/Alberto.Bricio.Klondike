package com.klondike.views;

import com.klondike.controllers.MoveFromTableauToTableauController;
import com.klondike.utils.ClosedInterval;
import com.klondike.utils.IO;

public class MoveFromTableauToTableauView {
	
    private MenuView menuView;
	
	private GameView gameView;
	
	private ErrorView errorView;
	
    private static final int FIRST_TABLEAU = 1;
	
	private static final int LAST_TABLEAU = 7;
	
	public MoveFromTableauToTableauView()
	{
		this.menuView = new MenuView();
		this.errorView = new ErrorView();
	}
	
	private void askFromWhatTableau()
	{
		IO.instance().writeln("De que escalera? [1-7]: ");
	}
	
	private void askHowManyCards()
	{
		IO.instance().writeln("Cuantas cartas? ");
	}
	
	private void askToWhatTableau()
	{
		IO.instance().writeln("A que escalera? [1-7]: ");
	}
	
	public void interact(MoveFromTableauToTableauController moveFromTableauToTableauController)
	{
		ClosedInterval ci = new ClosedInterval(FIRST_TABLEAU, LAST_TABLEAU);
        int tableauOriginNumber;
        int tableauDestinyNumber;
        int numCartas;
        this.askFromWhatTableau();
        tableauOriginNumber = IO.instance().readInt();
        assert ci.includes(tableauOriginNumber);
		this.askHowManyCards();
		numCartas = IO.instance().readInt();
		this.askToWhatTableau();
		tableauDestinyNumber = IO.instance().readInt();
		assert ci.includes(tableauDestinyNumber);
		if(moveFromTableauToTableauController.canMove(
				moveFromTableauToTableauController.getGame(),
				tableauOriginNumber, 
				tableauDestinyNumber, 
				numCartas))
		{
			moveFromTableauToTableauController.move(
					moveFromTableauToTableauController.getGame(),
					tableauOriginNumber,
					tableauDestinyNumber,
					numCartas);
			gameView = new GameView(moveFromTableauToTableauController.getGame());
			gameView.render();
			menuView.render();
		}
		else{
			errorView.visualizeMovementToTableauError();
		}
	}

}
