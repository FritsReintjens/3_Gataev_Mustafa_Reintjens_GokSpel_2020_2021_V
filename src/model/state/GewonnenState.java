package model.state;

import model.Spel;

public class GewonnenState implements SpelState{
    Spel spel;

    public GewonnenState(Spel spel){
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
            throw new IllegalStateException("Kan niet in huidige state");
    }

    @Override
    public void showGewonnen(){
        //Tegen controller zeggen laat de gewonnen box zien EN goksaldo verhogen
        this.spel.setWinst();
        this.spel.updateStrategyGewonnen();
        this.spel.notifyObserver();


        //In Spelverloop moet een knop zichtbaar worden om een nieuw spel te starten, of sessie te beeindigen
    }
}
