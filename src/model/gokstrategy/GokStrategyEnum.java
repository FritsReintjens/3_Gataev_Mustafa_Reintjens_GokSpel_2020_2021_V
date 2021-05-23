package model.gokstrategy;


public enum GokStrategyEnum {
    EVENOGEN("model.gokstrategy.EvenOgenStrategy", "EvenOgenStrategy"),
    SOMOGEN("model.gokstrategy.SomOgenStrategy", "SomOgenStrategy"),
    WOPRENOPLOPEND("model.gokstrategy.WorpenOplopendStrategy", "WorpenOplopendStrategy");


    private final String klassenaam;

    GokStrategyEnum(String klassenaam){
        this.klassenaam = klassenaam;
    }

    public String getKlassenaam(){
        return klassenaam;
    }
}
