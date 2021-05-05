package model.domain;

import java.util.Objects;

/**
 * @author team
 */
public class Speler implements Comparable<Speler>{
    private String voornaam, familienaam, spelersnaam;
    private double goksaldo;

    public Speler(){}

    public Speler(String voornaam, String familienaam, String spelersnaam, double goksaldo){
        setVoornaam(voornaam);
        setFamilienaam(familienaam);
        setSpelersnaam(spelersnaam);
        setGoksaldo(goksaldo);
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        if (voornaam == null || voornaam.isEmpty())
            throw new IllegalArgumentException("Voer een voornaam in.");
        this.voornaam = voornaam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public void setFamilienaam(String familienaam) {
        if (familienaam == null || familienaam.isEmpty()){
            throw new IllegalArgumentException("Voer een familienaam in.");
        }
        this.familienaam = familienaam;
    }

    public String getSpelersnaam() {
        return spelersnaam;
    }

    public void setSpelersnaam(String spelersnaam) {
        if (spelersnaam == null || spelersnaam.isEmpty()){
            throw new IllegalArgumentException("Voer een spelersnaam in.");
        }
        this.spelersnaam = spelersnaam;
    }

    public double getGoksaldo() {
        return goksaldo;
    }

    public void setGoksaldo(double goksaldo) {
        if (goksaldo < 0)
            throw new IllegalArgumentException("Goksaldo moet positief zijn.");
        this.goksaldo = goksaldo;
    }

    public String toTextBestand(){
        return getFamilienaam() + "," + getVoornaam() + "," + getSpelersnaam() + "," + getGoksaldo();
    }

    @Override
    public String toString() {
        return "Speler{" +
                "voornaam='" + voornaam + '\'' +
                ", familienaam='" + familienaam + '\'' +
                ", spelersnaam='" + spelersnaam + '\'' +
                ", goksaldo=" + goksaldo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speler speler = (Speler) o;
        return spelersnaam.equals(speler.spelersnaam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spelersnaam);
    }

    @Override
    public int compareTo(Speler andereSpeler) {
        return this.getSpelersnaam().compareTo(andereSpeler.getSpelersnaam());
    }
}
