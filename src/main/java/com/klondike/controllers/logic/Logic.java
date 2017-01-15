package com.klondike.controllers.logic;

import com.klondike.controllers.OperationController;
import com.klondike.controllers.OperationControllerBuilder;
import com.klondike.models.Game;
import com.klondike.models.Observer;

public class Logic implements Observer{

	private StatesBuilder statesBuilder;

	private State actualState;
	
	public Logic()
	{
		Game game = new Game(this);
		OperationControllerBuilder operationControllerBuilder = new OperationControllerBuilder(this, game);
		operationControllerBuilder.build();
		statesBuilder = new StatesBuilder(this, game, operationControllerBuilder);
		actualState = statesBuilder.getInitialState();
	}

	public void initialize() {
		actualState = actualState.initialize();
	}

	public void begin() {
		actualState = actualState.begin();
	}

	public void end() {
		actualState = actualState.end();
	}

	public void exit() {
		actualState = actualState.exit();
	}
	
	public OperationController getOperationController() {
		return actualState.getOperationController();
	}
	
}
