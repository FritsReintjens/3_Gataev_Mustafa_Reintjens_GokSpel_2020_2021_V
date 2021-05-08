package model.database.loadSaveStrategy;

/**
 * @author Jurgen Mustafa
 */
public enum LoadSaveStrategyEnum{
    TEKST("tekst", "model.database.loadSaveStrategy.SpelerTekstLoadSaveStrategy"),
    EXCEL("excel", "model.database.loadSaveStrategy.SpelerExcelLoadSaveStrategy");

    private final String omschrijving;
    private final String klassenaam;

    LoadSaveStrategyEnum(String omschrijving, String klassenaam){
        this.omschrijving = omschrijving;
        this.klassenaam = klassenaam;
    }

    public String getOmschrijving(){
        return omschrijving;
    }
    public String getKlassenaam(){
        return klassenaam;
    }
}
