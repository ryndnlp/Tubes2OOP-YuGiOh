package com.avatarduel;

public class BattlePhase extends Phase {
    public BattlePhase (Player P1, Player P2, boolean turn) {
        super(P1,P2,turn,"B");
        this.isEndphase = false;
    }
    //methods
    public void attack()

     //implement abstract method
     public Phase nextPhase() {
        Phase nextPhase = new MainPhase(this.P1,this.P2,this.turn,"M2"); //create new phase
        return nextPhase;
    }
    public Phase run() {
        Player p = this.seekTurn();
        while(!this.isEndphase) {
            // TODO:
            //some event listener here and its implementation
        }
        return this.nextPhase(); //return next phase
    }
}