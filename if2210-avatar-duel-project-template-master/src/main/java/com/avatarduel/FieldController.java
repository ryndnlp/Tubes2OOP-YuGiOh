package com.avatarduel;

import com.avatarduel.card.Card;
import com.avatarduel.field.Field;
import com.avatarduel.util.Tuple;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class FieldController {
    @FXML
    private ActiveCardController charCard1Controller;
    @FXML
    private ActiveCardController charCard2Controller;
    @FXML
    private ActiveCardController charCard3Controller;
    @FXML
    private ActiveCardController charCard4Controller;
    @FXML
    private ActiveCardController charCard5Controller;
    @FXML
    private ActiveCardController charCard6Controller;
    @FXML
    private ActiveCardController skillCard1Controller;
    @FXML
    private ActiveCardController skillCard2Controller;
    @FXML
    private ActiveCardController skillCard3Controller;
    @FXML
    private ActiveCardController skillCard4Controller;
    @FXML
    private ActiveCardController skillCard5Controller;
    @FXML
    private ActiveCardController skillCard6Controller;

    private ArenaController ac;
    private Field field;
    private List<ActiveCardController> listOfSkillController;
    private List<ActiveCardController> listOfCharController;

    public void init(ArenaController ac, Field field){
        this.ac = ac;
        this.field = field;

        listOfSkillController = new ArrayList<ActiveCardController>();
        listOfCharController = new ArrayList<ActiveCardController>();
        listOfCharController.add(charCard1Controller);
        listOfCharController.add(charCard2Controller);
        listOfCharController.add(charCard3Controller);
        listOfCharController.add(charCard4Controller);
        listOfCharController.add(charCard5Controller);
        listOfCharController.add(charCard6Controller);
        listOfSkillController.add(skillCard1Controller);
        listOfSkillController.add(skillCard2Controller);
        listOfSkillController.add(skillCard3Controller);
        listOfSkillController.add(skillCard4Controller);
        listOfSkillController.add(skillCard5Controller);
        listOfSkillController.add(skillCard6Controller);

        HashMap<Tuple<Integer,Integer>, Card> temp = field.getCardOnField();

        int i = 0;
        int j = 0;
        for (Tuple<Integer,Integer> loc: temp.keySet()) {
            if(loc.getFirst()==0){
                listOfCharController.get(i).init(ac, temp.get(loc));
                i++;
            }else if(loc.getSecond()==1){
                listOfSkillController.get(j).init(ac, temp.get(loc));
                j++;
            }
        }
        
//        System.out.println(handCard);
//        try {
//            hc1Controller.init(ac, this.handCard.get(0));
//            hc2Controller.init(ac, this.handCard.get(1));
//            hc3Controller.init(ac, this.handCard.get(2));
//            hc4Controller.init(ac, this.handCard.get(3));
//            hc5Controller.init(ac, this.handCard.get(4));
//            hc6Controller.init(ac, this.handCard.get(5));
//            hc7Controller.init(ac, this.handCard.get(6));
//            hc8Controller.init(ac, this.handCard.get(7));
//        }catch(Exception e){
//            System.out.println("Gagal ke CardController");
//
//        }
    }

    public void mouseEntered(MouseEvent event) {

    }
}