package model.database;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
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
        loadSaveStrategy = factory.createLoadSaveStrategy(loadSaveStratgy);
        this.spelers = loadSaveStrategy.load("speler");
    }

    public Map<String, Speler> getSpelers() {
        TreeMap<String, Speler> sorted = new TreeMap<>(this.spelers);
        return sorted;
    }

    public void save() throws BiffException, WriteException, IOException {
        loadSaveStrategy.save("speler", (HashMap) spelers);
    }

    //ALS ER IN INSTELLINGENPANE EEN VERANDERING WORDT OPGESLAGEN MOET DEZE AANGESPROKEN WORDEN
    public void setLoadSaveStrategy(String format) throws BiffException, IOException {
        LoadSaveFactory factory = LoadSaveFactory.getInstance();
        this.loadSaveStrategy = factory.createLoadSaveStrategy(format);
        this.spelers = loadSaveStrategy.load("speler");
    }

}
