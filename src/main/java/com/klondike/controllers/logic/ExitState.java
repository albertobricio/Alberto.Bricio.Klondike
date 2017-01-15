package com.klondike.controllers.logic;

import com.klondike.controllers.ExitController;
import com.klondike.controllers.OperationController;

class ExitState extends State {
	
	private ExitController exitController;

	ExitState(StatesBuilder statesBuilder){
		super(statesBuilder);
	}
	
	@Override
	OperationController getOperationController() {
		return exitController;
	}

}
