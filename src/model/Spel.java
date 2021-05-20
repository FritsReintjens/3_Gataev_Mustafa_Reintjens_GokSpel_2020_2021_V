package model;

import jxl.read.biff.BiffException;
import model.database.SpelerDB;
import model.observer.Observable;
import model.observer.Observer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;


public class Spel implements Observable {
    private SpelerDB spelerDB;
    private SpelState spelState;
    private Collection<Observer> observers = new ArrayList<>();

    public Spel() throws BiffException, IOException {
        this.spelerDB = new SpelerDB();
    }

    public Map<String,Speler> getSpelers(){
        return spelerDB.getSpelers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer obs: observers){
            obs.update();
        }
    }
}
