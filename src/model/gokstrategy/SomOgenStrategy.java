package model.gokstrategy;

import java.util.ArrayList;

/**
 * @author Frits Reintjens
 */

public class SomOgenStrategy implements GokStrategy{
    private int winstFactor = 5, aantalOgen = 21, som = 0;
    private ArrayList<Integer> worpen = new ArrayList<>();

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
        worpen.add(aantalOgen);
        som += aantalOgen;
        if (worpen.size() < 4)
            return som < 21;
        if (worpen.size() == 4)
            return som == 21;
        return false;
    }
}
