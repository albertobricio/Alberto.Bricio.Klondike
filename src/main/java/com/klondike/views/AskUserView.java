package com.klondike.views;

import com.klondike.utils.IO;

public abstract class AskUserView {
	
	public int ask()
	{
        int tableauNumber;
		
        this.showQuestion();
		tableauNumber = IO.instance().readInt();
		return tableauNumber;
	}
	
	protected abstract void showQuestion();

}
