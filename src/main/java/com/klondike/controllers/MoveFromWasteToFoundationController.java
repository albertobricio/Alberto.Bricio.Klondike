package com.klondike.controllers;

import com.klondike.models.Game;
import com.klondike.models.Observer;
import com.klondike.models.Subject;

public class MoveFromWasteToFoundationController extends OperationController{
	
	private Subject subject;
	
	protected MoveFromWasteToFoundationController(Observer observer, Game game) {
		super(game);
		subject = new Subject();
		subject.register(observer);
	}
	
	public boolean canMove(Game game)
	{
		assert game != null;
		
		return game.canMoveToFoundation(game.getGameWaste().getWaste());
	}
	
	public void isFinish()
	{
		if(this.finishAllSuits())
		{
			subject.end();
		}
	}
	
	public void move(Game game) {
		assert game != null;
		
		game.moveToFoundation(game.getGameWaste().getWaste());
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}

}
