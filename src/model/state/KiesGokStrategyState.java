package model.state;

import model.Spel;

public class KiesGokStrategyState implements SpelState {
    Spel spel;

    public KiesGokStrategyState(Spel spel){
        this.spel = spel;
    }

    @Override
    public void startGokspel() {
        throw new IllegalStateException("Kan niet in huidige state");
    }

    @Override
    public void bevestigKeuze() {
        //code
        this.spel.setStrategy();
        spel.notifyObserver();
        spel.changeState(new SpeelState(spel));
    }

    @Override
    public void werpDobbelsteen() {
        throw new IllegalStateException("Kan niet in huidige state");
    }

    @Override
    public void verhoogInzet() {
        throw new IllegalStateException("Kan niet in huidige state");
    }
}
