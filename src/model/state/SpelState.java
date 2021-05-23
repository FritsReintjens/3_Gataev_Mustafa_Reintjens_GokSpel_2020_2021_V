package model.state;

/**
 * Spel is de contextklasse
 */

public interface SpelState {
    void startGokspel();
    void bevestigKeuze();
    void werpDobbelsteen();
    void verhoogInzet();
    void showVerloren();
    void showGewonnen();
    void resetGame();
}
