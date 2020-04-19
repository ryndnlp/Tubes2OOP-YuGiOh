package com.avatarduel.card;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

import java.io.IOException;

public class ActiveCardView extends AnchorPane {
    private Card card;
    @FXML private Label nameLabel;
    @FXML private Label attack;
    @FXML private Label power;
    @FXML private Label def;

    public ActiveCardView(Card card) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ActiveCard.fxml")); //Change the file name if necessary
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        nameLabel.setText(card.name);
        //attack.setText("Att: " + card.getAttack());
        //power.setText("Power: " + card.getPower());
        //def.setText("Def: " + card.getDefence());
    }
}
