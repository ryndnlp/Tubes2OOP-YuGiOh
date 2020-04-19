package com.avatarduel;

import com.avatarduel.card.SkillCard;
import com.avatarduel.phase.MainPhase;
import com.avatarduel.util.Tuple;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class SkillController {

    @FXML private AnchorPane container1;
    @FXML private Label powerChar;
    @FXML private Label defenseChar;
    @FXML private Label attackChar;
    @FXML private Label nameChar;
    @FXML private ImageView elementChar;
    @FXML private Label descChar;
    @FXML private ImageView gambarChar;
    @FXML private Button connectButton;
    @FXML private AnchorPane container;
    @FXML private Label powerSkill;
    @FXML private Label defenseSkill;
    @FXML private Label attackSkill;
    @FXML private Label nameSkill;
    @FXML private ImageView elementSkill;
    @FXML private Label descSkill;
    @FXML private ImageView gambarSkill;

    private ArenaController ac;

    public void init(ArenaController ac) {
        this.ac = ac;
    }
    public void renderNameS(String name){
        this.nameSkill.setText(name);
    }
    public void renderAttackS(String attack){
        this.attackSkill.setText("ATK/ " + attack + " ");
    }
    public void renderDefenseS(String defense){
        this.defenseSkill.setText("DEF/ " + defense + " ");
    }
    public void renderPowerS(String power){
        this.powerSkill.setText("POW/ " + power);
    }

    public void renderDescS(String desc){
        SkillCard sc = (SkillCard) ac.toBeUsed;
        this.descSkill.setText(desc + "\n[" + sc.getSkill() + "]");
    }
    public void renderImageS(String path){
        this.gambarSkill.setImage(new Image(path, 165, 121, false, false));
    }
    public void renderElementS(String path){
        this.elementSkill.setImage(new Image(path, 50, 50, false, false));
    }

    public void renderNameA(String name){
        this.nameChar.setText(name);
    }
    public void renderAttackA(String attack){
        this.attackChar.setText("ATK/ " + attack + " ");
    }
    public void renderDefenseA(String defense){
        this.defenseChar.setText("DEF/ " + defense + " ");
    }
    public void renderPowerA(String power){
        this.powerChar.setText("POW/ " + power);
    }
    public void renderDescA(String desc){
        this.descChar.setText(desc);
    }
    public void renderImageA(String path){
        this.gambarChar.setImage(new Image(path, 165, 121, false, false));
    }
    public void renderElementA(String path){
        this.elementChar.setImage(new Image(path, 50, 50, false, false));
    }

    public void showButton(){
        this.connectButton.setVisible(true);
    }
    @FXML public void sync(){
        for (ActiveCardController sc : ac.getFieldController().getListOfSkillController()) {
            if(sc.getCard() == null) {
                Tuple<Integer, Integer> pos = sc.getPosition();
                MainPhase phase = (MainPhase) ac.getPhase();
                SkillCard willBeUsed = (SkillCard) ac.toBeUsed;
                phase.placeCard(willBeUsed, pos.getFirst(), pos.getSecond(), ac.locToBeBind.getFirst(), ac.locToBeBind.getSecond());
                ac.setPhase(phase,ac.getMain());
                break;
            }
        }
    }
}
