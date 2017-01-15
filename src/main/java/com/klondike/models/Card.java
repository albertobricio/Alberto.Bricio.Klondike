package com.klondike.models;

public class Card {

	private Suit suit;
	private Figure figure;
	private boolean turned;

	public Card(Suit suit, Figure figure) {
		this.suit = suit;
		this.figure = figure;
		this.turned = false;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public Figure getFigure() {
		return figure;
	}

	public void setFigure(Figure figure) {
		this.figure = figure;
	}

	public boolean isTurned() {
		return turned;
	}

	public void setTurned(boolean turned) {
		this.turned = turned;
	}
	
	public int getFigureNumberValue()
	{
		return this.figure.getNumValue();
	}
	
	public char getFigureCharValue()
	{
		return this.figure.getValue();
	}
	
	public char getSuitCharValue()
	{
		return this.suit.getValue();
	}
	
	

}
