package view.panels;

import controller.SpelVerloopPaneController;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class SpelVerloopPane extends GridPane {
    private SpelVerloopPaneController controller;

    private Label lblNaam, lblGoksaldo, lblInzet;
    private TextField tfdNaamInput, tfdInzetInput;
    private Button btnStart;


    public SpelVerloopPane(SpelVerloopPaneController controller) {

        this.controller = controller;
        this.controller.setView(this);


        this.add(lblNaam = new Label("Wat is je spelersnaam?"),0, 0);
        this.add(tfdNaamInput = new TextField(),1,0);


        tfdNaamInput.setOnAction(eventIngaveNaam -> {
            //Controlleer of naam in DB zit
            //Toon volgend scherm of toon foutmelding

            //this.add(lblGoksaldo = new Label("Je goksaldo is " + controller.getSaldo() + "euro"));
            this.add(lblInzet = new Label("Wat is je inzet?"),0,1);
            this.add(tfdInzetInput = new TextField(),1,1);

            tfdInzetInput.setOnAction(eventIngaveInzet ->{
                //Controlleer of inzet <= saldo
                this.add(btnStart = new Button("Start gokspel"), 2, 0);
                btnStart.setOnAction(eventStartSpel ->{
                    //start spel
                });
            });

        });

    }


}
