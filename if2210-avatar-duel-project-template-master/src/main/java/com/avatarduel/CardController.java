package com.avatarduel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class CardController implements Initializable {

    //@FXML
    //private AnchorPane card;

    @FXML
    private Label nameLabel;

    @FXML
    private Label elemLabel;

    @FXML
    private Label status;

    @FXML
    public ImageView gambar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image image = new Image("com/avatarduel/card/image/character/Aang.png", 60, 49, false, false);
        gambar.setImage(image);

    }

    @FXML
    void mouseEntered(MouseEvent event) {
        nameLabel.setText("Lah");
    }


}
