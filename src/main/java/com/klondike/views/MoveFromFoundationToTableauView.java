package com.klondike.views;

import com.klondike.controllers.MoveFromFoundationToTableauController;
import com.klondike.utils.ClosedInterval;
import com.klondike.utils.IO;

public class MoveFromFoundationToTableauView {
	
    private MenuView menuView;
	
	private GameView gameView;
	
	private ErrorView errorView;
	
    private static final int FIRST_TABLEAU = 1;
	
	private static final int LAST_TABLEAU = 7;
	
    private static final int FIRST_FOUNDATION = 1;
	
	private static final int LAST_FOUNDATION = 4;
	
	public MoveFromFoundationToTableauView()
	{
		this.menuView = new MenuView();
		this.errorView = new ErrorView();
	}
	
	private void askFromWhatFoundation()
	{
		IO.instance().writeln("De que palo? [1-4]: ");
	}
	
	private void askToWhatTableau()
	{
		IO.instance().writeln("A que escalera? [1-7]: ");
	}

	public void interact(MoveFromFoundationToTableauController moveFromFoundationToTableauController)
	{
		ClosedInterval ci1 = new ClosedInterval(FIRST_TABLEAU, LAST_TABLEAU);
		ClosedInterval ci2 = new ClosedInterval(FIRST_FOUNDATION, LAST_FOUNDATION);
		int foundationNumber;
		int tableauNumber;
		this.askFromWhatFoundation();
		foundationNumber = IO.instance().readInt();
		assert ci2.includes(foundationNumber);
		this.askToWhatTableau();
		tableauNumber = IO.instance().readInt();
		assert ci1.includes(tableauNumber);
		if(moveFromFoundationToTableauController.canMove(
				moveFromFoundationToTableauController.getGame(), foundationNumber, tableauNumber))
		{
			moveFromFoundationToTableauController.move(
					moveFromFoundationToTableauController.getGame(), foundationNumber, tableauNumber);
			gameView = new GameView(moveFromFoundationToTableauController.getGame());
			gameView.render();
			menuView.render();
		}
		else
		{
			errorView.visualizeMovementToTableauError();
		}
	}
}
