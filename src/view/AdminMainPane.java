package view;


import controller.GamblerOverviewPaneController;
import controller.InstellingenPaneController;
import controller.SpelVerloopPaneController;
import controller.StatistiekPaneController;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import view.panels.GamblerOverviewPane;
import view.panels.InstellingenPane;
import view.panels.SpelVerloopPane;
import view.panels.StatistiekenPane;

/**
 * @Author team
 */

public class AdminMainPane extends BorderPane {

        public AdminMainPane(SpelVerloopPaneController spelVerloopPaneController, GamblerOverviewPaneController gamblerOverviewPaneController, StatistiekPaneController statistiekPaneController, InstellingenPaneController instellingenPaneController){
                TabPane tabPane = new TabPane();

                SpelVerloopPane spelVerloopPane = new SpelVerloopPane(spelVerloopPaneController);
                spelVerloopPaneController.setView(spelVerloopPane);
                GamblerOverviewPane gamblerOverviewPane = new GamblerOverviewPane(gamblerOverviewPaneController);
                gamblerOverviewPaneController.setView(gamblerOverviewPane);
                StatistiekenPane statistiekenPane = new StatistiekenPane(statistiekPaneController);
                statistiekPaneController.setView(statistiekenPane);
                InstellingenPane instellingenPane = new InstellingenPane(instellingenPaneController);
                instellingenPaneController.setView(instellingenPane);

                Tab spelVerloopTab = new Tab("Spelverloop", spelVerloopPane);
                Tab spelerTab = new Tab("Spelers",gamblerOverviewPane);
                Tab statistiekTab = new Tab("Statistieken", statistiekenPane);
                Tab instellingTab = new Tab("Instellingen", instellingenPane);

                tabPane.getTabs().add(spelVerloopTab);
                tabPane.getTabs().add(spelerTab);
                tabPane.getTabs().add(statistiekTab);
                tabPane.getTabs().add(instellingTab);


                this.setCenter(tabPane);
        }
}
