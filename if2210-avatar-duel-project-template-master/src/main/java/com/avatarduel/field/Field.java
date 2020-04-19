package com.avatarduel.field;

import com.avatarduel.card.*;
import com.avatarduel.util.*;

import java.util.*;

public class Field{
    private HashMap<Tuple<Integer,Integer>, Card> cardOnField;
    public Field(){
        this.cardOnField = new HashMap<Tuple<Integer,Integer>, Card>();
    }

    public HashMap<Tuple<Integer,Integer>, Card> getCardOnField() {
        return this.cardOnField;
    }
}