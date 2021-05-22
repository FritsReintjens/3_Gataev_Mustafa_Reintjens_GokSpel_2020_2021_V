package model.state;

import model.Spel;

public class SpeelState implements SpelState {
    Spel spel;
    int aantalWorpen = 0;

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
        //knop "werp dobbelsteen" aan, rest uit
        if (spel.getAantalWorpen() == 0){
            if (!this.spel.gooiDobbelsteen())
                spel.changeState(new VerlorenState(spel));
        }

        if (spel.getAantalWorpen() == 1){
            if (!this.spel.gooiDobbelsteen())
                spel.changeState(new VerlorenState(spel));
        }

        if (spel.getAantalWorpen() == 2){
            if (!this.spel.gooiDobbelsteen())
                spel.changeState(new VerlorenState(spel));
            //MOGELIJKHEID OM INZET TE VERHOGEN HIER
        }

        if (spel.getAantalWorpen() == 3) {
            if (!this.spel.gooiDobbelsteen())
                spel.changeState(new VerlorenState(spel));
        }else{
            spel.changeState(new GewonnenState(spel));
        }
        aantalWorpen++;
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
}
