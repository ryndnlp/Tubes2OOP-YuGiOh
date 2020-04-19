package com.avatarduel;

import com.avatarduel.player.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class PlayerController {

    @FXML
    private Label typePlayer;

    @FXML
    private Label namePlayer;

    @FXML
    private Label heathLabel;

    @FXML
    private ProgressBar healthBar;

    private Player P;

    private ArenaController ac;

    public void init(ArenaController ac){

        this.ac = ac;
    }

    public void setHealthLabel(int health){
        this.heathLabel.setText("HP: " + health + "/ "+"80");
    }
    public void setHealthBar(int health){
        this.healthBar.setProgress((Double.parseDouble(health+""))/80);
    }
}