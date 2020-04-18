package com.avatarduel.player;

import com.avatarduel.model.*;
import com.avatarduel.util.*;
import com.avatarduel.deck.*;
import com.avatarduel.hand.*;
import com.avatarduel.card.*;
import com.avatarduel.field.*;
import java.util.*;

public class Player {
    private String name;
    private int health;
    private HashMap<Element,Tuple<Integer,Integer>> power; //key = Element, tuple<val,limit>
    private Deck deck;
    private Hand hand;
    private Field field;

    public Player (String name, Deck listdeck, Hand listhand){
        this.name = name;
        health = 80;
        deck = listdeck;
        hand = listhand;
        field = new Field();
        power = new HashMap<Element,Tuple<Integer,Integer>>();
        //inisiasi
        power.put(Element.EARTH, new Tuple<Integer,Integer>(0,0));
        power.put(Element.FIRE, new Tuple<Integer,Integer>(0,0));
        power.put(Element.WATER, new Tuple<Integer,Integer>(0,0));
        power.put(Element.AIR, new Tuple<Integer,Integer>(0,0));
    }

    public String getName(){
        return name;
    }

    public int getHealth(){
        return health;
    }

    public HashMap<Element,Tuple<Integer,Integer>> getPower(){
        return power;
    }

    public Deck getDeck(){
        return this.deck;
    }

    public Hand getHand(){
        return this.hand;
    }

    public Field getField(){
        return this.field;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}