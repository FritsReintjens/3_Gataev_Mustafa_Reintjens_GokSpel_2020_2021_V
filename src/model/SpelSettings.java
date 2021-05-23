package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

public class SpelSettings {
    private Properties properties = new Properties();

    public SpelSettings() {
        loadSpelSetting();
    }

    public void loadSpelSetting(){
        try{
            InputStream is = new FileInputStream("src/bestanden/spelsettings.properties");
            properties.load(is);
            is.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void storeSpelSettings(){
        try {
            FileOutputStream os = new FileOutputStream("src/bestanden/spelsettings.properties");
            properties.store(os, "");
            os.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getSpelSetting(String property){
        return this.properties.getProperty(property);
    }

    public void setFormatProperty(String format){
        properties.setProperty("LoadSaveFormat", format);
    }

    public void setGokStrategiesProperty(String strategies){
        properties.setProperty("Strategies", strategies);
    }

}
