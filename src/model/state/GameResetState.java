package model.state;

import model.Spel;

public class GameResetState implements SpelState {

    private Spel spel;

    public GameResetState(Spel spel) {
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
    public void showVerloren() {
        throw new IllegalStateException("Kan niet in huidige state");
    }

    @Override
    public void showGewonnen() {
        throw new IllegalStateException("Kan niet in huidige state");
    }

    @Override
    public void resetGame() {
        this.spel.changeState(new WachtVoorInputState(spel));
    }
}
