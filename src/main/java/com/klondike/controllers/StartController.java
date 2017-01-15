package com.klondike.controllers;

import com.klondike.models.Game;
import com.klondike.models.Observer;
import com.klondike.models.Subject;

public class StartController extends OperationController{
	
	private Subject subject;
	
	private OperationControllerBuilder operationControllerBuilder;
	
	protected StartController(Observer observer, Game game, OperationControllerBuilder operationControllerBuilder) {
		super(game);
		subject = new Subject();
		subject.register(observer);
		assert operationControllerBuilder != null;
		this.operationControllerBuilder = operationControllerBuilder;
	}
	
	public void start()
	{
		operationControllerBuilder.build();
		subject.begin();
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}
	

}
