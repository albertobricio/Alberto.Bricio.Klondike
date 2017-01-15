package com.klondike.models;

public enum Suit {
	
	SWORDS('e'), CUPS('c'), COINS('o'), BATONS('b');

    private char value;

    private Suit(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

}
