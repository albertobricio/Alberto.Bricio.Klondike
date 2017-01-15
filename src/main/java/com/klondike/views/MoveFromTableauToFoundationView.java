package com.klondike.views;

import com.klondike.controllers.MoveFromTableauToFoundationController;
import com.klondike.utils.IO;

public class MoveFromTableauToFoundationView extends AskUserView{
	
	public MoveFromTableauToFoundationView()
	{
		
	}
	
	@Override
	protected void showQuestion() {
		IO.instance().writeln("De que escalera? [1-7]: ");
	}
	
	public void interact(MoveFromTableauToFoundationController moveFromTableauToFoundationController)
	{
		
	}

}
