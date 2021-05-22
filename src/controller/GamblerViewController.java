package controller;

import model.Spel;
import model.observer.Observer;
import view.GamblerView;

public class GamblerViewController implements Observer {
    private GamblerView gamblerView;
    private Spel spel;
    private int[] worpen;
    private int aantalWorpen;

    public GamblerViewController (Spel spel){
        this.spel = spel;
        spel.registerObserver(this);
        this.worpen = new int[4];
        this.aantalWorpen = 0;
    }

    public Spel getSpel() {
        return spel;
    }

    public void setView(GamblerView view){
        this.gamblerView = view;
    }

    public int[] getWorpen(){
        return this.worpen;
    }

    public int getAantalWorpen(){
        return aantalWorpen;
    }

    public boolean gooiDobbelsteen(){
        int res = (int)(Math.random()*6+1);
        worpen[aantalWorpen] = res;
        aantalWorpen++;
        return spel.getGokStrategy().kanWinnen(res);
    }

    @Override
    public void update(){

    }
}
