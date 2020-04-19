package com.avatarduel.card;

import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterCardTest {
    @Test
    public void test(){
        CharacterCard characterCard = new CharacterCard();
        characterCard.setId(7);
        characterCard.setName("Skill Card");
        characterCard.setDescription("This is Skill Card");
        characterCard.setType('S');
        characterCard.setElement("Water");
        characterCard.setAttack(20);
        characterCard.setDefense(30);
        characterCard.setPower(40);
        characterCard.setImagepath("skillcard.png");
        assertEquals("7", characterCard.getId());
        assertEquals("Skill Card", characterCard.getName());
        assertEquals("This is Skill Card", characterCard.getDescription());
        assertEquals("S", characterCard.getType());
        assertEquals(20,characterCard.getAttack());
        assertEquals(30, characterCard.getDefense());
        assertEquals(40, characterCard.getPower());
        assertEquals("skillcard.pnd", characterCard.getImagepath());
    }
}