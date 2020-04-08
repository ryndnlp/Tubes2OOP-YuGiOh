package com.avatarduel;

import  com.avatarduel.Deck;
import  com.avatarduel.Hand;
import com.avatarduel.model.Element;
import com.avatarduel.Field;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import javax.print.DocFlavor.STRING;

class Player {
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

    public Queue<Card> getDeck(){
        return this.deck.getCardOnDeck();
    }

    public ArrayList<Card> getHand(){
        return this.hand.getCardOnHand();
    }

    public HashMap<Tuple<Integer,Integer>, Card> getField(){
        return field.getCardOnField();
    }
}