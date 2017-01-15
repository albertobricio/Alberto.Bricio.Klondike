package com.klondike.views;

import com.klondike.models.Card;
import com.klondike.models.Foundation;

public class FoundationView {

	private CardView cardView;

	private static final String empty = "<vacio>";
	
	FoundationView()
	{
		this.cardView = new CardView();
	}

	public String render(Foundation foundation) {
		if (foundation.isEmpty()) {
			return empty;
		}else{
			return getFoundationRepresentation(foundation);
		}
	}

	private String getFoundationRepresentation(Foundation foundation) {
		StringBuilder representationBuilder = new StringBuilder();
		Foundation foundationTmp = foundation;
		Card cardTmp;
		while(!foundationTmp.isEmpty())
		{
			cardTmp = foundationTmp.getFoundation().popLastCard();
			if(cardTmp.isTurned())
			{
				representationBuilder.append("[");
			}
			else
			{
				representationBuilder.append(cardView.render(cardTmp));
			}
		}
		return representationBuilder.toString();
	}

}
