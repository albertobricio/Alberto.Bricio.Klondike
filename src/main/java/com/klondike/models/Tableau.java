package com.klondike.models;

public class Tableau {

	private CardStack tableauPile;
	
	private Pile pile;
	
	public Tableau(Pile pile) {
		this.tableauPile = new CardStack();
		this.pile = pile;
	}
	
	public CardStack getTableau() {
		return tableauPile;
	}

	public void setTableau(CardStack tableauPile) {
		this.tableauPile = tableauPile;
	}
	
	public Pile getPile() {
		return pile;
	}

	public void setPile(Pile pile) {
		this.pile = pile;
	}
	
	public boolean isEmpty()
	{
		return this.tableauPile.isEmpty();
	}
	
	public int size()
	{
		return this.tableauPile.cardStackSize();
	}

}
