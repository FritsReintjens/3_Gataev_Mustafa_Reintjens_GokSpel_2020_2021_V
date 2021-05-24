package model.gokstrategy;

/**
 * @Author team
 */

public class WinStrategy implements GokStrategy{
    private int winstFactor = 10, aantalOgen = 0, som = 0, counter = 0;

    @Override
    public String beschrijving(){
        return "altijd winnen \t mogelijke winst is "+ this.winstFactor + " x je inzet";
    }

    @Override
    public double getWinst(double inzet){
        return winstFactor * inzet;
    }

    @Override
    public boolean kanWinnen(int aantalOgen){
        return true;
    }

    @Override
    public void setWinstFactor(int winstFactor) {
        this.winstFactor = winstFactor;
    }
}
