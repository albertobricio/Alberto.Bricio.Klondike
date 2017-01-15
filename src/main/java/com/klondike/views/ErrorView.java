package com.klondike.views;

import com.klondike.models.Card;
import com.klondike.utils.IO;

public class ErrorView {
	
	private CardView cardView;
	
	public ErrorView()
	{
		this.cardView = new CardView();
	}

	public void visualizeIncorrectOptionError()
	{
		IO.instance().writeln("ERROR!!! La opcion debe ser entre 1 y 9 inclusives");
	}
	
	public void visualizeTurningTurnedCardError()
	{
		IO.instance().writeln("ERROR!!! No se puede voltear una carta descubierta");
	}
	
	public void visualizeMovementToFoundationError()
	{
		IO.instance().writeln("ERROR!!! No se puede apilar la carta en la pila.");
	}
	
	public void visualizeMovementNotPossibleError(Card cardToPush, Card downCard)
	{
		IO.instance().writeln("ERROR!!! No se puede poner "+ cardView.getCardRepresentation(cardToPush) +"sobre "+cardView.getCardRepresentation(downCard));
	}
}
