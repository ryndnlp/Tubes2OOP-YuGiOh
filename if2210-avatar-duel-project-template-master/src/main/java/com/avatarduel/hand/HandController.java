package com.avatarduel.hand;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class HandController {
    private ArenaController ac;
    @FXML private AnchorPane hc1;
    @FXML private AnchorPane hc2;
    @FXML private AnchorPane hc3;
    @FXML private AnchorPane hc4;
    @FXML private AnchorPane hc5;
    @FXML private AnchorPane hc6;
    @FXML private AnchorPane hc7;
    @FXML private AnchorPane hc8;

    public void mouseEntered(MouseEvent event) {
        ac.setCard();

    }
    public void init(ArenaController ac) {
        this.ac = ac;
    }

}
