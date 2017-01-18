package com.klondike.views;

import java.util.Iterator;

import com.klondike.models.Card;
import com.klondike.models.Foundation;

public class FoundationView {

	private CardView cardView;

	private static final String EMPTY = "<vacio>";
	
	FoundationView()
	{
		this.cardView = new CardView();
	}

	public String render(Foundation foundation) {
		if (foundation.isEmpty()) {
			return EMPTY;
		}else{
			return getFoundationRepresentation(foundation);
		}
	}

	private String getFoundationRepresentation(Foundation foundation) {
		StringBuilder representationBuilder = new StringBuilder();
		Card cardTmp; 
		for(Iterator<Card> itr = foundation.getFoundation().getCardStack().descendingIterator(); itr.hasNext();)  {
			cardTmp = (Card) itr.next();
			representationBuilder.append(cardView.render(cardTmp));
		}
		return representationBuilder.toString();
	}
	
}


