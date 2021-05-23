package model.gokstrategy;


public enum GokStrategyEnum {
    EVENOGEN("model.gokstrategy.EvenOgenStrategy", "EvenOgenStrategy"),
    SOMOGEN("model.gokstrategy.SomOgenStrategy", "SomOgenStrategy"),
    WOPRENOPLOPEND("model.gokstrategy.WorpenOplopendStrategy", "WorpenOplopendStrategy"),
    WIN("model.gokstrategy.WinStrategy", "WinStrategy");


    private final String klassenaam;
    private final String klassenaamSimpel;

    GokStrategyEnum(String klassenaam, String klassenaamSimpel){
        this.klassenaamSimpel = klassenaamSimpel;
        this.klassenaam = klassenaam;
    }

    public String getKlassenaam(){
        return klassenaam;
    }
    public String getKlassenaamSimpel(){
        return klassenaamSimpel;
    }
}
