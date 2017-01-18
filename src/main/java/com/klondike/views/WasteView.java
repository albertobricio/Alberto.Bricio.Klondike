package com.klondike.views;

import java.util.Iterator;

import com.klondike.models.Card;
import com.klondike.models.Waste;

public class WasteView {

	private CardView cardView;

	private static final String EMPTY = "<vacio>";
	
	WasteView(){
		this.cardView = new CardView();
	}

	public String render(Waste waste) {
		if (waste.isEmpty()) {
			return EMPTY;
		} else {
			return getWasteRepresentation(waste);
		}
	}

	private String getWasteRepresentation(Waste waste) {
		StringBuilder representationBuilder = new StringBuilder();
		Card cardTmp; 
		for(Iterator<Card> itr = waste.getWaste().getCardStack().descendingIterator(); itr.hasNext();)  {
			cardTmp = (Card) itr.next();
			representationBuilder.append(cardView.render(cardTmp));
		}
		return representationBuilder.toString();
	}

}
