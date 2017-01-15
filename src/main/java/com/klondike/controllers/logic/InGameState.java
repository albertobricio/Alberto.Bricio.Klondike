package com.klondike.controllers.logic;

import com.klondike.controllers.OperationController;
import com.klondike.controllers.OperationControllerBuilder;

class InGameState extends State {

	private OperationControllerBuilder operationControllerBuilder;
	
	public InGameState(StatesBuilder statesBuilder, OperationControllerBuilder operationControllerBuilder) {
		super(statesBuilder);
		this.operationControllerBuilder = operationControllerBuilder;
	}

	@Override
	State end() {
		return statesBuilder.getFinalState();
	}

	@Override
	OperationController getOperationController() {
		return operationControllerBuilder.getOptionController();
	}

}
