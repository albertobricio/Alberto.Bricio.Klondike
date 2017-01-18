package com.klondike.views;

import java.util.Iterator;

import com.klondike.models.Card;
import com.klondike.models.Tableau;

public class TableauView {

	private CardView cardView;
	
	private static final String EMPTY = "<vacio>";
	
	TableauView()
	{
		this.cardView = new CardView();
	}

	public String render(Tableau tableau) {
		
		if(tableau.isEmpty())
		{
			return EMPTY;
		}
		else
		{
			return getTableauRepresentation(tableau);
		}
	}
	
	private String getTableauRepresentation(Tableau tableau) {
		StringBuilder representationBuilder = new StringBuilder();
		Card cardTmp; 
		for(Iterator<Card> itr = tableau.getTableau().getCardStack().descendingIterator(); itr.hasNext();)  {
			cardTmp = (Card) itr.next();
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
