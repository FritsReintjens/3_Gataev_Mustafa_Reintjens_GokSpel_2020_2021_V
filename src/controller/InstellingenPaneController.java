package controller;

import model.Spel;
import model.observer.Observer;

public class InstellingenPaneController implements Observer {
    private Spel spelFacade;

    public InstellingenPaneController(Spel spel) {
        this.spelFacade = spel;
        spel.registerObserver(this);
    }

    @Override
    public void update() {

    }
}
