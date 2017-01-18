package com.klondike.controllers;

import com.klondike.models.Game;
import com.klondike.models.Observer;
import com.klondike.models.Subject;

public class MoveFromTableauToFoundationController extends OperationController{
	
	private Subject subject;
	
	protected MoveFromTableauToFoundationController(Observer observer, Game game) {
		super(game);
		subject = new Subject();
		subject.register(observer);
	}
	
	public void isFinish()
	{
		if(this.finishAllSuits())
		{
			subject.end();
		}
	}
	
	public boolean canMove(Game game, int numTableau)
	{
		assert game != null;
		
		return game.canMoveToFoundation(game.getTableau(numTableau).getTableau());
	}

	public void move(Game game, int numTableau) 
	{
		assert game != null;
		
		game.moveToFoundation(game.getTableau(numTableau).getTableau());
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}
	
}
