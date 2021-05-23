package controller;

import jxl.read.biff.BiffException;
import model.Spel;
import model.observer.Observer;
import model.state.WachtVoorInputState;
import view.panels.SpelVerloopPane;

import java.io.IOException;

public class SpelVerloopPaneController implements Observer {
    private SpelVerloopPane spelVerloopPane;
    private Spel spelFacade;

    public SpelVerloopPaneController(Spel spel){
        this.spelFacade = spel;
        spel.registerObserver(this);
    }

    public void setView(SpelVerloopPane spelVerloopPane) {
        this.spelVerloopPane = spelVerloopPane;
    }

    public Spel getSpelFacade() {
        return spelFacade;
    }

    public void startNieuwSpel() throws IOException, BiffException {
        this.spelFacade.notifyObserver();
        this.spelFacade.changeState(new WachtVoorInputState(this.spelFacade));
        this.spelFacade = new Spel(this.spelFacade.getSpelVolgNummer());
    }

    @Override
    public void update(){
        spelVerloopPane.vulWaardenIn();
    }
}
