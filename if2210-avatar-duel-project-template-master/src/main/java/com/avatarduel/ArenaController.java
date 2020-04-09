package com.avatarduel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ArenaController  {
    @FXML private DetailCardController detailCardController;

    @FXML private HandController handController;

    @FXML
    private ImageView gambar;

    //private  detailcard;

    public void initialize() {
        handController.init(this);
        detailCardController.init(this);
    }

    public void setCard(){
        detailCardController.setName("Ryan");
        detailCardController.setAttack("10");
        detailCardController.setDef("15");
        detailCardController.setPower("3");
        detailCardController.setDetail("sad");
    }
    
}
