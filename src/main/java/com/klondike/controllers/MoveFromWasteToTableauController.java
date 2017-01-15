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

	public void start(Game game)
	{
		assert game != null;
		
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}

}
