package model.state;

import model.Spel;

/**
 * @Author team
 */

public class VerhoogInzetState implements SpelState{
    Spel spel;

    public VerhoogInzetState(Spel spel){
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
        //hier moeten we de 3de worp doen EN state terug veranderen naar SpeelState EN nadat de derde worp is gegooid moet de label verhoog saldo en textinput weer verdwijnen
        boolean res = true;
        res = this.spel.gooiDobbelsteen();
        //VERHOOGINZETINPUT DISABLE
        if (!res) spel.changeState(new VerlorenState(spel));
        if (res) spel.changeState(new SpeelState(spel));
        spel.notifyObserver();
    }

    @Override
    public void verhoogInzet() {
        //hier moet view een label "verhoog saldo" en een textinput zichtbaar maken
        spel.notifyObserver();
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
