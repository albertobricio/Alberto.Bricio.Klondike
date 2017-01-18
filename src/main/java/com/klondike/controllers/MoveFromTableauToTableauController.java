package com.klondike.controllers;

import com.klondike.models.Game;
import com.klondike.models.Observer;
import com.klondike.models.Subject;

public class MoveFromTableauToTableauController extends OperationController{
	
	private Subject subject;

	protected MoveFromTableauToTableauController(Observer observer, Game game) {
		super(game);
		subject = new Subject();
		subject.register(observer);
	}
	
	public boolean canMove(Game game, int tableauOriginNumber, int tableauDestinyNumber, int numCards)
	{
		assert game != null;
		
		return game.canMoveNumCardsToTableau(
				game.getTableau(tableauOriginNumber).getTableau()
				, game.getTableau(tableauDestinyNumber), 
				numCards);
	}
	
	public void move(Game game, int tableauOriginNumber, int tableauDestinyNumber, int numCards)
	{
		assert game != null;
		
		game.moveNumCardsToTableau(
				game.getTableau(tableauOriginNumber).getTableau()
				, game.getTableau(tableauDestinyNumber).getTableau(), 
				numCards);
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}

}
