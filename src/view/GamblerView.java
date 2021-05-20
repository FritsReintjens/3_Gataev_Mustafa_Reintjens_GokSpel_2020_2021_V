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

    private Label spelerLabel, goksaldoLabel, inzetLabel, errorKader1;
    private TextField spelerField, inzetField;
    private Button startButton;

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

        VBox p221 = new VBox(10);
        //which checkbox?
        VBox p222 = new VBox(10);


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

        VBox p11 = new VBox(10);
        p11.getChildren().addAll(p111,p112,p113);
        VBox p12 = new VBox(10);
        this.errorKader1 = new Label("");
        p12.getChildren().addAll(errorKader1);

        //DEEL 2
        HBox p21 = new HBox(10);
        Label kiesStrategyLabel = new Label("Kies je gok strategie uit de volgende lijst");
        HBox p22 = new HBox(10);
        p22.getChildren().addAll(p221,p222);

        HBox p23 = new HBox(10);

        HBox p1 = new HBox(10);
        p1.getChildren().addAll(p11,p12);
        VBox p2 = new VBox(10);
        p2.getChildren().addAll(p21,p22,p23);
        VBox p3 = new VBox(10);
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
