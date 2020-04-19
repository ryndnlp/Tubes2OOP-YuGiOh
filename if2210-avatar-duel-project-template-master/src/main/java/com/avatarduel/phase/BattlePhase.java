package com.avatarduel.phase;

import com.avatarduel.util.*;
import com.avatarduel.player.*;
import com.avatarduel.card.*;
import java.util.*;




public class BattlePhase extends Phase {
    private ArrayList<Tuple<Integer,Integer>> alreadyAttack;
    
    public BattlePhase (Player P1, Player P2, boolean turn, ArrayList<Tuple<Integer,Integer>> alreadyAttack) {
        super(P1,P2,turn,"B");
        this.isEndphase = false;
        this.alreadyAttack = alreadyAttack;
    }
    //methods
    //destroy card and its binding skillCard
    
    public ArrayList<Tuple<Integer,Integer>> getAlreadyAttack() {
        return this.alreadyAttack;
    }

    public void destroyCard(int i, int j, Player p) {
        Tuple<Integer,Integer> key = new Tuple<Integer,Integer>(i,j);
        for(Tuple<Integer,Integer> loc : p.getField().getCardOnField().keySet()) {
            if(loc.getFirst()==key.getFirst() && loc.getSecond() == key.getSecond()) {
                key = loc;
            }
        }
        //get Card to destroy
        CharacterCard card = (CharacterCard) p.getField().getCardOnField().get(key);
        //if there are some skillcard binded with this card then destroy it
        if(card.getSkillLoc().size() != 0) {
            for(Tuple<Integer,Integer> skilLoc : card.getSkillLoc()) {
                for(Tuple<Integer,Integer> locSkill : p.getField().getCardOnField().keySet()) {
                    if(locSkill.getFirst()==skilLoc.getFirst() && locSkill.getSecond() == skilLoc.getSecond()) {
                        skilLoc = locSkill;
                        p.getField().getCardOnField().remove(skilLoc);
                    }
                }
            }
        }
        p.getField().getCardOnField().remove(key);
    }

    public void attack(int i, int j, int k, int l) {
        Player p = this.seekTurn();
        int atkcrPoint,targetPoint,residue;
        
        Player opponent;
        if(p.equals(P1)) {
            opponent = P2;
        } else {
            opponent = P1;
        }
        
        //TODO : (Bad Practice with tuples for some reason too lazy to remoe this data type!)

        //location validation, handle on OnClick() 
        Tuple<Integer,Integer> attackerLocation = new Tuple<Integer,Integer>(i,j);
        Tuple<Integer,Integer> targetLocation = new Tuple<Integer,Integer>(k,l);
        for(Tuple<Integer,Integer> loc : p.getField().getCardOnField().keySet()) {
            if(loc.getFirst()==attackerLocation.getFirst() && loc.getSecond() == attackerLocation.getSecond()) {
                attackerLocation = loc;
            }
        }
        for(Tuple<Integer,Integer> loc : opponent.getField().getCardOnField().keySet()) {
            if(loc.getFirst()==targetLocation.getFirst() && loc.getSecond() == targetLocation.getSecond()) {
                targetLocation = loc;
            }
        }
        
        CharacterCard attackerCard = (CharacterCard)p.getField().getCardOnField().get(attackerLocation);
        CharacterCard targetCard = (CharacterCard)opponent.getField().getCardOnField().get(targetLocation);
        
        //get point
        atkcrPoint = attackerCard.getPoint();
        targetPoint = targetCard.getPoint();
        
        
        this.alreadyAttack.add(attackerLocation); // so this card cant attack twice
        
        residue = atkcrPoint - targetPoint;
        if(residue == 0) { //both card destroyed
            this.destroyCard(attackerLocation.getFirst(), attackerLocation.getSecond(), p); //destroy player
        }
        this.destroyCard(targetLocation.getFirst(), targetLocation.getSecond(), opponent);  //destroy opponent

        if(targetCard.getPosition() || attackerCard.isPoweredUp()) { //target in atk pos  
            opponent.setHealth(opponent.getHealth()-residue);
        } //else on defend pos so dont reducce the health but when attacker has power up skill it will ber reduced
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
        for(Tuple<Integer,Integer> loc : p.getField().getCardOnField().keySet()) {
            if(loc.getFirst()==attackerLocation.getFirst() && loc.getSecond() == attackerLocation.getSecond()) {
                attackerLocation = loc;
            }
        }
        CharacterCard attackerCard = (CharacterCard)p.getField().getCardOnField().get(attackerLocation);
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