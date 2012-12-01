/**
 * Repräsentiert eine Damefigur.
 * @author		Jim Martens
 * @copyright	2012 Jim Martens
 * @license		http://www.gnu.org/licenses/gpl-3.0 GNU General Public License, version 3
 * @version		01.12.2012
 */
public class Damefigur
{
	// Enthält die Farbe dieser Figur.
	private  String _farbe;
	
	// Enthält den Radius der Figur.
	private  double _radius;
	
	// Enthält die anfängliche x Position.
	private final  double _xPosition;
	
	// Enthält die anfängliche y Position.
	private final  double _yPosition;
	
	// Enthält ein Turtle-Objekt.
	private final  Turtle _turtle;
	
	/**
	 * Initialisiert eine neue Damefigur.
	 * @param farbe "schawrz", "blau", "cyan", "dunkelgrau", "grau", "gruen", "hellgrau", "magenta", "orange", "pink", "rot", "weiss" oder "gelb"
	 * @param radius Ein positiver Wert.
	 * @param xPosition
	 * @param yPosition
	 */
	public Damefigur(String farbe, double radius, double xPosition, double yPosition)
	{
		setzeFarbe(farbe);
		
		if (radius <= 0)
		{
			_radius = 1;
		}
		else
		{
			_radius = radius;
		}
		_xPosition = xPosition;
		_yPosition = yPosition;
		_turtle = new Turtle(_xPosition, _yPosition);
		_turtle.setzeGeschwindigkeit(10);
		zeichne(_farbe);
	}
	
	/**
	 * Setzt die Turtle Geschwindigkeit auf den angegebenen Wert.
	 * @param geschwindigkeit ein Wert zwischen 0 (am langsamsten) bis 10 (am schnellsten)
	 */
	public void setzeGeschwindigkeit(int geschwindigkeit)
	{
		if (geschwindigkeit < 0)
		{
			geschwindigkeit = 0;
		}
		else if (geschwindigkeit > 10)
		{
			geschwindigkeit = 10;
		}
		_turtle.setzeGeschwindigkeit(geschwindigkeit);
	}
	
	/**
	 * Zeichnet die Figur wieder an der anfänglichen Stelle.
	 */
	public void erneutZeichnen()
	{
		_turtle.hinterlasseKeineSpur();
		_turtle.geheZu(_xPosition, _yPosition);
		zeichne(_farbe);
	}
	
	/**
	 * Setzt die Farbe.
	 * @param farbe "schawrz", "blau", "cyan", "dunkelgrau", "grau", "gruen", "hellgrau", "magenta", "orange", "pink", "rot", "weiss" oder "gelb"
	 */
	public void setzeFarbe(String farbe)
	{
		switch (farbe)
		{
			case "schwarz":
			case "blau":
			case "cyan":
			case "dunkelgrau":
			case "grau":
			case "gruen":
			case "hellgrau":
			case "magenta":
			case "orange":
			case "pink":
			case "rot":
			case "weiss":
			case "gelb":
				_farbe = farbe;
				break;
			default:
				// Workaround: Da Exceptions noch nicht behandelt, muss _farbe einen validen Wert enthalten.
				_farbe = "weiss";
				System.err.println("Die Farbe muss einem der erlaubten Werte entsprechen.");
				break;
		}
	}
	
	/**
	 * Löscht die Figur.
	 */
	public void loesche()
	{
		_turtle.hinterlasseKeineSpur();
		_turtle.geheZu(_xPosition, _yPosition);
		_turtle.setzeRichtung(0);
		zeichne("schwarz");
	}
	
	/**
	 * Zeichnet die Figur.
	 * @param farbe 
	 */
	public void zeichne(String farbe)
	{
		_turtle.setzeFarbe(farbe);
		_turtle.hinterlasseKeineSpur();
		_turtle.geheVor(_radius);
		_turtle.drehe(90);
		_turtle.hinterlasseSpur();
		
		for (double radius = _radius; radius >= 0; --radius)
		{
			if (radius < _radius)
			{
				_turtle.hinterlasseKeineSpur();
				_turtle.drehe(90);
				_turtle.geheVor(1);
				_turtle.drehe(-90);
				_turtle.hinterlasseSpur();
			}
			double schritte = (radius * 23) /1300;
			for (int winkel = 0; winkel < 360; ++winkel)
			{
				_turtle.geheVor(schritte);
				_turtle.drehe(1);
			}
		}
		
	}
}

