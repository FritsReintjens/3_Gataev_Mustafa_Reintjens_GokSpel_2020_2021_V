package application;
	
import controller.AdminViewController;
import controller.GamblerViewController;
import controller.SpelVerloopPaneController;
import javafx.application.Application;
import javafx.stage.Stage;
import jxl.read.biff.BiffException;
import model.Spel;
import view.AdminView;
import view.GamblerView;

import java.io.IOException;

public class GokSpelMain extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException, BiffException {
		Spel facadeSpel = new Spel();
		AdminViewController adminController = new AdminViewController(facadeSpel);
		AdminView adminView = new AdminView(adminController);
		GamblerViewController gamblerViewController = new GamblerViewController(facadeSpel);
		GamblerView gamblerView = new GamblerView(gamblerViewController);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
