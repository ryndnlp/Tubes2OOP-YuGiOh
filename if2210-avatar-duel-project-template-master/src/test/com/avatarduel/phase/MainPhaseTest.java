package com.avatarduel.phase;

import com.avatarduel.AvatarDuel;
import com.avatarduel.card.Card;
import com.avatarduel.card.CardFactory;
import com.avatarduel.card.CharacterCard;
import com.avatarduel.deck.Deck;
import com.avatarduel.hand.Hand;
import com.avatarduel.player.Player;
import com.avatarduel.util.Tuple;
import org.junit.Test;
import sun.applet.Main;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class MainPhaseTest {
    @Test
    public void placeCard() throws IOException, URISyntaxException {
        AvatarDuel avatarDuel = new AvatarDuel();
        Deck deck1 = avatarDuel.loadDeckCard();
        Hand hand1 = avatarDuel.loadHandCard(deck1);
        Player p1 = new Player("p1",deck1,hand1);

        Deck deck2 = avatarDuel.loadDeckCard();
        Hand hand2 = avatarDuel.loadHandCard(deck2);
        Player p2 = new Player("p2",deck2,hand2);

        MainPhase mainPhase = new MainPhase(p1,p2,false);
        for(Card card : p1.getHand().getCardOnHand()){
            if(card.getType() == 'C'){
                break;
            }
        }
//        mainPhase.placeCard(,0,1);

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

        MainPhase mainPhase = new MainPhase(p1,p2,false);
        Phase phase = mainPhase.nextPhase();
        assertEquals("com.avatarduel.phase.BattlePhase",phase.getClass().getName());
    }
}