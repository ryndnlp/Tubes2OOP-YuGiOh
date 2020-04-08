package com.avatarduel;

import com.avatarduel.Card;

import java.util.ArrayList;
import java.util.List;

public class Hand{
    private List<Card> cardOnHand;
    public Hand(List<Card> listHand){
        cardOnHand = listHand;
    }

    public List<Card> getCardOnHand() {
        return cardOnHand;
    }
}