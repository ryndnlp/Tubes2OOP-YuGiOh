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

    public void renderCard(){
        detailCardController.renderName("Ryan");
        detailCardController.renderAttack("10");
        detailCardController.renderDef("15");
        detailCardController.renderPower("3");
        detailCardController.renderDetail("sad");
    }

    public void resetCard(){
        detailCardController.renderName("Default");
        detailCardController.renderAttack("");
        detailCardController.renderDef("");
        detailCardController.renderPower("");
        detailCardController.renderDetail("Default");
    }

}
