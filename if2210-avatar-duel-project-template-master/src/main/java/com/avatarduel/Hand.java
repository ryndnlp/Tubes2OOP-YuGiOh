package com.avatarduel;

import com.avatarduel.Card;

import java.util.ArrayList;

public class Hand{
    private ArrayList<Card> cardOnHand;
    public Hand(ArrayList<Card> listHand){
        this.cardOnHand = listHand;
    }

    public ArrayList<Card> getCardOnHand() {
        return this.cardOnHand;
    }
}