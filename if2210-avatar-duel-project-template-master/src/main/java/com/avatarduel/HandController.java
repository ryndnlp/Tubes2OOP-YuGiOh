package com.avatarduel;

import com.avatarduel.card.Card;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.List;

public class HandController {
    @FXML private CardController hc1Controller;
    @FXML private CardController hc2Controller;
    @FXML private CardController hc3Controller;
    @FXML private CardController hc4Controller;
    @FXML private CardController hc5Controller;
    @FXML private CardController hc6Controller;
    @FXML private CardController hc7Controller;
    @FXML private CardController hc8Controller;

    private ArenaController ac;
    private List<Card> handCard;

    public void mouseEntered(MouseEvent event) {
        ac.renderCard();
    }
    public void mouseExited(MouseEvent event){
        ac.resetCard();
    }
    public void mouseClicked(MouseEvent event){
        //Add Summon Button
    }
    public void init(ArenaController ac, List<Card> handCard) {
        this.ac = ac;
        this.handCard = handCard;
        try {
            hc1Controller.init(ac, this.handCard.get(0));
            hc2Controller.init(ac, this.handCard.get(1));
            hc3Controller.init(ac, this.handCard.get(2));
            hc4Controller.init(ac, this.handCard.get(3));
            hc5Controller.init(ac, this.handCard.get(4));
            hc6Controller.init(ac, this.handCard.get(5));
            hc7Controller.init(ac, this.handCard.get(6));
            hc8Controller.init(ac, this.handCard.get(7));
        }catch(Exception e){
            System.out.println("Gagal ke CardController");
        }
    }
//    public void renderHand1(String att,String def,String power,String desc,String name){
//        hc1Controller.renderAttack(att);
//        hc1Controller.renderDef(def);
//        hc1Controller.renderPower(power);
//        hc1Controller.renderDesc(desc);
//        hc1Controller.renderName((name));
//    }
}
