package com.avatarduel;

import com.avatarduel.card.*;
import com.avatarduel.hand.*;
import com.avatarduel.model.Element;
import com.avatarduel.phase.*;
import com.avatarduel.player.Player;
import com.avatarduel.util.Tuple;
import com.avatarduel.field.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.*;

public class ArenaController  {
    private Phase phase;
    private AvatarDuel main;

    static public Card toBeSummoned;
    static public Card attacker;
    static public Card defender;
    static public Tuple<Integer, Integer> locAttacker;
    static public Tuple<Integer, Integer> locDefender;
    static public Card toBeUsed;
    static public Card toBeBind;
    static public boolean toBeBindTurn;
    static public Tuple<Integer, Integer> locToBeBind;

    @FXML private DetailCardController detailCardController;

    @FXML private PlayerController p1Controller;
    @FXML private PlayerController p2Controller;

    @FXML private FieldController fieldP1Controller;
    @FXML private FieldController fieldP2Controller;

    @FXML private HandController handP1Controller;
    @FXML private HandController handP2Controller;

    @FXML private ElementController elmtP1Controller;
    @FXML private ElementController elmtP2Controller;

    @FXML private BattleController battleController;
    @FXML private SkillController skillController;

    @FXML private ImageView gambar;
    @FXML private Label drawPhase;
    @FXML private Label mainPhase;
    @FXML private Label battlePhase;
    @FXML private Label endPhase;
    @FXML private Button nextPhase;

    public void init() {
        detailCardController.init(this);

    }
    public Phase getPhase() {
        return this.phase;
    }

    public AvatarDuel getMain() {
        return this.main;
    }

    @FXML public void nextPhase(MouseEvent event){
        if(this.getPhase().getType()=="M" && this.getPhase().seekTurn().getHand().getCardOnHand().size()==8){
            nextPhase.setDisable(true);
        }else{
            skillController.flush();
            battleController.flush();
            flush(phase.getTurn());
            flush(!phase.getTurn());

            setPhase(this.getPhase().nextPhase(), this.getMain());
        }

    }

    public void flush(boolean isPlayer){
        if(isPlayer){
            for(CardController cont : handP2Controller.getListOfCardController()) {
                cont.resetCard();
            }
            for(CardController cont : handP2Controller.getListOfCardController()) {
                if(cont.getCard() == null) {
                    cont.flush();
                }
            }
        }
        else{
            for(CardController cont : handP1Controller.getListOfCardController()) {
                cont.resetCard();
            }
            for(CardController cont : handP1Controller.getListOfCardController()) {
                if(cont.getCard() == null) {
                    cont.flush();
                }
            }
        }

    }

    public void setPhase(Phase phase, AvatarDuel main){
        this.phase = phase;
        this.main = main;

        nextPhase.setDisable(false);


        if(battleController!=null){
            battleController.flush();
        }
        battleController.init(this);
        skillController.init(this);
        if(handP1Controller.getAC() == null && handP2Controller.getAC() == null) {
            handP1Controller.init(this, phase.getP1().getHand());
            handP2Controller.init(this, phase.getP2().getHand());
            flush(!this.getPhase().getTurn());
        }

        if(!phase.getTurn()){
            Hand handP1 = phase.getP1().getHand();
            handP1Controller.init(this,handP1);
        }else{
            Hand handP2 = phase.getP2().getHand();
            handP2Controller.init(this,handP2);
        }
        Player p1 = phase.getP1();
        Player p2 = phase.getP2();
        p1Controller.init(this);
        p2Controller.init(this);

        Field fieldP1 = phase.getP1().getField();
        Field fieldP2 = phase.getP2().getField();
        fieldP1Controller.init(this, fieldP1, false);
        fieldP2Controller.init(this, fieldP2, true);

        elmtP1Controller.init(this,phase.getP1().getPower());
        elmtP2Controller.init(this, phase.getP2().getPower());

        System.out.println("Berhasil set phase");
        runPhase();
    }

    public void setUpPhaseBackground(){
        if(phase.getType()=="D") {
            drawPhase.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
            mainPhase.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            battlePhase.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            endPhase.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        }else if(phase.getType()=="M"){
            mainPhase.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
            drawPhase.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            battlePhase.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            endPhase.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        }else if(phase.getType()=="B"){
            battlePhase.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
            mainPhase.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            drawPhase.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            endPhase.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        }else{
            endPhase.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
            mainPhase.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            battlePhase.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            drawPhase.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }

    public void runPhase(){
        setUpPhaseBackground();
        if(phase.getType().equals("D")){
            this.nextPhase.setText("Next phase");
            System.out.println("Masuk Draw Phase");
            DrawPhase p = (DrawPhase) this.phase;
            p.draw();
            p.resetPower();
            if(p.getTurn()) {
                handP2Controller.init(this, p.getP2().getHand());
                elmtP2Controller.init(this, p.getP2().getPower());
            } else {
                handP1Controller.init(this, p.getP1().getHand());
                elmtP1Controller.init(this, p.getP1().getPower());
            }
        }else if(phase.getType().equals("M")){
            System.out.println("Masuk Main Phase");
        }else if(phase.getType().equals("B")){
            System.out.println("Masuk Battle Phase");
        }else {
            System.out.println("Masuk End Phase");
            this.nextPhase.setText("Change turn");
        }

    }


    public void renderCard(Card card){

        detailCardController.renderName(card.getName());
        detailCardController.renderDesc(card.getDescription());
        detailCardController.renderImage(card.getImagepath());

        if(card.getElement()== Element.WATER){
            detailCardController.renderElement("com/avatarduel/card/image/element/Water.jpeg");
        }else if(card.getElement()==Element.AIR){
            detailCardController.renderElement("com/avatarduel/card/image/element/Air.jpeg");
        }else if(card.getElement()==Element.FIRE){
            detailCardController.renderElement("com/avatarduel/card/image/element/Fire.jpeg");
        }else {
            detailCardController.renderElement("com/avatarduel/card/image/element/Earth.jpeg");
        }

        if (card.getType()=='C'){
            detailCardController.renderAttackC(Integer.toString(card.getAttack()));
            detailCardController.renderDefenseC(Integer.toString(card.getDefense()));
            detailCardController.renderPower(Integer.toString(card.getPower()));
        }else if(card.getType()=='S'){
            detailCardController.renderAttackS(Integer.toString(card.getAttack()));
            detailCardController.renderDefenseS(Integer.toString(card.getDefense()));
            detailCardController.renderPower(Integer.toString(card.getPower()));
        }else{
            detailCardController.renderAttackL();
            detailCardController.renderDefenseL();
            detailCardController.renderPowerL();
        }
    }
    public void renderCard2(){

        battleController.renderNameA(attacker.getName());
        battleController.renderDescA(attacker.getDescription());
        battleController.renderImageA(attacker.getImagepath());

        if(attacker.getElement()== Element.WATER){
            battleController.renderElementA("com/avatarduel/card/image/element/Water.jpeg");
        }else if(attacker.getElement()==Element.AIR){
            battleController.renderElementA("com/avatarduel/card/image/element/Air.jpeg");
        }else if(attacker.getElement()==Element.FIRE){
            battleController.renderElementA("com/avatarduel/card/image/element/Fire.jpeg");
        }else {
            battleController.renderElementA("com/avatarduel/card/image/element/Earth.jpeg");
        }

        battleController.renderAttackA(Integer.toString(attacker.getAttack()));
        battleController.renderDefenseA(Integer.toString(attacker.getDefense()));
        battleController.renderPowerA(Integer.toString(attacker.getPower()));

        Player p = this.getPhase().seekTurn();
        Player opponent;
        if(p == this.getPhase().getP1()){
            opponent = this.getPhase().getP2();
        }else{
            opponent = this.getPhase().getP1();
        }
        if(attacker!=null){
            if(defender!=null){
                CharacterCard attack = (CharacterCard) attacker;
                CharacterCard defense = (CharacterCard) defender;
                if(attack.getPoint()>=defense.getPoint()){
                    battleController.showButton();
                }
            }else if(opponent.isNoCharacterCard()){
                battleController.showButton();
            }
        }
    }
    public void renderCard3(){

        battleController.renderNameD(defender.getName());
        battleController.renderDescD(defender.getDescription());
        battleController.renderImageD(defender.getImagepath());

        if(defender.getElement()== Element.WATER){
            battleController.renderElementD("com/avatarduel/card/image/element/Water.jpeg");
        }else if(defender.getElement()==Element.AIR){
            battleController.renderElementD("com/avatarduel/card/image/element/Air.jpeg");
        }else if(defender.getElement()==Element.FIRE){
            battleController.renderElementD("com/avatarduel/card/image/element/Fire.jpeg");
        }else {
            battleController.renderElementD("com/avatarduel/card/image/element/Earth.jpeg");
        }

        battleController.renderAttackD(Integer.toString(defender.getAttack()));
        battleController.renderDefenseD(Integer.toString(defender.getDefense()));
        battleController.renderPowerD(Integer.toString(defender.getPower()));

        Player p = this.getPhase().seekTurn();
        Player opponent;
        if(p == this.getPhase().getP1()){
            opponent = this.getPhase().getP2();
        }else{
            opponent = this.getPhase().getP1();
        }
        if(attacker!=null){
            if(defender!=null){
                CharacterCard attack = (CharacterCard) attacker;
                CharacterCard defense = (CharacterCard) defender;
                if(attack.getPoint()>=defense.getPoint()){
                    battleController.showButton();
                }
            }else if(opponent.isNoCharacterCard()){
                battleController.showButton();
            }
        }
    }
    public void renderCard4(){
        skillController.hideButton();
        skillController.renderNameS(toBeUsed.getName());
        skillController.renderDescS(toBeUsed.getDescription());
        skillController.renderImageS(toBeUsed.getImagepath());

        if(toBeUsed.getElement()== Element.WATER){
            skillController.renderElementS("com/avatarduel/card/image/element/Water.jpeg");
        }else if(toBeUsed.getElement()==Element.AIR){
            skillController.renderElementS("com/avatarduel/card/image/element/Air.jpeg");
        }else if(toBeUsed.getElement()==Element.FIRE){
            skillController.renderElementS("com/avatarduel/card/image/element/Fire.jpeg");
        }else {
            skillController.renderElementS("com/avatarduel/card/image/element/Earth.jpeg");
        }

        skillController.renderAttackS(Integer.toString(toBeUsed.getAttack()));
        skillController.renderDefenseS(Integer.toString(toBeUsed.getDefense()));
        skillController.renderPowerS(Integer.toString(toBeUsed.getPower()));

        if(toBeBind!=null && toBeUsed!=null){
            showButtonSkill();
        }
    }
    public void renderCard5(){
        skillController.hideButton();
        skillController.renderNameA(toBeBind.getName());
        skillController.renderDescA(toBeBind.getDescription());
        skillController.renderImageA(toBeBind.getImagepath());

        if(toBeBind.getElement()== Element.WATER){
            skillController.renderElementA("com/avatarduel/card/image/element/Water.jpeg");
        }else if(toBeBind.getElement()==Element.AIR){
            skillController.renderElementA("com/avatarduel/card/image/element/Air.jpeg");
        }else if(toBeBind.getElement()==Element.FIRE){
            skillController.renderElementA("com/avatarduel/card/image/element/Fire.jpeg");
        }else {
            skillController.renderElementA("com/avatarduel/card/image/element/Earth.jpeg");
        }

        skillController.renderAttackA(Integer.toString(toBeBind.getAttack()));
        skillController.renderDefenseA(Integer.toString(toBeBind.getDefense()));
        skillController.renderPowerA(Integer.toString(toBeBind.getPower()));

        if(toBeBind!=null && toBeUsed!=null){
            showButtonSkill();
        }
    }
    public void hideButtonBattle(){
        battleController.hideButton();
    }
    public void showButtonSkill(){
        skillController.showButton();
    }
    public void hideButtonSkill(){
        skillController.hideButton();
    }
    public void renderHealth(int healthP1, int healthP2){
        p2Controller.setHealthLabel(healthP2);
        p1Controller.setHealthLabel(healthP1);
    }
    public void DrawPhaseClicked() {
        if(phase.getType().equals("D")){
            System.out.println("Tetap di Draw Phase");
        }
    }

    public void MainPhaseClicked() {
        if(phase.getType().equals("D")){
            this.main.initRoot(this.phase.nextPhase());
            System.out.println("Berhasil ganti phase ke MainPhase");
        }
    }

    public void BattlePhaseClicked() {
       if(phase.getType().equals("M")){
           this.main.initRoot(this.phase.nextPhase());
           System.out.println("Berhasil ganti phase ke Battle Phase");
       }
    }

    public void EndPhaseClicked() {
       if(phase.getType().equals("B")){
           this.main.initRoot(this.phase.nextPhase());
           System.out.println("Berhasil ganti phase ke End Phase");
       }

    }
    public void summon(){
        FieldController cont;
        if(this.getPhase().getTurn()) {
            cont = fieldP2Controller;
        }
        else {
            cont = fieldP1Controller;
        }
        if(toBeSummoned.getType().equals('C')) {
            for (ActiveCardController cc:  cont.getListOfCharController()) {
                if(cc.getCard()==null){
                    Tuple<Integer, Integer> pos = cc.getPosition();
                    MainPhase phase = (MainPhase) this.phase;
                    CharacterCard willSummoned = (CharacterCard) toBeSummoned;
                    phase.placeCard(willSummoned, pos.getFirst(), pos.getSecond());
                    this.setPhase(phase, main);
                    break;
                }
            }
        }
    }
    public HandController getHandController(){
        if(this.phase.getTurn()){
            return this.handP2Controller;
        }else{
            return this.handP1Controller;
        }
    }
    public FieldController getFieldController(){
        if(this.phase.getTurn()){
            return this.fieldP2Controller;
        }else{
            return this.fieldP1Controller;
        }
    }
    public BattleController getBattleController(){
        return this.battleController;
    }
    public SkillController getSkillController(){
        return this.skillController;
    }

}
