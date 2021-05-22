package view.panels;

import controller.GamblerOverviewPaneController;
import controller.GamblerViewController;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import jxl.read.biff.BiffException;
import model.database.SpelerDB;
import model.Speler;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author team
 */
public class GamblerOverviewPane extends GridPane{
	private SpelerDB spelerDB;
	private TableView<Speler> table;
	private ObservableList<Speler> spelers;
	private GamblerOverviewPaneController gamblerOverviewPaneController;
	
	public GamblerOverviewPane(GamblerOverviewPaneController gamblerOverviewPaneController) {
		this.gamblerOverviewPaneController = gamblerOverviewPaneController;
		this.spelerDB = this.gamblerOverviewPaneController.getSpelFacade().getSpelerDB();

		this.setPadding(new Insets(5, 5, 5, 5));
		this.setVgap(5);
		this.setHgap(5);
		this.add(new Label("Spelers:"), 0, 0, 1, 1);

		table = new TableView<Speler>();
		TableColumn<Speler, String> kolFamilienaam = new TableColumn<Speler, String>("Familienaam");
		kolFamilienaam.setMinWidth(125);
		kolFamilienaam.setCellValueFactory(new PropertyValueFactory<Speler, String>("familienaam"));
		TableColumn<Speler, String> kolVoornaam = new TableColumn<Speler, String>("Voornaam");
		kolVoornaam.setMinWidth(125);
		kolVoornaam.setCellValueFactory(new PropertyValueFactory<Speler, String>("voornaam"));
		TableColumn<Speler, String> kolSpelersnaam = new TableColumn<Speler, String>("Spelersnaam");
		kolSpelersnaam.setMinWidth(125);
		kolSpelersnaam.setCellValueFactory(new PropertyValueFactory<Speler, String>("spelersnaam"));
		TableColumn<Speler, Double> kolGoksaldo = new TableColumn<Speler, Double>("Goksaldo");
		kolGoksaldo.setMinWidth(125);
		kolGoksaldo.setCellValueFactory(new PropertyValueFactory<Speler, Double>("Goksaldo"));

		table.getColumns().addAll(kolFamilienaam, kolVoornaam, kolSpelersnaam, kolGoksaldo);

		//Waarom kunnen we niet gewoon de refresh methode gebruiken, aangezien we daar al 'table.setItems(spelers)' doen?
		spelers = FXCollections.observableArrayList(spelerDB.getSpelers().values());
		table.setItems(spelers);
		table.refresh();

		this.add(table, 0, 1);
	}

	public void refresh(){
		spelers = FXCollections.observableArrayList(spelerDB.getSpelers().values());
		table.setItems(spelers);
		table.refresh();
	}

	public void displayErrorMessage(String errorMessage){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Information Alert");
		alert.setContentText(errorMessage);
		alert.show();
	}

}
