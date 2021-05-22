package model.state;

import model.Spel;
import model.Speler;

public class WachtVoorInputState implements SpelState{
    Spel spel;

    public WachtVoorInputState(Spel spel){
        this.spel = spel;
    }

    @Override
    public void startGokspel() {
        this.spel.setSpelVolgNummer();
        spel.notifyObserver();
        spel.changeState(new KiesGokStrategyState(spel));
    }

    @Override
    public void bevestigKeuze() {
        throw new IllegalStateException("Kan niet in huidige state");
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
