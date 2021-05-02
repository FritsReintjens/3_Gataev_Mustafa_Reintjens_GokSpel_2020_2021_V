package model.database;

import model.domain.Speler;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author team
 */
public class SpelerDB extends TekstLoadSaveTemplate{
    private Map<String, Speler> spelers;


    public SpelerDB() throws FileNotFoundException {
        this.spelers = load("speler");
    }

    @Override
    public Speler objectVanString(String regel) {
        List<String> lijst = Arrays.asList(regel.split(","));
        Speler speler = new Speler(lijst.get(1), lijst.get(0), lijst.get(2), Double.parseDouble(lijst.get(3)));
        return speler;
    }

    @Override
    public String getKeyOfObject(Object o) {
        String spelersnaam = ((Speler)o).getSpelersnaam();
        return spelersnaam;
    }

    @Override
    protected String toBestand(Object o) {
        return ((Speler)o).toTextBestand();
    }

    public Map<String, Speler> getSpelers() {
        return spelers;
    }
}
