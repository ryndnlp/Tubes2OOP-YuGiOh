package com.avatarduel;

import java.util.*;

import com.avatarduel.model.Element;
public class MainPhase extends Phase {
    //constructor
    public MainPhase(Player P1, Player P2, boolean turn,String type) {
        super(P1,P2,turn,type);
        this.isEndphase = false;
    }
    //methods


    public void placeCard(CharacterCard card, int i, int j) {
        Player p = this.seekTurn();
        if(p.getPower().get(card.getElement()).getFirst() >= card.getPower()) {
            HashMap<Tuple<Integer,Integer>, Card> field = p.getField();
            ArrayList<Card> hand = p.getHand();
            Tuple<Integer,Integer> key = new Tuple<Integer,Integer>(i,j);
            if(field.containsKey(key)) {
                //TODO:
                //error here there is a card on that box
            }
            else {
                if(j != 1) {
                    //TODO:
                    //error wrong placement, suppose to be placed on row 1, not 0
                }
                else {
                    //reduce power
                    int newPow = p.getPower().get(card.getElement()).getFirst() - card.getPower();
                    Tuple<Integer,Integer> newPowState = new Tuple<Integer,Integer>(newPow,p.getPower().get(card.getElement()).getSecond());
                    p.getPower().put(card.getElement(), newPowState);
                    //removing card from hand and place it
                    field.put(key, card);
                    hand.remove(card);
                }
            }
        } else {
            //TODO:
            //throw error iinsufficent power
        }
    }
    public void placeCard(SkillCard card, int i, int j) {
        Player p = this.seekTurn();
        if(p.getPower().get(card.getElement()).getFirst() >= card.getPower()) {
            HashMap<Tuple<Integer,Integer>, Card> field = p.getField();
            ArrayList<Card> hand = p.getHand();
            Tuple<Integer,Integer> key = new Tuple<Integer,Integer>(i,j);
            if(field.containsKey(key)) {
                //TODO:
                //error here there is a card on that box
            }
            else {
                if(j != 0) {
                    //TODO:
                    //error wrong placement, suppose to be placed on row 0, not 1
                }
                else {
                    //reduce power
                    int newPow = p.getPower().get(card.getElement()).getFirst() - card.getPower();
                    Tuple<Integer,Integer> newPowState = new Tuple<Integer,Integer>(newPow,p.getPower().get(card.getElement()).getSecond());
                    p.getPower().put(card.getElement(), newPowState);
                    //remove card from hands and place it to the field
                    field.put(key, card);
                    hand.remove(card);
                }
            }
        } else {
            //TODO:
            //throw error iinsufficent power
        }
    }
    public void placeCard(LandCard card) {
        Player p = this.seekTurn();
        HashMap<Element,Tuple<Integer,Integer>> power = p.getPower();
        if(card.element.equals(Element.WATER)) {
            power.put(Element.WATER, new Tuple<Integer,Integer>(power.get(Element.WATER).getFirst()+1,power.get(Element.WATER).getSecond()+1));
        }
        else if(card.element.equals(Element.FIRE)) {
            power.put(Element.FIRE, new Tuple<Integer,Integer>(power.get(Element.FIRE).getFirst()+1,power.get(Element.FIRE).getSecond()+1));
        }
        else if(card.element.equals(Element.AIR)) {
            power.put(Element.AIR, new Tuple<Integer,Integer>(power.get(Element.AIR).getFirst()+1,power.get(Element.AIR).getSecond()+1));
        }
        else if(card.element.equals(Element.EARTH)) {
            power.put(Element.EARTH, new Tuple<Integer,Integer>(power.get(Element.EARTH).getFirst()+1,power.get(Element.EARTH).getSecond()+1));
        }
    }
    public void drop(Card card) {
        Player p = this.seekTurn();
        ArrayList<Card> hand = p.getHand();
        hand.remove(card);
    }
    public void changePosition(int i, int j) {
        Player p = this.seekTurn();
        Tuple<Integer,Integer> location = new Tuple<Integer,Integer>(i,j);
        if(p.getField().containsKey(location)) {
            if(i != 1) {
                //TODO:
                //throw error here cuz selected card may not character card
            } else {
                // CharacterCard C = p.getField().get(location).changePosition(); //gabisa karena musti pake adapter kali wkwk wmager masihan
            }
        } else {
            //TODO:
            //throw error here cuz the card isnt exist
        }
    }
    
    //implement abstract method
    public Phase nextPhase() {
        if(this.type.equals("M1")) {
            Phase nextPhase = new BattlePhase(this.P1,this.P2,this.turn); //create new phase
            return nextPhase;       
        } else {
            Phase nextPhase = new EndPhase(this.P1, this.P2, this.turn); 
            return nextPhase;
        }
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