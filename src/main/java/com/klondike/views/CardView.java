package com.klondike.views;

import com.klondike.models.Card;

public class CardView {
	
	private static final String TURNED_CARD = "[X,X]";
	
	CardView()
	{
		
	}
	
	public String render(Card card){
		if(card.isTurned())
		{
			return TURNED_CARD;
		}
		else
		{
			return getCardRepresentation(card);
		}
	}
	
	public String getCardRepresentation(Card card){
		return "["+card.getFigureCharValue()+","+card.getSuitCharValue()+"]";
	}

}
