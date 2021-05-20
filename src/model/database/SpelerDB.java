package model.database;

import jxl.read.biff.BiffException;
import model.database.loadSaveStrategy.LoadSaveFactory;
import model.database.loadSaveStrategy.LoadSaveStrategy;
import model.database.loadSaveStrategy.SpelerExcelLoadSaveStrategy;
import model.database.loadSaveStrategy.SpelerTekstLoadSaveStrategy;
import model.Speler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * @author team
 */
public class SpelerDB {
    private Map<String, Speler> spelers;
    private LoadSaveStrategy loadSaveStrategy;


    public SpelerDB() throws IOException, BiffException {
        LoadSaveFactory factory = LoadSaveFactory.getInstance();
        //TODO
        //Parameter implementeren
        loadSaveStrategy = factory.createLoadSaveStrategy("TEKST");
        this.spelers = loadSaveStrategy.load("speler");
    }

    public Map<String, Speler> getSpelers() {
        TreeMap<String, Speler> sorted = new TreeMap<>(this.spelers);
        return sorted;
    }

    //Moet DB ook singleton?
}
