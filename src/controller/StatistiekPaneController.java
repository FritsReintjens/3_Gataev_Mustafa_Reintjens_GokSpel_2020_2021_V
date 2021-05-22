package controller;

import model.Spel;
import model.observer.Observer;

public class StatistiekPaneController implements Observer {
    private Spel spelFacade;

    public StatistiekPaneController(Spel spel) {
        this.spelFacade = spel;
        spel.registerObserver(this);
    }

    @Override
    public void update() {

    }
}
