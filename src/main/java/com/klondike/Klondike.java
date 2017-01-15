package com.klondike;

import com.klondike.controllers.OperationController;
import com.klondike.controllers.logic.Logic;
import com.klondike.views.console.ConsoleView;

public class Klondike 
{
	private Logic logic;
	
	private View view;
	
	public Klondike (View view, Logic logic){
		this.view=view;
		this.logic=logic;
	}
	
	public void play()
	{
		OperationController operationController;
		do {
			operationController = logic.getOperationController();
			if (operationController != null){
				view.interact(operationController);
			}
		} while (operationController != null);
	}
	
    public static void main( String[] args )
    {
       new Klondike(new ConsoleView(), new Logic()).play();
    }
}
