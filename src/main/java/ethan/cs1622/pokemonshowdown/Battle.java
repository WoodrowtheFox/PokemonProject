package ethan.cs1622.pokemonshowdown;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import static javafx.application.Application.launch;
public class Battle extends Application {

    private BorderPane pane;

    CheckBox cpu = new CheckBox("CPU");

    TextField player_pokemon = new TextField();
    TextField oppnent_pokemon = new TextField();
    TextField player_move = new TextField();
    TextField oppnent_move = new TextField();

    Pane elements = new Pane();
    Scene scene = new Scene(elements, 640, 480);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Pokemon Battle");

        HBox buttons = new HBox();
        VBox labels = new VBox();
        VBox textboxes = new VBox();
        pane = new BorderPane();

        Button player_action = new Button();
        player_action.setText("Use Move");

        Button oppnent_action = new Button();
        oppnent_action.setText("Opponent Action");

        Label player_poke = new Label("Player Pokemon");
        Label opponent_poke = new Label("Opponent Pokemon");
        Label player_movenamemove = new Label("Player Movename");
        Label opponent_movename = new Label("Opponent Movename");

        labels.getChildren().addAll(player_poke, opponent_poke, player_movenamemove, opponent_movename);
        labels.setSpacing(30);

        buttons.getChildren().addAll(player_action, oppnent_action, cpu);
        buttons.setSpacing(30);

        textboxes.getChildren().addAll(player_pokemon, oppnent_pokemon, player_move, oppnent_move);
        textboxes.setSpacing(20);

        pane.setCenter(textboxes);
        pane.setLeft(labels);
        pane.setTop(buttons);

        player_action.setOnAction(this::player);
        oppnent_action.setOnAction(this::oppnent);
        elements.getChildren().addAll(pane);
        stage.setScene(scene);
        stage.show();
    }
    public void player(ActionEvent e){
        PokemonFactory factory = new PokemonFactory();
        Pokemon player = factory.factory(player_pokemon.getText());
    }
    public void oppnent(ActionEvent e){

    }
}