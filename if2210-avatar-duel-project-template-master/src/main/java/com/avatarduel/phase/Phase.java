package com.avatarduel.phase;

import com.avatarduel.player.*;

public abstract class Phase {
    protected boolean isEndphase;
    protected String type;
    protected boolean turn;
    protected Player P1;
    protected Player P2;

    public Phase(Player P1, Player P2, boolean turn, String type) {
        this.P1 = P1;
        this.P2 = P2;
        this.isEndphase = false; //phase always not end when created
        this.turn = turn;//P1 False, True for P2
        this.type = type;//type of phase {D,M1,B,M2,E}
    }
    public Player seekTurn() {
        if(this.turn) { //P2 : true
            return this.P2;
        }
        else { //P1 : false
            return this.P1;
        }
    }
    public Player getP1(){
        return this.P1;
    }
    public Player getP2(){
        return this.P2;
    }
    public boolean getTurn(){
        return turn;
    }
    public String getType(){
        return type;
    }
    public abstract Phase run();
    public abstract Phase nextPhase();
}