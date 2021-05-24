package model;

import java.util.Objects;

/**
 * @Author team
 */

public class StrategyData {
    private String naam;
    private int aantalKeerGekozen;
    private int aantalKeerSucces;
    private double totalInzet;
    private double totaleWinst;

    public StrategyData(String naam){
        this.naam = naam;
        this.aantalKeerGekozen = 0;
        this.aantalKeerSucces = 0;
        this.totalInzet = 0.0;
        this.totaleWinst = 0.0;

    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getAantalKeerGekozen() {
        return aantalKeerGekozen;
    }

    public void setAantalKeerGekozen(int aantalKeerGekozen) {
        this.aantalKeerGekozen = aantalKeerGekozen;
    }

    public int getAantalKeerSucces() {
        return aantalKeerSucces;
    }

    public void setAantalKeerSucces(int aantalKeerSucces) {
        this.aantalKeerSucces = aantalKeerSucces;
    }

    public double getTotalInzet() {
        return totalInzet;
    }

    public void setTotalInzet(double totalInzet) {
        this.totalInzet = totalInzet;
    }

    public double getTotaleWinst() {
        return totaleWinst;
    }

    public void setTotaleWinst(double totaleWinst) {
        this.totaleWinst = totaleWinst;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StrategyData that = (StrategyData) o;
        return naam.equals(that.naam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam);
    }

    public void verhoogAantalGekozen() {
        this.aantalKeerGekozen++;
    }

    public void verhoogAantalGewonnen() {
        this.aantalKeerSucces++;
    }

    public void verhoogInzet(double inzet) {
        this.totalInzet += inzet;
    }

    public void verhoogWinst(double winst) {
        this.totaleWinst += winst;
    }
}
