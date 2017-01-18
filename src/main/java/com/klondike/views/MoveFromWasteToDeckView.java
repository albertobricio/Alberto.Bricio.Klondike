package com.klondike.views;

import com.klondike.controllers.MoveFromWasteToDeckController;

public class MoveFromWasteToDeckView {
	
    private MenuView menuView;
	
	private GameView gameView;
	
	public MoveFromWasteToDeckView()
	{
		this.menuView = new MenuView();
	}
	
	public void interact(MoveFromWasteToDeckController moveFromWasteToDeckController)
	{
		moveFromWasteToDeckController.move(moveFromWasteToDeckController.getGame());
		gameView = new GameView(moveFromWasteToDeckController.getGame());
		gameView.render();
		menuView.render();
	}

}
