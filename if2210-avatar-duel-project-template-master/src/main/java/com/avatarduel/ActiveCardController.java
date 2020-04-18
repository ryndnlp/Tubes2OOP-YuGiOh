package com.avatarduel;

import com.avatarduel.card.Card;
import com.avatarduel.model.Element;
import com.avatarduel.util.Tuple;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ActiveCardController {

    @FXML
    private Label nameLabel;

    @FXML
    private ImageView gambar;

    @FXML
    private Label attack;

    @FXML
    private Label defense;

    @FXML
    private Label power;

    @FXML
    private Button actionButton;

    private Tuple<Integer, Integer> position;

    @FXML
    void onMouseClicked(MouseEvent event) {

    }
    private ArenaController ac;
    private Card card;
    @FXML
    void onMouseExited(MouseEvent event) {

    }
    public Card getCard(){
        return this.card;
    }

    public Tuple<Integer, Integer> getPosition(){
        return this.position;
    }
    
    public void resetCard() {
        this.card = null;
        //this.position = null;
    }

    public void flush() {
        this.nameLabel.setText("");
        this.gambar.setImage(null);
        //this.element.setImage(null);
        //this.desc.setText("");
        this.attack.setText("");
        this.defense.setText("");
        this.power.setText("");
    }

    public void setPosition(Integer x, Integer y){
        Tuple<Integer, Integer> position = new Tuple<Integer, Integer>(x,y);
        this.position = position;
    }

    public void init(ArenaController ac, Card card, Tuple<Integer,Integer> pos) {
        this.ac = ac;
        this.card = card;
        this.position = pos;
        this.renderCard();
    }
    public void renderCard(){
        this.actionButton.setVisible(false);
        this.nameLabel.setText(this.card.getName());
        this.gambar.setImage(new Image(this.card.getImagepath(),58, 45, false, false));

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
    public void setCard(Card card){
        this.card = card;
    }
}

