package com.avatarduel.card;

import org.junit.Test;

import static org.junit.Assert.*;

public class SkillCardTest {

    @Test
    public void getPower() {
        SkillCard card = (SkillCard) CardFactory.getCard("SkillCard");
        assertEquals(0,card.getPower());
    }

    @Test
    public void getSkill() {
    }

    @Test
    public void setSkill() {
    }

    @Test
    public void getAttack() {
    }

    @Test
    public void getDefense() {
    }

    @Test
    public void setPower() {
    }

    @Test
    public void setAttack() {
    }

    @Test
    public void setDefense() {
    }
}