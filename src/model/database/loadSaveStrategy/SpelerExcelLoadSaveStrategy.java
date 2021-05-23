package model.database.loadSaveStrategy;

import excel.ExcelPlugin;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import model.Speler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Dit is een Adapter klasse
 * @author Adam Gataev
 */
public class SpelerExcelLoadSaveStrategy implements LoadSaveStrategy{
    ExcelPlugin excelPlugin;

    public SpelerExcelLoadSaveStrategy(){
        excelPlugin = new ExcelPlugin();
    }

    @Override
    public Map load(String filename) throws IOException, BiffException {
        //read vraagt om een type File als parameter
        File f = new File("src/bestanden/"+filename+".xls");
        ArrayList<ArrayList<String>> spelers = excelPlugin.read(f);
        Map<String,Speler> map = new HashMap<>();
        for (ArrayList<String> speler : spelers){
            String key = speler.get(2);
            Speler speler1 = new Speler(speler.get(1),speler.get(0),speler.get(2), Double.parseDouble(speler.get(3)));
            map.put(key, speler1);
        }
        return map;
    }

    @Override
    public void save(String filename, HashMap lijst) throws WriteException, IOException, BiffException {
        File f = new File("src/bestanden/"+filename+".xls");

        Collection<Speler> values = lijst.values();
        ArrayList<Speler> listOfPlayers = new ArrayList<>(values);


        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for(Speler speler : listOfPlayers){
            ArrayList<String> spelerAlsString = new ArrayList<>();
            spelerAlsString.add(speler.getFamilienaam());
            spelerAlsString.add(speler.getVoornaam());
            spelerAlsString.add(speler.getSpelersnaam());
            spelerAlsString.add(Double.toString(speler.getGoksaldo()));
            result.add(spelerAlsString);
        }
        excelPlugin.write(f,result);
    }
}
