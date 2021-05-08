package model.database.loadSaveStrategy;

import excel.ExcelPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Dit is een Adapter klasse
 */
public class SpelerExcelLoadSaveStrategy implements LoadSaveStrategy{
    ExcelPlugin excelPlugin;

    public SpelerExcelLoadSaveStrategy(){
        excelPlugin = new ExcelPlugin();
    }

    @Override
    public Map load(String filename) {
        //read vraagt om een type File als parameter
        //return excelPlugin.read(filename);
        return null;
    }

    @Override
    public void save(String filename, HashMap lijst) {
        /*Collection<String> values = lijst.values();
        ArrayList<String> listOfValues = new ArrayList<>(values);
        File f = new File(filename+".xls");
        excelPlugin.write(f,listOfValues);*/
    }
}
