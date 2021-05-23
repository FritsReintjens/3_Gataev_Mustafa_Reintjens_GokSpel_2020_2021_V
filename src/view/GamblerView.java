package view;

import controller.GamblerViewController;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.layout.*;
import model.Speler;
import model.gokstrategy.GokStrategy;

import java.util.Map;

/**
 * @Author Adam Gataev, Jurgen Mustafa
 */
public class GamblerView extends GridPane {
    private String gegevenSpelersNaam;
    private double gevondenSpelerGoksaldo;
    private double inzet;

    private Stage stage = new Stage();
    private GamblerViewController controller;

    private Pane root;
    private Scene scene;
    private Label spelerLabel, goksaldoLabel, inzetLabel, errorKader1, kiesStrategyLabel, strategy1Label, strategy2Label, strategy3Label,strategy4Label,w1Label,w2Label,w3Label,w4Label,w1resultLabel, w2resultLabel, w3resultLabel, w4resultLabel, resultLabel, nieuweGoksaldoLabel, verhoogInzetLabel;
    private TextField spelerField, inzetField, verhoogInzetField;
    private Button startButton,bevestigButton, werpButton;
    private RadioButton rgs1,rgs2,rgs3,rgs4;
    private HBox p1, p21, p22, p23, p31, p111, p112, p113, p3211, p3212,p3213, p3214, p3215;
    private VBox p0 ,p2 ,p3 ,p11 ,p12,p32 ,p221 ,p222 ,p321 ,p322;

    public GamblerView(GamblerViewController controller) {

        this.root = createNodeHierarchy();

        this.controller = controller;
        stage.setTitle("GAMBLER VIEW");
        stage.initStyle(StageStyle.UTILITY);
        stage.setX(20);
        stage.setY(20);

        this.scene = new Scene(root, 600, 600);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();

        controller.setView(this);

    }

    private Pane createNodeHierarchy() {

        this.p111 = new HBox(10);
        this.spelerLabel = new Label("wat is je spelersnaam? ");
        this.spelerField = new TextField();
        spelerField.setOnAction(event -> checkNaamInput(spelerField.getText()));
        this.goksaldoLabel = new Label();
        p111.getChildren().addAll(spelerLabel,spelerField,goksaldoLabel);


        this.p112 = new HBox(10);
        this.inzetLabel = new Label("wat is je inzet? ");
        inzetLabel.setVisible(false);
        this.inzetField = new TextField();
        inzetField.setVisible(false);
        inzetField.setOnAction(event -> checkInzetInput(inzetField.getText()));
        p112.getChildren().addAll(inzetLabel,inzetField);

        this.p113 = new HBox(10);
        this.startButton = new Button("Start gokspel");
        this.startButton.setVisible(false);
        startButton.setOnAction(event -> startGokspel());
        p113.getChildren().addAll(startButton);


        this.p221 = new VBox(10);
        final ToggleGroup tGroup = new ToggleGroup();

        this.rgs1 = new RadioButton("Het aantal ogen bij elke worp is een " + "even" + " getal");
        rgs1.setToggleGroup(tGroup);
        rgs1.setSelected(true);
        rgs1.setVisible(false);


        this.rgs2 = new RadioButton("de som van de ogen van alle worpen samen is " + 21);
        rgs2.setToggleGroup(tGroup);
        rgs2.setVisible(false);

        this.rgs3 = new RadioButton("het aantal ogen is bij elke worp " + "hoger" + " dan bij de vorige worp");
        rgs3.setToggleGroup(tGroup);
        rgs3.setVisible(false);

        this.rgs4 = new RadioButton("win");
        rgs4.setToggleGroup(tGroup);
        rgs4.setVisible(false);


        p221.getChildren().addAll(rgs1, rgs2, rgs3,rgs4);
        this.p222 = new VBox(10);
        this.strategy1Label = new Label("mogelijke winst is " + 4 + "x je inzet");
        this.strategy2Label = new Label("mogelijke winst is " + 5 + "x je inzet");
        this.strategy3Label = new Label("mogelijke winst is " + 10 + "x je inzet");
        this.strategy4Label = new Label("mogelijke winst is " + 10 + "x je inzet");
        p222.getChildren().addAll(strategy1Label, strategy2Label, strategy3Label, strategy4Label);

        this.p321 = new VBox();
        this.p3211 = new HBox();
        this.p3212 = new HBox();
        this.p3213 = new HBox();
        this.p3214 = new HBox();

        this.w1Label = new Label("worp1 :");
        this.w2Label = new Label("worp2 :");
        this.w3Label = new Label("worp3 :");
        this.w4Label = new Label("worp4 :");
        this.w1resultLabel = new Label("");
        this.w2resultLabel = new Label("");
        this.w3resultLabel = new Label("");
        this.w4resultLabel = new Label("");
        this.verhoogInzetLabel = new Label("Verhoog inzet met maximaal 10 €");
        this.verhoogInzetField = new TextField();
        this.verhoogInzetField.setOnAction(event -> verhoogInzet(verhoogInzetField.getText()));
        this.verhoogInzetLabel.setVisible(false);
        this.verhoogInzetField.setVisible(false);

        p3211.getChildren().addAll(w1Label,w1resultLabel);
        p3212.getChildren().addAll(w2Label,w2resultLabel, verhoogInzetLabel, verhoogInzetField);
        p3213.getChildren().addAll(w3Label,w3resultLabel);
        p3214.getChildren().addAll(w4Label,w4resultLabel);
        p321.getChildren().addAll(p3211,p3212,p3213,p3214);
        p321.setVisible(false);


        this.p322 = new VBox();
        this.resultLabel = new Label("");
        this.nieuweGoksaldoLabel = new Label("");
        p322.getChildren().addAll(resultLabel, nieuweGoksaldoLabel);
        p322.setVisible(false);

        this.p11 = new VBox(10);
        p11.getChildren().addAll(p111,p112,p113);
        this.p12 = new VBox(10);
        this.errorKader1 = new Label("");
        p12.getChildren().addAll(errorKader1);


        this.p21 = new HBox(10);
        this.kiesStrategyLabel = new Label("Kies je gok strategie uit de volgende lijst");
        p21.getChildren().addAll(kiesStrategyLabel);
        this.p22 = new HBox(10);
        p22.getChildren().addAll(p221,p222);
        this.p23 = new HBox(10);
        this.bevestigButton = new Button("bevestig je keuze");
        bevestigButton.setOnAction(event -> bevestigKeuze(((RadioButton)(tGroup.getSelectedToggle())).getText()));
        p23.getChildren().addAll(bevestigButton);

        this.p31 = new HBox(10);
        this.werpButton = new Button("werp dobbelsteen");
        werpButton.setOnAction(event -> werpDobbelsteen());
        p31.getChildren().addAll(werpButton);
        this.p32 = new VBox(10);
        p32.getChildren().addAll(p321,p322);


        this.p1 = new HBox(10);
        p1.getChildren().addAll(p11,p12);
        this.p2 = new VBox(10);
        p2.getChildren().addAll(p21,p22,p23);
        p2.setVisible(false);
        this.p3 = new VBox(10);
        p3.getChildren().addAll(p31,p32);
        p3.setVisible(false);
        this.p0 = new VBox(10);
        p0.getChildren().addAll(p1,p2,p3);

        return this.p0;
    }


    public void checkNaamInput(String spelersNaam){
        Map<String,Speler> spelers = controller.getSpel().getSpelers();
        double tijdelijkeGoksaldo;

        if (spelers.containsKey(spelersNaam)){
            this.inzetField.setVisible(true);
            Speler s = spelers.get(spelersNaam);
            tijdelijkeGoksaldo = s.getGoksaldo();
            this.goksaldoLabel.setText("Je goksaldo is " + tijdelijkeGoksaldo + " €");
            this.inzetLabel.setVisible(true);
            this.startButton.setVisible(true);
            this.startButton.setDisable(true);
            this.gevondenSpelerGoksaldo = tijdelijkeGoksaldo;
            this.errorKader1.setVisible(false);
            this.gegevenSpelersNaam = spelersNaam;
        } else {
            this.inzetField.setVisible(false);
            this.inzetLabel.setVisible(false);
            this.startButton.setVisible(false);
            this.goksaldoLabel.setText("");
            this.errorKader1.setVisible(true);
            this.errorKader1.setText("Naam niet gevonden, probeer opnieuw");
            this.errorKader1.setTextFill(Color.RED);
            p2.setVisible(false);
            p3.setVisible(false);
        }

    }

    public void checkInzetInput(String inzet){
        try {
            double dInzet = Double.parseDouble(inzet);
            if (!inzet.trim().isEmpty() && dInzet > 0 && this.gevondenSpelerGoksaldo >= dInzet) {
                this.startButton.setDisable(false);
                this.errorKader1.setVisible(false);
                this.inzet = dInzet;
            } else {
                this.startButton.setDisable(true);
                this.errorKader1.setVisible(true);
                this.errorKader1.setText("Ongeldige inzet");
                this.errorKader1.setTextFill(Color.RED);
                this.p2.setVisible(false);
                this.p3.setVisible(false);
            }
        }catch(Exception e){
            this.errorKader1.setVisible(true);
            this.errorKader1.setText("Hier mogen enkel cijfers ingevuld worden");
            this.errorKader1.setTextFill(Color.RED);
            this.p2.setVisible(false);
            this.p3.setVisible(false);
        }
    }

    public void startGokspel(){
        this.p2.setVisible(true);
        this.inzetField.setDisable(true);
        this.spelerField.setDisable(true);
        //HIER GEEF JE DE SPELER DOOR AAN DE FACADE
        this.controller.getSpel().setSpeler(this.gegevenSpelersNaam);
        this.controller.getSpel().setInzet(this.inzet);
        if (controller.getSpel().getActiveStrategies().contains("EvenOgenStrategy")) {
            rgs1.setVisible(true);
        }
        if (controller.getSpel().getActiveStrategies().contains("SomOgenStrategy")) {
            rgs2.setVisible(true);
        }
        if (controller.getSpel().getActiveStrategies().contains("WorpenOplopendStrategy")) {
            rgs3.setVisible(true);
        }
        if (controller.getSpel().getActiveStrategies().contains("WinStrategy")) {
            rgs4.setVisible(true);
        }
        this.controller.getSpel().startSpel();
        this.startButton.setDisable(true);
    }

    public void bevestigKeuze(String strategy){
        this.p3.setVisible(true);
        if (strategy.equalsIgnoreCase("de som van de ogen van alle worpen samen is 21")){
            this.controller.getSpel().setEnumString("SOMOGEN");
        }
        else if(strategy.equalsIgnoreCase("Het aantal ogen bij elke worp is een even getal")){
            this.controller.getSpel().setEnumString("EVENOGEN");
        }
        else if(strategy.equalsIgnoreCase("het aantal ogen is bij elke worp " + "hoger" + " dan bij de vorige worp")){
            this.controller.getSpel().setEnumString("WOPRENOPLOPEND");
        } else {
            this.controller.getSpel().setEnumString("WIN");
        }
        this.controller.getSpel().bevestigKeuze();
        this.bevestigButton.setDisable(true);
    }

    public void werpDobbelsteen(){
        this.controller.getSpel().getState().werpDobbelsteen();

        int aantalWorpen = this.controller.getSpel().getAantalWorpen();
        p321.setVisible(true);
        if(aantalWorpen == 1){
            w1resultLabel.setText(Integer.toString(this.controller.getSpel().getWorpen()[0]));
            if (this.controller.getSpel().getState().getClass().getSimpleName().equalsIgnoreCase("GewonnenState")){
                this.controller.getSpel().showGewonnen();
            }
            if (this.controller.getSpel().getState().getClass().getSimpleName().equalsIgnoreCase("VerlorenState")){
                this.controller.getSpel().showVerloren();
            }
        }else if(aantalWorpen == 2){
            w2resultLabel.setText(Integer.toString(this.controller.getSpel().getWorpen()[1]));
            if (this.controller.getSpel().getState().getClass().getSimpleName().equalsIgnoreCase("GewonnenState")){
                this.controller.getSpel().showGewonnen();
            }
            if (this.controller.getSpel().getState().getClass().getSimpleName().equalsIgnoreCase("VerlorenState")){
                this.controller.getSpel().showVerloren();
            }
        }
        else if(aantalWorpen == 3){
            w3resultLabel.setText(Integer.toString(this.controller.getSpel().getWorpen()[2]));
            if (this.controller.getSpel().getState().getClass().getSimpleName().equalsIgnoreCase("GewonnenState")){
                this.controller.getSpel().showGewonnen();
            }
            if (this.controller.getSpel().getState().getClass().getSimpleName().equalsIgnoreCase("VerlorenState")){
                this.controller.getSpel().showVerloren();
            }
        }
        else{
            w4resultLabel.setText(Integer.toString(this.controller.getSpel().getWorpen()[3]));
            if (this.controller.getSpel().getState().getClass().getSimpleName().equalsIgnoreCase("GewonnenState")){
                this.controller.getSpel().showGewonnen();
            }
            if (this.controller.getSpel().getState().getClass().getSimpleName().equalsIgnoreCase("VerlorenState")){
                this.controller.getSpel().showVerloren();
            }
        }
    }

    private void verhoogInzet(String text) {
        try {
            double verhoogdeInzet = Double.parseDouble(text);
            this.controller.getSpel().setVerhoogdeInzet(verhoogdeInzet);
            this.controller.getSpel().verhoogInzet();

        }catch (Exception e){
            //TODO
        }
        this.verhoogInzetField.setDisable(true);
        this.verhoogInzetField.setVisible(false);
        this.verhoogInzetLabel.setVisible(false);
    }

    public void update(){
        this.goksaldoLabel.setText("Je goksaldo is "+ this.controller.getSpel().getSpeler().getGoksaldo() + " €");
        if (this.controller.getSpel().getState().getClass().getSimpleName().equalsIgnoreCase("VerlorenState")){
            this.resultLabel.setText("Helaas, je hebt verloren.");
            this.resultLabel.setTextFill(Color.RED);
            this.nieuweGoksaldoLabel.setText("Je nieuwe goksaldo is: " + this.controller.getSpel().getSpeler().getGoksaldo());
            this.nieuweGoksaldoLabel.setTextFill(Color.RED);
            this.werpButton.setDisable(true);
            p322.setVisible(true);
        }
        if(this.controller.getSpel().getState().getClass().getSimpleName().equalsIgnoreCase("GewonnenState")){
            this.resultLabel.setText("Gefeliciteerd, je hebt gewonnen!");
            this.resultLabel.setTextFill(Color.GREEN);
            this.nieuweGoksaldoLabel.setText("Je nieuwe goksaldo is: " + this.controller.getSpel().getSpeler().getGoksaldo());
            this.nieuweGoksaldoLabel.setTextFill(Color.GREEN);
            this.werpButton.setDisable(true);
            p322.setVisible(true);
        }
        if (this.controller.getSpel().getState().getClass().getSimpleName().equalsIgnoreCase("VerhoogInzetState")){
            this.verhoogInzetLabel.setVisible(true);
            this.verhoogInzetField.setVisible(true);
        }
        if (!this.controller.getSpel().getState().getClass().getSimpleName().equalsIgnoreCase("VerhoogInzetState")){
            this.verhoogInzetLabel.setVisible(false);
            this.verhoogInzetField.setVisible(false);
        }
    }
    public void reset() {
        root.getChildren().clear();
        this.root = createNodeHierarchy();
        this.controller = controller;
        stage.setTitle("GAMBLER VIEW");
        stage.setX(20);
        stage.setY(20);

        this.scene = new Scene(root, 600, 600);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();

        controller.setView(this);

    }
}


