package com.avatarduel;

import com.avatarduel.card.Card;
import com.avatarduel.field.Field;
import com.avatarduel.util.Tuple;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FieldController {
    @FXML private ActiveCardController charCard1Controller;
    @FXML private ActiveCardController charCard2Controller;
    @FXML private ActiveCardController charCard3Controller;
    @FXML private ActiveCardController charCard4Controller;
    @FXML private ActiveCardController charCard5Controller;
    @FXML private ActiveCardController charCard6Controller;
    @FXML private ActiveCardController skillCard1Controller;
    @FXML private ActiveCardController skillCard2Controller;
    @FXML private ActiveCardController skillCard3Controller;
    @FXML private ActiveCardController skillCard4Controller;
    @FXML private ActiveCardController skillCard5Controller;
    @FXML private ActiveCardController skillCard6Controller;

    public ArenaController ac;
    public Field field;
    private List<ActiveCardController> listOfSkill;
    private List<ActiveCardController> listOfChar;

    public List<ActiveCardController> getListOfCharController(){
        return listOfChar;
    }
    public List<ActiveCardController> getListOfSkillController(){
        return listOfSkill;
    }
    public void setListOfCharController(List<ActiveCardController> listOfCharController){
       this.listOfChar = listOfCharController;
    }
    public void setListOfSkillController(List<ActiveCardController> listOfSkillController){
        this.listOfSkill = listOfSkillController;
    }


    public void mouseEntered(MouseEvent event) {
//        Node node = (Node) event.getSource();
//        String data = (String) node.getUserData();
//        ac.renderCard(field.getCardOnField().get(Integer.parseInt(data)));
    }

    public void renderField(){
        charCard1Controller.setPosition(0,0);
        charCard2Controller.setPosition(0,1);
        charCard3Controller.setPosition(0,2);
        charCard4Controller.setPosition(0,3);
        charCard5Controller.setPosition(0,4);
        charCard6Controller.setPosition(0,5);
        skillCard1Controller.setPosition(1, 0);
        skillCard2Controller.setPosition(1, 1);
        skillCard3Controller.setPosition(1, 2);
        skillCard4Controller.setPosition(1, 3);
        skillCard5Controller.setPosition(1, 4);
        skillCard6Controller.setPosition(1, 5);

        listOfSkill = new ArrayList<ActiveCardController>();
        listOfChar = new ArrayList<ActiveCardController>();
        
        listOfChar.add(charCard1Controller);
        listOfChar.add(charCard2Controller);
        listOfChar.add(charCard3Controller);
        listOfChar.add(charCard4Controller);
        listOfChar.add(charCard5Controller);
        listOfChar.add(charCard6Controller);
        listOfSkill.add(skillCard1Controller);
        listOfSkill.add(skillCard2Controller);
        listOfSkill.add(skillCard3Controller);
        listOfSkill.add(skillCard4Controller);
        listOfSkill.add(skillCard5Controller);
        listOfSkill.add(skillCard6Controller);

        HashMap<Tuple<Integer,Integer>, Card> temp = field.getCardOnField();

        for (Tuple<Integer,Integer> loc: temp.keySet()) {
            if(loc.getFirst()==0){
                listOfChar.get(loc.getSecond()).init(ac, temp.get(loc), loc);
            }else if(loc.getSecond()==1){
                listOfSkill.get(loc.getSecond()).init(ac, temp.get(loc), loc);
            }
        }
    }

    public void init(ArenaController ac, Field field){
        this.ac = ac;
        this.field = field;

        renderField();
    }

}