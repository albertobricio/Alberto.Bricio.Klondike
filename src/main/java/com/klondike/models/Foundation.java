package com.klondike.models;

public class Foundation {

	private Suit foundationSuit;
	private CardStack foundationPile;

	public Foundation(Suit foundationSuit) {
		this.foundationSuit = foundationSuit;
		this.foundationPile = new CardStack();
	}

	public Suit getFoundationSuit() {
		return foundationSuit;
	}

	public void setFoundationSuit(Suit foundationSuit) {
		this.foundationSuit = foundationSuit;
	}

	public CardStack getFoundation() {
		return foundationPile;
	}

	public void setFoundation(CardStack foundationPile) {
		this.foundationPile = foundationPile;
	}

	public int size() {
		return this.foundationPile.cardStackSize();
	}

	public boolean isEmpty() {
		return this.foundationPile.isEmpty();
	}

}
