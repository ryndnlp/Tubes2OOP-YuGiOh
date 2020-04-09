package com.avatarduel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class CardController {

    @FXML
    private Label name;

    @FXML
    private ImageView gambar;

    @FXML
    private ImageView element;

    @FXML
    private Label desc;

    @FXML
    private Label attack;

    @FXML
    private Label def;

    @FXML
    private Label power;

//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        Image image = new Image("com/avatarduel/card/image/character/Aang.png", 60, 49, false, false);
//        gambar.setImage(image);
//        image = new Image("com/avatarduel/card/image/element/Air.png");
//        element.setImage(image);
//    }



    @FXML
    public void mouseEntered(MouseEvent event) {
//        ac.setCard();
//        System.out.println("Masuk");
    }



}

