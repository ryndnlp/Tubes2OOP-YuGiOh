package com.avatarduel.phase;

import com.avatarduel.AvatarDuel;
import com.avatarduel.card.Card;
import com.avatarduel.deck.Deck;
import com.avatarduel.hand.Hand;
import com.avatarduel.model.Element;
import com.avatarduel.player.Player;
import com.avatarduel.util.Tuple;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class DrawPhaseTest {

    @Test
    public void drawFull() throws IOException, URISyntaxException {
        AvatarDuel avatarDuel = new AvatarDuel();
        Deck deck1 = avatarDuel.loadDeckCard();
        Hand hand1 = avatarDuel.loadHandCard(deck1);
        Player p1 = new Player("p1",deck1,hand1);

        Deck deck2 = avatarDuel.loadDeckCard();
        Hand hand2 = avatarDuel.loadHandCard(deck2);
        Player p2 = new Player("p2",deck2,hand2);

        DrawPhase drawPhase = new DrawPhase(p1,p2,false);
        int handSize = p1.getHand().getCardOnHand().size();
        drawPhase.draw();

        assertTrue(p1.getHand().getCardOnHand().size() == handSize);
    }

    @Test
    public void draw() throws IOException, URISyntaxException {
        AvatarDuel avatarDuel = new AvatarDuel();
        Deck deck1 = avatarDuel.loadDeckCard();
        Hand hand1 = new Hand(new ArrayList<Card>());
        Player p1 = new Player("p1",deck1,hand1);

        Deck deck2 = avatarDuel.loadDeckCard();
        Hand hand2 = avatarDuel.loadHandCard(deck2);
        Player p2 = new Player("p2",deck2,hand2);

        DrawPhase drawPhase = new DrawPhase(p1,p2,false);
        int handSize = p1.getHand().getCardOnHand().size();
        drawPhase.draw();

        assertTrue(p1.getHand().getCardOnHand().size() == handSize+1);
    }

    @Test
    public void resetPower() throws IOException, URISyntaxException {
        AvatarDuel avatarDuel = new AvatarDuel();
        Deck deck1 = avatarDuel.loadDeckCard();
        Hand hand1 = avatarDuel.loadHandCard(deck1);
        Player p1 = new Player("p1",deck1,hand1);

        Deck deck2 = avatarDuel.loadDeckCard();
        Hand hand2 = avatarDuel.loadHandCard(deck2);
        Player p2 = new Player("p2",deck2,hand2);

        DrawPhase drawPhase = new DrawPhase(p1,p2,false);
        HashMap<Element,Tuple<Integer,Integer>> power = p1.getPower();
        power.put(Element.AIR,new Tuple<Integer, Integer>(5,10));
        drawPhase.resetPower();
        assertEquals(p1.getPower().get(Element.AIR).getFirst(),p1.getPower().get(Element.AIR).getSecond());
        assertTrue(10 == p1.getPower().get(Element.AIR).getFirst());
    }

    @Test
    public void nextPhase() throws IOException, URISyntaxException {
        AvatarDuel avatarDuel = new AvatarDuel();
        Deck deck1 = avatarDuel.loadDeckCard();
        Hand hand1 = avatarDuel.loadHandCard(deck1);
        Player p1 = new Player("p1",deck1,hand1);

        Deck deck2 = avatarDuel.loadDeckCard();
        Hand hand2 = avatarDuel.loadHandCard(deck2);
        Player p2 = new Player("p2",deck2,hand2);

        DrawPhase drawPhase = new DrawPhase(p1,p2,false);
        Phase phase = drawPhase.nextPhase();
        assertEquals("com.avatarduel.phase.MainPhase",phase.getClass().getName());
    }
}