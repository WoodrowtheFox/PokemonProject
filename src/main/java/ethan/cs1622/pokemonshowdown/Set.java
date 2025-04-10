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
public class Set extends Application {
    DataStorage storage = new DataStorage();

    private BorderPane drawingPane;
    private BorderPane pane;

    CheckBox circle = new CheckBox("Circle");
    CheckBox square = new CheckBox("Square");
    CheckBox red = new CheckBox("Red");
    CheckBox blue = new CheckBox("Blue");
    CheckBox green = new CheckBox("Green");
    CheckBox yellow = new CheckBox("Yellow");
    CheckBox purple = new CheckBox("Purple");

    TextField statname = new TextField();
    TextField statamount = new TextField();
    TextField movename = new TextField();
    TextField movevalue = new TextField();
    TextField pokemonnames = new TextField();
    TextField typename = new TextField();

    Pane elements = new Pane();
    Scene scene = new Scene(elements, 640, 480);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Pokemon Data");
        drawingPane = new BorderPane();

        HBox buttons = new HBox();
        HBox color = new HBox();
        VBox labels = new VBox();
        VBox textboxes = new VBox();
        pane = new BorderPane();

        Button types = new Button();
        types.setText("Save Type");
        Button setmoves = new Button();
        setmoves.setText("Save Move Data");

        Button setstats = new Button();
        setstats.setText("Save Stat Data");

        Button storealldata = new Button();
        storealldata.setText("Final Storage");

        Label stat = new Label("Stat");
        Label statvalue = new Label("Stat-Value");
        Label move = new Label("Movename");
        Label move_value = new Label("Basepower");
        Label pokemonname = new Label("Pokemon Name");
        Label type = new Label("Pokemon Type");
        Label pokemon = new Label("Draw a Pokemon!");

        color.getChildren().addAll(circle, square, red, blue, green, yellow, purple);
        color.setSpacing(30);

        labels.getChildren().addAll(stat, statvalue, move, move_value, pokemonname, type, pokemon);
        labels.setSpacing(30);

        buttons.getChildren().addAll(types, setmoves, setstats, storealldata);
        buttons.setSpacing(30);

        textboxes.getChildren().addAll(statname, statamount, movename, movevalue, pokemonnames, typename);
        textboxes.setSpacing(20);
        drawingPane.setLayoutX(30);
        drawingPane.setLayoutY(30);
        pane.setBottom(color);
        pane.setCenter(textboxes);
        pane.setLeft(labels);
        pane.setTop(buttons);

        scene.setOnMouseClicked(this::drawpokemon);
        setmoves.setOnAction(this::storemovedata);
        setstats.setOnAction(this::storestatsdata);
        types.setOnAction(this::setype);
        storealldata.setOnAction(this::storefinaldata);
        elements.getChildren().addAll(pane, drawingPane);
        stage.setScene(scene);
        stage.show();
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
    public void setype(ActionEvent e){
        storage.setType(typename.getText());
    }
    public void storestatsdata(ActionEvent e){
        storage.addstats(statname.getText(), statamount.getText());
    }
    public void storemovedata(ActionEvent e){
        storage.addmoveset(movename.getText(), movevalue.getText());
    }
    public void storefinaldata(ActionEvent e){
        HashMap<String, String> stats = storage.getstats();
        HashMap<String, String> moveset = storage.getmoves();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pokemonnames.getText() + ".txt"))) {
            writer.write(storage.getType());
        }
        catch (FileNotFoundException fnf){
            System.out.println(fnf.getMessage());
        }
        catch (IOException o){
            System.out.println(o.getMessage());
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pokemonnames.getText()+ "stats" + ".txt"))) {
            for (String i : stats.keySet()) {
                writer.write(i);
                writer.write(" ");
                writer.write(stats.get(i));
                writer.newLine();
            }
        }
        catch (FileNotFoundException fnf){
            System.out.println(fnf.getMessage());
        }
        catch (IOException o){
            System.out.println(o.getMessage());
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pokemonnames.getText() + "moves" + ".txt"))) {
            for (String i : moveset.keySet()) {
                writer.write(i);
                writer.write(" ");
                writer.write(moveset.get(i));
                writer.newLine();
            }
        }
        catch (FileNotFoundException fnf){
            System.out.println(fnf.getMessage());
        }
        catch (IOException o){
            System.out.println(o.getMessage());
        }
    }
}