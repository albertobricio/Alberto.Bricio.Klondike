package com.klondike.controllers.logic;
import com.klondike.controllers.OperationController;
import com.klondike.controllers.OperationControllerBuilder;

class FinalState extends State {

	FinalState(StatesBuilder statesBuilder, OperationControllerBuilder operationControllerBuilder) {
		super(statesBuilder);
	}

	@Override
	State initialize() {
		return statesBuilder.getInitialState();
	}
	
	@Override
	State exit() {
		return statesBuilder.getExitState();
	}

	@Override
	OperationController getOperationController() {
		return null;
	}

}
