package ethan.cs1622.pokemonshowdown;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
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

    private Pokemon player;
    private Pokemon opponent;
    private BorderPane drawingPane;
    private BorderPane pane;

    CheckBox cpu = new CheckBox("CPU");
    CheckBox circle = new CheckBox("Circle");
    CheckBox square = new CheckBox("Square");
    CheckBox red = new CheckBox("Red");
    CheckBox blue = new CheckBox("Blue");
    CheckBox green = new CheckBox("Green");
    CheckBox yellow = new CheckBox("Yellow");
    CheckBox purple = new CheckBox("Purple");

    TextField player_pokemon = new TextField();
    TextField oppnent_pokemon = new TextField();
    TextField player_move = new TextField();
    TextField player_stat = new TextField();
    TextField oppnent_move = new TextField();
    TextField oppnent_stat = new TextField();

    Pane elements = new Pane();
    Scene scene = new Scene(elements, 640, 480);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Pokemon Battle");

        drawingPane = new BorderPane();

        HBox buttons = new HBox();
        VBox labels = new VBox();
        VBox textboxes = new VBox();
        HBox checkboxes = new HBox();
        pane = new BorderPane();

        Button player_action = new Button();
        player_action.setText("Use Move");

        Button oppnent_action = new Button();
        oppnent_action.setText("Opponent Action");

        Button set_pokemon = new Button();
        set_pokemon.setText("Set Pokemon");

        Label player_poke = new Label("Player Pokemon");
        Label opponent_poke = new Label("Opponent Pokemon");
        Label player_movenamemove = new Label("Player Movename");
        Label player_stats = new Label("Player Stat");
        Label opponent_movename = new Label("Opponent Movename");
        Label oppnent_stats = new Label("Opponent Stat");
        Label draw = new Label("Draw a Pokemon!");

        labels.getChildren().addAll(player_poke, opponent_poke, player_movenamemove, player_stats, opponent_movename, oppnent_stats, draw);
        labels.setSpacing(30);

        buttons.getChildren().addAll(player_action, oppnent_action,set_pokemon, cpu);
        buttons.setSpacing(30);

        textboxes.getChildren().addAll(player_pokemon, oppnent_pokemon, player_move, player_stat, oppnent_move, oppnent_stat);
        textboxes.setSpacing(20);

        checkboxes.getChildren().addAll(circle, square, red, green, blue, yellow, purple);
        checkboxes.setSpacing(30);

        pane.setBottom(checkboxes);
        pane.setCenter(textboxes);
        pane.setLeft(labels);
        pane.setTop(buttons);

        scene.setOnMouseClicked(this::drawpokemon);
        set_pokemon.setOnAction(this::setpokemon);
        player_action.setOnAction(this::player);
        oppnent_action.setOnAction(this::oppnent);
        elements.getChildren().addAll(pane, drawingPane);
        stage.setScene(scene);
        stage.show();
    }
    public void setpokemon(ActionEvent e){
        PokemonFactory factory = new PokemonFactory();
        this.player = factory.factory(player_pokemon.getText());
        player.addmove((player_pokemon.getText()+ "moves" + ".txt"));
        player.addstat((player_pokemon.getText()+ "stats" + ".txt"));
        this.opponent = factory.factory(oppnent_pokemon.getText());
        opponent.addmove((oppnent_pokemon.getText()+ "moves" + ".txt"));
        opponent.addstat((oppnent_pokemon.getText()+ "stats" + ".txt"));
    }
    public void player(ActionEvent e){
        Float value = player.calcdamage(player_move.getText(), player, player_stat.getText());
        System.out.println(value);
        opponenthealthset(value);
    }
    public void oppnent(ActionEvent e){
        Float value = opponent.calcdamage(oppnent_pokemon.getText(), opponent, oppnent_stat.getText());
        playerhealthset(value);
    }
    public void playerhealthset(Float value){
        if(value > 0){player.setHealth((player.getHealth() - value));}
        else{System.out.println("You Wins!");}
    }
    public void opponenthealthset(Float value){
        if(value > 0){opponent.setHealth((opponent.getHealth() - value));}
        else{System.out.println("You Wins!");}
    }
    private void drawpokemon(MouseEvent mouseEvent){

        if (circle.isSelected()) {
            Circle circ = new Circle();

            circ.setRadius(10);
            circ.setCenterX(mouseEvent.getSceneX());
            circ.setCenterY(mouseEvent.getSceneY());

            if(red.isSelected()){circ.setFill(Color.RED);}
            else if(blue.isSelected()){circ.setFill(Color.BLUE);}
            else if(green.isSelected()){circ.setFill(Color.GREEN);}
            else if(yellow.isSelected()){circ.setFill(Color.YELLOW);}
            else if(purple.isSelected()){circ.setFill(Color.PURPLE);}
            else{circ.setFill(Color.BLACK);}

            drawingPane.getChildren().addAll(circ);
        }
        else if(square.isSelected()){
            Rectangle rectangle = new Rectangle(20, 20);

            rectangle.setX(mouseEvent.getSceneX());
            rectangle.setY(mouseEvent.getSceneY());

            if(red.isSelected()){rectangle.setFill(Color.RED);}
            else if(blue.isSelected()){rectangle.setFill(Color.BLUE);}
            else if(green.isSelected()){rectangle.setFill(Color.GREEN);}
            else if(yellow.isSelected()){rectangle.setFill(Color.YELLOW);}
            else if(purple.isSelected()){rectangle.setFill(Color.PURPLE);}
            else{rectangle.setFill(Color.BLACK);}

            drawingPane.getChildren().addAll(rectangle);
        }
    }
}