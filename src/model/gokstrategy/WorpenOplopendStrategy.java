package model.gokstrategy;

/**
 * @author Frits Reintjens
 */

public class WorpenOplopendStrategy implements GokStrategy{
    private int winstFactor = 10, vorigeWorp = 0, counter = 0;
    @Override
    public String beschrijving(){
        return "het aantal ogen is bij elke worp hoger dan bij de vorige worp \t mogelijke winst is " + this.winstFactor + " x je inzet";
    }

    @Override
    public double getWinst(double inzet){
        return winstFactor * inzet;
    }

    /**
     * if (aantalOgen > 3 + counter) kijkt of de worp niet te hoog is om nog mogelijk te kunnen winnen
     */
    @Override
    public boolean kanWinnen(int aantalOgen){
        if (aantalOgen > 3 + counter)
            return false;
        if (aantalOgen > vorigeWorp) {
            counter++;
            vorigeWorp = aantalOgen;
            return true;
        }
        return false;
    }
}
