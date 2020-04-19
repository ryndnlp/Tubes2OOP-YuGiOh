package com.avatarduel.phase;

import com.avatarduel.AvatarDuel;
import com.avatarduel.card.*;
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
    public void placeCardCharacter() throws IOException, URISyntaxException {
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
                CharacterCard characterCard = (CharacterCard)card;
                mainPhase.placeCard(characterCard,0,1);
                break;
            }
        }
        assertEquals("com.avatarduel.card.Card",mainPhase.getP1().getField().getCardOnField().get(new Tuple<Integer,Integer>(0,1)).getClass().getName());
    }

    @Test
    public void placeCardLand() throws IOException, URISyntaxException {
        AvatarDuel avatarDuel = new AvatarDuel();
        Deck deck1 = avatarDuel.loadDeckCard();
        Hand hand1 = avatarDuel.loadHandCard(deck1);
        Player p1 = new Player("p1",deck1,hand1);

        Deck deck2 = avatarDuel.loadDeckCard();
        Hand hand2 = avatarDuel.loadHandCard(deck2);
        Player p2 = new Player("p2",deck2,hand2);
        LandCard landCard = new LandCard();
        MainPhase mainPhase = new MainPhase(p1,p2,false);
        for(Card card : p1.getHand().getCardOnHand()){
            if(card.getType() == 'L'){
                landCard = (LandCard) card;
                break;
            }
        }
        mainPhase.placeCard(landCard);
        assertEquals(1, mainPhase.getP1().getPower().get(landCard.getElement()).getFirst().intValue());
    }

    @Test
    public void placeCardSkill() throws IOException, URISyntaxException {
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
                CharacterCard characterCard = (CharacterCard)card;
                mainPhase.placeCard(characterCard,0,1);
                break;
            }
        }
        SkillCard skillCard = new SkillCard();
        for(Card card : p1.getHand().getCardOnHand()){
            if(card.getType() == 'S'){
                skillCard = (SkillCard) card;
                break;
            }
        }
        mainPhase.placeCard(skillCard,1,1,0,1,mainPhase.getTurn());
        assertEquals("com.avatarduel.card.Card",mainPhase.getP1().getField().getCardOnField().get(new Tuple<Integer,Integer>(1,1)).getClass().getName());
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