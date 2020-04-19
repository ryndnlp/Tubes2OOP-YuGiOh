package com.avatarduel.card;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {
    @Test
    public void test(){
        Card card = new Card() {
            @Override
            public int getPower() {
                return 0;
            }

            @Override
            public int getAttack() {
                return 0;
            }

            @Override
            public int getDefense() {
                return 0;
            }
        };
    }
}