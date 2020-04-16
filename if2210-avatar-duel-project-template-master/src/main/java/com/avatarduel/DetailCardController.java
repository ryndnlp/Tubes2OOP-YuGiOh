package com.avatarduel;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class DetailCardController {

    @FXML private Label name;
    @FXML private ImageView element;
    @FXML private Label desc;
    @FXML private ImageView gambar;
    @FXML private Label detail;
    @FXML private Label attack;
    @FXML private Label defense;
    @FXML private Label power;

    private ArenaController ac;

    public void init(ArenaController ac) {
        this.ac = ac;
        name.setWrapText(true);
        desc.setWrapText(true);
        detail.setWrapText(true);
    }
    public void renderName(String name){
        this.name.setText(name);
    }
    public void renderAttack(String attack){
        this.attack.setText("Att: " + attack);
    }
    public void renderDef(String def){
        this.defense.setText("Def: " + def);
    }
    public void renderPower(String power){
        this.power.setText("Pow: " + power);
    }
    public void renderDetail(String detail){
        this.detail.setText(detail);
    }
    public void renderImage(String path){
        if (path == ""){
            this.gambar.setImage(null);

        } else {
            this.gambar.setImage(new Image(path, 60, 49, false, false));
        }
    }
    public void renderElement(String path){
        if (path == ""){
            this.element.setImage(null);

        } else {
            this.element.setImage(new Image(path, 50, 50, false, false));
        }
    }

}
