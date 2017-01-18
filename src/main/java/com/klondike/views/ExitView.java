package com.klondike.views;
import com.klondike.controllers.ExitController;
import com.klondike.utils.IO;

public class ExitView {
	
	public ExitView()
	{
		
	}
	
	public void interact(ExitController exitController)
	{
		IO.instance().writeln("Adios!!!");
		exitController.exit();
	}

}
