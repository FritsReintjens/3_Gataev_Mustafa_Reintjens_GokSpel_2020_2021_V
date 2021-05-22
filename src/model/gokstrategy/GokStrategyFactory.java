package model.gokstrategy;

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
}
