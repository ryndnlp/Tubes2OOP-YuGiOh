package com.avatarduel;

import com.avatarduel.card.Card;
import com.avatarduel.card.CharacterCard;
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
    private AnchorPane container;

    @FXML
    private Label nameLabel;

    @FXML
    private ImageView element;

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
        if(card.getType()=='C'  && ac.getPhase().getType()=="M"){
            this.actionButton.setText("Change pos");
            this.actionButton.setVisible(true);
        }
    }
    private ArenaController ac;
    private Card card;
    @FXML
    void onMouseExited(MouseEvent event) {
        this.actionButton.setVisible(false);
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
        this.nameLabel.setText(this.card.getName());
        this.gambar.setImage(new Image(this.card.getImagepath(),58, 45, false, false));
        this.container.setRotate(0);
        this.actionButton.setRotate(0);
        if(card.getType()=='L'){//Land
            this.attack.setText("");
            this.defense.setText("");
            this.power.setText("");
        }else if(card.getType()=='S'){//Skill
            if(card.getAttack()>0){
                this.attack.setText("+" + String.valueOf(card.getAttack()) + " / ");
            }else{
                this.attack.setText(String.valueOf(card.getAttack()) + " / ");
            }
            if(card.getDefense()>0){
                this.defense.setText("+" + String.valueOf(card.getDefense()) + " / ");
            }else{
                this.defense.setText(String.valueOf(card.getDefense()) + " / ");
            }
            this.power.setText(String.valueOf(card.getPower()));
        }else{
            this.attack.setText(card.getAttack() + " / ");
            this.defense.setText(card.getDefense() + " / ");
            this.power.setText(card.getPower() + " ");
        }
        if(card.getType()=='C'){
            CharacterCard card = (CharacterCard) this.card;
            if(!card.getPosition()) {
                container.setRotate(90);
            }
        }
    }
    public void setCard(Card card){
        this.card = card;
    }
    public void onButtonClicked(MouseEvent event) {
        Tuple<Integer, Integer> pos = this.position;
        CharacterCard card = (CharacterCard) ac.getPhase().seekTurn().getField().getCardOnField().get(pos);
        System.out.println(card.getPosition());
        card.changePosition();
        System.out.println(card.getPosition());
        ac.setPhase(ac.getPhase(), ac.getMain());
    }
}

