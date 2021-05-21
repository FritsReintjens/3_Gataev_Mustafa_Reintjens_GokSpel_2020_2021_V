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
import java.util.Map;

/**
 * @Author Adam Gataev, Jurgen Mustafa
 */
public class GamblerView extends GridPane {
    private String gegevenSpelersNaam;
    private double gevondenSpelerGoksaldo;

    private Stage stage = new Stage();
    private GamblerViewController controller;

    private Label spelerLabel, goksaldoLabel, inzetLabel, errorKader1, kiesStrategyLabel, strategy1Label, strategy2Label, strategy3Label,w1Label,w2Label,w3Label,w4Label, resultLabel, nieuweGoksaldoLabel;
    private TextField spelerField, inzetField;
    private Button startButton,bevestigButton, werpButton;
    private RadioButton rgs1,rgs2,rgs3;

    public GamblerView(GamblerViewController controller) {

        Pane root = createNodeHierarchy();

        this.controller = controller;
        stage.setTitle("GAMBLER VIEW");
        stage.initStyle(StageStyle.UTILITY);
        stage.setX(20);
        stage.setY(20);

		Scene scene = new Scene(root, 600, 600);
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();

		controller.setView(this);

    }

    private Pane createNodeHierarchy() {

        HBox p111 = new HBox(10);
        this.spelerLabel = new Label("wat is je spelersnaam? ");
        this.spelerField = new TextField();
        spelerField.setOnAction(event -> checkNaamInput(spelerField.getText()));
        this.goksaldoLabel = new Label();
        p111.getChildren().addAll(spelerLabel,spelerField,goksaldoLabel);


        HBox p112 = new HBox(10);
        this.inzetLabel = new Label("wat is je inzet? ");
        inzetLabel.setVisible(false);
        this.inzetField = new TextField();
        inzetField.setVisible(false);
        inzetField.setOnAction(event -> checkInzetInput(inzetField.getText()));
        p112.getChildren().addAll(inzetLabel,inzetField);

        HBox p113 = new HBox(10);
        this.startButton = new Button("Start gokspel");
        this.startButton.setVisible(false);
        //startButton.setOnAction(event -> checkInput(spelerField.getText(), inzetField.getText()));
        p113.getChildren().addAll(startButton);


        VBox p221 = new VBox(10);
        final ToggleGroup tGroup = new ToggleGroup();
        this.rgs1 = new RadioButton("Het aantal ogen bij elke worp is een" + "even" +" getal");
        rgs1.setToggleGroup(tGroup);
        rgs1.setSelected(true);
        this.rgs2 = new RadioButton("de som van de ogen van alle worpen samen is" + 21);
        rgs2.setToggleGroup(tGroup);
        this.rgs3 = new RadioButton("het aantal ogen is bij elke worp" + "hoger" + "dan bij de vorige worp");
        rgs3.setToggleGroup(tGroup);
        p221.getChildren().addAll(rgs1, rgs2, rgs3);
        VBox p222 = new VBox(10);
        this.strategy1Label = new Label("mogelijke winst is " + 4 + "x je inzet");
        this.strategy2Label = new Label("mogelijke winst is " + 5 + "x je inzet");
        this.strategy3Label = new Label("mogelijke winst is " + 10 + "x je inzet");
        p222.getChildren().addAll(strategy1Label, strategy2Label, strategy3Label);

        VBox p321 = new VBox();
        this.w1Label = new Label("werp1");
        this.w2Label = new Label("werp2");
        this.w3Label = new Label("werp3");
        this.w4Label = new Label("werp4");
        p321.getChildren().addAll(w1Label,w2Label,w3Label,w4Label);

        VBox p322 = new VBox();
        this.resultLabel = new Label("enter resultaat hier");
        this.nieuweGoksaldoLabel = new Label("enter nieuwe goksaldo hier");
        p322.getChildren().addAll(resultLabel, nieuweGoksaldoLabel);



        VBox p11 = new VBox(10);
        p11.getChildren().addAll(p111,p112,p113);
        VBox p12 = new VBox(10);
        this.errorKader1 = new Label("");
        p12.getChildren().addAll(errorKader1);


        //DEEL 2
        HBox p21 = new HBox(10);
        this.kiesStrategyLabel = new Label("Kies je gok strategie uit de volgende lijst");
        p21.getChildren().addAll(kiesStrategyLabel);
        HBox p22 = new HBox(10);
        p22.getChildren().addAll(p221,p222);

        HBox p23 = new HBox(10);
        this.bevestigButton = new Button("bevestig je keuze");
        p23.getChildren().addAll(bevestigButton);

        HBox p31 = new HBox(10);
        this.werpButton = new Button("werp dobbelsteen");
        p31.getChildren().addAll(werpButton);
        HBox p32 = new HBox(10);
        p32.getChildren().addAll(p321,p322);



        HBox p1 = new HBox(10);
        p1.getChildren().addAll(p11,p12);
        VBox p2 = new VBox(10);
        p2.getChildren().addAll(p21,p22,p23);
        VBox p3 = new VBox(10);
        p3.getChildren().addAll(p31,p32);
        VBox p0 = new VBox(10);
        p0.getChildren().addAll(p1,p2,p3);

        return p0;
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
            this.errorKader1.setText("Naam niet gevonden, probeer opnieuw");
            this.errorKader1.setTextFill(Color.RED);
        }

    }

    public void checkInzetInput(String inzet){
        try {
            double dInzet = Double.parseDouble(inzet);
            if (!inzet.trim().isEmpty() && dInzet > 0 && this.gevondenSpelerGoksaldo >= dInzet) {
                this.startButton.setDisable(false);
                this.errorKader1.setVisible(false);
            } else {
                this.startButton.setDisable(true);
                this.errorKader1.setVisible(true);
                this.errorKader1.setText("Ongeldige inzet");
                this.errorKader1.setTextFill(Color.RED);
            }
        }catch(Exception e){
            this.errorKader1.setVisible(true);
            this.errorKader1.setText("Hier mogen enkel cijfers ingevuld worden");
            this.errorKader1.setTextFill(Color.RED);
        }
    }
}
