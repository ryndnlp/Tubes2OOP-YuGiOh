package com.avatarduel.card;

import org.junit.Test;

import static org.junit.Assert.*;

public class SkillCardTest {
    @Test
    public void test(){
        SkillCard skillCard = new SkillCard();
        skillCard.setId(7);
        skillCard.setName("Skill Card");
        skillCard.setDescription("This is Skill Card");
        skillCard.setType('S');
        skillCard.setElement("Water");
        skillCard.setSkill("Aura");
        skillCard.setAttack(20);
        skillCard.setDefense(30);
        skillCard.setPower(40);
        skillCard.setImagepath("skillcard.png");
        assertEquals("7", skillCard.getId());
        assertEquals("Skill Card", skillCard.getName());
        assertEquals("This is Skill Card", skillCard.getDescription());
        assertEquals("S", skillCard.getType());
        assertEquals("Aura", skillCard.getSkill());
        assertEquals(20,skillCard.getAttack());
        assertEquals(30, skillCard.getDefense());
        assertEquals(40, skillCard.getPower());
        assertEquals("skillcard.pnd", skillCard.getImagepath());
    }
}