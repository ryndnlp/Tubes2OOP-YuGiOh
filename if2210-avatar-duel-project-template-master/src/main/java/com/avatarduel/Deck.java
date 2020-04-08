package com.avatarduel;

import com.avatarduel.Card;

import java.util.ArrayList;
import java.util.List;

public class Deck{
    private ArrayList<Card> cardOnDeck;
    public Deck(ArrayList<Card> listdeck){
        this.cardOnDeck = listdeck;
    }

    public ArrayList<Card> getCardOnDeck() {
        return this.cardOnDeck;
    }
}