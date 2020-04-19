package com.avatarduel.card;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardFactoryTest {

    @Test
    public void getCardSkill() {
        assertEquals("com.avatarduel.card.SkillCard",CardFactory.getCard("SkillCard").getClass().getName());
    }

    @Test
    public void getCardChar() {
        assertEquals("com.avatarduel.card.CharacterCard",CardFactory.getCard("CharacterCard").getClass().getName());
    }

    @Test
    public void getCardLand() {
        assertEquals("com.avatarduel.card.LandCard",CardFactory.getCard("LandCard").getClass().getName());
    }
}