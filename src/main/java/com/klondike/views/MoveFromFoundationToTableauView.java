package com.klondike.views;

import com.klondike.controllers.MoveFromFoundationToTableauController;
import com.klondike.utils.IO;

public class MoveFromFoundationToTableauView {
	
	public MoveFromFoundationToTableauView()
	{
		
	}
	
	private void askFromWhatFoundation()
	{
		IO.instance().writeln("De que palo? [1-4]: ");
	}
	
	private void askToWhatTableau()
	{
		IO.instance().writeln("A que escalera? [1-7]: ");
	}

	public void interact(MoveFromFoundationToTableauController moveFromFoundationToTableauController)
	{
		
	}
}
