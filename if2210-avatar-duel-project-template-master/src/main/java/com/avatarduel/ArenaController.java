package com.avatarduel;

import com.avatarduel.card.*;
import com.avatarduel.hand.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
//        List<Card> deck, List<Card> hand
//        deckCard = deck;
//        handCard = hand;
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
        //handController.init(this, handCard);
//        handController.renderHand1("30","20","10","Ini kartu","Koizumi");
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

    /*public void renderCard(){
        detailCardController.renderName("Ryan");
        detailCardController.renderAttack("10");
        detailCardController.renderDef("15");
        detailCardController.renderPower("3");
        detailCardController.renderDetail("sad");
    }*/

    public void renderCard(Card card){
        detailCardController.renderName(card.getName());
        detailCardController.renderDetail(card.getDescription());
        detailCardController.renderImage(card.getImagepath());
        if (card.getType()!='L'){
            detailCardController.renderAttack(Integer.toString(card.getAttack()));
            detailCardController.renderDef(Integer.toString(card.getDefense()));
            detailCardController.renderPower(Integer.toString(card.getPower()));
        }

    }

    public void resetCard(){
        detailCardController.renderName("");
        detailCardController.renderAttack("");
        detailCardController.renderDef("");
        detailCardController.renderPower("");
        detailCardController.renderDetail("");
        detailCardController.renderImage("");
    }

}
