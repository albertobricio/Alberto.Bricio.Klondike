package com.klondike.views;

import com.klondike.controllers.MoveFromWasteToFoundationController;
import com.klondike.utils.IO;

public class MoveFromWasteToFoundationView {
	
    private MenuView menuView;
	
	private GameView gameView;
	
	private ErrorView errorView;
	
	public MoveFromWasteToFoundationView()
	{
		this.menuView = new MenuView();
		this.errorView = new ErrorView();
	}
	
	public void interact(MoveFromWasteToFoundationController moveFromWasteToFoundationController)
	{
		IO.instance().writeln("===========================");
		if (moveFromWasteToFoundationController.canMove(moveFromWasteToFoundationController.getGame()))
		{
			moveFromWasteToFoundationController.move(moveFromWasteToFoundationController.getGame());
			gameView = new GameView(moveFromWasteToFoundationController.getGame());
			gameView.render();
			menuView.render();
		}
		else
		{
			errorView.visualizeMovementToFoundationError();
		}
	}

}
