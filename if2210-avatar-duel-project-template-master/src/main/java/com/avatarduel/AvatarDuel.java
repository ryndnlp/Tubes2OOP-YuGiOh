package com.avatarduel;

import com.avatarduel.card.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.avatarduel.phase.DrawPhase;
import com.avatarduel.phase.Phase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Objects;
import java.util.Random;

import com.avatarduel.model.Element;
import com.avatarduel.model.Land;
import com.avatarduel.util.CSVReader;

public class AvatarDuel extends Application {
//  private static final String LAND_CSV_FILE_PATH = "card/data/land.csv";
  private List<Card> deckCard;
  private List<Card> handCard;
  private List<Card> listCharCard;
  private List<Card> listLandCard;
  private List<Card> listSkillCard;
  private Phase phase;

//  public void loadCards() throws IOException, URISyntaxException {
//    File landCSVFile = new File(getClass().getResource(LAND_CSV_FILE_PATH).toURI());
//    CSVReader landReader = new CSVReader(landCSVFile, "\t");
//    landReader.setSkipHeader(true);
//    List<String[]> landRows = landReader.read();
//    for (String[] row : landRows) {
//      Land l = new Land(row[1], row[3], Element.valueOf(row[2]));
//    }
//  }

  private void loadCardsLand() throws URISyntaxException, IOException {
  	//System.out.println("Load land");
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
      //Land l = new Land(row[1], row[3], Element.valueOf(row[2]));
    }
  }
  private void loadCardsCharacter() throws URISyntaxException, IOException {
  	//System.out.println("Load char");
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
      //Land l = new Land(row[1], row[3], Element.valueOf(row[2]));
    }
  }
  private void loadCardsSkill() throws URISyntaxException, IOException {
  	//System.out.println("Load skill");
    listSkillCard = new ArrayList<Card>();
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
      skillc.setType('S');
      this.listSkillCard.add(skillc);
      //Land l = new Land(row[1], row[3], Element.valueOf(row[2]));
    }
  }
  public void loadDeckCard() throws IOException, URISyntaxException {
  	//System.out.println("Load deck");
    deckCard = new ArrayList<Card>();
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
  	//System.out.println("Load hand");
    handCard = new ArrayList<Card>();
    for (int i=0; i<8; i++) {
      Random rand = new Random();
      int idx = rand.nextInt(deckCard.size());
      this.handCard.add(deckCard.get(idx));
      this.deckCard.remove(idx);
    }
  }

  @Override
  public void start(Stage stage) throws IOException {
  	//System.out.println("Start");
    Text text = new Text();
    text.setText("Loading...");
    text.setX(50);
    text.setY(50);

    try {
      this.loadDeckCard();
      this.loadHandCard();
      System.out.println("Yeay berhasil");
      System.out.println(listLandCard.get(0).getDescription());
      System.out.println(listCharCard.get(3).getDescription());
      System.out.println(listSkillCard.get(5).getDescription());
      deckCard.get(1).cekKartu();
      handCard.get(0).cekKartu();
      text.setText("Avatar Duel!");
    } catch (Exception e) {
      text.setText("Failed to load cards: " + e);
      System.out.println("Fail load csv");
    }

//      ArenaController arenaController = new ArenaController(deckCard,handCard);
//      System.out.println(arenaController.deckCard.get(2).getDescription());
//      System.out.println(arenaController.handCard.get(2).getDescription());

      FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getClassLoader().getResource("Arena.fxml")));
//      Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("Arena.fxml")));
      try{
        Parent root = loader.load();
        ArenaController arenaController = loader.getController();
        System.out.println(arenaController);
//        ArenaController arenaController = new ArenaController();
        arenaController.setDeckCard(deckCard);
        arenaController.setHandCard(handCard);
        //Phase phase = new DrawPhase();
        //arenaController.setPhase(phase);
  //      loader.setController(arenaController);

        System.out.println("Yuhu...kenapa kamu ga masuk sini");
        Scene scene = new Scene(root, 1280, 660);

        stage.setTitle("Avatar Duel");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
      }catch (Exception e){
        System.out.println("Kenapa Gagal :(");
        System.out.println(e);
      }

  }

  public static void main(String[] args) {
    launch();
  }
}