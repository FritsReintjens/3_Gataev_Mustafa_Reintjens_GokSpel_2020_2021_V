package controller;

import model.Spel;
import model.observer.Observable;
import model.observer.Observer;

public class AdminViewController implements Observer {
    private Spel spelFacade;

    public AdminViewController(Spel spel){
        this.spelFacade = spel;
    }

    @Override
    public void update() {

    }
}
