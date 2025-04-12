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
/**
 * This is the main part of the program that is used to simulate the actual battles
 */
public class Battle extends Application {

    private Pokemon player;
    private Pokemon opponent;
    private BorderPane drawingPane;
    private BorderPane pane;

    Random rand = new Random();
    PokemonFactory factory = new PokemonFactory();
    CPUFactory cpufactory = new CPUFactory();

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
    /**
     * This is the creation of the stage and the elements found within it
     * @param stage - The inital blank stage
     */
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
    /**
     * This is used to set the opponents and the players pokemon that are being used
     * @param e The button being clicked
     */
    public void setpokemon(ActionEvent e){
        if(cpu.isSelected()){
            this.player = factory.factory(player_pokemon.getText());
            player.addmove((player_pokemon.getText()+ "moves" + ".txt"));
            player.addstat((player_pokemon.getText()+ "stats" + ".txt"));
            this.opponent = cpufactory.factory(rand.nextInt(1, 3));
            opponent.addmove((opponent.getCpuname() + "moves" + ".txt"));
            opponent.addstat((opponent.getCpuname() + "stats" + ".txt"));}
        else{
        PokemonFactory factory = new PokemonFactory();
        this.player = factory.factory(player_pokemon.getText());
        player.addmove((player_pokemon.getText()+ "moves" + ".txt"));
        player.addstat((player_pokemon.getText()+ "stats" + ".txt"));
        this.opponent = factory.factory(oppnent_pokemon.getText());
        opponent.addmove((oppnent_pokemon.getText()+ "moves" + ".txt"));
        opponent.addstat((oppnent_pokemon.getText()+ "stats" + ".txt"));}
    }
    /**
     * This is used for calculating the effects of the players move
     * @param e The button being clicked
     */
    public void player(ActionEvent e){
        Float value = player.calcdamage(player_move.getText(), player, opponent, player_stat.getText());
        opponenthealthset(value);
    }
    /**
     * This is used for calculating the effects of the opponents move
     * @param e The button being clicked
     */
    public void oppnent(ActionEvent e){
        if(cpu.isSelected()){

            Float value = opponent.calcdamage(cpufactory.movefactory(opponent), opponent, player, cpufactory.statfactory(opponent));
            playerhealthset(value);}
        else{
        Float value = opponent.calcdamage(oppnent_move.getText(), opponent, player, oppnent_stat.getText());
        playerhealthset(value);}
    }
    /**
     * This is used to change the players health after an opponents move
     * @param value - The value of the damage
     */
    public void playerhealthset(Float value){
        if(player.getHealth() > 0){
            player.setHealth((player.getHealth() - value));
            System.out.print("A total of " + value + " was done!");
        }
        else{System.out.println("You Wins!");}
    }
    /**
     This is used to change the opponents health after a players move
     * @param value - The value of the damage
     */
    public void opponenthealthset(Float value){
        if(opponent.getHealth() > 0){
            opponent.setHealth((opponent.getHealth() - value));
            System.out.print("A total of " + value + " was done!");
        }
        else{System.out.println("You Wins!");}
    }
    /**
     * This is used for drawing pokemon when a shape and color are selected on the stage
     * @param mouseEvent - The mouse being clicked on the screen
     */
    public void drawpokemon(MouseEvent mouseEvent){

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