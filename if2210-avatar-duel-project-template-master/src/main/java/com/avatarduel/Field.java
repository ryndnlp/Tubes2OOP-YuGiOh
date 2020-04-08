package com.avatarduel;

import com.avatarduel.Card;

import java.util.*;

public class Field{
    private Map<Integer,String> cardOnField;
    public Field(){
        cardOnField = new HashMap<Integer, String>();
    }

    public Map<Integer,String> getCardOnField() {
        return cardOnField;
    }
}