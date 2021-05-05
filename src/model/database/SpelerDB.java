package model.database;

import model.database.loadSaveStrategy.LoadSaveStrategy;
import model.database.loadSaveStrategy.SpelerTekstLoadSaveStrategy;
import model.Speler;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author team
 */
public class SpelerDB {
    private Map<String, Speler> spelers;
    private LoadSaveStrategy loadSaveStrategy;


    public SpelerDB() throws FileNotFoundException {
        loadSaveStrategy = new SpelerTekstLoadSaveStrategy();
        this.spelers = loadSaveStrategy.load("speler");
    }

    public Map<String, Speler> getSpelers() {
        TreeMap<String, Speler> sorted = new TreeMap<>(this.spelers);
        return sorted;
    }
}
