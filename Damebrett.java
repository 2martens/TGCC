/**
 * Verk�rpert ein Damebrett.
 * 
 * @author		Jim Martens
 * @copyright	2012 Jim Martens
 * @license		http://www.gnu.org/licenses/gpl-3.0 GNU General Public License, version 3
 * @version		30.11.2012
 */
public class Damebrett
{
	// Enth�lt ein String Array.
	private final StringArray _felder;
	
	// Enth�lt ein Turtle.
	private final Turtle _turtle;
	
	// Enth�lt die Kantenl�nge.
	private final int _kantenlaenge;
	
	// Enth�lt die anf�ngliche x Position.
	private final double _xPosition;
	
	// Enth�lt die anf�ngliche y Position.
	private final double _yPosition;
	
	/**
	 * Erstellt ein neues Damefeld.
	 * @param kantenlaenge Ein Wert von mindestens 1.
	 * @param xPosition
	 * @param yPosition 
	 */
	public Damebrett(int kantenlaenge, double xPosition, double yPosition)
	{
		_felder = new StringArray();
		
		_xPosition = xPosition;
		_yPosition = yPosition;
		_turtle = new Turtle(_xPosition, _yPosition);
		
		// Sicherstellen, dass die Kantenl�nge nicht negativ oder 0 ist.
		if (kantenlaenge < 1)
		{
			_kantenlaenge = 1;
		}
		else
		{
			_kantenlaenge = kantenlaenge;
		}
		
		brettErstellen();
	}
	
	/**
	 * Erstellt das Brett.
	 * 
	 * Es besteht aus 8x8 Feldern (wie bei einem Schachbrett) und ist abwechselnd mit schwarzen 
	 * und wei�en Fl�chen gef�llt.
	 * 
	 */
	private void brettErstellen()
	{
		for (int i = 0; i < 8; ++i)
		{
			if (i > 0) 
			{
				_turtle.hinterlasseKeineSpur();
				_turtle.geheZu(_xPosition, _yPosition + (i*_kantenlaenge));
				_turtle.drehe(90);
				_turtle.hinterlasseSpur();
			}
			
			reiheErstellen();
		}
	}
	
	/**
	 * Erstellt eine neue Reihe.
	 */
	private void reiheErstellen()
	{
		for (int i = 0; i < 8; ++i)
		{
			_turtle.geheVor(_kantenlaenge); // oben
			_turtle.drehe(90); 
			_turtle.geheVor(_kantenlaenge); // rechts
			_turtle.drehe(90);
			_turtle.geheVor(_kantenlaenge); // unten
			_turtle.drehe(90);
			_turtle.geheVor(_kantenlaenge); // links
			
			if (i == 7) 
			{
				continue;
			}
			
			_turtle.hinterlasseKeineSpur();
			_turtle.drehe(90);
			_turtle.geheVor(_kantenlaenge);
			_turtle.hinterlasseSpur();
		}
	}
}
