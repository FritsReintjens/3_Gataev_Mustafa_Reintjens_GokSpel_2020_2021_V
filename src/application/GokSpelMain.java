package application;
	
import controller.*;
import javafx.application.Application;
import javafx.stage.Stage;
import jxl.read.biff.BiffException;
import model.Spel;
import view.AdminView;
import view.GamblerView;
import view.panels.GamblerOverviewPane;

import java.io.IOException;

public class GokSpelMain extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException, BiffException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Spel facadeSpel = new Spel(0);
		AdminViewController adminController = new AdminViewController(facadeSpel);
		GamblerViewController gamblerViewController = new GamblerViewController(facadeSpel);
		SpelVerloopPaneController spelVerloopPaneController = new SpelVerloopPaneController(facadeSpel);
		GamblerOverviewPaneController gamblerOverviewPaneController = new GamblerOverviewPaneController(facadeSpel);
		InstellingenPaneController instellingenPaneController = new InstellingenPaneController(facadeSpel);
		StatistiekPaneController statistiekPaneController = new StatistiekPaneController(facadeSpel);
		AdminView adminView = new AdminView(adminController, spelVerloopPaneController, gamblerOverviewPaneController, statistiekPaneController, instellingenPaneController);

		GamblerView gamblerView = new GamblerView(gamblerViewController);

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
