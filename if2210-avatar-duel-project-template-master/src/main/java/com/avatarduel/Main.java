package com.avatarduel;

import com.avatarduel.model.*;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        CardLoader cardLoader = new CardLoader();
        cardLoader.loadDeckCard();
        cardLoader.loadHandCard();
        //ActiveCardView card = new ActiveCardView(new Card(1,"Name",Element.AIR,"Desc","path"));
        ActiveCardView card = new ActiveCardView(cardLoader.getHandCard().get(0));
        Stage secondStage = new Stage();
        ActiveCardView card2 = new ActiveCardView(cardLoader.getHandCard().get(1));
        primaryStage.setTitle("Hello World");
        secondStage.setTitle("Coba coba");
        //Scene scene = new Scene(root.load(), 50, 150);
        Scene scene = new Scene(card, 50, 150);
        Scene scene1 = new Scene(card2,50,50);
        primaryStage.setScene(scene);
        secondStage.setScene(scene1);
        primaryStage.show();
        secondStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
