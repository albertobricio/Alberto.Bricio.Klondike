package com.klondike.controllers;

import com.klondike.models.Game;
import com.klondike.models.Observer;
import com.klondike.models.Subject;

public class MoveFromFoundationToTableauController extends OperationController{
	
	private Subject subject;
	
	private static final int NUM_MAX_CARDS_TO_MOVE = 1;

	protected MoveFromFoundationToTableauController(Observer observer, Game game) {
		super(game);
		subject = new Subject();
		subject.register(observer);
	}
	
	public boolean canMove(Game game, int foundationNumber, int tableauNumber)
	{
		assert game != null;
		
		return game.canMoveNumCardsToTableau(
				game.getFoundationByNumber(foundationNumber).getFoundation(),
				game.getTableau(tableauNumber),
				NUM_MAX_CARDS_TO_MOVE);
	}
	
	public void move(Game game, int foundationNumber, int tableauNumber)
	{
		assert game != null;
		
		game.moveNumCardsToTableau(
				game.getFoundationByNumber(foundationNumber).getFoundation(),
				game.getTableau(tableauNumber).getTableau(),
				NUM_MAX_CARDS_TO_MOVE);
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}

}
