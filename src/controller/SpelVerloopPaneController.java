package controller;

import model.Spel;
import model.observer.Observer;
import view.panels.SpelVerloopPane;

public class SpelVerloopPaneController implements Observer {
    private SpelVerloopPane spelVerloopPane;
    private Spel spelFacade;

    public SpelVerloopPaneController(Spel spel){
        this.spelFacade = spel;
        spel.registerObserver(this);
    }

    public void setView(SpelVerloopPane spelVerloopPane) {
        this.spelVerloopPane = spelVerloopPane;
    }

    public Spel getSpelFacade() {
        return spelFacade;
    }

    @Override
    public void update(){
        spelVerloopPane.vulWaardenIn();
    }
}
