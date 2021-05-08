package model.database.loadSaveStrategy;

/**
 * @author Frits Reintjens
 */
public class LoadSaveFactory {
    private static LoadSaveFactory uniqueInstance;

    private LoadSaveFactory(){}

    //Dit is de factoryMethod
    public LoadSaveStrategy createLoadSaveStrategy(String type){
        LoadSaveStrategy loadSaveStrategy = null;
        LoadSaveStrategyEnum loadSaveStrategyEnum = LoadSaveStrategyEnum.valueOf(type);
        String klasseNaam = loadSaveStrategyEnum.getKlassenaam();
        try{
            Class dbClass = Class.forName(klasseNaam);
            loadSaveStrategy = (LoadSaveStrategy) dbClass.newInstance();
        }
        catch (Exception e){}
        return loadSaveStrategy;
    }

    //Singleton
    public static LoadSaveFactory getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new LoadSaveFactory();
        }
        return uniqueInstance;
    }
}
