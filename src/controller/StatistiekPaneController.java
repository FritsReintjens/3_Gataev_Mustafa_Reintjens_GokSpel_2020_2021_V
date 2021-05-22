package controller;

import model.Spel;
import model.observer.Observer;
import view.panels.StatistiekenPane;

public class StatistiekPaneController implements Observer {
    private Spel spelFacade;
    private StatistiekenPane statistiekenPane;

    public StatistiekPaneController(Spel spel) {
        this.spelFacade = spel;
        spel.registerObserver(this);
    }

    @Override
    public void update() {

    }

    public void setView(StatistiekenPane statistiekenPane) {
        this.statistiekenPane = statistiekenPane;
    }
}
