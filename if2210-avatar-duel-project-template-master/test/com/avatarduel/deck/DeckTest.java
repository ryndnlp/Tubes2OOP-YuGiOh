package com.avatarduel.deck;

import com.avatarduel.card.Card;
import com.avatarduel.card.CardFactory;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

public class DeckTest {
    @Test
    public void getDeck(){
        Queue<Card> deck = new LinkedList<Card>();
        deck.add(CardFactory.getCard("SkillCard"));
        deck.add(CardFactory.getCard("CharacterCard"));
        deck.add(CardFactory.getCard("LandCard"));

        Deck deckCard = new Deck(deck);
        assertEquals("com.avatarduel.card.SkillCard", deckCard.getCardOnDeck().getClass().getName());
    }
}