package com.avatarduel.card;

import org.junit.Test;

import static org.junit.Assert.*;

public class LandCardTest {
    @Test
    public void test(){
        LandCard landCard = new LandCard();
        landCard.setId(12);
        landCard.setDescription("This Is Land Card");
        landCard.setElement("Fire");
        landCard.setName("land");
        landCard.setType('L');
        landCard.setImagepath("");
        assertEquals(12, landCard.getId());
        assertEquals("land",landCard.getName());
        assertEquals("This Is Land Card", landCard.getDescription());
        assertEquals("L", landCard.getType());
    }
}