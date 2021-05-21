package view;

import controller.AdminViewController;
import controller.SpelVerloopPaneController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;	

public class AdminView {
	private Stage stage = new Stage();
	private AdminViewController adminViewController;
	private SpelVerloopPaneController spelVerloopPaneController;
		
	public AdminView(AdminViewController adminViewController, SpelVerloopPaneController spelVerloopPaneController){
		this.adminViewController = adminViewController;
		this.spelVerloopPaneController = spelVerloopPaneController;
		stage.setTitle("ADMIN VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(630);
		stage.setY(20);
		Group root = new Group();
		Scene scene = new Scene(root, 600, 600);
		BorderPane borderPane = new AdminMainPane(adminViewController,spelVerloopPaneController);
		borderPane.prefHeightProperty().bind(scene.heightProperty());
		borderPane.prefWidthProperty().bind(scene.widthProperty());
		root.getChildren().add(borderPane);
		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();		
	}
}
