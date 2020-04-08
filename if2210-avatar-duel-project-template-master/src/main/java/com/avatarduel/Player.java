package com.avatarduel;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.print.DocFlavor.STRING;

class Player {
    private String name;
    private int health;
    private int power;
    private List<Card> deck;
    private List<Card> hand;
    private Map<Integer,String> field;

    public Player (String name){
        this.name = name;
        health = 80;
        deck = new ArrayList<Card>();
        hand = new ArrayList<Card>();
        field = new HashMap<Integer,String>();
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
        return deck;
    }

    public List<Card> getHand(){
        return hand;
    }

    public Map<Integer,String> getField(){
        return field;
    }
}