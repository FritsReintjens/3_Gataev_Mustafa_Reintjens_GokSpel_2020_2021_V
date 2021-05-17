package view;

import controller.GamblerViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jxl.read.biff.BiffException;
import model.Speler;
import model.database.SpelerDB;

import java.io.FileNotFoundException;
import java.io.IOException;

public class GamblerView extends GridPane {
    private Stage stage = new Stage();
    private GamblerViewController controller;

	private GridPane root = new GridPane();
    private Label lblNaam, lblGoksaldo, lblInzet;
    private TextField tfdNaamInput, tfdInzetInput;
    private Button btnStart;
    private TableView<Speler> table;

    public GamblerView(GamblerViewController controller) {
        this.controller = controller;
        stage.setTitle("GAMBLER VIEW");
        stage.initStyle(StageStyle.UTILITY);
        stage.setX(20);
        stage.setY(20);

		root.setPadding(new Insets(25, 25, 25, 25));
		root.setHgap(10);
		root.setVgap(10);
		Label spelerLabel = new Label("wat is je spelersnaam? ");
		Label inzetLabel = new Label("wat is je inzet? ");


		/*tfdNaamInput.setOnAction(eventIngaveNaam -> {
			//Controlleer of naam in DB zit
			//Toon volgend scherm of toon foutmelding

			//this.add(lblGoksaldo = new Label("Je goksaldo is " + controller.getSaldo() + "euro"));
			this.add(lblInzet = new Label("Wat is je inzet?"), 0, 1);
			this.add(tfdInzetInput = new TextField(), 1, 1);

			tfdInzetInput.setOnAction(eventIngaveInzet -> {
				//Controlleer of inzet <= saldo
				this.add(btnStart = new Button("Start gokspel"), 2, 0);
				btnStart.setOnAction(eventStartSpel -> {
					//start spel
				});
			});

		});*/

		Scene scene = new Scene(root, 600, 600);
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();

		controller.setView(this);

		this.add(lblNaam = new Label("Wat is je spelersnaam?"), 0, 0);
		this.add(tfdNaamInput = new TextField(), 1, 0);




    }
}
