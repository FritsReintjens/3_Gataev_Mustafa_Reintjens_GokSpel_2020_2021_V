package model.state;

import model.Spel;

public class VerlorenState implements SpelState {
    Spel spel;

    public VerlorenState(Spel spel){
        this.spel = spel;
    }

    @Override
    public void startGokspel() {
        throw new IllegalStateException("Kan niet in huidige state");
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
        //
    }

    @Override
    public void showGewonnen(){
        throw new IllegalStateException("Kan niet in huidige state");
    }
}