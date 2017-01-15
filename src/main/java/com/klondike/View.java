package com.klondike;

import com.klondike.controllers.OperationController;
import com.klondike.controllers.OperationControllerVisitor;

public interface View extends OperationControllerVisitor{
	
	public void interact(OperationController operationController);

}
