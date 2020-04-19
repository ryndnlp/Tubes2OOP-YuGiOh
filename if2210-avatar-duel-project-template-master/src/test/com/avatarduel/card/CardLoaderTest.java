package com.avatarduel.card;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CardLoaderTest {

    @Test
    public void getDeckCard() {
        List<Card> deck = new ArrayList<Card>();
        List<Card> hand = new ArrayList<Card>();
        deck.add(CardFactory.getCard("SkillCard"));
        deck.add(CardFactory.getCard("CharacterCard"));
        deck.add(CardFactory.getCard("LandCard"));

        CardLoader loader = new CardLoader(deck,hand);
        assertEquals(deck,loader.getDeckCard());
    }

    @Test
    public void getHandCard() {
        List<Card> deck = new ArrayList<Card>();
        List<Card> hand = new ArrayList<Card>();
        hand.add(CardFactory.getCard("SkillCard"));
        hand.add(CardFactory.getCard("CharacterCard"));
        hand.add(CardFactory.getCard("LandCard"));

        CardLoader loader = new CardLoader(deck,hand);
        assertEquals(hand,loader.getHandCard());
    }
}