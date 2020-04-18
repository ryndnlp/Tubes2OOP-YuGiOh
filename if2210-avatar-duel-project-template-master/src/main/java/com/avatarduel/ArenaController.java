package com.avatarduel;

import com.avatarduel.card.*;
import com.avatarduel.hand.*;
import com.avatarduel.model.Element;
import com.avatarduel.phase.Phase;
import com.avatarduel.player.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.*;

public class ArenaController  {
    public Phase phase;
    public Player player1;
    public Player player2;

    @FXML private DetailCardController detailCardController;

    @FXML private HandController handController;

    @FXML private ImageView gambar;

    @FXML private Label drawPhase;

    @FXML private Label mainPhase;

    @FXML private Label battlePhase;

    @FXML private Label endPhase;

    public void init() {
        detailCardController.init(this);
    }
    public void setPhase(Phase phase){
        this.phase = phase;
        this.setPlayer(phase.getP1(),phase.getP2());
//        if(phase.getTurn()){
            Hand handP1 = new Hand(phase.getP1().getHand());
            handController.init(this,handP1);
//        }
        System.out.println("Berhasil set phase");
    }
    public void setPlayer(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    public void runPhase(){

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
    }

    public void MainPhaseClicked(MouseEvent mouseEvent) {
    }

    public void BattlePhaseClicked(MouseEvent mouseEvent) {
    }

    public void EndPhaseClicked(MouseEvent mouseEvent) {
    }
}
