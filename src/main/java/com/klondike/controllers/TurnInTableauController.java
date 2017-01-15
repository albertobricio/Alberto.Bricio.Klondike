package com.klondike.controllers;

import com.klondike.models.Game;
import com.klondike.models.Observer;
import com.klondike.models.Subject;

public class TurnInTableauController extends OperationController{
	
	private Subject subject;
	
    protected TurnInTableauController(Observer observer, Game game) {
		super(game);
		subject = new Subject();
		subject.register(observer);
	}
    
    public boolean canTurn(Game game, int numTableau)
    {
    	return game.canTurnInTableau(game.getTableau(numTableau), numTableau);
    }
	
	public void turn(Game game, int numTableau)
	{
		game.turnInTableau(game.getTableau(numTableau), numTableau);;
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}

}
