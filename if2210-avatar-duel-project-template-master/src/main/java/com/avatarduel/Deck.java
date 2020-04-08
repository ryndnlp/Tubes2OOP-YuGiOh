package com.avatarduel;

import com.avatarduel.Card;

import java.util.ArrayList;
import java.util.List;

public class Deck{
    private List<Card> cardOnDeck;
    public Deck(List<Card> listdeck){
        cardOnDeck = listdeck;
    }

    public List<Card> getCardOnDeck() {
        return cardOnDeck;
    }
}