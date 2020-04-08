package com.avatarduel;

import java.util.*;

import com.avatarduel.model.Element;

public class DrawPhase extends Phase{
    //constructor
    public DrawPhase(Player P1, Player P2, boolean turn) {
        super(P1,P2,turn,"D");
    }

    //draw
    public void draw() {
        Player p = this.seekTurn();
        ArrayList<Card> hand = p.getHand();
        Queue<Card> deck = p.getDeck();
        if(deck.size()>0) {
            Card temp = deck.poll();
            hand.add(temp);
        }
    }
    public void resetPower() {
        Player p = this.seekTurn();
        for (Element i : p.getPower().keySet()) {
            Tuple<Integer,Integer> powerVal = new Tuple<Integer,Integer>(p.getPower().get(i).getSecond(),p.getPower().get(i).getSecond());
            p.getPower().put(i, powerVal);
        }
    }

    //implement abstract method
    public Phase nextPhase() {
        Phase nextPhase = new MainPhase(this.P1,this.P2,this.turn,"M1"); //create new phase
        return nextPhase;
    }
    public Phase run() {
        //auto ended phase after drawing card
        this.draw();
        return this.nextPhase(); //return next phase
    }
}