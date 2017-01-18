package com.klondike.views;

import com.klondike.controllers.MoveFromTableauToFoundationController;
import com.klondike.utils.ClosedInterval;
import com.klondike.utils.IO;

public class MoveFromTableauToFoundationView extends AskUserView{
	
	private MenuView menuView;
	
    private GameView gameView;
    
    private ErrorView errorView;
    
    private static final int FIRST_TABLEAU = 1;
	
	private static final int LAST_TABLEAU = 7;
	
	public MoveFromTableauToFoundationView()
	{
		this.menuView = new MenuView();
		this.errorView = new ErrorView();
	}
	
	@Override
	protected void showQuestion() {
		IO.instance().writeln("De que escalera? [1-7]: ");
	}
	
	public void interact(MoveFromTableauToFoundationController moveFromTableauToFoundationController)
	{
		ClosedInterval ci = new ClosedInterval(FIRST_TABLEAU, LAST_TABLEAU);
		int tableauNumber;
		tableauNumber = this.ask();
		assert ci.includes(tableauNumber);
		if(moveFromTableauToFoundationController.canMove(moveFromTableauToFoundationController.getGame(), tableauNumber))
		{
			moveFromTableauToFoundationController.move(moveFromTableauToFoundationController.getGame(), tableauNumber);
			gameView = new GameView(moveFromTableauToFoundationController.getGame());
			gameView.render();
			menuView.render();
		}
		else
		{
			errorView.visualizeMovementToFoundationError();
		}
	}

}
