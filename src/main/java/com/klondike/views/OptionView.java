package com.klondike.views;

import com.klondike.controllers.OptionController;
import com.klondike.utils.ClosedInterval;
import com.klondike.utils.IO;

public class OptionView extends AskUserView{
	
	private static final int FIRST_OPTION = 1;
	
	private static final int LAST_OPTION = 1;
	
	public OptionView()
	{
		
	}

	@Override
	protected void showQuestion() {
		IO.instance().write("Opcion? [1-9]:");
	}
	
	public void interact(OptionController optionController)
	{
		ClosedInterval ci = new ClosedInterval(FIRST_OPTION, LAST_OPTION);
		int option = this.ask();
		assert ci.includes(option);
		optionController.start(option);
	}

}
