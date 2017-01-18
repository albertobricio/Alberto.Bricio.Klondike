package com.klondike.controllers;

import com.klondike.models.Game;
import com.klondike.models.Observer;
import com.klondike.models.Subject;

public class MoveFromWasteToTableauController extends OperationController{
	
	private Subject subject;
	
	protected MoveFromWasteToTableauController(Observer observer, Game game) {
		super(game);
		subject = new Subject();
		subject.register(observer);
	}
	
	public boolean canMove(Game game, int tableauNumber)
	{
		assert game != null;
		
		if(game.getTableau(tableauNumber).isEmpty())
		{
			return game.canPushCardInEmptyTableau(game.getGameWaste().getWaste(), game.getTableau(tableauNumber));
		}
		else
		{
			return game.canPushCardInTableau(game.getTableau(tableauNumber), game.getGameWaste().getWaste());
		}
	}

	public void move(Game game, int tableauNumber)
	{
		assert game != null;
		
		game.moveToTableau(game.getGameWaste().getWaste(), tableauNumber);
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}

}
