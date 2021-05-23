package controller;

import jxl.read.biff.BiffException;
import model.Spel;
import model.database.SpelerDB;
import model.observer.Observer;
import org.omg.CORBA.PRIVATE_MEMBER;
import view.panels.InstellingenPane;

import java.io.IOException;

public class InstellingenPaneController implements Observer {
    private Spel spelFacade;
    private InstellingenPane instellingenPane;

    public InstellingenPaneController(Spel spel) {
        this.spelFacade = spel;
        spel.registerObserver(this);
    }

    public void setView(InstellingenPane instellingenPane) {
        this.instellingenPane = instellingenPane;
    }

    @Override
    public void update() {

    }

    public void setSettingToProperty(String format, String strategies){
        this.spelFacade.getSpelSettings().setFormatProperty(format);
        this.spelFacade.getSpelSettings().setGokStrategiesProperty(strategies);
        this.spelFacade.getSpelSettings().storeSpelSettings();
        this.spelFacade.setActiveStrategies();
    }

    public void spelerDBFormat(String format) throws BiffException, IOException {
        this.spelFacade.getSpelerDB().setLoadSaveStrategy(format);
    }
}
