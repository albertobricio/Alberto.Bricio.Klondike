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
	
	public void canMove(Game game)
	{
		assert game != null;
		
	}

	public void move(Game game) {
		assert game != null;
		
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}
	
}
