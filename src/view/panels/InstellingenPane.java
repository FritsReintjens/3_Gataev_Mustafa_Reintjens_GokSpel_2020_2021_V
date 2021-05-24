package view.panels;

import controller.InstellingenPaneController;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import jxl.read.biff.BiffException;
import model.gokstrategy.GokStrategyFactory;

import java.io.IOException;
import java.lang.invoke.LambdaConversionException;

/**
 * @Author team
 */

public class InstellingenPane extends GridPane {

    private InstellingenPaneController instellingenPaneController;
    private VBox p0,p11,p12,p21,p22,p31;
    private HBox p1, p2,p3, p221, p222,p223,p224, p225;
    private TextField winstFactor1,winstFactor2, winstFactor3, winstFactor4;
    private Label formaatLabel,selectGokStrategyLabel, gokStrategyTitel, winstFactorTitel, errorLbl1,errorLbl2,errorLbl3,errorLbl4;
    private Button saveButton;
    private CheckBox gokStrategy1, gokStrategy2, gokStrategy3, gokStrategy4;
    private RadioButton textButton, excelButton;
    private boolean canSave;

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
        this.textButton = new RadioButton("TEKST");
        textButton.setToggleGroup(tGroup);
        textButton.setSelected(true);
        this.excelButton = new RadioButton("EXCEL");
        excelButton.setToggleGroup(tGroup);
        p12.getChildren().addAll(textButton, excelButton);

        this.errorLbl1 = new Label("Winstfactor moet >= 1 zijn");
        this.errorLbl2 = new Label("Winstfactor moet >= 1 zijn");
        this.errorLbl3 = new Label("Winstfactor moet >= 1 zijn");
        this.errorLbl4 = new Label("Winstfactor moet >= 1 zijn");
        errorLbl1.setTextFill(Color.RED);
        errorLbl2.setTextFill(Color.RED);
        errorLbl3.setTextFill(Color.RED);
        errorLbl4.setTextFill(Color.RED);
        errorLbl1.setVisible(false);
        errorLbl2.setVisible(false);
        errorLbl3.setVisible(false);
        errorLbl4.setVisible(false);

        this.p21 = new VBox(10);
        this.selectGokStrategyLabel = new Label("selecteer gokstrategien");
        p21.getChildren().addAll(selectGokStrategyLabel);

        this.p22 = new VBox(10);

        this.p221 = new HBox(10);
        this.p222 = new HBox(10);
        this.p223 = new HBox(10);
        this.p224 = new HBox(10);
        this.p225 = new HBox(10);

        this.gokStrategyTitel = new Label("Gokstrategy:");
        this.winstFactorTitel = new Label("Winstafactor:");

        this.gokStrategy1 = new CheckBox("EvenOgenStrategy");
        this.gokStrategy2 = new CheckBox("SomOgenStrategy");
        this.gokStrategy3 = new CheckBox("WorpenOplopendStrategy");
        this.gokStrategy4 = new CheckBox("WinStrategy");

        this.winstFactor1 = new TextField();
        this.winstFactor2 = new TextField();
        this.winstFactor3 = new TextField();
        this.winstFactor4 = new TextField();

        this.p221.getChildren().addAll(gokStrategyTitel, winstFactorTitel);
        this.p222.getChildren().addAll(gokStrategy1, winstFactor1,errorLbl1);
        this.p223.getChildren().addAll(gokStrategy2, winstFactor2,errorLbl2);
        this.p224.getChildren().addAll(gokStrategy3, winstFactor3,errorLbl3);
        this.p225.getChildren().addAll(gokStrategy4, winstFactor4,errorLbl4);

        this.p22.getChildren().addAll(p221,p222,p223,p224,p225);

        this.p31 = new VBox(10);
        this.saveButton = new Button("Save");
        saveButton.setOnAction(event -> {
            try {
                setSettings(((RadioButton)(tGroup.getSelectedToggle())).getText(), gokStrategy1.isSelected(), gokStrategy2.isSelected(), gokStrategy3.isSelected(), gokStrategy4.isSelected());
            } catch (BiffException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
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

    private void setSettings(String format, boolean strat1, boolean strat2, boolean strat3, boolean strat4) throws BiffException, IOException {
        String strategies = "";
        canSave = true;

        if (gokStrategy1.isSelected()) {
            if (!winstFactor1.getText().equals("")) {
                int wf1 = Integer.parseInt(winstFactor1.getText());
                if (wf1 < 1) errorLbl1.setVisible(true);
                canSave = false;
            }
        }
        if (gokStrategy2.isSelected()) {
            if (!winstFactor2.getText().equals("")) {
                int wf2 = Integer.parseInt(winstFactor2.getText());
                if (wf2 < 1) errorLbl1.setVisible(true);
                canSave = false;
            }
        }
        if (gokStrategy3.isSelected()) {
            if (!winstFactor3.getText().equals("")) {
                int wf3 = Integer.parseInt(winstFactor3.getText());
                if (wf3 < 1) errorLbl3.setVisible(true);
                canSave = false;
            }
        }
        if (gokStrategy4.isSelected()) {
            if (!winstFactor4.getText().equals("")) {
                int wf4 = Integer.parseInt(winstFactor4.getText());
                if (wf4 < 1) errorLbl1.setVisible(true);
                canSave = false;
            }
        }
        if (canSave){
            strategies += (gokStrategy1.isSelected()) ? gokStrategy1.getText() + ":" + winstFactor1.getText() + "," : "";
            strategies += (gokStrategy2.isSelected()) ? gokStrategy2.getText() + ":" + winstFactor2.getText() + "," : "";
            strategies += (gokStrategy3.isSelected()) ? gokStrategy3.getText() + ":" + winstFactor3.getText() + "," : "";
            strategies += (gokStrategy4.isSelected()) ? gokStrategy4.getText() + ":" + winstFactor4.getText() + "," : "";

            if (strategies.length() > 0) strategies = strategies.substring(0, strategies.length() - 1);

            this.instellingenPaneController.setSettingToProperty(format, strategies);
            this.instellingenPaneController.spelerDBFormat(format);
        }
    }
}
