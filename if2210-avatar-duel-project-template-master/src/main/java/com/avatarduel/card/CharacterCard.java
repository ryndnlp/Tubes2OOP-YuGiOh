package com.avatarduel.card;

import java.util.*;
import com.avatarduel.util.*;

public class CharacterCard extends Card{
    private int power;
    private int attack;
    private int defense;
    private boolean position; //true atk, false defense
    private ArrayList<Tuple<Integer,Integer>> skillLoc; //location of skillcard on field

    public CharacterCard(){
        super();
        this.position = true;
        this.skillLoc = new ArrayList<Tuple<Integer,Integer>>();
    }
    
    public ArrayList<Tuple<Integer,Integer>> getSkillLoc() {
        return this.skillLoc;
    }

    public void setSkillLoc(ArrayList<Tuple<Integer,Integer>> loc) {
        this.skillLoc = loc;
    }

    public void changePosition() {
        this.position = !this.position;
    }
    
    public int getPower(){
        return power;
    }

    public int getAttack(){
        return attack;
    }

    public int getDefense(){
        return defense;
    }

    public void setPower(int power){
        this.power = power;
    }

    public void setAttack(int attack){
        this.attack = attack;
    }

    public boolean getPosition() {
        return this.position;
    }

    public void setDefense(int defense){
        this.defense = defense;
    }

    public int getPoint() {
        if(this.position) {
            return this.attack;
        } else {
            return this.defense;
        }
    }

    public void cekKartu(){
        System.out.println("Character card");
        super.cekKartu();
        System.out.println(power + "\n" + attack + "\n" + defense);
    }
}