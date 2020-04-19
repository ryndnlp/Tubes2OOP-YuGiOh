package com.avatarduel;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class BattleController {
    @FXML private AnchorPane container1;
    @FXML private Label powerDefender;
    @FXML private Label defenseDefender;
    @FXML private Label attackDefender;
    @FXML private Label nameDefender;
    @FXML private ImageView elementDefender;
    @FXML private Label descDefender;
    @FXML private ImageView gambarDefender;
    @FXML private Button attackButton;
    @FXML private AnchorPane container;
    @FXML private Label powerAttacker;
    @FXML private Label defenseAttacker;
    @FXML private Label attackAttacker;
    @FXML private Label nameAttacker;
    @FXML private ImageView elementAttacker;
    @FXML private Label descAttacker;
    @FXML private ImageView gambarAttacker;

    private ArenaController ac;

    public void init(ArenaController ac) {
        this.ac = ac;
    }
    public void renderNameA(String name){
        this.nameAttacker.setText(name);
    }
    public void renderNameD(String name){
        this.nameDefender.setText(name);
    }
    public void renderAttackA(String attack){
        this.nameAttacker.setText("ATK/ " + attack + " ");
    }
    public void renderAttackD(String attack){
        this.nameDefender.setText("ATK/ " + attack + " ");
    }
    public void renderDefenseA(String defense){
        this.defenseAttacker.setText("DEF/ " + defense + " ");
    }
    public void renderDefenseD(String defense){
        this.defenseDefender.setText("DEF/ " + defense + " ");
    }
    public void renderPowerA(String power){
        this.powerAttacker.setText("POW/ " + power);
    }
    public void renderPowerD(String power){
        this.powerDefender.setText("POW/ " + power);
    }
//    public void renderDesc(String desc){
//        this.desc.setText(desc);
//    }
//    public void renderImage(String path){
//        this.gambar.setImage(new Image(path, 165, 121, false, false));
//    }
//    public void renderElement(String path){
//        this.element.setImage(new Image(path, 50, 50, false, false));
//    }


}
