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

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}

}
