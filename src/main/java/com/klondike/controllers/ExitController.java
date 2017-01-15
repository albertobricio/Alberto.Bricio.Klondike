package com.klondike.controllers;

import com.klondike.models.Game;
import com.klondike.models.Observer;
import com.klondike.models.Subject;

public class ExitController extends OperationController{
	
    private Subject subject;
	
	protected ExitController(Observer observer, Game game) {
		super(game);
		subject = new Subject();
		subject.register(observer);
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}

}
