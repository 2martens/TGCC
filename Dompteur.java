/**
 * Das Grundgeruest fuer Aufgabe 7.4
 * 
 * @author Fredrik Winkler
 * @version 2. Dezember 2011
 */
class Dompteur
{
    /**
     * Zeichnet drei Koch-Kurven mit den Detailstufen 1, 2 und 3.
     */
    public void zeichneDreiKochKurven()
    {
        Turtle oben = new Turtle(10, 150);
        zeichneKochKurve(oben, 480, 1);

        Turtle mitte = new Turtle(10, 320);
        zeichneKochKurve(mitte, 480, 2);

        Turtle unten = new Turtle(10, 490);
        zeichneKochKurve(unten, 480, 3);
    }

    /**
     * Zeichnet eine Koch-Kurve.
     * 
     * @param turtle die Turtle, die das Zeichnen uebernimmt.
     * Diese sollte eine sinnvolle Position und Ausrichtung haben.
     * @param laenge der Abstand vom Startpunkt zum Zielpunkt
     * @param detail der Detailgrad (die Rekursiontiefe)
     */
    private void zeichneKochKurve(Turtle turtle, double laenge, int detail)
    {
    }
}
