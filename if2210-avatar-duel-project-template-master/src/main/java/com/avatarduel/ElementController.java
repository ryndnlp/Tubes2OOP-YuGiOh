package com.avatarduel;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import com.avatarduel.model.Element;
import com.avatarduel.util.Tuple;

import java.util.HashMap;

public class ElementController {
    @FXML private Label fire;
    @FXML private Label water;
    @FXML private Label earth;
    @FXML private Label air;

    private ArenaController ac;
    private HashMap<Element,Tuple<Integer,Integer>> power;

    public void init(ArenaController ac, HashMap<Element, Tuple<Integer,Integer>> power){
        this.ac = ac;
        this.power = power;
        renderElemet();
    }
    public void renderElemet(){
        this.fire.setText(power.get(Element.FIRE).getFirst() + " / " + power.get(Element.FIRE).getSecond());
        this.water.setText(power.get(Element.WATER).getFirst() + " / " + power.get(Element.WATER).getSecond());
        this.air.setText(power.get(Element.AIR).getFirst() + " / " + power.get(Element.AIR).getSecond());
        this.earth.setText(power.get(Element.EARTH).getFirst() + " / " + power.get(Element.EARTH).getSecond());
    }
}
