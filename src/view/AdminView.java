package view;

import controller.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import view.panels.GamblerOverviewPane;

/**
 * @Author team
 */


public class AdminView {
	private Stage stage = new Stage();
		
	public AdminView(AdminViewController adminViewController, SpelVerloopPaneController spelVerloopPaneController, GamblerOverviewPaneController gamblerOverviewPaneController, StatistiekPaneController statistiekPaneController, InstellingenPaneController instellingenPaneController){
		stage.setTitle("ADMIN VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(630);
		stage.setY(20);
		Group root = new Group();
		Scene scene = new Scene(root, 600, 600);
		BorderPane borderPane = new AdminMainPane(spelVerloopPaneController, gamblerOverviewPaneController, statistiekPaneController, instellingenPaneController);
		borderPane.prefHeightProperty().bind(scene.heightProperty());
		borderPane.prefWidthProperty().bind(scene.widthProperty());
		root.getChildren().add(borderPane);
		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();		
	}
}
