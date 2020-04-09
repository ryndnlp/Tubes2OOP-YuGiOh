package com.avatarduel;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class HandController {
    @FXML private ArenaController ac;

    @FXML private CardController hc1Controller;
    @FXML private CardController hc2Controller;
    @FXML private CardController hc3Controller;
    @FXML private CardController hc4Controller;
    @FXML private CardController hc5Controller;
    @FXML private CardController hc6Controller;
    @FXML private CardController hc7Controller;
    @FXML private CardController hc8Controller;

    public void mouseEntered(MouseEvent event) {
        ac.renderCard();
    }
    public void mouseExited(MouseEvent event){
        ac.resetCard();
    }
    public void init(ArenaController ac) {
        this.ac = ac;
    }

}
