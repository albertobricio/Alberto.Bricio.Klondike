package com.klondike.controllers;

import com.klondike.models.Game;
import com.klondike.models.Observer;
import com.klondike.models.Subject;

public class MoveFromWasteToDeckController extends OperationController{
	
	private Subject subject;

	MoveFromWasteToDeckController(Observer observer, Game game) {
		super(game);
		subject = new Subject();
		subject.register(observer);
	}

	public void move(Game game)
	{
		assert game != null;
		
		game.emptyWaste(game.getGameWaste(), game.getGameDeck());
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}
	
}
