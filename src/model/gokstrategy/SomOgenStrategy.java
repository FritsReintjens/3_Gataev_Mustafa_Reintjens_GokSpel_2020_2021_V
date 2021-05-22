package model.gokstrategy;

import java.util.ArrayList;

/**
 * @author Frits Reintjens
 */

public class SomOgenStrategy implements GokStrategy{
    private int winstFactor = 5, aantalOgen = 21, som = 0, counter = 0;

    @Override
    public String beschrijving(){
        return "de som van de ogen van alle worpen samen is 21 \t mogelijke winst is " + this.winstFactor + " x je inzet";
    }

    @Override
    public double getWinst(double inzet){
        return winstFactor * inzet;
    }

    @Override
    public boolean kanWinnen(int aantalOgen){
        counter ++;
        som += aantalOgen;
        if (counter < 4)
            return som < 21;
        if (counter == 4)
            return som == 21;
        return false;
    }
}
