package com.klondike.views;

import com.klondike.models.Card;
import com.klondike.models.Waste;

public class WasteView {

	private CardView cardView;

	private static String EMPTY = "<vacio>";
	
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
		Waste wasteTmp = waste;
		Card cardTmp;
		while(!wasteTmp.isEmpty())
		{
			cardTmp = wasteTmp.getWaste().popLastCard();
			representationBuilder.append(cardView.render(cardTmp));
		}
		return representationBuilder.toString();
	}

}
