package com.avatarduel;

import com.avatarduel.AvatarDuel;
import com.avatarduel.CardFactory;
import com.avatarduel.Card;
import com.avatarduel.CharacterCard;
import com.avatarduel.LandCard;
import com.avatarduel.SkillCard;
import com.avatarduel.util.CSVReader;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class CardController {
    private List<Card> deckCard;
    private List<Card> handCard;
    private List<Card> listCharCard;
    private List<Card> listLandCard;
    private List<Card> listSkillCard;

    public CardController(){
        deckCard = new ArrayList<Card>();
        handCard = new ArrayList<Card>();
        listCharCard = new ArrayList<Card>();
        listLandCard = new ArrayList<Card>();
        listSkillCard = new ArrayList<Card>();
    }
    private void loadCardsLand() throws URISyntaxException, IOException {
        String LAND_CSV_FILE_PATH = "card/data/land.csv";
        File landCSVFile = new File(getClass().getResource(LAND_CSV_FILE_PATH).toURI());
        CSVReader landReader = new CSVReader(landCSVFile, "\t");
        landReader.setSkipHeader(true);
        List<String[]> landRows = landReader.read();
        for (String[] row : landRows) {
            CardFactory cardFactory = new CardFactory();
            Card landc = cardFactory.getCard("LandCard");
            landc.setDescription(row[3]);
            landc.setElement(row[2]);
            landc.setId(Integer.parseInt(row[0]));
            landc.setName(row[1]);
            landc.setImagepath(row[4]);
            this.listLandCard.add(landc);
            //Land l = new Land(row[1], row[3], Element.valueOf(row[2]));
        }
    }
    private void loadCardsCharacter() throws URISyntaxException, IOException {
        String CHARACTER_CSV_FILE_PATH = "card/data/character.csv";
        File charCSVFile = new File(getClass().getResource(CHARACTER_CSV_FILE_PATH).toURI());
        CSVReader charReader = new CSVReader(charCSVFile, "\t");
        charReader.setSkipHeader(true);
        List<String[]> charRows = charReader.read();
        for (String[] row : charRows) {
            CardFactory cardFactory = new CardFactory();
            CharacterCard charc = (CharacterCard)cardFactory.getCard("CharacterCard");
            charc.setDescription(row[3]);
            charc.setElement(row[2]);
            charc.setId(Integer.parseInt(row[0]));
            charc.setName(row[1]);
            charc.setImagepath(row[4]);
           charc.setPower(Integer.parseInt(row[7]));
           charc.setAttack(Integer.parseInt(row[5]));
           charc.setDefense(Integer.parseInt(row[6]));
            this.listCharCard.add(charc);
            //Land l = new Land(row[1], row[3], Element.valueOf(row[2]));
        }
    }
    private void loadCardsSkill() throws URISyntaxException, IOException {
        String SKILL_CSV_FILE_PATH = "card/data/skill_aura.csv";
        File skillCSVFile = new File(getClass().getResource(SKILL_CSV_FILE_PATH).toURI());
        CSVReader skillReader = new CSVReader(skillCSVFile, "\t");
        skillReader.setSkipHeader(true);
        List<String[]> skillrow = skillReader.read();
        for (String[] row : skillrow) {
            CardFactory cardFactory = new CardFactory();
            SkillCard skillc = (SkillCard)cardFactory.getCard("SkillCard");
            skillc.setDescription(row[3]);
            skillc.setElement(row[2]);
            skillc.setId(Integer.parseInt(row[0]));
            skillc.setName(row[1]);
            skillc.setImagepath(row[4]);
            skillc.setPower(Integer.parseInt(row[5]));
            skillc.setAttack(Integer.parseInt(row[6]));
            skillc.setDefense(Integer.parseInt(row[7]));
            this.listSkillCard.add(skillc);
            //Land l = new Land(row[1], row[3], Element.valueOf(row[2]));
        }
    }
    public void loadDeckCard() throws IOException, URISyntaxException {
        loadCardsLand();
        loadCardsCharacter();
        loadCardsSkill();
        for (int i=0; i<12; i++){
            Random rand1 = new Random();
            this.deckCard.add(listLandCard.get(rand1.nextInt(listLandCard.size())));
            Random rand2 = new Random();
            this.deckCard.add(listLandCard.get(rand2.nextInt(listLandCard.size())));
            Random rand3 = new Random();
            this.deckCard.add(listCharCard.get(rand3.nextInt(listCharCard.size())));
            Random rand4 = new Random();
            this.deckCard.add(listCharCard.get(rand4.nextInt(listCharCard.size())));
            Random rand5 = new Random();
            this.deckCard.add(listSkillCard.get(rand5.nextInt(listSkillCard.size())));
        }
    }
    public void loadHandCard(){
        for (int i=0; i<7; i++) {
            Random rand = new Random();
            int idx = rand.nextInt(deckCard.size());
            this.handCard.add(deckCard.get(idx));
            this.deckCard.remove(idx);
        }
    }

    public List<Card> getCharacterCard(){
        return listCharCard;
    }

    public List<Card> getSkillCard(){
        return listSkillCard;
    }

    public List<Card> getLandCard(){
        return listLandCard;
    }


}