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
    public void renderAttackC(String attack){
        this.attack.setText("ATK/ " + attack + " ");
    }
    public void renderDefenseC(String def){
        this.defense.setText("DEF/ " + def + " ");
    }
    public void renderAttackL(){
        this.attack.setText("");
    }
    public void renderDefenseL(){
        this.defense.setText("");
    }
    public void renderPower(String power){
        this.power.setText("POW/ " + power);
    }
    public void renderPowerL(){
        this.power.setText("");
    }
    public void renderAttackS(String attack){
        if(Integer.valueOf(attack)>0){
            this.attack.setText("+" + attack + " ATK ");
        }else{
            this.attack.setText(attack + " ATK ");
        }
    }
    public void renderDefenseS(String defense){
        if(Integer.valueOf(defense)>0){
            this.defense.setText("+" + defense + " DEF ");
        }else{
            this.defense.setText(defense + " DEF ");
        }
    }

    public void renderDesc(String desc){
        this.desc.setText(desc);
    }
    public void renderImage(String path){
        this.gambar.setImage(new Image(path, 165, 121, false, false));
    }
    public void renderElement(String path){
        this.element.setImage(new Image(path, 50, 50, false, false));
    }


}
