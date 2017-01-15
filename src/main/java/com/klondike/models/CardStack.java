package com.klondike.models;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class CardStack {

	private Deque<Card> cardPile;

	public CardStack() {
		this.cardPile = new LinkedList<Card>();
	}

	public Deque<Card> getCardStack() {
		return cardPile;
	}

	public void setCardStack(Deque<Card> cardPile) {
		this.cardPile = cardPile;
	}

	public void addCardToFirst(Card card) {
		this.cardPile.addFirst(card);
	}

	public void addCardToDown(Card card) {
		this.cardPile.addLast(card);
	}

	public Card popFirstCard() {
		return this.cardPile.removeFirst();
	}

	public Card popLastCard() {
		return this.cardPile.removeLast();
	}

	public void addCardStackToTop(CardStack cardPile) {
		for (int i = 0; i < cardPile.cardStackSize(); i++) {
			Card cardToAdd = cardPile.popLastCard();
			addCardToFirst(cardToAdd);
		}
	}

	public CardStack popCardStack(int numCards) {
		CardStack cardPilePopped = new CardStack();
		for (int i = 0; i < numCards; i++) {
			Card cardToPop = popFirstCard();
			cardPilePopped.addCardToDown(cardToPop);
		}
		return cardPilePopped;
	}

	public boolean isEmpty() {
		return this.cardPile.isEmpty();
	}

	public Card showTopCard() {
		return this.cardPile.peekFirst();
	}

	public Card showDownCard() {
		return this.cardPile.peekLast();
	}

	public int cardStackSize() {
		return this.cardPile.size();
	}

	public boolean canPushCard(Card card) {
		Card firstStackCard = showTopCard();
		if ((firstStackCard.getSuit() != card.getSuit()) && cardToPushFixWithFirstCardOfStack(card, firstStackCard)) {
			return true;
		}
		return false;
	}

	private static boolean cardToPushFixWithFirstCardOfStack(Card cardToPush, Card firstStackCard) {
		return cardToPush.getFigureNumberValue() == (firstStackCard.getFigureNumberValue() - 1);
	}

	public boolean canPushStackCard(CardStack cardStack) {
		Card firstStackCard = showTopCard();
		if ((firstStackCard.getSuit() != cardStack.showDownCard().getSuit())
				&& cardToPushFixWithFirstCardOfStack(cardStack.showDownCard(), firstStackCard)) {
			return true;
		}
		return false;
	}

	public boolean canPopCard() {
		return isEmpty();
	}
	
	public void shuffle(){
		Collections.shuffle((List<?>) this.cardPile);
	}

}
