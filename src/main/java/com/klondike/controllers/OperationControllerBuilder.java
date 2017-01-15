package com.klondike.controllers;

import com.klondike.models.Game;
import com.klondike.models.Observer;

public class OperationControllerBuilder {

	private StartController startController;
	
    private MoveFromWasteToDeckController moveFromWasteToDeckController;
	
    private MoveFromWasteToFoundationController moveFromWasteToFoundationController;
	
    private MoveFromWasteToTableauController moveFromWasteToTableauController;
	
    private MoveFromDeckToWasteController moveFromDeckToWasteController;
	
    private MoveFromFoundationToTableauController moveFromFoundationToTableauController;
	
    private MoveFromTableauToTableauController moveFromTableauToTableauController;
	
    private MoveFromTableauToFoundationController moveFromTableauToFoundationController;
	
    private TurnInTableauController turnInTableauController;
    
    private ExitController exitController;
    
    private OptionController optionController;
	
	private Game game;
	
	private Observer observer;

	public OperationControllerBuilder(Observer observer, Game game)
	{
		this.observer = observer;
		this.game = game;
	}
	
	public void build()
	{
		this.startController = new StartController (observer, game, this);
		this.optionController = new OptionController(observer, game, this);
		this.exitController = new ExitController (observer, game);
		this.moveFromDeckToWasteController = new MoveFromDeckToWasteController(observer, game);
		this.moveFromWasteToDeckController = new MoveFromWasteToDeckController(observer, game);
		this.moveFromFoundationToTableauController = new MoveFromFoundationToTableauController(observer, game);
		this.moveFromTableauToFoundationController = new MoveFromTableauToFoundationController(observer, game);
		this.moveFromTableauToTableauController = new MoveFromTableauToTableauController(observer, game);
		this.moveFromWasteToFoundationController = new MoveFromWasteToFoundationController(observer, game);
		this.moveFromWasteToTableauController = new MoveFromWasteToTableauController(observer, game);
		this.turnInTableauController = new TurnInTableauController(observer, game);
	}
	
	public void build(int option)
	{
		switch(option)
		{
		case 1:
			this.moveFromDeckToWasteController = new MoveFromDeckToWasteController(observer, game);
			break;
		case 2:
			this.moveFromWasteToDeckController = new MoveFromWasteToDeckController(observer, game);
			break;
		case 3:
			this.moveFromWasteToFoundationController = new MoveFromWasteToFoundationController(observer, game);
			break;
		case 4:
			this.moveFromWasteToTableauController = new MoveFromWasteToTableauController(observer, game);
			break;
		case 5:
			this.moveFromTableauToFoundationController = new MoveFromTableauToFoundationController(observer, game);
			break;
		case 6:
			this.moveFromTableauToTableauController = new MoveFromTableauToTableauController(observer, game);
			break;
		case 7:
			this.moveFromFoundationToTableauController = new MoveFromFoundationToTableauController(observer, game);
			break;
		case 8:
			this.turnInTableauController = new TurnInTableauController(observer, game);
			break;
		case 9:
			this.exitController = new ExitController (observer, game);
			break;
		default:
			break;
		}	
	}
	
	public StartController getStartController() {
		assert startController != null;
		return startController;
	}
	
	public OptionController getOptionController()
	{
		assert optionController != null;
		return optionController;
	}
	
	public MoveFromWasteToTableauController getMoveFromWasteToTableauController() {
		assert moveFromWasteToTableauController != null;
		return moveFromWasteToTableauController;
	}
	
	public MoveFromWasteToDeckController getMoveFromWasteToDeckController() {
		assert moveFromWasteToDeckController != null;
		return moveFromWasteToDeckController;
	}
	
	public MoveFromDeckToWasteController getMoveFromDeckToWasteController() {
		assert moveFromDeckToWasteController != null;
		return moveFromDeckToWasteController;
	}
	
	public MoveFromWasteToFoundationController getMoveFromWasteToFoundationController() {
		assert moveFromWasteToFoundationController != null;
		return moveFromWasteToFoundationController;
	}
	
	public MoveFromTableauToTableauController getMoveFromTableauToTableauController() {
		assert moveFromTableauToTableauController != null;
		return moveFromTableauToTableauController;
	}
	
	public MoveFromFoundationToTableauController getMoveFromFoundationToTableauController() {
		assert moveFromFoundationToTableauController != null;
		return moveFromFoundationToTableauController;
	}
	
	public MoveFromTableauToFoundationController getMoveFromTableauToFoundationController() {
		assert moveFromTableauToFoundationController != null;
		return moveFromTableauToFoundationController;
	}
	
	public TurnInTableauController getTurnInTableauController() {
		assert turnInTableauController != null;
		return turnInTableauController;
	}
	
	public ExitController getExitController() {
		assert exitController != null;
		return exitController;
	}
	
}
