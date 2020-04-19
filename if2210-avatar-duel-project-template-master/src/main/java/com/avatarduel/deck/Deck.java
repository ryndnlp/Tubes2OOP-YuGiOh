package com.avatarduel.deck;

import com.avatarduel.card.*;

import java.util.Queue;

public class Deck{
    private Queue<Card> cardOnDeck;
    public Deck(Queue<Card> listdeck){
        this.cardOnDeck = listdeck;
    }

    public Queue<Card> getCardOnDeck() {
        return this.cardOnDeck;
    }
}