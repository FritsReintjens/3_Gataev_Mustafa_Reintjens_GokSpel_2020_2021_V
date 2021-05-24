package model.state;

import model.Spel;

/**
 * @Author team
 */

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
        //Tegen controller zeggen laat de verloren box zien
        this.spel.updateStrategyVerloren();
        this.spel.notifyObserver();
        this.spel.changeState(new GameResetState(spel));

        //In Spelverloop moet een knop zichtbaar worden om een nieuw spel te starten, of sessie te beeindigen

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