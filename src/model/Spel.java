package model;

import jxl.read.biff.BiffException;
import model.database.SpelerDB;
import model.database.GokStrategyDB;
import model.database.loadSaveStrategy.LoadSaveFactory;
import model.gokstrategy.*;
import model.observer.Observable;
import model.observer.Observer;
import model.state.*;

import java.io.IOException;
import java.util.*;


public class Spel implements Observable {
    private SpelerDB spelerDB;
    private GokStrategyDB gokStrategyDB;
    private ArrayList<GokStrategy> alleStrategies;
    private StrategyData strategyData;
    private int spelVolgNummer = 0;
    private Speler speler;
    private double inzet;
    private double verhoogdeInzet;
    private double winst;
    private SpelState spelState;
    private String enumString;
    private GokStrategy gokStrategy;
    private int[] worpen;
    private int aantalWorpen;
    private Map<String,Integer> stratFactorMap;
    private SpelSettings spelSettings;

    private Collection<Observer> observers = new ArrayList<>();

    public Spel(int spelVolgNummer) throws BiffException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.gokStrategyDB = new GokStrategyDB();
        this.spelState = new WachtVoorInputState(this);
        this.spelVolgNummer = spelVolgNummer;
        this.spelSettings = new SpelSettings();
        this.spelerDB = new SpelerDB(spelSettings.getSpelSetting("LoadSaveFormat"));
        this.stratFactorMap = new HashMap<>();
        setAllStrategies();
        setActiveStrategies();

    }

    public Map<String,Integer> getActiveStrategies() {
        return stratFactorMap;
    }

    public void setActiveStrategies(){
        this.stratFactorMap = new HashMap<>();
        String stratFactor = this.spelSettings.getSpelSetting("Strategies");
        String[] arrayStratFactor = stratFactor.split(",");

        for (int i = 0; i < arrayStratFactor.length; i++){
            this.stratFactorMap.put(arrayStratFactor[i].split(":")[0], Integer.parseInt(arrayStratFactor[i].split(":")[1]));
        }
        for (GokStrategy gokStrategy: getAllStrategies()) {
            if (stratFactorMap.containsKey(gokStrategy.getClass().getSimpleName())){
                gokStrategy.setWinstFactor(stratFactorMap.get(gokStrategy.getClass().getSimpleName()));
            }
        }

    }

    public GokStrategy findStrategyInAlleStrategies(String simpleClassName){
        for (GokStrategy s: getAllStrategies()) {
            if (s.getClass().getSimpleName().equalsIgnoreCase(simpleClassName)){
                return s;
            }
        }
        return null;
    }

    public Map<String,Speler> getSpelers(){
        return spelerDB.getSpelers();
    }

    public SpelerDB getSpelerDB(){
        return spelerDB;
    }

    public GokStrategyDB getGokStrategyDB() {
        return gokStrategyDB;
    }

    public Speler getSpeler(){
        return speler;
    }

    public void setSpeler(String spelersnaam){
        Speler s = this.spelerDB.getSpelers().get(spelersnaam);
        this.speler = s;
    }

    public void setInzet(double inzet){
        Double saldo = this.speler.getGoksaldo();
        if (inzet > saldo)
            throw new IllegalArgumentException("Inzet kan niet hoger zijn dan je goksaldo!");
        this.inzet = inzet;
        this.speler.setGoksaldo(saldo - inzet);
    }

    public double getInzet(){
        return this.inzet;
    }

    public void setVerhoogdeInzet(double inzet){
        if (inzet > 10 || inzet <= 0)
            throw new IllegalArgumentException("Je mag je inzet met maximaal 10 euro verhogen.");
        Double saldo = this.speler.getGoksaldo();
        if (inzet > saldo)
            throw new IllegalArgumentException("Inzet kan niet hoger zijn dan je goksaldo!");
        this.verhoogdeInzet = inzet;
        this.speler.setGoksaldo(saldo - inzet);
    }

    public double getVerhoogdeInzet(){
        return this.verhoogdeInzet;
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
        this.gokStrategy = null;
        for (GokStrategy strategy: getAllStrategies()) {
            if (strategy.getClass().getSimpleName().equalsIgnoreCase(this.enumString)){
                gokStrategy = strategy;
            }
        }
    }

    public ArrayList<GokStrategy> getAllStrategies(){
        return alleStrategies;
    }

    public void setAllStrategies() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.alleStrategies = GokStrategyFactory.getInstance().getAllStrategies();
    }

    public GokStrategy getGokStrategy(){
        return this.gokStrategy;
    }

    public int[] getWorpen() {
        return worpen;
    }

    public void setWorpen(){
        this.worpen = new int[4];
    }

    public int getAantalWorpen(){
        return this.aantalWorpen;
    }

    public void setAantalWorpen(){
        this.aantalWorpen = 0;
    }

    public boolean gooiDobbelsteen(){
        int res = (int)(Math.random()*6+1);
        worpen[aantalWorpen] = res;
        aantalWorpen++;
        return gokStrategy.kanWinnen(res);
    }

    public void verhoogInzet(){
        this.getState().verhoogInzet();
    }

    public double getWinst(){
        return this.winst;
    }

    public void setWinst(){
        this.winst = this.gokStrategy.getWinst(this.inzet+this.verhoogdeInzet);
        this.speler.voegWinstToe(winst);
    }

    public void showGewonnen(){
        this.getState().showGewonnen();
    }

    public void showVerloren(){
        this.getState().showVerloren();
    }


    public void updateStrategyGewonnen(){
        StrategyData data = this.gokStrategyDB.getStrategyData().get(this.gokStrategy.getClass().getSimpleName());
        data.verhoogAantalGekozen();
        data.verhoogAantalGewonnen();
        data.verhoogInzet(this.inzet + this.verhoogdeInzet);
        data.verhoogWinst(getWinst());
        this.gokStrategyDB.getStrategyData().put(this.gokStrategy.getClass().getSimpleName(), data);

    }

    public void updateStrategyVerloren(){
        StrategyData data = this.gokStrategyDB.getStrategyData().get(this.gokStrategy.getClass().getSimpleName());
        data.verhoogAantalGekozen();
        data.verhoogInzet(this.inzet + this.verhoogdeInzet);
        this.gokStrategyDB.getStrategyData().put(this.gokStrategy.getClass().getSimpleName(), data);
    }

    public void resetGame() {
        this.getState().resetGame();
    }

    public void resetFacade() {
        this.speler = null;
        this.inzet = 0.0;
        this.verhoogdeInzet = 0.0;
        this.winst = 0.0;
        this.worpen = new int[4];
        this.aantalWorpen = 0;
    }


    public SpelSettings getSpelSettings() {
        return spelSettings;
    }
}
