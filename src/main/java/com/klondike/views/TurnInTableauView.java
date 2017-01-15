package com.klondike.views;

import com.klondike.controllers.TurnInTableauController;
import com.klondike.utils.IO;

public class TurnInTableauView extends AskUserView{
	
private MenuView menuView;
	
	private GameView gameView;
	
	private ErrorView errorView;
	
	public TurnInTableauView()
	{
		this.menuView = new MenuView();
		this.errorView = new ErrorView();
	}
	
	public void interact(TurnInTableauController turnInTableauController)
	{
		int tableauNumber;
		IO.instance().writeln("===========================");
		tableauNumber = this.ask();
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
