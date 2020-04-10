package com.avatarduel.card;
import com.avatarduel.*;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CardController{

    @FXML private Label name;
    @FXML private ImageView gambar;
    @FXML private ImageView element;
    @FXML private Label desc;
    @FXML private Label attack;
    @FXML private Label def;
    @FXML private Label power;

    private ArenaController ac;
    private Card card;

    public void init() {
        Image image = new Image("com/avatarduel/card/image/character/Aang.png", 60, 49, false, false);
        gambar.setImage(image);
        image = new Image("com/avatarduel/card/image/element/Air.png");
        element.setImage(image);
    }

}

