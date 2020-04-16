package com.avatarduel;

import com.avatarduel.card.*;
import com.avatarduel.hand.*;
import com.avatarduel.model.Element;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ArenaController  {
    public List<Card> deckCard;
    public List<Card> handCard;
    public ArenaController(){

        deckCard = new ArrayList<Card>();
        handCard = new ArrayList<Card>();
    }

    @FXML private DetailCardController detailCardController;

    @FXML private HandController handController;

    @FXML
    private ImageView gambar;

    //private  detailcard;

    public void initialize() {
        try {
            handCard.get(0).cekKartu();
            deckCard.get(0).cekKartu();
        } catch (Exception e){
            System.out.println("Tidak masuk lho");
            System.out.println(e);
        }
        detailCardController.init(this);

    }
    public void setDeckCard(List<Card> deck){
        System.out.println("Not yet");
        deckCard = deck;
    }
    public void setHandCard(List<Card> hand){
        handCard = hand;
        handController.init(this,handCard);
    }

    public List<Card> getDeckCard(){
        return deckCard;
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
        }

    }

    public void resetCard(){
        detailCardController.resetCard();
    }

}
