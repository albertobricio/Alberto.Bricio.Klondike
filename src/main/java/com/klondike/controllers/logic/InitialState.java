package com.klondike.controllers.logic;

import com.klondike.controllers.OperationController;
import com.klondike.controllers.OperationControllerBuilder;
import com.klondike.controllers.StartController;

class InitialState extends State {

	private StartController startController;
	
	InitialState(StatesBuilder statesBuilder, OperationControllerBuilder operationControllerBuilder){
		super(statesBuilder);
		startController = operationControllerBuilder.getStartController();
	}
	
	@Override
	State begin() {
		return statesBuilder.getInGameState();
	}
		
	@Override
	OperationController getOperationController() {
		return startController;
	}

}
