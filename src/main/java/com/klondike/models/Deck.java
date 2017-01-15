package com.klondike.models;

public class Deck {
	
	private CardStack deckPile;
	
	public Deck() {
		this.deckPile = new CardStack();
	}

	public CardStack getDeck() {
		return deckPile;
	}

	public void setDeck(CardStack deckPile) {
		this.deckPile = deckPile;
	}
	
	public boolean isEmpty()
	{
		return this.deckPile.isEmpty();
	}
	
	public int size()
	{
		return this.deckPile.cardStackSize();
	}

}
