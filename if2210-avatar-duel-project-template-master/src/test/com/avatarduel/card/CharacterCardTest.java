package com.avatarduel.card;

import com.avatarduel.util.Tuple;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CharacterCardTest {

    @Test
    public void getSkillLoc() {
        ArrayList<Tuple<Integer,Integer>> loc = new ArrayList<Tuple<Integer,Integer>>();
        CharacterCard card = (CharacterCard) CardFactory.getCard("CharacterCard");
        card.setSkillLoc(loc);
        assertEquals(loc,card.getSkillLoc());
    }

    @Test
    public void setSkillLoc() {
        ArrayList<Tuple<Integer,Integer>> loc = new ArrayList<Tuple<Integer,Integer>>();
        CharacterCard card = (CharacterCard) CardFactory.getCard("CharacterCard");
        card.setSkillLoc(loc);
        assertEquals(loc,card.getSkillLoc());
    }

    @Test
    public void changePosition() {
        CharacterCard card = (CharacterCard) CardFactory.getCard("CharacterCard");
        boolean old = card.getPosition();
        card.changePosition();
        assertNotEquals(old,card.getPosition());
    }

    @Test
    public void getPower() {
        CharacterCard card = (CharacterCard) CardFactory.getCard("CharacterCard");
        assertEquals(0,card.getPower());
    }

    @Test
    public void getAttack() {
        CharacterCard card = (CharacterCard) CardFactory.getCard("CharacterCard");
        assertEquals(0,card.getAttack());
    }

    @Test
    public void getDefense() {
        CharacterCard card = (CharacterCard) CardFactory.getCard("CharacterCard");
        assertEquals(0,card.getDefense());
    }

    @Test
    public void setPower() {
        CharacterCard card = (CharacterCard) CardFactory.getCard("CharacterCard");
        card.setPower(5);
        assertEquals(5,card.getPower());
    }

    @Test
    public void setAttack() {
        CharacterCard card = (CharacterCard) CardFactory.getCard("CharacterCard");
        card.setAttack(5);
        assertEquals(5,card.getAttack());
    }

    @Test
    public void getPosition() {
        CharacterCard card = (CharacterCard) CardFactory.getCard("CharacterCard");
        assertTrue(card.getPosition());
    }

    @Test
    public void setDefense() {
        CharacterCard card = (CharacterCard) CardFactory.getCard("CharacterCard");
        card.setDefense(5);
        assertEquals(5,card.getDefense());
    }

    @Test
    public void getPointAttack() {
        CharacterCard card = (CharacterCard) CardFactory.getCard("CharacterCard");
        card.setAttack(5);
        card.setDefense(2);
        assertEquals(5,card.getPoint());
    }

    @Test
    public void getPointDefense() {
        CharacterCard card = (CharacterCard) CardFactory.getCard("CharacterCard");
        card.changePosition();
        card.setAttack(5);
        card.setDefense(2);
        assertEquals(2,card.getPoint());
    }
}