package model.gokstrategy;

/**
 * @author Frits Reintjens
 */

public class WorpenOplopendStrategy implements GokStrategy{
    private int winstFactor = 10;
    private int[] worpen = new int[4];

    @Override
    public String beschrijving(){
        return "het aantal ogen is bij elke worp hoger dan bij de vorige worp \t mogelijke winst is " + this.winstFactor + " x je inzet";
    }

    @Override
    public double getWinst(double inzet){
        return winstFactor * inzet;
    }

    /**
     * Met de if(worpen[i] == 0) statement in de lus weet je op welke worp je zit, aangezien het aantalOgen altijd 1-6 is
     *
     * De if(aantalOgen > 3 + i) statement in de for lus controleert of de speler nog kan winnen:
     * als je op de eerste worp (i == 0) meer dan 3 gooit kan je niet meer winnen,
     * als je op de tweede worp (i == 1) meer dan 4 gooit kan je niet meer winnen, ...
     *
     * De if (worpen[i] < worpen[i -1]) statement controleert vanaf de tweede worp of deze worp hoger is dan de vorige
     */
    @Override
    public boolean kanWinnen(int aantalOgen){
        for (int i = 0; i < 4; i++) {
            if (worpen[i] == 0) {
                worpen[i] = aantalOgen;
                if (aantalOgen > 3 + i)
                    return false;
            }
            if (i > 0) {
                if (worpen[i] < worpen[i -1])
                    return false;
            }
        }
        return true;
    }
}
