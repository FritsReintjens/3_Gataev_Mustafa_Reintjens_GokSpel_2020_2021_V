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
        //knop "Start gokspel" moet aanstaan
        //alle andere uit

        this.spel.setWorpen();
        this.spel.setAantalWorpen();
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

    @Override
    public void showVerloren(){
        throw new IllegalStateException("Kan niet in huidige state");
    }

    @Override
    public void showGewonnen(){
    throw new IllegalStateException("Kan niet in huidige state");
    }

    @Override
    public void resetGame() {
        throw new IllegalStateException("Kan niet in huidige state");

    }
}
