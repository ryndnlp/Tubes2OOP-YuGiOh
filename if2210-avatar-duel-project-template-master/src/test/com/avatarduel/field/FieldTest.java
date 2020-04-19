package com.avatarduel.field;

import com.avatarduel.card.Card;
import com.avatarduel.card.CardFactory;
import com.avatarduel.util.Tuple;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class FieldTest {
    @Test
    public void getCardOnField(){
        Field cardfield = new Field();
        cardfield.getCardOnField().put(new Tuple<Integer, Integer>(2,3), CardFactory.getCard("SkillCard"));
        assertEquals("java.util.HashMap",cardfield.getCardOnField().getClass().getName());
    }
}