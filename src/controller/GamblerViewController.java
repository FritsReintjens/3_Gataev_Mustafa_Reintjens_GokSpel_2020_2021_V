package controller;

import model.Spel;
import model.observer.Observer;
import view.GamblerView;

/**
 * @Author team
 */

public class GamblerViewController implements Observer {
    private GamblerView gamblerView;
    private Spel spel;

    public GamblerViewController (Spel spel){
        this.spel = spel;
        spel.registerObserver(this);
    }

    public Spel getSpel() {
        return spel;
    }

    public void setView(GamblerView view){
        this.gamblerView = view;
    }

    @Override
    public void update(){
        this.gamblerView.update();
        if (this.spel.getState().getClass().getSimpleName().equalsIgnoreCase("GameResetState")){
            this.gamblerView.reset();
        }
    }
}
