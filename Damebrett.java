/**
 * Verkoerpert ein Damebrett.
 * 
 * @author		Jim Martens
 * @copyright	2012 Jim Martens
 * @license		http://www.gnu.org/licenses/gpl-3.0 GNU General Public License, version 3
 * @version		30.11.2012
 */
public class Damebrett
{
	// Enthaelt ein Turtle.
	private final  Turtle _turtle;
	
	// Enthaelt die Kantenlaenge.
	private  double _kantenlaenge;
	
	// Enthaelt die anfaengliche x Position.
	private final  double _xPosition;
	
	// Enthaelt die anfaengliche y Position.
	private final  double _yPosition;
	
	// Enthaelt einen Figurenspeicher.
	private final Figurenspeicher _speicher;
	
	/**
	 * Erstellt ein neues Damefeld.
	 * @param kantenlaenge Ein Wert von mindestens 1.
	 * @param xPosition
	 * @param yPosition 
	 */
	public Damebrett(int kantenlaenge, double xPosition, double yPosition)
	{
		_xPosition = xPosition;
		_yPosition = yPosition;
		_turtle = new Turtle(_xPosition, _yPosition);
		_turtle.setzeGeschwindigkeit(10);
		_speicher = new Figurenspeicher();
		
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
		figurenErstellen();
	}
	
	/**
	 * Setze eine Figur, die auf (startReihe, startFeld) steht, auf (zielReihe, zielFeld).
	 * 
	 * @param startReihe Eine Zahl zwischen 0 und 7.
	 * @param startFeld Eine Zahl zwischen 0 und 7.
	 * @param zielReihe Eine Zahl zwischen 0 und 7.
	 * @param zielFeld Eine Zahl zwischen 0 und 7.
	 * @param warte True, wenn die Ausfuehrung verzoegert werden soll.
	 * @param weissAmZug True, wenn weiss am Zug ist, false wenn rot am Zug ist.
	 */
	public void setzeFigur(int startReihe, int startFeld, int zielReihe, int zielFeld, boolean warte, boolean weissAmZug)
	{
		Damefigur figur = _speicher.gibFigur(startReihe, startFeld);
		
		if (warte)
		{
			warte();
		}
		figur.loesche();
		
		figur = _speicher.gibFigur(zielReihe, zielFeld);
		String farbe = "";
		if (weissAmZug)
		{
			farbe = "weiss";
		}
		else
		{
			farbe = "rot";
		}
		
		figur.setzeFarbe(farbe);
		figur.erneutZeichnen();
	}
	
	/**
	 * Loescht eine Figur an der gegebenen Position.
	 * @param reihe Eine Zahl zwischen 0 und 7.
	 * @param feld Eine Zahl zwischen 0 und 7.
	 * @param warte True, wenn die Ausfuerung verzoegert werden soll.
	 */
	public void loescheFigur(int reihe, int feld, boolean warte)
	{
		Damefigur figur = _speicher.gibFigur(reihe, feld);
		figur.loesche();
		if (warte)
		{
			warte();
		}
	}
	
	/**
	 * Setzt die Figuren auf das Damefeld.
	 */
	private void figurenErstellen()
	{
		for (int reihe = 0; reihe < 8; ++reihe)
		{
			// Enthaelt die Farbe der Figuren.
			String farbe = "weiss";
			
			/* Den anderen Fall muessen wir nicht abdecken, 
			 * da die farbe bei jedem Durchgang standardmaeßig bereits auf weiss ist.
			 */
			if (reihe >= 5)
			{
				farbe = "rot";
			}
			else if (reihe == 3 || reihe == 4)
			{
				farbe = "schwarz";
			}
			
			for (int feld = 0; feld < 8; ++feld)
			{
				boolean setzeFigur = ((feld + reihe) % 2) == 1;
				if (!setzeFigur)
				{
					continue;
				}
				
				Damefigur figur = new Damefigur(
						farbe, 
						(0.5 * _kantenlaenge) - 2, 
						_xPosition + (0.5 * _kantenlaenge) + (feld * _kantenlaenge), 
						_yPosition + (0.5 * _kantenlaenge) + (reihe * _kantenlaenge)
				);
				_speicher.setzeFigur(reihe, feld, figur);
			}
		}
	}
	
	/**
	 * Erstellt das Brett.
	 * 
	 * Es besteht aus 8x8 Feldern (wie bei einem Schachbrett) und ist abwechselnd mit schwarzen 
	 * und weißen Flaechen gefuellt.
	 * 
	 */
	private void brettErstellen()
	{
		for (int reihe = 0; reihe < 8; ++reihe)
		{
			if (reihe > 0) 
			{
				_turtle.hinterlasseKeineSpur();
				_turtle.geheZu(_xPosition, _yPosition + (reihe * _kantenlaenge));
				_turtle.drehe(90);
				_turtle.hinterlasseSpur();
			}
			
			reiheErstellen(reihe);
		}
	}
	
	/**
	 * Erstellt eine neue Reihe.
	 * @param reihennummer
	 */
	private void reiheErstellen(int reihennummer)
	{
		for (int feld = 0; feld < 8; ++feld)
		{
			_turtle.geheVor(_kantenlaenge); // oben
			_turtle.drehe(90); 
			_turtle.geheVor(_kantenlaenge); // rechts
			_turtle.drehe(90);
			_turtle.geheVor(_kantenlaenge); // unten
			_turtle.drehe(90);
			_turtle.geheVor(_kantenlaenge); // links
			
			if (((feld + reihennummer) % 2) == 1)
			{
				double xPosition = _turtle.gibX();
				double yPosition = _turtle.gibY();
				fuelleFeldAus(_kantenlaenge);
				_turtle.hinterlasseKeineSpur();
				_turtle.geheZu(xPosition, yPosition);
			}
			
			if (feld == 7) 
			{
				continue;
			}
			
			_turtle.hinterlasseKeineSpur();
			_turtle.drehe(90);
			_turtle.geheVor(_kantenlaenge);
			_turtle.hinterlasseSpur();
		}
	}
	
	/**
	 * Befuellt ein Feld mit schwarzer Farbe.
	 * @param kantenlaenge Eine Zahl größer oder gleich 0.
	 */
	private void fuelleFeldAus(double kantenlaenge)
	{
		if (kantenlaenge <= 0)
		{
			return;
		}
		
		for (int i = 0; i < 4; ++i)
		{
			_turtle.drehe(90);
			_turtle.geheVor(kantenlaenge - 1);
		}
		
		fuelleFeldAus(kantenlaenge - 1);
	}
	
	/**
	 * Wartet um die Dauer der Ausfuehrung der Methode.
	 */
	private static void warte()
	{
		Turtle turtle = new Turtle(0,0);
		turtle.hinterlasseKeineSpur();
		turtle.setzeGeschwindigkeit(5);
		for (int i = 360; i > 0; --i)
		{
			turtle.geheVor(1);
			turtle.drehe(1);
		}
		
	}
}
