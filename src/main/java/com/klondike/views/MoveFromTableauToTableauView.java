package com.klondike.views;

import com.klondike.controllers.MoveFromTableauToTableauController;
import com.klondike.utils.IO;

public class MoveFromTableauToTableauView {
	
	public MoveFromTableauToTableauView()
	{
		
	}
	
	private void askFromWhatTableau()
	{
		IO.instance().writeln("De que escalera? [1-7]: ");
	}
	
	private void askHowManyCards()
	{
		IO.instance().writeln("Cuantas cartas? ");
	}
	
	private void askToWhatTableau()
	{
		IO.instance().writeln("A que escalera? [1-7]: ");
	}
	
	public void interact(MoveFromTableauToTableauController moveFromTableauToTableauController)
	{
		
	}

}
