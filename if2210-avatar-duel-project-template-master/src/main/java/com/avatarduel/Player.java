package com.avatarduel;

import  com.avatarduel.Deck;
import  com.avatarduel.Hand;
import com.avatarduel.Field;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.print.DocFlavor.STRING;

class Player {
    private String name;
    private int health;
    private int power;
    private Deck deck;
    private Hand hand;
    private Field field;

    public Player (String name, Deck listdeck, Hand listhand){
        this.name = name;
        health = 80;
        deck = listdeck;
        hand = listhand;
        field = new Field();
        power = 0;
    }

    public String getName(){
        return name;
    }

    public int getHealth(){
        return health;
    }

    public int getPower(){
        return power;
    }

    public List<Card> getDeck(){
        return deck.getCardOnDeck();
    }

    public List<Card> getHand(){
        return hand.getCardOnHand();
    }

    public Map<Integer,String> getField(){
        return field.getCardOnField();
    }
}