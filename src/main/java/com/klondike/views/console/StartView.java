package com.klondike.views.console;

import com.klondike.controllers.StartController;
import com.klondike.utils.IO;
import com.klondike.views.GameView;
import com.klondike.views.MenuView;

public class StartView {
	
	private MenuView menuView;
	
	private GameView gameView;
	
	StartView()
	{
		this.menuView = new MenuView();
	}
	
	void interact(StartController startController)
	{
		IO.instance().writeln("===========================");
		gameView = new GameView(startController.getGame());
		gameView.render();
		menuView.render();
		startController.start();
	}

}
