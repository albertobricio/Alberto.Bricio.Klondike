package com.klondike.models;

import java.util.Iterator;

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
	
	public void setTableau(Tableau tableau, int numberTableau)
	{
		this.tableaus[numberTableau - 1] = tableau;
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
			return getCupsFoundation();
		default:
			return null;
		}
	}
	
	public Foundation getFoundationByNumber(int foundationNumber)
	{
		switch(foundationNumber)
		{
		case 1:
			return getCoinsFoundation();
		case 2:
			return getCupsFoundation();
		case 3:
			return getSwordsFoundation();
		case 4:
			return getBatonsFoundation();
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
		
		if(foundation.isEmpty())
		{
			return cardToMoveIsFirstFoundationCard(cardStack.showTopCard(), foundation);
		}
		else
		{
			return cardToMoveIsFoundationCard(cardStack.showTopCard(), foundation);
		}
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
	
	public void moveToTableau(CardStack cardStack, int tableauNumber)
	{
		Tableau tableau;
		Card cardToMove;
		
		tableau = getTableau(tableauNumber);
		
		cardToMove = cardStack.popFirstCard();
		tableau.getTableau().addCardToFirst(cardToMove);
		setTableau(tableau, tableauNumber);
	}
	
	public void moveNumCards(CardStack cardStackOrigin, CardStack cardStackDestiny, int numCards)
	{
        Card cardToMove;
		for (int i = 0; i < numCards; i++)
		{
			cardToMove = cardStackOrigin.popFirstCard();
			cardStackDestiny.addCardToFirst(cardToMove);
		}
	}
	
	public boolean canMoveNumCardsToTableau(CardStack cardStackOrigin, Tableau tableau, int numCards)
	{
        Card cardToMove;
        CardStack cardStackTmp;
        int cardCounter = 0;
        for(Iterator<Card> itr = cardStackOrigin.getCardStack().descendingIterator(); itr.hasNext();)  {
        	cardToMove = (Card) itr.next();
        	cardCounter++;
        	if(cardCounter == (cardStackOrigin.cardStackSize() - numCards + 1))
        	{
        		cardStackTmp = new CardStack();
    			cardStackTmp.addCardToFirst(cardToMove);
        		if(!tableau.isEmpty() && !tableau.getTableau().getCardStack().getFirst().isTurned())
        		{
        			return canPushCardInTableau(tableau, cardStackTmp);
        		}
        		else if(tableau.isEmpty())
        		{
        			return canPushCardInEmptyTableau(cardStackTmp, tableau);
        		}
        		break;
        	}
		}
		return false;
	}
	
	public void moveNumCardsToTableau(CardStack cardStackOrigin, CardStack cardStackDestiny, int numCards)
	{
		Card cardToMove;
		CardStack cardStackTmp = new CardStack();
		for (int i = 0; i < numCards; i++)
		{
			cardToMove = cardStackOrigin.popFirstCard();
			cardStackTmp.addCardToFirst(cardToMove);
		} 
		while(!cardStackTmp.isEmpty())
		{
			cardToMove = cardStackTmp.popFirstCard();
			cardStackDestiny.addCardToFirst(cardToMove);
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
	
	public boolean cardToMoveIsFoundationCard (Card cardToMove, Foundation foundation)
	{
		return  cardToMove.getSuit() == foundation.getFoundationSuit() &&
				foundation.getFoundation().showTopCard().getFigureNumberValue() == cardToMove.getFigureNumberValue() - 1;
	}
	
	public boolean canPushCardInEmptyTableau (CardStack cardStack, Tableau tableau)
	{
		return cardStack.showTopCard().getFigureCharValue() == 'K';
	}
	
	private static boolean isSameSuit (Card card1, Card card2)
	{
		return card1.getSuitCharValue() == card2.getSuitCharValue();
	}
	
	public boolean canPushCardInTableau (Tableau tableau, CardStack cardStack)
	{
        Card cardToPush;
        Card tableauCard;
		
        cardToPush = cardStack.getCardStack().getFirst();
		tableauCard = tableau.getTableau().showTopCard();
		return !isSameSuit(cardToPush, tableauCard) && cardToMoveIsNext(tableauCard, cardToPush);
	}
	
	public void turnInTableau(Tableau tableau, int numTableau)
	{
		tableau.getTableau().getCardStack().getFirst().setTurned(false);
		setTableau(tableau, numTableau);
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
		
		tableaus = new Tableau[NUM_TABLEAUS];
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
