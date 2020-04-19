package com.avatarduel.card;

import com.avatarduel.model.Land;
import org.junit.Test;

import static org.junit.Assert.*;

public class LandCardTest {

    @Test
    public void getPower() {
        LandCard card = (LandCard) CardFactory.getCard("LandCard");
        assertEquals(0,card.getPower());
    }

    @Test
    public void getAttack() {
        LandCard card = (LandCard) CardFactory.getCard("LandCard");
        assertEquals(0,card.getAttack());

    }

    @Test
    public void getDefense() {
        LandCard card = (LandCard) CardFactory.getCard("LandCard");
        assertEquals(0,card.getDefense());
    }
}