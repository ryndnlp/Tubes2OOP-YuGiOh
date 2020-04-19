package com.avatarduel;

import com.avatarduel.phase.BattlePhase;
import com.avatarduel.util.Tuple;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javax.smartcardio.Card;

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

    public void showButton(){
        this.attackButton.setVisible(true);
    }
    @FXML public void attack(){
        System.out.println(ac.attacker.getName());
        //System.out.println(ac.defender.getName());
        BattlePhase bp = (BattlePhase) ac.getPhase();

        if(ac.defender==null){
            bp.attack(ac.locAttacker.getFirst(), ac.locAttacker.getSecond());
        }else{
            bp.attack(ac.locAttacker.getFirst(), ac.locAttacker.getSecond(), ac.locDefender.getFirst(), ac.locDefender.getSecond());
        }

        System.out.println(ac.getPhase().getP1().getHealth());
        System.out.println(ac.getPhase().getP2().getHealth());
        ac.renderHealth(ac.getPhase().getP1().getHealth(), ac.getPhase().getP2().getHealth());
        flush();
        ac.setPhase(ac.getPhase(), ac.getMain());

    }
    public void hideButton(){
        this.attackButton.setVisible(false);
    }
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
        this.attackAttacker.setText("ATK/ " + attack + " ");
    }
    public void renderAttackD(String attack){
        this.attackDefender.setText("ATK/ " + attack + " ");
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
    public void renderDescA(String desc){
        this.descAttacker.setText(desc);
    }
    public void renderDescD(String desc){
        this.descDefender.setText(desc);
    }
    public void renderImageA(String path){
        this.gambarAttacker.setImage(new Image(path, 165, 121, false, false));
    }
    public void renderImageD(String path){
        this.gambarDefender.setImage(new Image(path, 165, 121, false, false));
    }
    public void renderElementA(String path){
        this.elementAttacker.setImage(new Image(path, 50, 50, false, false));
    }
    public void renderElementD(String path){
        this.elementDefender.setImage(new Image(path, 50, 50, false, false));
    }

    public void flush() {
        this.ac.attacker = null;
        this.ac.defender = null;
        this.ac.locAttacker = null;
        this.ac.locDefender = null;
        this.attackButton.setVisible(false);
        this.nameAttacker.setText("");
        this.nameDefender.setText("");
        this.attackAttacker.setText("");
        this.attackDefender.setText("");
        this.defenseAttacker.setText("");
        this.defenseDefender.setText("");
        this.powerAttacker.setText("");
        this.powerDefender.setText("");
        this.descAttacker.setText("");
        this.descDefender.setText("");
        this.gambarAttacker.setImage(null);
        this.gambarDefender.setImage(null);
        this.elementAttacker.setImage(null);
        this.elementDefender.setImage(null);
    }
}
