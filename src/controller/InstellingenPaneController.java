package controller;

import model.Spel;
import model.observer.Observer;
import view.panels.InstellingenPane;

public class InstellingenPaneController implements Observer {
    private Spel spelFacade;
    private InstellingenPane instellingenPane;

    public InstellingenPaneController(Spel spel) {
        this.spelFacade = spel;
        spel.registerObserver(this);
    }

    public void setView(InstellingenPane instellingenPane) {
        this.instellingenPane = instellingenPane;
    }

    @Override
    public void update() {

    }
}
