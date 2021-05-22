package model.gokstrategy;

/**
 * @author Frits Reintjens
 */

public interface GokStrategy {
    /**
     * @return geeft een beschrijving voor de view
     */
    String beschrijving();

    /**
     * @param inzet
     * @return berekent winst op basis van inzet, doet niets met saldo van de speler
     */
    double getWinst(double inzet);

    /**
     * @param aantalOgen
     * @return
     * geeft false als de speler niet meer kan winnen
     * geeft true als de speler nog kan winnen, we kunnen dan zeggen als deze methode true geeft bij de 4de worp heeft de speler gewonnen
     */
    boolean kanWinnen(int aantalOgen);


}
