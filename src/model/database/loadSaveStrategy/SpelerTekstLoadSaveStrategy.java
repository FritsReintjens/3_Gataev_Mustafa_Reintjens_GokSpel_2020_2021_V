package model.database.loadSaveStrategy;

import helper.TekstLoadSaveTemplate;
import model.Speler;

import java.util.Arrays;
import java.util.List;
/**
 * @Author team
 */
public class SpelerTekstLoadSaveStrategy extends TekstLoadSaveTemplate implements LoadSaveStrategy{

    public SpelerTekstLoadSaveStrategy(){
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
}
