package com.avatarduel;

import com.avatarduel.card.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

import com.avatarduel.deck.Deck;
import com.avatarduel.hand.Hand;
import com.avatarduel.phase.DrawPhase;
import com.avatarduel.phase.Phase;
import com.avatarduel.player.Player;
import com.avatarduel.util.Tuple;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import com.avatarduel.model.Element;
import com.avatarduel.model.Land;
import com.avatarduel.util.CSVReader;

public class AvatarDuel extends Application {
  private List<Card> listCharCard;
  private List<Card> listLandCard;
  private List<Card> listSkillCard;
  private Player player1;
  private Player player2;
  private Phase phase;
  private Stage stage;

  private void loadCardsLand() throws URISyntaxException, IOException {
  	listLandCard = new ArrayList<Card>();
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
      landc.setType('L');
      listLandCard.add(landc);
    }
  }
  private void loadCardsCharacter() throws URISyntaxException, IOException {
    listCharCard = new ArrayList<Card>();
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
      charc.setType('C');
      this.listCharCard.add(charc);
    }
  }
  private void loadCardsSkill(String filename, String skill) throws URISyntaxException, IOException {
    if(listSkillCard == null){
      listSkillCard = new ArrayList<Card>();
    }
//    String SKILL_CSV_FILE_PATH = "card/data/skill_aura.csv";
    String SKILL_CSV_FILE_PATH = filename;
    File skillCSVFile = new File(getClass().getResource(SKILL_CSV_FILE_PATH).toURI());
    CSVReader skillReader = new CSVReader(skillCSVFile, "\t");
    skillReader.setSkipHeader(true);
    List<String[]> skillrow = skillReader.read();
    for (String[] row : skillrow) {
      CardFactory cardFactory = new CardFactory();
      SkillCard skillc = (SkillCard)cardFactory.getCard("SkillCard");
      skillc.setElement(row[2]);
      skillc.setId(Integer.parseInt(row[0]));
      skillc.setName(row[1]);
      skillc.setImagepath(row[4]);
      skillc.setPower(Integer.parseInt(row[5]));
      skillc.setSkill(skill);
      skillc.setType('S');
        skillc.setDescription(row[3]);
      skillc.setAttack(Integer.parseInt(row[6]));
      skillc.setDefense(Integer.parseInt(row[7]));
      this.listSkillCard.add(skillc);
    }
  }
  public Deck loadDeckCard() throws IOException, URISyntaxException {
    Queue<Card> deckCard = new LinkedList<Card>();
    loadCardsLand();
    loadCardsCharacter();
    loadCardsSkill("card/data/skill_aura.csv","Aura");
    loadCardsSkill("card/data/skill_destroy.csv", "Destroy");
    loadCardsSkill("card/data/skill_power_up.csv", "Power Up");
    for (int i=0; i<12; i++){
      Random rand1 = new Random();
      deckCard.add(listLandCard.get(rand1.nextInt(listLandCard.size())));
      Random rand2 = new Random();
      deckCard.add(listLandCard.get(rand2.nextInt(listLandCard.size())));
      Random rand3 = new Random();
      deckCard.add(listCharCard.get(rand3.nextInt(listCharCard.size())));
      Random rand4 = new Random();
      deckCard.add(listCharCard.get(rand4.nextInt(listCharCard.size())));
      Random rand5 = new Random();
      deckCard.add(listSkillCard.get(rand5.nextInt(listSkillCard.size())));
    }
    Deck deck = new Deck(deckCard);
    System.out.println("Load Deck berhasil");
    return deck;
  }
  public Hand loadHandCard(Deck deckCard){
    ArrayList<Card> handCard = new ArrayList<Card>();
    for (int i=0; i<8; i++) {
      handCard.add(deckCard.getCardOnDeck().remove());
    }
    Hand hand = new Hand(handCard);
    System.out.println("Load Hand berhasil");
    return hand;
  }

  @Override
  public void start(Stage stage) throws IOException {
  	//System.out.println("Start");
    Text text = new Text();
    text.setText("Loading...");
    text.setX(50);
    text.setY(50);
    this.stage = stage;
    try {
      Deck deckplayer1 = loadDeckCard();
      Hand handplayer1 = loadHandCard(deckplayer1);
      player1 = new Player("Player1", deckplayer1,handplayer1);
      Deck deckplayer2 = loadDeckCard();
      Hand handplayer2 = loadHandCard(deckplayer2);
      player2 = new Player("Player2", deckplayer2,handplayer2);
      phase = new DrawPhase(player1,player2,true);
      //phase = phase.nextPhase();

      // phase = new DrawPhase(player1,player2,true);
      // phase = phase.nextPhase();

      text.setText("Avatar Duel!");
    } catch (Exception e) {
      text.setText("Failed to load cards: " + e);
      System.out.println("Fail load csv");
    }

    initRoot(phase);

  }

  public void initRoot(Phase newphase){
    try{
      this.phase = newphase;
      FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getClassLoader().getResource("Arena.fxml")));
      Parent root = loader.load();
      ArenaController arenaController = loader.getController();
      System.out.println(arenaController);
      arenaController.setPhase(phase, this);

      System.out.println("Berhasil load Area Controller");
      Scene scene = new Scene(root, 1280, 660);

      stage.setTitle("Avatar Duel");
      stage.setScene(scene);
      stage.show();
      stage.setResizable(false);
    }catch (Exception e){
      System.out.println("Gagal load Arena Controller :(");
      System.out.println(e);
    }
  }

  public static void main(String[] args) {
    launch();
  }
}