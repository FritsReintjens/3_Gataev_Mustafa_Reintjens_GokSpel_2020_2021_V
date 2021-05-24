package view.panels;

import controller.StatistiekPaneController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import model.StrategyData;
import model.database.GokStrategyDB;

/**
 * @Author team
 */

public class StatistiekenPane extends GridPane {
    private StatistiekPaneController statistiekPaneController;
    private TableView<StrategyData> table;
    private GokStrategyDB gokStrategyDB;
    private ObservableList<StrategyData> strategyData;

    public StatistiekenPane(StatistiekPaneController statistiekPaneController) {
        this.statistiekPaneController = statistiekPaneController;
        this.gokStrategyDB = this.statistiekPaneController.getSpelFacade().getGokStrategyDB();

        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
        this.add(new Label("Statistiek:"), 0, 0, 1, 1);

        table = new TableView<StrategyData>();
        TableColumn<StrategyData, String> kolNaam = new TableColumn<StrategyData, String>("Naam");
        kolNaam.setMinWidth(100);
        kolNaam.setCellValueFactory(new PropertyValueFactory<StrategyData, String>("Naam"));

        TableColumn<StrategyData, Integer> kolGekozen = new TableColumn<StrategyData, Integer>("Gekozen");
        kolGekozen.setMinWidth(100);
        kolGekozen.setCellValueFactory(new PropertyValueFactory<StrategyData, Integer>("AantalKeerGekozen"));

        TableColumn<StrategyData, Integer> kolSucces = new TableColumn<StrategyData, Integer>("Succes");
        kolSucces.setMinWidth(100);
        kolSucces.setCellValueFactory(new PropertyValueFactory<StrategyData, Integer>("AantalKeerSucces"));

        TableColumn<StrategyData, Double> kolInzet = new TableColumn<StrategyData, Double>("TotalInzet");
        kolInzet.setMinWidth(100);
        kolInzet.setCellValueFactory(new PropertyValueFactory<StrategyData, Double>("TotalInzet"));

        TableColumn<StrategyData, Double> kolWinst = new TableColumn<StrategyData, Double>("TotaleWinst");
        kolWinst.setMinWidth(100);
        kolWinst.setCellValueFactory(new PropertyValueFactory<StrategyData, Double>("TotaleWinst"));

        table.getColumns().addAll(kolNaam, kolGekozen, kolSucces, kolInzet, kolWinst);

        this.strategyData = FXCollections.observableArrayList(gokStrategyDB.getStrategyData().values());
        table.setItems(strategyData);
        table.refresh();

        this.add(table, 0, 1);

    }

    public void update() {
        this.strategyData = FXCollections.observableArrayList(gokStrategyDB.getStrategyData().values());
        table.setItems(strategyData);
        table.refresh();
    }
}
