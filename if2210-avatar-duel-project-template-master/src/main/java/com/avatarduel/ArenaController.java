package com.avatarduel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ArenaController  {
    @FXML
    private CardController cc;

    @FXML
    private DetailCardController dc;

    @FXML
    private Label desc;

    @FXML
    private ImageView gambar;

    @FXML
    private Label detail;

    @FXML public void initialize() {
        cc.init(this);
        dc.init(this);
    }

    public void setCard(){
        dc.setName("Ryan");
        dc.setAttack("10");
        dc.setDef("15");
        dc.setPower("3");
    }

}
