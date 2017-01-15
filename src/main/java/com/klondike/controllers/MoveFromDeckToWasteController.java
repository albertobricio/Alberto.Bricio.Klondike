package com.klondike.controllers;

import com.klondike.models.Game;
import com.klondike.models.Observer;
import com.klondike.models.Subject;

public class MoveFromDeckToWasteController extends OperationController{
	
    private Subject subject;
    
    private static final int NUM_MAX_CARDS_TO_MOVE_FROM_DECK = 3;

	protected MoveFromDeckToWasteController(Observer observer, Game game) {
		super(game);
		subject = new Subject();
		subject.register(observer);
	}
	
	public void move(Game game)
	{
        assert game != null;
		
		if(game.getGameDeck().size() < NUM_MAX_CARDS_TO_MOVE_FROM_DECK)
		{
			game.moveNumCards(game.getGameDeck(), game.getGameWaste(), game.getGameDeck().size());
		}
		else
		{
			game.moveNumCards(game.getGameDeck(), game.getGameWaste(), NUM_MAX_CARDS_TO_MOVE_FROM_DECK);
		}
	}
	
	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}
}
