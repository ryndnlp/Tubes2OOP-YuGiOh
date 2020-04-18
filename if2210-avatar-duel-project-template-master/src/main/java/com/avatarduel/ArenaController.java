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
    @FXML private FieldController fieldPlayerController;
    @FXML private HandController handController;

    @FXML private ImageView gambar;

    @FXML private Label drawPhase;

    @FXML private Label mainPhase;

    @FXML private Label battlePhase;

    @FXML private Label endPhase;

    public void init() {
        detailCardController.init(this);

    }
    public void setPhase(Phase phase, AvatarDuel main){
        this.phase = phase;
        this.main = main;
        if(!phase.getTurn()){
            Hand handP1 = phase.getP1().getHand();
            handController.init(this,handP1);
            Field fieldP1 = phase.getP1().getField();
            fieldPlayerController.init(this, fieldP1);
        }else{
            Hand handP2 = phase.getP2().getHand();
            handController.init(this,handP2);
            Field fieldP2 = phase.getP1().getField();
            fieldPlayerController.init(this, fieldP2;
        }
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
        if(toBeSummoned.getType().equals('C')) {
            for (ActiveCardController cc:  fieldPlayerController.getListOfCharController()) {
                if(cc.getCard()==null){
                    Tuple<Integer, Integer> pos = cc.getPosition();
                    MainPhase phase = (MainPhase) this.phase;
                    CharacterCard willSummoned = (CharacterCard) toBeSummoned;
                    phase.placeCard(willSummoned, pos.getFirst(), pos.getSecond());
                    fieldPlayerController.getListOfCharController().get(0).setCard(willSummoned);
                    fieldPlayerController.getListOfCharController().get(0).renderCard();
                    //System.out.println(toBeSummoned.getName());
                    //fieldPlayerController.renderField();
                    setPhase(phase,this.main);
                    break;
                }
            }
        }
        if(toBeSummoned.getType().equals('S')) {
            for (ActiveCardController sc : fieldPlayerController.getListOfSkillController()) {
                if(sc.getCard().equals(null)) {
                    Tuple<Integer, Integer> pos = sc.getPosition();
                    MainPhase phase = (MainPhase) this.phase;
                    SkillCard willSummoned = (SkillCard) toBeSummoned;
                    phase.placeCard(willSummoned, pos.getFirst(), pos.getSecond());
                    //System.out.println(toBeSummoned.getName());
                    //fieldPlayerController.renderField();
                    setPhase(phase,this.main);
                    break;
                }
            }
        }
        if(toBeSummoned.getType().equals('L')) {
            MainPhase phase = (MainPhase) this.phase;
            LandCard willSummoned = (LandCard) toBeSummoned;
            phase.placeCard(willSummoned);
            //System.out.println(toBeSummoned.getName());
            //fieldPlayerController.renderField();
            setPhase(phase,this.main);
        }
    }

}
