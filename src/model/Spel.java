package model;

import jxl.read.biff.BiffException;
import model.database.SpelerDB;
import model.database.loadSaveStrategy.LoadSaveFactory;
import model.gokstrategy.EvenOgenStrategy;
import model.gokstrategy.GokStrategy;
import model.gokstrategy.GokStrategyFactory;
import model.observer.Observable;
import model.observer.Observer;
import model.state.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;


public class Spel implements Observable {
    private SpelerDB spelerDB;
    private int spelVolgNummer = 0;
    private Speler speler;
    private double inzet;
    private SpelState spelState;
    private String enumString;
    private GokStrategy gokStrategy;

    private Collection<Observer> observers = new ArrayList<>();

    public Spel() throws BiffException, IOException {
        this.spelerDB = new SpelerDB();
        this.spelState = new WachtVoorInputState(this);
    }


    public Map<String,Speler> getSpelers(){
        return spelerDB.getSpelers();
    }

    public SpelerDB getSpelerDB(){
        return spelerDB;
    }

    public Speler getSpeler(){
        return speler;
    }

    public void setSpeler(String spelersnaam){
        Speler s = this.spelerDB.getSpelers().get(spelersnaam);
        this.speler = s;
    }

    public void setInzet(double inzet){
        this.inzet = inzet;
    }

    public double getInzet(){
        return this.inzet;
    }

    public int getSpelVolgNummer() {
        return spelVolgNummer;
    }

    public void setSpelVolgNummer() {
        this.spelVolgNummer += 1;
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

    public void startSpel() {
        this.spelState.startGokspel();
    }

    public void bevestigKeuze(){
        this.spelState.bevestigKeuze();
    }

    public SpelState getState() {
        return spelState;
    }

    public void changeState(SpelState spelState){
        this.spelState = spelState;
    }

    public void setEnumString(String s){
        this.enumString = s;
    }

    public void setStrategy() {
       GokStrategyFactory factory = GokStrategyFactory.getInstance();
       this.gokStrategy = factory.createGokStrategy(this.enumString);
    }

    public GokStrategy getGokStrategy(){
        return this.gokStrategy;
    }
}
