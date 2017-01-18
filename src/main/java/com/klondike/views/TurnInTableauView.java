package com.klondike.views;

import com.klondike.controllers.TurnInTableauController;
import com.klondike.utils.ClosedInterval;
import com.klondike.utils.IO;

public class TurnInTableauView extends AskUserView{
	
private MenuView menuView;
	
	private GameView gameView;
	
	private ErrorView errorView;
	
    private static final int FIRST_TABLEAU = 1;
	
	private static final int LAST_TABLEAU = 7;
	
	public TurnInTableauView()
	{
		this.menuView = new MenuView();
		this.errorView = new ErrorView();
	}
	
	public void interact(TurnInTableauController turnInTableauController)
	{
		ClosedInterval ci = new ClosedInterval(FIRST_TABLEAU, LAST_TABLEAU);
		int tableauNumber;
		tableauNumber = this.ask();
		assert ci.includes(tableauNumber);
		if(turnInTableauController.canTurn(turnInTableauController.getGame(), tableauNumber))
		{
			turnInTableauController.turn(turnInTableauController.getGame(), tableauNumber);
			gameView = new GameView(turnInTableauController.getGame());
			gameView.render();
			menuView.render();
		}
		else
		{
			errorView.visualizeTurningTurnedCardError();
		}
	}

	@Override
	protected void showQuestion() {
		IO.instance().writeln("En que escalera? [1-7]: ");
	}

}
