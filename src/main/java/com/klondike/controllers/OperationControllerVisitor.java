package com.klondike.controllers;

public interface OperationControllerVisitor {
	
	void visit(StartController startController);
	
	void visit(MoveFromWasteToDeckController moveFromWasteToDeckController);
	
	void visit(MoveFromWasteToFoundationController moveFromWasteToFoundationController);
	
	void visit(MoveFromWasteToTableauController moveFromWasteToTableauController);
	
	void visit(MoveFromDeckToWasteController moveFromDeckToWasteController);
	
	void visit(MoveFromFoundationToTableauController moveFromFoundationToTableauController);
	
	void visit(MoveFromTableauToTableauController moveFromTableauToTableauController);
	
	void visit(MoveFromTableauToFoundationController moveFromTableauToFoundationController);
	
	void visit(TurnInTableauController turnInTableauController);

	void visit(ExitController exitController);

	void visit(OptionController optionController);
	
}
