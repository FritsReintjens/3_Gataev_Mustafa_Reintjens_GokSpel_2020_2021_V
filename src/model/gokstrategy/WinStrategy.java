package model.gokstrategy;

public class WinStrategy implements GokStrategy{
    private int winstFactor = 10, aantalOgen = 0, som = 0, counter = 0;

    @Override
    public String beschrijving(){
        return "altijd winnen";
    }

    @Override
    public double getWinst(double inzet){
        return winstFactor * inzet;
    }

    @Override
    public boolean kanWinnen(int aantalOgen){
        return true;
    }
}
