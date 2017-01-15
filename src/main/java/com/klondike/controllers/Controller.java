package com.klondike.controllers;

import com.klondike.models.Game;

public abstract class Controller {
	
	private Game game;
	
	protected Controller(Game game)
	{
		assert game != null;
		this.game = game;
	}
	
	public Game getGame()
	{
		return game;
	}
	
	public boolean finishAllSuits()
	{
		return game.finishAllSuits();
	}
	
}
