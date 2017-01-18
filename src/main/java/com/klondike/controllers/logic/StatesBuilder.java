package com.klondike.controllers.logic;

import com.klondike.controllers.OperationControllerBuilder;
import com.klondike.models.Game;
import com.klondike.models.Observer;

class StatesBuilder {

	private InitialState initialState;

	private InGameState inGameState;

	private FinalState finalState;

	private ExitState exitState;

	StatesBuilder(Observer observer, Game game, OperationControllerBuilder operationControllerBuilder) {
		initialState = new InitialState(this, operationControllerBuilder);
		inGameState = new InGameState(this, operationControllerBuilder);
		finalState = new FinalState(this);
		exitState = new ExitState(this);
	}

	InitialState getInitialState() {
		return initialState;
	}

	InGameState getInGameState() {
		return inGameState;
	}

	FinalState getFinalState() {
		return finalState;
	}

	ExitState getExitState() {
		return exitState;
	}
}
