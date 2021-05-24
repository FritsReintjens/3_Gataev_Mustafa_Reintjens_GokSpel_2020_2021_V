package controller;

import model.Spel;
import model.observer.Observer;
import view.panels.StatistiekenPane;

/**
 * @Author team
 */
public class StatistiekPaneController implements Observer {
    private Spel spelFacade;
    private StatistiekenPane statistiekenPane;

    public StatistiekPaneController(Spel spel) {
        this.spelFacade = spel;
        spel.registerObserver(this);
    }

    public void setView(StatistiekenPane statistiekenPane) {
        this.statistiekenPane = statistiekenPane;
    }

    public Spel getSpelFacade(){
        return this.spelFacade;
    }

    @Override
    public void update() {
        this.statistiekenPane.update();
    }


}
