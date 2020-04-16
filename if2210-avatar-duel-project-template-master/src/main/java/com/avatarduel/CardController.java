package com.avatarduel;

import com.avatarduel.card.*;
import com.avatarduel.model.Element;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CardController {

    @FXML private Label name;
    @FXML private ImageView gambar;
    @FXML private ImageView element;
    @FXML private Label desc;
    @FXML private Label attack;
    @FXML private Label def;
    @FXML private Label power;

    private ArenaController ac;
    private Card card;

    public void init(ArenaController ac,Card card) {
        this.ac = ac;
        this.card = card;

        setCard();
    }

    public void setCard(){
        this.name.setText(this.card.getName());
        this.desc.setText(this.card.getDescription());
        this.gambar.setImage(new Image(this.card.getImagepath(),60, 49, false, false));
        if(card.getElement()== Element.WATER){
            this.element.setImage(new Image("com/avatarduel/card/image/element/Water.jpeg",60, 49, false, false));
        }else if(card.getElement()==Element.AIR){
            this.element.setImage(new Image("com/avatarduel/card/image/element/Air.jpeg",60, 49, false, false));
        }else if(card.getElement()==Element.FIRE){
            this.element.setImage(new Image("com/avatarduel/card/image/element/Fire.jpeg",60, 49, false, false));
        }else {
            this.element.setImage(new Image("com/avatarduel/card/image/element/Earth.jpeg",60, 49, false, false));
        }
        if(card.getType()=='L'){//Land
            this.attack.setText("Att:0");
            this.def.setText("Def:0");
            this.power.setText("Power:0");
        }else {//Skill
            this.attack.setText("Att: " + String.valueOf(card.getAttack()));
            this.def.setText("Def: " + String.valueOf(card.getDefense()));
            this.power.setText("Power: " + String.valueOf(card.getPower()));
        }
    }
}

