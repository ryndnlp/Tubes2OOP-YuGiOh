package com.avatarduel.phase;

import com.avatarduel.player.*;

public class EndPhase extends Phase{
    //constructor
    public EndPhase(Player P1, Player P2,boolean turn) {
        super(P1,P2,turn,"E");
    }

    //change turn
    public void changeTurn() {
        this.turn = !this.turn;//false for P1 true for P2
    }

    //implement abstract method
    public Phase nextPhase() {
        Phase nextPhase = new DrawPhase(this.P1,this.P2,this.turn); //create new phase
        return nextPhase;
    }
    public Phase run() {
        changeTurn(); //change turn
        return this.nextPhase(); //return next phase
    }

}