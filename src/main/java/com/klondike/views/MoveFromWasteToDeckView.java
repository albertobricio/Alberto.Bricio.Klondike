package com.klondike.views;

import com.klondike.controllers.MoveFromWasteToDeckController;
import com.klondike.utils.IO;

public class MoveFromWasteToDeckView {
	
    private MenuView menuView;
	
	private GameView gameView;
	
	public MoveFromWasteToDeckView()
	{
		this.menuView = new MenuView();
	}
	
	public void interact(MoveFromWasteToDeckController moveFromWasteToDeckController)
	{
		IO.instance().writeln("===========================");
		moveFromWasteToDeckController.move(moveFromWasteToDeckController.getGame());
		gameView = new GameView(moveFromWasteToDeckController.getGame());
		gameView.render();
		menuView.render();
	}

}
