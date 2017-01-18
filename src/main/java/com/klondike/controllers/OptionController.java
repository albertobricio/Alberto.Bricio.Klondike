package com.klondike.controllers;

import com.klondike.models.Game;
import com.klondike.models.Observer;
import com.klondike.models.Subject;
import com.klondike.views.console.ConsoleView;

public class OptionController extends OperationController {
	
	private Subject subject;
	
	private ConsoleView consoleView;
	
	private OperationControllerBuilder operationControllerBuilder;
	
	OptionController(Observer observer, Game game, OperationControllerBuilder operationControllerBuilder) {
		super(game);
		subject = new Subject();
		consoleView = new ConsoleView();
		subject.register(observer);
		assert operationControllerBuilder != null;
		this.operationControllerBuilder = operationControllerBuilder;
	}
	
	public void start(int option)
	{
		switch(option)
		{
		case 1:
			consoleView.visit(operationControllerBuilder.getMoveFromDeckToWasteController());
			break;
		case 2:
			consoleView.visit(operationControllerBuilder.getMoveFromWasteToDeckController());
			break;
		case 3:
			consoleView.visit(operationControllerBuilder.getMoveFromWasteToFoundationController());
			break;
		case 4:
			consoleView.visit(operationControllerBuilder.getMoveFromWasteToTableauController());
			break;
		case 5:
			consoleView.visit(operationControllerBuilder.getMoveFromTableauToFoundationController());
			break;
		case 6:
			consoleView.visit(operationControllerBuilder.getMoveFromTableauToTableauController());
			break;
		case 7:
			consoleView.visit(operationControllerBuilder.getMoveFromFoundationToTableauController());
			break;
		case 8:
			consoleView.visit(operationControllerBuilder.getTurnInTableauController());
			break;
		case 9:
			consoleView.visit(operationControllerBuilder.getExitController());
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
