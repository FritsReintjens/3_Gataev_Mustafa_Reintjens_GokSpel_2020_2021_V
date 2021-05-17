package controller;

import model.Spel;
import model.observer.Observer;
import view.panels.SpelVerloopPane;

public class SpelVerloopPaneController implements Observer {
    private SpelVerloopPane spelVerloopPane;
    private Spel spel;

    public SpelVerloopPaneController(Spel spel){
        this.spel = spel;
        this.spelVerloopPane = spelVerloopPane;
        spel.registerObserver(this);
    }

    public void setView(SpelVerloopPane view) {
        this.spelVerloopPane = view;
    }

    @Override
    public void update(){

    }
}
