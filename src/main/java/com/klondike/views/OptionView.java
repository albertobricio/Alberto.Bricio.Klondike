package com.klondike.views;

import com.klondike.controllers.OptionController;
import com.klondike.utils.IO;

public class OptionView extends AskUserView{
	
	public OptionView()
	{
		
	}

	@Override
	protected void showQuestion() {
		IO.instance().write("Opcion? [1-9]:");
	}
	
	public void interact(OptionController optionController)
	{
		int option = this.ask();
		optionController.start(option);
	}

}
