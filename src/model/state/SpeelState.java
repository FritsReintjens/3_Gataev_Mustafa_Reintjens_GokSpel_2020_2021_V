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

        boolean res = true;

        switch (spel.getAantalWorpen()){
            case 0:
            case 2:
                res = this.spel.gooiDobbelsteen();
                if (!res) spel.changeState(new VerlorenState(spel));
                spel.notifyObserver();
                break;
            case 3:
                res = this.spel.gooiDobbelsteen();
                if (!res) spel.changeState(new VerlorenState(spel));
                if (res) spel.changeState(new GewonnenState(spel));
                spel.notifyObserver();
                break;
            case 1:
                res = this.spel.gooiDobbelsteen();
                if (!res) spel.changeState(new VerlorenState(spel));
                if (res) spel.changeState(new VerhoogInzetState(spel));
                spel.notifyObserver();
                break;
        }
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
