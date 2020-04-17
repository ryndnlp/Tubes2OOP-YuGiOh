package com.avatarduel.phase;

import com.avatarduel.util.*;
import com.avatarduel.player.*;
import com.avatarduel.card.*;
import java.util.*;

public class BattlePhase extends Phase {
    public ArrayList<Tuple<Integer,Integer>> alreadyAttack;
    public BattlePhase (Player P1, Player P2, boolean turn, ArrayList<Tuple<Integer,Integer>> alreadyAttack) {
        super(P1,P2,turn,"B");
        this.isEndphase = false;
        this.alreadyAttack = alreadyAttack;
    }
    //methods
    public void attack(int i, int j, int k, int l) {
        Player p = this.seekTurn();
        Player opponent;
        if(p.equals(P1)) {
            opponent = P2;
        } else {
            opponent = P1;
        }
        //location validation, handle on OnClick()
        Tuple<Integer,Integer> attackerLocation = new Tuple<Integer,Integer>(i,j);
        Tuple<Integer,Integer> targetLocation = new Tuple<Integer,Integer>(k,l);
        
        //err
        if(this.alreadyAttack.contains(attackerLocation)) {
            //throw error cuz this already attack
        }
        
        //err
        if(!p.getField().get(attackerLocation).getType().equals('C') || !opponent.getField().get(targetLocation).getType().equals('C')) {
            //throw error cuz not valid type
        }
        
        CharacterCard attackerCard = (CharacterCard)p.getField().get(attackerLocation);
        CharacterCard targetCard = (CharacterCard)opponent.getField().get(targetLocation);
        int atkcrPoint,targetPoint,residue;
        
        //err
        if(!attackerCard.getPosition()) {
            //attackker card on defense pos so throw error
        }

        atkcrPoint = attackerCard.getPoint();
        targetPoint = targetCard.getPoint();
        
        //err
        if(atkcrPoint < targetPoint) {
            //throw error cuz atckr < target
        }
        this.alreadyAttack.add(attackerLocation);
        residue = atkcrPoint - targetPoint;
        if(residue == 0) { //both card destroyed
            p.getField().remove(attackerLocation);
        }
        opponent.getField().remove(targetLocation);
        
        if(targetCard.getPosition()) { //target in atk pos  
            opponent.setHealth(opponent.getHealth()-residue);
        } //else on defend pos so dont reducce the health
    }
    public void attack(int i, int j) {
        //direct attack make sure there is no card on field
        Player p = this.seekTurn();
        Player opponent;
        if(p.equals(P1)) {
            opponent = P2;
        } else {
            opponent = P1;
        }
        Tuple<Integer,Integer> attackerLocation = new Tuple<Integer,Integer>(i,j);
        CharacterCard attackerCard = (CharacterCard)p.getField().get(attackerLocation);
        this.alreadyAttack.add(attackerLocation);
        opponent.setHealth(opponent.getHealth()-attackerCard.getPoint());
    }

     //implement abstract method
     public Phase nextPhase() {
        Phase nextPhase = new EndPhase(P1, P2, this.turn); //create new phase
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