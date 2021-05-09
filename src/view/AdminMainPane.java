package view;


import controller.SpelVerloopPaneController;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import view.panels.GamblerOverviewPane;
import view.panels.SpelVerloopPane;

public class AdminMainPane extends BorderPane {
	public AdminMainPane(/*SpelVerloopPaneController spelVerloopPaneController*/){
	    TabPane tabPane = new TabPane();
        /*SpelVerloopPane spelVerloopPane = new SpelVerloopPane(spelVerloopPaneController);*/
        Tab spelVerloopTab = new Tab("Spelverloop");
        GamblerOverviewPane gamblerOverviewPane = new GamblerOverviewPane();
        Tab spelerTab = new Tab("Spelers",gamblerOverviewPane);
        Tab instellingTab = new Tab("Instellingen");
        Tab statistiekTab = new Tab("Staitieken");
        tabPane.getTabs().add(spelVerloopTab);
        tabPane.getTabs().add(spelerTab);
        tabPane.getTabs().add(statistiekTab);
        tabPane.getTabs().add(instellingTab);
        this.setCenter(tabPane);
	}
}
