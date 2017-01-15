package com.klondike.views;

import com.klondike.models.Deck;

public class DeckView {
	
	private static final String EMPTY = "<vacio>";
	
	private static final String NOT_EMPTY = "[X,X]";
	
	DeckView()
	{
		
	}
	
	public String render(Deck deck)
	{
		if(deck.isEmpty())
		{
			return EMPTY;
		}
		else
		{
			return NOT_EMPTY;
		}
	}

}
