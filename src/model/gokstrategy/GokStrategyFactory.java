package model.gokstrategy;

import java.util.ArrayList;

public class GokStrategyFactory {
    private static GokStrategyFactory uniqueInstance;

    private GokStrategyFactory(){}

    //Dit is de factoryMethod
    public GokStrategy createGokStrategy(String type){
        GokStrategy gokStrategy = null;
        GokStrategyEnum gokStrategyEnum = GokStrategyEnum.valueOf(type);
        String klasseNaam = gokStrategyEnum.getKlassenaam();
        try{
            Class gokStrategyClass = Class.forName(klasseNaam);
            gokStrategy = (GokStrategy) gokStrategyClass.newInstance();
        }
        catch (Exception e){}
        return gokStrategy;
    }


    //Singleton
    public static GokStrategyFactory getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new GokStrategyFactory();
        }
        return uniqueInstance;
    }

    public ArrayList<GokStrategy> getAllStrategies() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ArrayList<GokStrategy> strategies = new ArrayList<>();

        for (GokStrategyEnum strategy : GokStrategyEnum.values()){
            GokStrategy gokStrategy = null;
            String klasseNaam = strategy.getKlassenaam();
            Class gokStrategyClass = Class.forName(klasseNaam);
            gokStrategy = (GokStrategy) gokStrategyClass.newInstance();
            strategies.add(gokStrategy);
        }
        return strategies;
    }
}
