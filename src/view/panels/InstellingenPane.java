package view.panels;

import controller.InstellingenPaneController;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.gokstrategy.GokStrategyFactory;

import java.awt.*;
import java.lang.invoke.LambdaConversionException;

/**
 * @Author Jurgen Mustafa
 */

public class InstellingenPane extends GridPane {

    private InstellingenPaneController instellingenPaneController;
    private VBox p0,p11,p12,p21,p22,p31;
    private HBox p1, p2,p3;
    private Label formaatLabel,selectGokStrategyLabel;
    private Button saveButton;
    private CheckBox gokStrategy1, gokStrategy2, gokStrategy3, gokStrategy4;
    private RadioButton textButton, excelButton;

    public InstellingenPane(InstellingenPaneController instellingenPaneController) {
        this.instellingenPaneController = instellingenPaneController;

        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
        this.add(new Label("instellingen: "), 0, 0, 1, 1);

        this.p11 = new VBox(10);
        this.formaatLabel = new Label("Formaat: ");
        p11.getChildren().addAll(formaatLabel);

        this.p12 = new VBox(10);
        final ToggleGroup tGroup = new ToggleGroup();
        this.textButton = new RadioButton("text");
        textButton.setToggleGroup(tGroup);
        textButton.setSelected(true);
        this.excelButton = new RadioButton("excel");
        excelButton.setToggleGroup(tGroup);
        p12.getChildren().addAll(textButton, excelButton);

        this.p21 = new VBox(10);
        this.selectGokStrategyLabel = new Label("selecteer gokstrategien");
        p21.getChildren().addAll(selectGokStrategyLabel);

        this.p22 = new VBox(10);
        this.gokStrategy1 = new CheckBox("1");
        this.gokStrategy2 = new CheckBox("2");
        this.gokStrategy3 = new CheckBox("3");
        this.gokStrategy4 = new CheckBox("4");
        p22.getChildren().addAll(gokStrategy1, gokStrategy2, gokStrategy3, gokStrategy4);

        this.p31 = new VBox(10);
        this.saveButton = new Button("Save");
        saveButton.setOnAction(event -> setSettings(((RadioButton)(tGroup.getSelectedToggle())).getText(), gokStrategy1.isSelected(), gokStrategy2.isSelected(), gokStrategy3.isSelected(), gokStrategy4.isSelected()));
        p31.getChildren().addAll(saveButton);

        this.p1 = new HBox(10);
        p1.getChildren().addAll(p11,p12);

        this.p2 = new HBox(10);
        p2.getChildren().addAll(p21,p22);

        this.p3 = new HBox(10);
        p3.getChildren().addAll(p31);

        this.p0 = new VBox(10);
        p0.getChildren().addAll(p1,p2,p3);
        this.add(p0,0,1);
    }

    private void setSettings(String format, boolean strat1, boolean strat2, boolean strat3, boolean strat4) {

        System.out.println(strategies);
    }
}
