package com.klondike.controllers;

import com.klondike.models.Game;
import com.klondike.models.Observer;
import com.klondike.models.Subject;

public class OptionController extends OperationController{
	
	private Subject subject;
	
	private OperationControllerBuilder operationControllerBuilder;
	
	OptionController(Observer observer, Game game, OperationControllerBuilder operationControllerBuilder) {
		super(game);
		subject = new Subject();
		subject.register(observer);
		assert operationControllerBuilder != null;
		this.operationControllerBuilder = operationControllerBuilder;
	}
	
	public void start(int option)
	{
		switch(option)
		{
		case 1:
			operationControllerBuilder.getMoveFromDeckToWasteController().move(getGame());
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
		default:
			break;
		}
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}

}
