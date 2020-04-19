package com.avatarduel.card;

import java.util.List;

public class CardLoader {
    private List<Card> deckCard;
    private List<Card> handCard;

    public CardLoader(List<Card> deck, List<Card> hand){
        deckCard = deck;
        handCard = hand;
    }

    public List<Card> getDeckCard() { return deckCard;}

    public List<Card> getHandCard() { return handCard;}
}