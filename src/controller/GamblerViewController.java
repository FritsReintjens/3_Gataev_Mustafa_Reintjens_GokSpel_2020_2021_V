package controller;

import model.Spel;
import model.observer.Observer;
import view.GamblerView;

public class GamblerViewController implements Observer {
    private GamblerView gamblerView;
    private Spel spel;

    public GamblerViewController (Spel spel){
        this.spel = spel;
        this.gamblerView = gamblerView;
        spel.registerObserver(this);
    }

    public void setView(GamblerView view){
        this.gamblerView = view;
    }

    @Override
    public void update(){

    }
}
