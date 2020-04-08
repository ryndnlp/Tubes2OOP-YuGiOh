package com.avatarduel;

import java.util.*;

public class DrawPhase extends Phase{
    //constructor
    public DrawPhase(Player P1, Player P2, boolean turn) {
        super(P1,P2,turn,"D");
    }
    //draw
    public void draw() {
        ArrayList<Card> hand;
        ArrayList<Card> deck;
        if(this.turn) { //P2
            hand =this.P2.getHand();
            deck = this.P2.getDeck(); 
        }
        else { //P1
            hand =this.P1.getHand();
            deck = this.P1.getDeck(); 
        }
    }

    //implement abstract method
    public Phase nextPhase() {
        Phase nextPhase = new MainPhase(this.P1,this.P2,this.turn); //create new phase
        return nextPhase;
    }
    public Phase run() {
        this.draw();
        return this.nextPhase(); //return next phase
    }



}