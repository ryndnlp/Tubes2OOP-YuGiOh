package com.avatarduel.card;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class DetailCardController {

    @FXML
    private Label name;

    @FXML
    private ImageView element;

    @FXML
    private Label desc;

    @FXML
    private ImageView gambar;

    @FXML
    private Label detail;

    @FXML
    private Label attack;

    @FXML
    private Label defense;

    @FXML
    private Label power;

    private ArenaController ac;

    public void init(ArenaController ac) {
        this.ac = ac;
    }


    public void setName(String name){
        this.name.setText(name);
    }
    public void setAttack(String Attack){
        this.attack.setText("Att: " + Attack);
    }
    public void setDef(String Def){
        this.defense.setText("Def: " + Def);
    }
    public void setPower(String power){
        this.power.setText("Pow: " + power);
    }
    public void setDetail(String detail){
        this.detail.setText("detail");
    }

}
