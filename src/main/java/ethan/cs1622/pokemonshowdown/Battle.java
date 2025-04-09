package ethan.cs1622.pokemonshowdown;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

/**
 * This class is for the inital entering of data to be stored from different weather stations using JavaFX
 */
public class Battle extends Application {
    TextField filetemp = new TextField();
    TextField filewindspeed = new TextField();
    TextField filewindchill = new TextField();
    TextField filehumidity = new TextField();
    TextField fileprev = new TextField();

    HashMap<Object, Object> hash = new HashMap<>();
    CheckBox multi = new CheckBox("Multi-Sensor");
    CheckBox thsensor = new CheckBox("TH-Sensor");
    CheckBox wind = new CheckBox("Wind-Sensor");
    CheckBox basic = new CheckBox("Temp-Sensor");
    CheckBox circle = new CheckBox("Circle?");

    TextField date = new TextField();
    TextField temp = new TextField();
    TextField windspeed = new TextField();
    TextField windchill = new TextField();
    TextField humidity = new TextField();

    private Pane drawingPane;
    Pane elements = new Pane();
    Scene scene = new Scene(elements,800 , 800);

    /**
     * This is what is displayed on the stage and shows were buttons, textboxes, and checkboxes go to
     * @param stage - The window where the UI will be displayed
     * @throws IOException - This enables the program to run without having a try and catch
     */
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Weather Application!");
        drawingPane = new Pane();
        BorderPane pane = new BorderPane();
        HBox horiz = new HBox();
        VBox verti = new VBox();
        VBox h = new VBox();

        Button adddata = new Button();
        adddata.setText("Save your data");

        Button dates = new Button();
        dates.setText("Get data for a date");

        Button storedata = new Button();
        storedata.setText("Store Data");

        Button prevdata = new Button();
        prevdata.setText("Get Previous Data");

        Label newdate = new Label("Date");
        Label temps = new Label("Temp");
        Label windspeeds = new Label("Wind-Speed");
        Label windchills = new Label("WindChill");
        Label humiditys = new Label("Humidity");
        Label tempfile = new Label("TempFile");
        Label windspeedfile = new Label("Wind-SpeedFile");
        Label windchillfile = new Label("WindChillFile");
        Label humidityfile = new Label("HumidityFile");
        Label prevfile = new Label("Previous Data File");

        horiz.getChildren().addAll(multi, thsensor, wind, basic, circle);
        horiz.setSpacing(20);
        h.getChildren().addAll(newdate, temps, windspeeds, windchills, humiditys ,tempfile, windspeedfile, windchillfile, humidityfile, prevfile, adddata, dates, storedata, prevdata);
        h.setSpacing(29);
        verti.getChildren().addAll(date, temp, windspeed, windchill,humidity, filetemp, filewindspeed, filewindchill, filehumidity, fileprev);
        verti.setSpacing(20);
        pane.setLeft(h);
        pane.setCenter(verti);
        pane.setTop(horiz);

        adddata.setOnAction(this::Adddata);
        dates.setOnAction(this::getdata);
        storedata.setOnAction(this::storedata);
        prevdata.setOnAction(this::readdata);
        scene.setOnMouseClicked( this::processMouseEvent );
        elements.getChildren().addAll(pane, drawingPane);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This is the class the shows what will happen after the circle? checkbox is clicked per mouseclick
     * @param mouseEvent - The mouse being clicked on the UI
     */
    private void processMouseEvent(MouseEvent mouseEvent){
        if (circle.isSelected()){
            Random rand = new Random();
            int value = rand.nextInt(0, 4);
            if (value == 0){
                Circle circ = new Circle();
                circ.setRadius(5);
                circ.setCenterX(mouseEvent.getSceneX());
                circ.setCenterY(mouseEvent.getSceneY());
                circ.setFill(Color.BLUE);
                drawingPane.getChildren().addAll(circ);}
            if (value == 1){
                Circle circ = new Circle();
                circ.setRadius(10);
                circ.setCenterX(mouseEvent.getSceneX());
                circ.setCenterY(mouseEvent.getSceneY());
                circ.setFill(Color.BLACK);
                drawingPane.getChildren().addAll(circ);}
            if (value == 2){
                Circle circ = new Circle();
                circ.setRadius(8);
                circ.setCenterX(mouseEvent.getSceneX());
                circ.setCenterY(mouseEvent.getSceneY());
                circ.setFill(Color.PURPLE);
                drawingPane.getChildren().addAll(circ);}
            if (value == 3){
                Circle circ = new Circle();
                circ.setRadius(15);
                circ.setCenterX(mouseEvent.getSceneX());
                circ.setCenterY(mouseEvent.getSceneY());
                circ.setFill(Color.GREEN);
                drawingPane.getChildren().addAll(circ);}}
        else {}
    }

    /**
     * This is what will add the data to different weather stations when their checkboxes are clicked
     * @param e - The button being clicked is the ActionEvent
     */
    public void Adddata(ActionEvent e){

    }

    /**
     * This is used to get the data from a weatherstation from a certain day
     * @param e - The button being clicked is the ActionEvent
     */
    public void getdata(ActionEvent e){
    }

    /**
     * This is used to store the data to from different weatherstations into different csvs
     * @param e - The button being clicked is the ActionEvent
     */
    public void storedata(ActionEvent e){

    }

    /**
     * This is used to return the data from a previous weatherstation
     * @param e - The button being clicked
     */
    public void readdata(ActionEvent e){
    }

    public static void main(String[] args) {
        launch(args);
    }}