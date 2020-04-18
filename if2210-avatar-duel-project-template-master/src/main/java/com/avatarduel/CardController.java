package com.avatarduel;

import com.avatarduel.card.*;
import com.avatarduel.model.Element;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
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
    @FXML private Label defense;
    @FXML private Label power;
    @FXML private Button summonButton;

    private ArenaController ac;
    private Card card;

    public void init(ArenaController ac,Card card) {
        this.ac = ac;
        this.card = card;

        renderCard();
    }

    public void renderCard(){
        this.summonButton.setVisible(false);
        this.name.setText(this.card.getName());
        this.desc.setText(this.card.getDescription());
        this.gambar.setImage(new Image(this.card.getImagepath(),58, 45, false, false));
        if(card.getElement()== Element.WATER){
            this.element.setImage(new Image("com/avatarduel/card/image/element/Water.jpeg",15, 13, false, false));
        }else if(card.getElement()==Element.AIR){
            this.element.setImage(new Image("com/avatarduel/card/image/element/Air.jpeg",15, 13, false, false));
        }else if(card.getElement()==Element.FIRE){
            this.element.setImage(new Image("com/avatarduel/card/image/element/Fire.jpeg",15, 13, false, false));
        }else {
            this.element.setImage(new Image("com/avatarduel/card/image/element/Earth.jpeg",15, 13, false, false));
        }
        if(card.getType()=='L'){//Land
            this.attack.setText("");
            this.defense.setText("");
            this.power.setText("");
        }else if(card.getType()=='S'){//Skill
            if(card.getAttack()>0){
                this.attack.setText("+" + String.valueOf(card.getAttack()) + " ATK ");
            }else{
                this.attack.setText(String.valueOf(card.getAttack()) + " ATK ");
            }
            if(card.getDefense()>0){
                this.defense.setText("+" + String.valueOf(card.getDefense()) + " DEF ");
            }else{
                this.defense.setText(String.valueOf(card.getDefense()) + " DEF ");
            }
            this.power.setText("Pow/ " + String.valueOf(card.getPower()));
        }else{
            this.attack.setText("ATK/ " + card.getAttack() + " ");
            this.defense.setText("DEF/ " + card.getDefense() + " ");
            this.power.setText("POW/" + card.getPower());
        }

    }
    @FXML
    void cardClicked(MouseEvent event) {
        this.summonButton.setVisible(true);
    }
    @FXML
    void cardUnhover(MouseEvent event) {
        this.summonButton.setVisible(false);
    }
    @FXML
    void onButtonClicked(MouseEvent event){
        Card summoned = card;
        if(card.getType()=='C'){
            ac.toBeSummoned =card;
            ac.summon();
            //System.out.println(ac.toBeSummoned.getName());
        }
    }
}

