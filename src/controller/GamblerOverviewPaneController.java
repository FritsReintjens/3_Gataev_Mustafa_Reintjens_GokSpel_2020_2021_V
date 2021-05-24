package controller;

import model.Spel;
import model.observer.Observer;
import view.panels.GamblerOverviewPane;

/**
 * @Author team
 */

public class GamblerOverviewPaneController implements Observer {
    private Spel spelFacade;
    private GamblerOverviewPane gamblerOverviewPane;

    public GamblerOverviewPaneController(Spel spel) {
        this.spelFacade = spel;
        this.gamblerOverviewPane = gamblerOverviewPane;
        spel.registerObserver(this);

    }

    public Spel getSpelFacade() {
        return spelFacade;
    }

    @Override
    public void update() {
        this.gamblerOverviewPane.refresh();

    }

    public void setView(GamblerOverviewPane gamblerOverviewPane) {
        this.gamblerOverviewPane = gamblerOverviewPane;
    }
}
