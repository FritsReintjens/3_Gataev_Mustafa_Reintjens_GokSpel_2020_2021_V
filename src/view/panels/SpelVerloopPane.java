package view.panels;

import controller.GamblerOverviewPaneController;
import controller.SpelVerloopPaneController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import model.Spel;

import java.io.IOException;


/**
 * @Author Jurgen Mustafa, Adam Gataev
 */
public class SpelVerloopPane extends GridPane {
    private SpelVerloopPaneController spelVerloopPaneController;

    private VBox p1, p15;
    private HBox p11,p12,p13,p14;
    private Label spelVolgNummer,spelerNaam, inzet, gokStrategy, spelVolgNummerResult, spelerNaamResult, inzetResult, gokStrategyResult;
    private Button startNieuwButton, stopSessieButton;

    public SpelVerloopPane(SpelVerloopPaneController spelVerloopPaneController) {
        this.spelVerloopPaneController = spelVerloopPaneController;

        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
        this.add(new Label("SpelVerloop: "), 0, 0, 1, 1);

            this.spelVolgNummer = new Label("spelvolgnummer: ");
            this.spelVolgNummerResult = new Label("");
            this.p11 = new HBox(10);
            p11.getChildren().addAll(spelVolgNummer, spelVolgNummerResult);

            this.spelerNaam = new Label("spelernaam: ");
            this.spelerNaamResult = new Label("");
            this.p12 = new HBox(10);
            p12.getChildren().addAll(spelerNaam, spelerNaamResult);

            this.inzet = new Label("inzet: ");
            this.inzetResult = new Label("");
            this.p13 = new HBox(10);
            p13.getChildren().addAll(inzet, inzetResult);

            this.gokStrategy = new Label("gokstrategy");
            this.gokStrategyResult = new Label("");
            this.p14 = new HBox(10);
            p14.getChildren().addAll(gokStrategy, gokStrategyResult);


            this.p15 = new VBox(10);

            //KNOP start nieuw spel / Enkel zichtbaar in gewonnen of verloren state
            this.startNieuwButton = new Button("Start nieuw spel");

            startNieuwButton.setOnAction(event -> {
                try {
                startNieuwSpel();
                } catch (IOException e) {
                e.printStackTrace();
                } catch (BiffException e) {
                e.printStackTrace();
                }
             });
            startNieuwButton.setVisible(false);

            //KNOP beeindig sessie / Enkel zichtbaar in gewonnen of verloren state
            this.stopSessieButton = new Button("Stop sessie");

            stopSessieButton.setOnAction(event -> {
                try {
                    stopSessie();
                } catch (BiffException e) {
                    e.printStackTrace();
                } catch (WriteException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            stopSessieButton.setVisible(false);


        p15.getChildren().addAll(startNieuwButton, stopSessieButton);

            this.p1 = new VBox(10);
            this.p1.getChildren().addAll(p11, p12, p13, p14, p15);

            this.add(p1, 0, 1);


    }
    public void vulWaardenIn(){
        this.spelVolgNummerResult.setText(Integer.toString((this.spelVerloopPaneController.getSpelFacade().getSpelVolgNummer())));
        System.out.println(this.spelVerloopPaneController.getSpelFacade().getState());
        System.out.println(this.spelVerloopPaneController.getSpelFacade().getSpeler().getSpelersnaam());
        this.spelerNaamResult.setText(this.spelVerloopPaneController.getSpelFacade().getSpeler().getSpelersnaam());
        this.inzetResult.setText(String.valueOf(this.spelVerloopPaneController.getSpelFacade().getInzet()));
        if (this.spelVerloopPaneController.getSpelFacade().getState().getClass().getSimpleName().equals("KiesGokStrategyState")) {
            this.gokStrategyResult.setText(this.spelVerloopPaneController.getSpelFacade().getGokStrategy().getClass().getSimpleName());
        }
        if (this.spelVerloopPaneController.getSpelFacade().getState().getClass().getSimpleName().equals("VerhoogInzetState")){
            this.inzetResult.setText(String.valueOf(this.spelVerloopPaneController.getSpelFacade().getInzet()+this.spelVerloopPaneController.getSpelFacade().getVerhoogdeInzet()));
        }
        if (this.spelVerloopPaneController.getSpelFacade().getState().getClass().getSimpleName().equals("GewonnenState") || this.spelVerloopPaneController.getSpelFacade().getState().getClass().getSimpleName().equals("VerlorenState")){
            this.startNieuwButton.setDisable(false);
            this.startNieuwButton.setVisible(true);
            this.stopSessieButton.setDisable(false);
            this.stopSessieButton.setVisible(true);
        }

    }

    public void startNieuwSpel() throws IOException, BiffException {
        //Nieuw spel object met verhoogd volgnummer, alle parameters terug naar initial waarde, GamblerView resetten
        this.spelVerloopPaneController.startNieuwSpel();
        this.startNieuwButton.setDisable(true);
        this.startNieuwButton.setVisible(false);
        this.stopSessieButton.setDisable(true);
        this.stopSessieButton.setVisible(false);
    }
    public void stopSessie() throws BiffException, WriteException, IOException {
        //Save spelergegevens naar bestand
        this.spelVerloopPaneController.getSpelFacade().getSpelerDB().save();
        System.exit(0);
    }


}
