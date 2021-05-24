package controller;

import model.Spel;
import model.observer.Observable;
import model.observer.Observer;

/**
 * @Author team
 */

public class AdminViewController implements Observer {
    private Spel spelFacade;

    public AdminViewController(Spel spel){
        this.spelFacade = spel;
        spel.registerObserver(this);
    }

    @Override
    public void update() {

    }
}
