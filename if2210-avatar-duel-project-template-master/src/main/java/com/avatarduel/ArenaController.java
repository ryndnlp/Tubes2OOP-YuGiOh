package com.avatarduel;

import com.avatarduel.card.*;
import com.avatarduel.hand.*;
import com.avatarduel.model.Element;
import com.avatarduel.phase.MainPhase;
import com.avatarduel.phase.Phase;
import com.avatarduel.player.Player;
import com.avatarduel.util.Tuple;
import com.avatarduel.field.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.*;

public class ArenaController  {
    private Phase phase;
    private AvatarDuel main;

    static public Card toBeSummoned;


    @FXML private DetailCardController detailCardController;
    @FXML private FieldController fieldP1Controller;
    @FXML private FieldController fieldP2Controller;
    @FXML private HandController handP1Controller;
    @FXML private HandController handP2Controller;

    @FXML private ElementController elmtP1Controller;
    @FXML private ElementController elmtP2Controller;

    @FXML private ImageView gambar;

    @FXML private Label drawPhase;

    @FXML private Label mainPhase;

    @FXML private Label battlePhase;

    @FXML private Label endPhase;

    @FXML private Button nextPhase;

    public void init() {
        detailCardController.init(this);
    }
    public Phase getPhase() {
        return this.phase;
    }

    public AvatarDuel getMain() {
        return this.main;
    }

    @FXML public void nextPhase(MouseEvent event){
        try{
            flush(phase.getTurn());
            flush(!phase.getTurn());
        }catch (Exception err){
            System.out.print(err.getMessage());
        }
        setPhase(this.getPhase().nextPhase(), this.getMain());
    }

    public void flush(boolean isPlayer){
        if(isPlayer){
            for(CardController cont : handP2Controller.getListOfCardController()) {
                cont.resetCard();
            }
            for(CardController cont : handP2Controller.getListOfCardController()) {
                if(cont.getCard() == null) {
                    cont.flush();
                }
            }
        }
        else{
            for(CardController cont : handP1Controller.getListOfCardController()) {
                cont.resetCard();
            }
            for(CardController cont : handP1Controller.getListOfCardController()) {
                if(cont.getCard() == null) {
                    cont.flush();
                }
            }
        }

    }

    public void setPhase(Phase phase, AvatarDuel main){
        this.phase = phase;
        this.main = main;
        
        if(!phase.getTurn()){
            Hand handP1 = phase.getP1().getHand();
            handP1Controller.init(this,handP1);
            Field fieldP1 = phase.getP1().getField();
            fieldP1Controller.init(this, fieldP1);


        }else{
            Hand handP2 = phase.getP2().getHand();
            handP2Controller.init(this,handP2);
            Field fieldP2 = phase.getP2().getField();
            fieldP2Controller.init(this, fieldP2);

        }
        this.elmtP1Controller.init(this,phase.getP1().getPower());
        this.elmtP2Controller.init(this, phase.getP2().getPower());
        System.out.println("Berhasil set phase");
        runPhase();
    }

    public void runPhase(){
        if(phase.getType().equals("D")){
            System.out.println("Masuk Draw Phase");
        }else if(phase.getType().equals("M")){
            System.out.println("Masuk Main Phase");
        }else if(phase.getType().equals("B")){
            System.out.println("Masuk Battle Phase");
        }else {
            System.out.println("Masuk End Phase");
        }
    }


    public void renderCard(Card card){

        detailCardController.renderName(card.getName());
        detailCardController.renderDesc(card.getDescription());
        detailCardController.renderImage(card.getImagepath());

        if(card.getElement()== Element.WATER){
            detailCardController.renderElement("com/avatarduel/card/image/element/Water.jpeg");
        }else if(card.getElement()==Element.AIR){
            detailCardController.renderElement("com/avatarduel/card/image/element/Air.jpeg");
        }else if(card.getElement()==Element.FIRE){
            detailCardController.renderElement("com/avatarduel/card/image/element/Fire.jpeg");
        }else {
            detailCardController.renderElement("com/avatarduel/card/image/element/Earth.jpeg");
        }

        if (card.getType()=='C'){
            detailCardController.renderAttackC(Integer.toString(card.getAttack()));
            detailCardController.renderDefenseC(Integer.toString(card.getDefense()));
            detailCardController.renderPower(Integer.toString(card.getPower()));
        }else if(card.getType()=='S'){
            detailCardController.renderAttackS(Integer.toString(card.getAttack()));
            detailCardController.renderDefenseS(Integer.toString(card.getDefense()));
            detailCardController.renderPower(Integer.toString(card.getPower()));
        }else{
            detailCardController.renderAttackL();
            detailCardController.renderDefenseL();
            detailCardController.renderPowerL();
        }
    }
    public void DrawPhaseClicked(MouseEvent mouseEvent) {
        if(phase.getType().equals("D")){
            System.out.println("Tetap di Draw Phase");
        }
    }

    public void MainPhaseClicked(MouseEvent mouseEvent) {
        if(phase.getType().equals("D")){
            this.main.initRoot(this.phase.nextPhase());
            System.out.println("Berhasil ganti phase ke MainPhase");
        }
    }

    public void BattlePhaseClicked(MouseEvent mouseEvent) {
       if(phase.getType().equals("M")){
           this.main.initRoot(this.phase.nextPhase());
           System.out.println("Berhasil ganti phase ke Battle Phase");
       }
    }

    public void EndPhaseClicked(MouseEvent mouseEvent) {
       if(phase.getType().equals("B")){
           this.main.initRoot(this.phase.nextPhase());
           System.out.println("Berhasil ganti phase ke End Phase");
       }
    }
    public void summon(){
        FieldController cont;
        if(this.getPhase().getTurn()) {
            cont = fieldP2Controller;
        }
        else {
            cont = fieldP1Controller;
        }
        if(toBeSummoned.getType().equals('C')) {
            for (ActiveCardController cc:  cont.getListOfCharController()) {
                if(cc.getCard()==null){
                    Tuple<Integer, Integer> pos = cc.getPosition();
                    MainPhase phase = (MainPhase) this.phase;
                    CharacterCard willSummoned = (CharacterCard) toBeSummoned;
                    phase.placeCard(willSummoned, pos.getFirst(), pos.getSecond());
                    this.setPhase(phase, main);
                    break;
                }
            }
        }
        else if(toBeSummoned.getType().equals('S')) {
            for (ActiveCardController sc : cont.getListOfSkillController()) {
                if(sc.getCard() == null) {
                    Tuple<Integer, Integer> pos = sc.getPosition();
                    MainPhase phase = (MainPhase) this.phase;
                    SkillCard willSummoned = (SkillCard) toBeSummoned;
                    phase.placeCard(willSummoned, pos.getFirst(), pos.getSecond());
                    this.setPhase(phase,this.main);
                    break;
                }
            }
        }
        else { //Land
            MainPhase phase = (MainPhase) this.phase;
            LandCard willSummoned = (LandCard) toBeSummoned;
            phase.placeCard(willSummoned);
            setPhase(phase,this.main);
        }
    }

}
