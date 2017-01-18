package com.klondike.controllers.logic;
import com.klondike.controllers.OperationController;

class FinalState extends State {

	FinalState(StatesBuilder statesBuilder) {
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
