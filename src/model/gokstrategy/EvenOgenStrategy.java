package model.gokstrategy;

/**
 * @author Frits Reintjens
 */

public class EvenOgenStrategy implements GokStrategy{
    private int winstFactor = 4;

    @Override
    public String beschrijving(){
        return "het aantal ogen is bij elke worp een even getal \t mogelijke winst is " + this.winstFactor + " x je inzet";
    }

    @Override
    public double getWinst(double inzet){
        return winstFactor * inzet;
    }

    @Override
    public boolean kanWinnen(int aantalOgen){
        return aantalOgen % 2 == 0;
    }
}
