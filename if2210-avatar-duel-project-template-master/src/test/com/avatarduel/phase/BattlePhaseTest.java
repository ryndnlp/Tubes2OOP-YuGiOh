package com.avatarduel.phase;

import com.avatarduel.AvatarDuel;
import com.avatarduel.deck.Deck;
import com.avatarduel.hand.Hand;
import com.avatarduel.player.Player;
import com.avatarduel.util.Tuple;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class BattlePhaseTest {

    @Test
    public void getAlreadyAttack() throws IOException, URISyntaxException {
        AvatarDuel avatarDuel = new AvatarDuel();
        Deck deck1 = avatarDuel.loadDeckCard();
        Hand hand1 = avatarDuel.loadHandCard(deck1);
        Player p1 = new Player("p1",deck1,hand1);

        Deck deck2 = avatarDuel.loadDeckCard();
        Hand hand2 = avatarDuel.loadHandCard(deck2);
        Player p2 = new Player("p2",deck2,hand2);

        BattlePhase battlePhase = new BattlePhase(p1,p2,false,new ArrayList<Tuple<Integer,Integer>>());
    }

    @Test
    public void destroyCard() throws IOException, URISyntaxException {
        AvatarDuel avatarDuel = new AvatarDuel();
        Deck deck1 = avatarDuel.loadDeckCard();
        Hand hand1 = avatarDuel.loadHandCard(deck1);
        Player p1 = new Player("p1",deck1,hand1);

        Deck deck2 = avatarDuel.loadDeckCard();
        Hand hand2 = avatarDuel.loadHandCard(deck2);
        Player p2 = new Player("p2",deck2,hand2);

        BattlePhase battlePhase = new BattlePhase(p1,p2,false,new ArrayList<Tuple<Integer,Integer>>());
    }

    @Test
    public void attack() throws IOException, URISyntaxException {
        AvatarDuel avatarDuel = new AvatarDuel();
        Deck deck1 = avatarDuel.loadDeckCard();
        Hand hand1 = avatarDuel.loadHandCard(deck1);
        Player p1 = new Player("p1",deck1,hand1);

        Deck deck2 = avatarDuel.loadDeckCard();
        Hand hand2 = avatarDuel.loadHandCard(deck2);
        Player p2 = new Player("p2",deck2,hand2);

        BattlePhase battlePhase = new BattlePhase(p1,p2,false,new ArrayList<Tuple<Integer,Integer>>());

    }

    @Test
    public void directAttack() throws IOException, URISyntaxException {
        AvatarDuel avatarDuel = new AvatarDuel();
        Deck deck1 = avatarDuel.loadDeckCard();
        Hand hand1 = avatarDuel.loadHandCard(deck1);
        Player p1 = new Player("p1",deck1,hand1);

        Deck deck2 = avatarDuel.loadDeckCard();
        Hand hand2 = avatarDuel.loadHandCard(deck2);
        Player p2 = new Player("p2",deck2,hand2);

        BattlePhase battlePhase = new BattlePhase(p1,p2,false,new ArrayList<Tuple<Integer,Integer>>());
        Player p = battlePhase.seekTurn();
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

        BattlePhase battlePhase = new BattlePhase(p1,p2,false,new ArrayList<Tuple<Integer,Integer>>());
        Phase phase = battlePhase.nextPhase();
        assertEquals("com.avatarduel.phase.EndPhase",phase.getClass().getName());
    }
}