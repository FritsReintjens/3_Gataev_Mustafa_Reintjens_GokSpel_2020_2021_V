package model.state;

import model.Spel;

public class SpeelState implements SpelState {
    Spel spel;

    public SpeelState(Spel spel){
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
        //Zet de gokStrategy

        //Gooi dobbelsteen

        //Controleer verloren -> verloren : naar verloren state

        //Gooi dobbelsteen

        //Controleer verloren -> verloren : naar verloren state
        //                      -> wilt de speler inzet verhogen?

        //Gooi dobbelsteen

        //Controleer Verloren -> verloren : naar verloren state

        //Gooi dobbelsteen

        //Controleer verloren  -> verloren : naar verloren state
        //                      -> gewonnen : naar gewonnen state


        if (){}
        spel.changeState(new GewonnenState(spel));


    }

    @Override
    public void verhoogInzet() {
        throw new IllegalStateException("Kan niet in huidige state");
    }
}
