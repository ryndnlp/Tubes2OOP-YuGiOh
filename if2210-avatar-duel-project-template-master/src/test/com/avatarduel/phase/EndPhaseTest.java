package com.avatarduel.phase;

import com.avatarduel.AvatarDuel;
import com.avatarduel.deck.Deck;
import com.avatarduel.hand.Hand;
import com.avatarduel.player.Player;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.*;

public class EndPhaseTest {

    @Test
    public void changeTurn() throws IOException, URISyntaxException {
        AvatarDuel avatarDuel = new AvatarDuel();
        Deck deck1 = avatarDuel.loadDeckCard();
        Hand hand1 = avatarDuel.loadHandCard(deck1);
        Player p1 = new Player("p1",deck1,hand1);

        Deck deck2 = avatarDuel.loadDeckCard();
        Hand hand2 = avatarDuel.loadHandCard(deck2);
        Player p2 = new Player("p2",deck2,hand2);

        EndPhase endPhase = new EndPhase(p1,p2,false);
        endPhase.changeTurn();
        assertTrue(endPhase.getTurn());
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

        EndPhase endPhase = new EndPhase(p1,p2,false);
        Phase phase = endPhase.nextPhase();
        assertEquals("com.avatarduel.phase.DrawPhase",phase.getClass().getName());
    }
}