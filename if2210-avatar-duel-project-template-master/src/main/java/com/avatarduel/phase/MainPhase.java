package com.avatarduel.phase;

import com.avatarduel.util.*;
import com.avatarduel.player.*;
import com.avatarduel.card.*;
import com.avatarduel.model.*;


import java.util.*;

public class MainPhase extends Phase {
    //constructor
    private ArrayList<Tuple<Integer,Integer>> alreadyAttack;
    private boolean alreadyPlaceLand;

    public MainPhase(Player P1, Player P2, boolean turn) {
        super(P1,P2,turn,"M");
        this.isEndphase = false;
        this.alreadyAttack = new ArrayList<Tuple<Integer,Integer>>();
        this.alreadyPlaceLand = false;
    }

    public boolean isLandAlreadyPlaced() {
        return this.alreadyPlaceLand;
    }

    // Summon Character Card on field with loc i,j
    public void placeCard(CharacterCard card, int i, int j) {
        // get player
        Player p = this.seekTurn();
        HashMap<Tuple<Integer,Integer>, Card> field = p.getField().getCardOnField();
        ArrayList<Card> hand = p.getHand().getCardOnHand();
        Tuple<Integer,Integer> key = new Tuple<Integer,Integer>(i,j);
        for(Tuple<Integer,Integer> loc : field.keySet()) {
            if(loc.getFirst()==key.getFirst() && loc.getSecond() == key.getSecond()) {
                key = loc;
            }
        }
        //reduce Player power with specific elmt
        int newPow = p.getPower().get(card.getElement()).getFirst() - card.getPower();
        Tuple<Integer,Integer> newPowState = new Tuple<Integer,Integer>(newPow,p.getPower().get(card.getElement()).getSecond());
        p.getPower().put(card.getElement(), newPowState);
        //removing card from hand and place it
        field.put(key, card);
        hand.remove(card);
    }

    // set Skill card on field with loc i,j and bind it to char card with loc k,l
    public void placeCard(SkillCard card, int i, int j, int k, int l) {
        //get Player
        Player p = this.seekTurn();
        Player opponent;
        if(p == this.P1) {
            opponent = this.P2;
        } else {
            opponent = this.P1;
        }
        HashMap<Tuple<Integer,Integer>, Card> field = p.getField().getCardOnField();
        ArrayList<Card> hand = p.getHand().getCardOnHand();
        Tuple<Integer,Integer> key = new Tuple<Integer,Integer>(i,j);
        for(Tuple<Integer,Integer> loc : field.keySet()) {
            if(loc.getFirst() == key.getFirst() && loc.getSecond() == key.getSecond()) {
                key = loc;
            }
        }

        //reduce power
        int newPow = p.getPower().get(card.getElement()).getFirst() - card.getPower();
        Tuple<Integer,Integer> newPowState = new Tuple<Integer,Integer>(newPow,p.getPower().get(card.getElement()).getSecond());
        p.getPower().put(card.getElement(), newPowState);
        //remove card from hands and place it to the field
        field.put(key, card);
        hand.remove(card);

        // if card.getSkill == "Aura" bind the aura to char card with loc k,l on player field
        // if card.getSkill == "Power Up" bind the power to char card with loc k,l on player field
        // if card.getSkill == "Destroy" destroy this card and destroy char card on opponent field
        Tuple<Integer,Integer> charCardLoc = new Tuple<Integer,Integer>(k,l);
        if(card.getSkill() == "Aura") { //Bind to Player Card
            for(Tuple<Integer,Integer> loc : field.keySet()) {
                if(loc.getFirst() == charCardLoc.getFirst() && loc.getSecond() == charCardLoc.getSecond()) {
                    charCardLoc = loc;
                }
            }
            //get CharCard
            CharacterCard pCharCard = (CharacterCard) p.getField().getCardOnField().get(charCardLoc);
            //adding skillLoc to characterCard SkillSet
            pCharCard.getSkillLoc().add(key); //key is location of the skillCard
            //added bonus attack and defense aura to charCard
            pCharCard.setAttack(pCharCard.getAttack()+card.getAttack());
            pCharCard.setDefense(pCharCard.getDefense()+card.getDefense());
            System.out.println(pCharCard.getSkillLoc().size());
        } else if(card.getSkill() == "Power Up") { //Bind to player Card
            for(Tuple<Integer,Integer> loc : field.keySet()) {
                if(loc.getFirst() == charCardLoc.getFirst() && loc.getSecond() == charCardLoc.getSecond()) {
                    charCardLoc = loc;
                }
            }
            //get CharCard
            CharacterCard pCharCard = (CharacterCard) p.getField().getCardOnField().get(charCardLoc);
            System.out.println(pCharCard.getSkillLoc().size());
            //adding skillLoc to characterCard SkillSet
            pCharCard.getSkillLoc().add(key); //key is location of the skillCard
        } else if(card.getSkill() == "Destroy") { //Destroy opponent Char Card
            // remove skillCard
            field.remove(key);//remove SkillCard with loc key
            //destroy Character Card on pos (k,l) opponent side
            this.destroyCard(k, l, opponent);
        }
    }

    public void placeCard(LandCard card) {
        Player p = this.seekTurn();
        HashMap<Element,Tuple<Integer,Integer>> power = p.getPower();
        ArrayList<Card> hand = p.getHand().getCardOnHand();
        if(card.getElement().equals(Element.WATER)) {
            power.put(Element.WATER, new Tuple<Integer,Integer>(power.get(Element.WATER).getFirst()+1,power.get(Element.WATER).getSecond()+1));
        }
        else if(card.getElement().equals(Element.FIRE)) {
            power.put(Element.FIRE, new Tuple<Integer,Integer>(power.get(Element.FIRE).getFirst()+1,power.get(Element.FIRE).getSecond()+1));
        }
        else if(card.getElement().equals(Element.AIR)) {
            power.put(Element.AIR, new Tuple<Integer,Integer>(power.get(Element.AIR).getFirst()+1,power.get(Element.AIR).getSecond()+1));
        }
        else if(card.getElement().equals(Element.EARTH)) {
            power.put(Element.EARTH, new Tuple<Integer,Integer>(power.get(Element.EARTH).getFirst()+1,power.get(Element.EARTH).getSecond()+1));
        }
        hand.remove(card);
        this.alreadyPlaceLand = true;
    }
    public void drop(Card card) {
        Player p = this.seekTurn();
        ArrayList<Card> hand = p.getHand().getCardOnHand();
        hand.remove(card);
    }
    public void changePosition(int i, int j) {
        Player p = this.seekTurn();
        Tuple<Integer,Integer> key = new Tuple<Integer,Integer>(i,j);
        for(Tuple<Integer,Integer> loc : p.getField().getCardOnField().keySet()) {
            if(loc.getFirst()==key.getFirst() && loc.getSecond() == key.getSecond()) {
                key = loc;
            }
        }
        CharacterCard c = (CharacterCard)p.getField().getCardOnField().get(key); //gabisa karena musti pake adapter kali wkwk wmager masihan
        c.changePosition();
        p.getField().getCardOnField().put(key, c);
        System.out.println(c.getName());
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
        if(card.getSkillLoc() != null) {
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
    
    //implement abstract method
    public Phase nextPhase() {
        Phase nextPhase = new BattlePhase(this.P1,this.P2,this.turn,this.alreadyAttack); //create new phase
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