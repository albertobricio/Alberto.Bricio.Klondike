package com.klondike.views;

import com.klondike.controllers.MoveFromDeckToWasteController;

public class MoveFromDeckToWasteView{

    private MenuView menuView;
	
	private GameView gameView;
	
	public MoveFromDeckToWasteView()
	{
		this.menuView = new MenuView();
	}
	
	public void interact(MoveFromDeckToWasteController moveFromDeckToWasteController)
	{
		moveFromDeckToWasteController.move(moveFromDeckToWasteController.getGame());
		gameView = new GameView(moveFromDeckToWasteController.getGame());
		gameView.render();
		menuView.render();
	}
}
