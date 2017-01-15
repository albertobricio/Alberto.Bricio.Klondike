package com.klondike.models;

public class Waste {

	private CardStack wastePile;
	
	public Waste() {
		this.wastePile = new CardStack();
	}

	public CardStack getWaste() {
		return wastePile;
	}

	public void setWaste(CardStack wastePile) {
		this.wastePile = wastePile;
	}
	
	public boolean isEmpty()
	{
		return this.wastePile.isEmpty();
	}
	
	public int size()
	{
		return this.wastePile.cardStackSize();
	}
}
