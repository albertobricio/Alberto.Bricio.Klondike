package com.klondike.views;

import com.klondike.controllers.MoveFromWasteToTableauController;
import com.klondike.utils.IO;

public class MoveFromWasteToTableauView extends AskUserView{
	
	public MoveFromWasteToTableauView()
	{
		
	}

	@Override
	protected void showQuestion() {
		IO.instance().writeln("A que escalera? [1-7]: ");
	}
	
	public void interact(MoveFromWasteToTableauController moveFromWasteToTableauController)
	{
		
	}
}
