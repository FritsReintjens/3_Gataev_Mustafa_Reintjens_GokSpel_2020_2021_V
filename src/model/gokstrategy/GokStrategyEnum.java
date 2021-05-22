package model.gokstrategy;


public enum GokStrategyEnum {
    EVENOGEN("model.gokstrategy.EvenOgenStrategy"),
    SOMOGEN("model.gokstrategy.SomOgenStrategy"),
    WOPRENOPLOPEND("model.gokstrategy.WorpenOplopendStrategy");


    private final String klassenaam;

    GokStrategyEnum(String klassenaam){
        this.klassenaam = klassenaam;
    }

    public String getKlassenaam(){
        return klassenaam;
    }
}
