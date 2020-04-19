package com.avatarduel.card;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class UnactiveCardView {
    private Card card;
    @FXML private Label name;
    @FXML private ImageView element;
    @FXML private Label desc;
    @FXML private Label attack;
    @FXML private Label defense;
    @FXML private Label power;
    @FXML private ImageView gambar;

    public UnactiveCardView (Card card) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UnactiveCard.fxml")); //Change the file name if necessary
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        name.setText(card.name);
        desc.setText(card.description);
        //element.setImage(new Image(getClass().getResourceAsStream(/*path*/)));
        //power.setText(/*power*/);
        //attack.setText(/*attack*/);
        //defense.setText(/*defense*/);
        gambar.setImage(new Image(getClass().getResourceAsStream(card.imagepath)));
    }
}
