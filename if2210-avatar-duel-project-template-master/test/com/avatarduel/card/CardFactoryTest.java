package com.avatarduel.card;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardFactoryTest {
    @Test
    public void getCard(){
        assertEquals("com.avatarduel.card.SkillCard", CardFactory.getCard("SkillCard").getClass().getName());
    }
}