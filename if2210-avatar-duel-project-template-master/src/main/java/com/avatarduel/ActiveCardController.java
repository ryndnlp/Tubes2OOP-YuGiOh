package com.avatarduel;

import com.avatarduel.card.Card;
import com.avatarduel.card.CharacterCard;
import com.avatarduel.model.Element;
import com.avatarduel.phase.*;
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

    @FXML
    private Button setSkillButton;

    private Tuple<Integer, Integer> position;
    private boolean turn;
    private ArenaController ac;
    private Card card;

    @FXML
    void onMouseClicked(MouseEvent event) {
        boolean couldAttack = true;
        if(ac.getPhase().getType()=="B") {
            ac.hideButtonBattle();
            BattlePhase bp = (BattlePhase) this.ac.getPhase();
            for (Tuple<Integer, Integer> loc : bp.getAlreadyAttack()) {
                if (this.position.getFirst() == loc.getFirst() && this.position.getSecond() == loc.getSecond()) {
                    couldAttack = false;
                }
            }
        }

        if(card.getType()=='C'){
            if(ac.getPhase().getType()=="M"){
                this.ac.hideButtonSkill();
                if(ac.getPhase().getTurn()==this.turn){
                    this.actionButton.setText("Change pos");
                    this.actionButton.setVisible(true);
                }
                CharacterCard cc = (CharacterCard) this.card;
                ac.toBeBind = cc;
                ac.locToBeBind = this.position;
                ac.toBeBindTurn = this.turn;
                ac.renderCard5();

            }else if(ac.getPhase().getType()=="B"){
                ac.hideButtonBattle();
                CharacterCard cc = (CharacterCard) this.card;
                if(ac.getPhase().getTurn()==this.turn) {
                    if(cc.getPosition() && couldAttack){
                        ac.attacker = cc;
                        ac.locAttacker = this.position;
                        ac.renderCard2();
                    }
                }else{
                    ac.defender = cc;
                    ac.locDefender = this.position;
                    ac.renderCard3();
                }
            }
        }
    }
    public void setTurn(boolean turn){
        this.turn = turn;
    }
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
        this.container.setRotate(0);
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
        MainPhase mp = (MainPhase) ac.getPhase();
        mp.changePosition(this.position.getFirst(), this.position.getSecond());

        ac.setPhase(ac.getPhase(), ac.getMain());
    }
}

