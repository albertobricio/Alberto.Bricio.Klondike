package com.klondike.views;

import com.klondike.controllers.MoveFromWasteToTableauController;
import com.klondike.utils.ClosedInterval;
import com.klondike.utils.IO;

public class MoveFromWasteToTableauView extends AskUserView{
	
	private MenuView menuView;
		
    private GameView gameView;
    
    private ErrorView errorView;
    
    private static final int FIRST_TABLEAU = 1;
	
	private static final int LAST_TABLEAU = 7;
	
	public MoveFromWasteToTableauView()
	{
		this.menuView = new MenuView();
		this.errorView = new ErrorView();
	}

	@Override
	protected void showQuestion() {
		IO.instance().writeln("A que escalera? [1-7]: ");
	}
	
	public void interact(MoveFromWasteToTableauController moveFromWasteToTableauController)
	{
		ClosedInterval ci = new ClosedInterval(FIRST_TABLEAU, LAST_TABLEAU);
		int tableauNumber;
		tableauNumber = this.ask();
		assert ci.includes(tableauNumber);
		if(moveFromWasteToTableauController.canMove(moveFromWasteToTableauController.getGame(), tableauNumber))
		{
			moveFromWasteToTableauController.move(moveFromWasteToTableauController.getGame(), tableauNumber);
			gameView = new GameView(moveFromWasteToTableauController.getGame());
			gameView.render();
			menuView.render();
		}
		else
		{
			errorView.visualizeMovementToTableauError();
		}
	}
}
