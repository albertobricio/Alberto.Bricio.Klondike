package com.klondike.views;

import com.klondike.controllers.MoveFromWasteToFoundationController;

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
