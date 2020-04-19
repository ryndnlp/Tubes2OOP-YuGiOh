package com.avatarduel;

import com.avatarduel.player.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PlayerController {

    @FXML
    private Label typePlayer;

    @FXML
    private Label namePlayer;

    @FXML
    private Label heathLabel;

    private Player P;

    private ArenaController ac;

    public void init(ArenaController ac){
        this.ac = ac;
    }

    public void setHealthLabel(int health){
        this.heathLabel.setText(health+"");
    }
}
