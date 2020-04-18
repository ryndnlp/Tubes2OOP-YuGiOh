package com.avatarduel;

import com.avatarduel.card.Card;
import com.avatarduel.card.CharacterCard;
import com.avatarduel.hand.Hand;
import com.avatarduel.util.Tuple;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.Node;

import java.util.ArrayList;
import java.util.HashMap;
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
    private Hand handCard;
    private List<CardController> listOfCardController;

    public void mouseEntered(MouseEvent event) {
        Node node = (Node) event.getSource();
        String data = (String) node.getUserData();
        ac.renderCard(handCard.getCardOnHand().get(Integer.parseInt(data)));

    }

    public void renderHand(){
        listOfCardController = new ArrayList<CardController>();
        listOfCardController.add(hc1Controller);
        listOfCardController.add(hc2Controller);
        listOfCardController.add(hc3Controller);
        listOfCardController.add(hc4Controller);
        listOfCardController.add(hc5Controller);
        listOfCardController.add(hc6Controller);
        listOfCardController.add(hc7Controller);
        listOfCardController.add(hc8Controller);

        for(CardController cont : listOfCardController) {
            cont.resetCard();
        }
        int i = 0;
        for (Card key: handCard.getCardOnHand()) {
            listOfCardController.get(i).init(ac, key);
            i++;
        }
        for(CardController cont : listOfCardController) {
            if(cont.getCard() == null) {
                cont.flush();
            }
        }
    }

    public void init(ArenaController ac, Hand handCard) {
        this.ac = ac;
        this.handCard = handCard;
        //System.out.println(handCard);
        renderHand();
    }


}
