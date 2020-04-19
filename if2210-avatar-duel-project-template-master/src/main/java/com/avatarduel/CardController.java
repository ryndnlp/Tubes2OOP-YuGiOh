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
import javafx.scene.layout.AnchorPane;

public class CardController {

    @FXML private Label name;
    @FXML private ImageView gambar;
    @FXML private ImageView element;
    @FXML private Label desc;
    @FXML private Label attack;
    @FXML private Label defense;
    @FXML private Label power;
    @FXML private Button actionButton;
    @FXML private AnchorPane container;

    private ArenaController ac;
    private Card card;

    public void flush() {
        this.name.setText("");
        this.gambar.setImage(null);
        this.element.setImage(null);
        this.desc.setText("");
        this.attack.setText("");
        this.defense.setText("");
        this.power.setText("");
        this.container.setVisible(false);
    }

    public Card getCard() {
        return this.card;
    }
    public void resetCard() {
        this.card = null;
    }

    public void init(ArenaController ac,Card card) {
        this.ac = ac;
        this.card = card;
        renderCard();
    }

    public void renderCard(){
        this.container.setVisible(true);
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
    public void cardClicked(MouseEvent event) {
        if(ac.getPhase().getType()=="M"){
            if (card.getPower() <= ac.getPhase().seekTurn().getPower().get(card.getElement()).getFirst()) {
                if (card.getType() == 'C') {
                    actionButton.setText("Summon");
                    this.actionButton.setVisible(true);
                } else if (card.getType() == 'L') {
                    actionButton.setText("Put");
                    this.actionButton.setVisible(true);
                } else {//Skill
                    SkillCard sc = (SkillCard) this.card;
                    ac.toBeUsed = sc;
                    ac.renderCard4();
                }

            }
        }
    }
    @FXML
    void cardUnhovered(MouseEvent event) {
        this.actionButton.setVisible(false);
    }
    @FXML
    void onButtonClicked(MouseEvent event){
        ac.toBeSummoned = card;
        ac.summon();
        this.actionButton.setVisible(false);
    }
}

