package com.klondike.views.console;

import com.klondike.View;
import com.klondike.controllers.ExitController;
import com.klondike.controllers.MoveFromDeckToWasteController;
import com.klondike.controllers.MoveFromFoundationToTableauController;
import com.klondike.controllers.MoveFromTableauToFoundationController;
import com.klondike.controllers.MoveFromTableauToTableauController;
import com.klondike.controllers.MoveFromWasteToDeckController;
import com.klondike.controllers.MoveFromWasteToFoundationController;
import com.klondike.controllers.MoveFromWasteToTableauController;
import com.klondike.controllers.OperationController;
import com.klondike.controllers.OptionController;
import com.klondike.controllers.StartController;
import com.klondike.controllers.TurnInTableauController;
import com.klondike.views.ExitView;
import com.klondike.views.MoveFromDeckToWasteView;
import com.klondike.views.MoveFromFoundationToTableauView;
import com.klondike.views.MoveFromTableauToFoundationView;
import com.klondike.views.MoveFromTableauToTableauView;
import com.klondike.views.MoveFromWasteToDeckView;
import com.klondike.views.MoveFromWasteToFoundationView;
import com.klondike.views.MoveFromWasteToTableauView;
import com.klondike.views.OptionView;
import com.klondike.views.TurnInTableauView;

public class ConsoleView implements View{
	
	private StartView startView;
	
    private MoveFromWasteToDeckView moveFromWasteToDeckView;
	
    private MoveFromWasteToFoundationView moveFromWasteToFoundationView;
	
    private MoveFromWasteToTableauView moveFromWasteToTableauView;
	
    private MoveFromDeckToWasteView moveFromDeckToWasteView;
	
    private MoveFromFoundationToTableauView moveFromFoundationToTableauView;
	
    private MoveFromTableauToTableauView moveFromTableauToTableauView;
	
    private MoveFromTableauToFoundationView moveFromTableauToFoundationView;
	
    private TurnInTableauView turnInTableauView;
    
    private ExitView exitView;
    
    private OptionView optionView;
	
	public ConsoleView()
	{
		startView = new StartView();
		exitView = new ExitView();
		moveFromDeckToWasteView = new MoveFromDeckToWasteView();
		moveFromWasteToDeckView = new MoveFromWasteToDeckView();
		moveFromWasteToFoundationView = new MoveFromWasteToFoundationView();
		moveFromWasteToTableauView = new MoveFromWasteToTableauView();
		moveFromFoundationToTableauView = new MoveFromFoundationToTableauView();
		moveFromTableauToTableauView = new MoveFromTableauToTableauView();
		moveFromTableauToFoundationView = new MoveFromTableauToFoundationView();
		turnInTableauView = new TurnInTableauView();
		optionView = new OptionView();
	}

	public void visit(StartController startController) {
		startView.interact(startController);
	}

	public void visit(MoveFromWasteToDeckController moveFromWasteToDeckController) {
		moveFromWasteToDeckView.interact(moveFromWasteToDeckController);
	}

	public void visit(MoveFromWasteToFoundationController moveFromWasteToFoundationController) {
		moveFromWasteToFoundationView.interact(moveFromWasteToFoundationController);
	}

	public void visit(MoveFromWasteToTableauController moveFromWasteToTableauController) {
		 moveFromWasteToTableauView.interact(moveFromWasteToTableauController);
		
	}

	public void visit(MoveFromDeckToWasteController moveFromDeckToWasteController) {
		moveFromDeckToWasteView.interact(moveFromDeckToWasteController);
	}

	public void visit(MoveFromFoundationToTableauController moveFromFoundationToTableauController) {
		moveFromFoundationToTableauView.interact(moveFromFoundationToTableauController);
		
	}

	public void visit(MoveFromTableauToTableauController moveFromTableauToTableauController) {
		moveFromTableauToTableauView.interact(moveFromTableauToTableauController);
		
	}

	public void visit(MoveFromTableauToFoundationController moveFromTableauToFoundationController) {
		moveFromTableauToFoundationView.interact(moveFromTableauToFoundationController);
	}

	public void visit(TurnInTableauController turnInTableauController) {
		turnInTableauView.interact(turnInTableauController);
		
	}

	public void visit(ExitController exitController) {
		exitView.interact(exitController);
	}
	
	public void visit(OptionController optionController) {
		optionView.interact(optionController);
	}
	
	public void interact(OperationController operationController) {
		assert operationController != null;
		operationController.accept(this);
	}
	
}
