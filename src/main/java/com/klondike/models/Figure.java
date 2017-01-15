package com.klondike.models;

public enum Figure {
	ACE('A', 1), 
	TWO('2', 2),
	THREE('3', 3),
	FOUR('4', 4),
	FIVE('5', 5), 
	SIX('6', 6),
	SEVEN('7', 7),
	EIGHT('8', 8),
	NINE('9', 9), 
	JACK('J', 10),
	QUEEN('Q', 11),
	KING('K', 12);

    private char value;
    private int numValue;

    private Figure(char value, int numValue) {
        this.value = value;
        this.numValue = numValue;
    }

    public char getValue() {
        return value;
    }
    
    public int getNumValue(){
    	return numValue;
    }
}
