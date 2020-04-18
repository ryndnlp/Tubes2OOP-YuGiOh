package com.avatarduel;

import com.avatarduel.model.Element;
import com.avatarduel.util.Tuple;
import javafx.fxml.FXML;

import java.awt.*;
import java.util.HashMap;

public class ElementController {
    @FXML private Label Fire;
    @FXML private Label Water;
    @FXML private Label Air;
    @FXML private Label Earth;

    private ArenaController ac;
    private HashMap<Element,Tuple<Integer,Integer>> power;

    public void init(ArenaController ac, HashMap<Element, Tuple<Integer,Integer>> power){
        this.ac = ac;
        this.power = power;
        renderElemet();
    }
    public void renderElemet(){
        this.Fire.setText(power.get(Element.FIRE).getFirst() + " / " + power.get(Element.FIRE).getSecond());
        this.Water.setText(power.get(Element.WATER).getFirst() + " / " + power.get(Element.WATER).getSecond());
        this.Air.setText(power.get(Element.AIR).getFirst() + " / " + power.get(Element.AIR).getSecond());
        this.Earth.setText(power.get(Element.EARTH).getFirst() + " / " + power.get(Element.EARTH).getSecond());
    }
}
