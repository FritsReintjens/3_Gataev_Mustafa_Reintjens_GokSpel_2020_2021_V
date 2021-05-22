package view.panels;

import controller.StatistiekPaneController;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import model.Speler;
import model.gokstrategy.GokStrategy;

public class StatistiekenPane extends GridPane {
    private  StatistiekPaneController statistiekPaneController;

    public StatistiekenPane(StatistiekPaneController statistiekPaneController) {
        this.statistiekPaneController = statistiekPaneController;

        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
        this.add(new Label("Statistiek: "), 0, 0, 1, 1);




    }
}
