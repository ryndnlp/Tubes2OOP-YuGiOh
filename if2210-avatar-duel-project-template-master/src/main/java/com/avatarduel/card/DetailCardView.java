package com.avatarduel.card;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DetailCardView extends AnchorPane {
    private Card card;
    @FXML private Label name;
    @FXML private Label desc;
    @FXML private ImageView gambar;
    @FXML private Label detail;
    @FXML private Label attack;
    @FXML private Label defense;
    @FXML private Label power;

    public DetailCardView (Card card) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DetailCard.fxml")); //Change the file name if necessary
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        name.setText(card.name);
        desc.setText(card.description);
        Image image = new Image(card.imagepath);
        gambar.setImage(image);
        //detail.setText(/*detail*/);
        //power.setText(/*power*/);
        //attack.setText(/*attack*/);
        //defense.setText(/*defense*/);
    }
}
