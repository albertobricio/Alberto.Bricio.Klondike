package com.klondike.models;

public class Game {
	
	private Deck deck;

	private Waste waste;
	
	private Foundation swordsFoundation;
	
	private Foundation cupsFoundation;
	
	private Foundation batonsFoundation;
	
	private Foundation coinsFoundation;
	
	private Tableau[] tableaus;
	
	private static final int NUM_CARDS_BY_SUIT = 12;
	
	private static final int NUM_TABLEAUS = 7;
	
	public Game(Observer observer)
	{
		deck = new Deck();
		
		waste = new Waste();

		swordsFoundation = new Foundation(Suit.SWORDS);
		cupsFoundation = new Foundation(Suit.CUPS);
		batonsFoundation = new Foundation(Suit.BATONS);
		coinsFoundation = new Foundation(Suit.COINS);
		
		tableaus = new Tableau[NUM_TABLEAUS];
		
		initDeck();
		initTableaus();
	}
	
	public Deck getGameDeck() {
		return deck;
	}
	
	public Waste getGameWaste() {
		return waste;
	}
	
	public Tableau getTableau(int numberTableau) {
		return tableaus[numberTableau - 1];
	}
	
	public void setSwordsFoundation(Foundation foundation)
	{
		this.swordsFoundation = foundation;
	}
	
	public void setCupsFoundation(Foundation foundation)
	{
		this.cupsFoundation = foundation;
	}
	
	public void setBatonsFoundation(Foundation foundation)
	{
		this.batonsFoundation = foundation;
	}
	
	public void setCoinsFoundation(Foundation foundation)
	{
		this.coinsFoundation = foundation;
	}
	
	public Foundation getSwordsFoundation()
	{
		return swordsFoundation;
	}
	
	public Foundation getCupsFoundation()
	{
		return cupsFoundation;
	}
	
	public Foundation getCoinsFoundation()
	{
		return coinsFoundation;
	}
	
	public Foundation getBatonsFoundation()
	{
		return batonsFoundation;
	}
	
	public void emptyWaste(Waste waste, Deck deck)
	{
        Card cardToMove; 
		
        while(!waste.isEmpty())
        {
        	cardToMove = waste.getWaste().popFirstCard();
    		deck.getDeck().addCardToDown(cardToMove);
        }
	}
	
	public Foundation getFoundationBySuit(Suit suit)
	{
		switch(suit)
		{
		case COINS:
			return getCoinsFoundation();
		case BATONS:
			return getBatonsFoundation();
		case SWORDS:
			return getSwordsFoundation();
		case CUPS:
			return getSwordsFoundation();
		default:
			return null;
		}
	}
	
	public void setFoundationBySuit(Suit suit, Foundation foundation)
	{
		switch(suit)
		{
		case COINS:
			setCoinsFoundation(foundation);
			break;
		case BATONS:
			setBatonsFoundation(foundation);
			break;
		case SWORDS:
			setSwordsFoundation(foundation);
			break;
		case CUPS:
			setCupsFoundation(foundation);
			break;
		default:
			break;
		}
	}
	
	public boolean canMoveToFoundation(CardStack cardStack)
	{
		Foundation foundation;
		
		foundation = getFoundationBySuit(cardStack.showTopCard().getSuit());
		return (foundation.getFoundation().showTopCard().getFigureNumberValue() == cardStack.showTopCard().getFigureNumberValue() - 1
				|| (cardToMoveIsFirstFoundationCard(cardStack.showTopCard(), foundation)));
	}
	
	public void moveToFoundation(CardStack cardStack)
	{
		Foundation foundation;
		Card cardToMove;
		
		foundation = getFoundationBySuit(cardStack.showTopCard().getSuit());
		
		cardToMove = cardStack.popFirstCard();
		foundation.getFoundation().addCardToFirst(cardToMove);
		setFoundationBySuit(cardToMove.getSuit(), foundation);
	}
	
	public void moveNumCards(Deck deck, Waste waste, int numCards)
	{
        Card cardToMove;
		for (int i = 0; i < numCards; i++)
		{
			cardToMove = deck.getDeck().popFirstCard();
			waste.getWaste().addCardToFirst(cardToMove);
		}
	}
	
	private static boolean cardToMoveIsNext(Card card1, Card card2)
	{
		return card1.getFigureNumberValue() == card2.getFigureNumberValue() + 1;
	}
	
	public boolean cardToMoveIsFirstFoundationCard (Card cardToMove, Foundation foundation)
	{
		return foundation.isEmpty() && cardToMove.getFigureCharValue() == 'A';
	}
	
	private static boolean canPushCardInEmptyTableau (Card card, Tableau tableau)
	{
		return tableau.isEmpty() && card.getFigureCharValue() == 'K';
	}
	
	private static boolean isSameSuit (Card card1, Card card2)
	{
		return card1.getSuitCharValue() == card2.getSuitCharValue();
	}
	
	public boolean canPush (Waste waste, Tableau tableau)
	{
		Card wasteCard;
		
		wasteCard = waste.getWaste().showTopCard();
		
		return canPushCardInEmptyTableau(wasteCard, tableau) || canPushInTableau (tableau, waste);
	}
	
	private static boolean canPushInTableau (Tableau tableau, Waste waste)
	{
        Card wasteCard;
        Card tableauCard;
		
		wasteCard = waste.getWaste().showTopCard();
		tableauCard = tableau.getTableau().showTopCard();
		return !tableau.isEmpty() && !isSameSuit(wasteCard, tableauCard) && cardToMoveIsNext(tableauCard, wasteCard);
	}
	
	public void turnInTableau(Tableau tableau, int numTableau)
	{
		tableaus[numTableau - 1].getTableau().getCardStack().getFirst().setTurned(true);
	}
	
	public boolean canTurnInTableau(Tableau tableau, int numTableau)
	{
		return tableaus[numTableau - 1].getTableau().showTopCard().isTurned();
	}
	
	public void initDeck()
	{
		Card card;
		
		for (Suit suit : Suit.values()) 
		{
			for (Figure figure : Figure.values())
			{
				card = new Card(suit, figure);
				deck.getDeck().addCardToFirst(card);
			}
		}
		deck.getDeck().shuffle();
	}
	
	public void initTableaus()
	{
		int numMaxCardsTableau = NUM_TABLEAUS;
		int contTableau = 0;
		for(Pile pile : Pile.values())
		{
			tableaus[contTableau] = new Tableau(pile);
			fillTableau(tableaus[contTableau] , numMaxCardsTableau);
			contTableau++;
			numMaxCardsTableau--;
		}
	}
	
	public void turn(Card card)
	{
		card.setTurned(true);
	}
	
	private void fillTableau(Tableau tableau , int numMaxCardsTableau) {
		Card cardTmp;
		for (int i = 0; i < numMaxCardsTableau; i++)
		{
			cardTmp = deck.getDeck().popFirstCard();
			if(i < numMaxCardsTableau - 1)
			{
				this.turn(cardTmp);
			}
			tableau.getTableau().addCardToFirst(cardTmp);
		}
	}

	public boolean finishAllSuits()
	{
		return isFull(swordsFoundation) && isFull(cupsFoundation) && isFull(batonsFoundation) && isFull(coinsFoundation);
	}
	
	private static boolean isFull(Foundation foundation)
	{
		return foundation.size() == NUM_CARDS_BY_SUIT;
	}
	
}
