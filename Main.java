/**
 * Die Startklasse dieses TGCC Projektes.
 * 
 * @author		Jim Martens
 * @copyright	2012 Jim Martens
 * @license		http://www.gnu.org/licenses/gpl-3.0 GNU General Public License, version 3
 * @version		2012-12-02
 */
public class Main
{
	// Enthält ein Main Objekt.
	private static Main _instance;
	
	// Enthält ein Damebrett.
	private final  Damebrett _damebrett;
	
	// Enthält die Kantenlänge.
	private final  int _kantenlaenge;
	
	// Enthält die x Position.
	private final  int _xPosition;
	
	// Enthält die y Position.
	private final  int _yPosition;
	
	/**
	 * Gibt ein Objekt von Main zurück.
	 * @return ein Main Objekt
	 */
	public static Main getInstance()
	{
		if (_instance == null)
		{
			_instance = new Main();
		}
		return _instance;
	}
	
	/**
	 * Initialisiert ein neues Main Objekt.
	 */
	public Main()
	{
		_xPosition = 100;
		_yPosition = 100;
		_kantenlaenge = 40;
		_damebrett = new Damebrett(_kantenlaenge, _xPosition, _yPosition);
	}
	
	/**
	 * Startet die TGCC-Animation.
	 */
	public void start()
	{
		Figurenspeicher speicher = _damebrett.gibSpeicher();
		Damefigur figur = speicher.gibFigur(2, 1);
		
		
		// Zug (2,1) nach (3,0)
		TurtleWelt.warte(4000);
		
		figur.setzeGeschwindigkeit(10);
		figur.loesche();
		
		figur = speicher.gibFigur(3, 0);
		figur.setzeFarbe("weiss");
		figur.erneutZeichnen();
		
		// Zug (5,6) nach (4,7)
		figur = speicher.gibFigur(5, 6);
		TurtleWelt.warte(4000);
		figur.loesche();
		
		figur = speicher.gibFigur(4, 7);
		figur.setzeFarbe("rot");
		figur.erneutZeichnen();
		
		// Zug (2,3) nach (3,4)
		figur = speicher.gibFigur(2, 3);
		TurtleWelt.warte(4000);
		figur.loesche();
		
		figur = speicher.gibFigur(3, 4);
		figur.setzeFarbe("weiss");
		figur.erneutZeichnen();
		
		// Zug (5,0) nach (4,1)
		figur = speicher.gibFigur(5, 0);
		TurtleWelt.warte(4000);
		figur.loesche();
		
		figur = speicher.gibFigur(4, 1);
		figur.setzeFarbe("rot");
		figur.erneutZeichnen();
		
		// Zug (1,4) nach (2,3)
		figur = speicher.gibFigur(1, 4);
		TurtleWelt.warte(4000);
		figur.loesche();
		
		figur = speicher.gibFigur(2, 3);
		figur.setzeFarbe("weiss");
		figur.erneutZeichnen();
		
		// Zug (5,4) nach (4,5)
		figur = speicher.gibFigur(5, 4);
		TurtleWelt.warte(4000);
		figur.loesche();
				
		figur = speicher.gibFigur(4, 5);
		figur.setzeFarbe("rot");
		figur.erneutZeichnen();
		
		// Zug (3,4) nach (5,6)
		figur = speicher.gibFigur(3, 4);
		TurtleWelt.warte(4000);
		figur.loesche();
				
		figur = speicher.gibFigur(5, 6);
		figur.setzeFarbe("weiss");
		figur.erneutZeichnen();
		
		figur = speicher.gibFigur(4, 5);
		figur.loesche();
		
		// Zug (6,7) nach (4,5)
		figur = speicher.gibFigur(6, 7);
		TurtleWelt.warte(4000);
		figur.loesche();
				
		figur = speicher.gibFigur(4, 5);
		figur.setzeFarbe("rot");
		figur.erneutZeichnen();
		
		figur = speicher.gibFigur(5, 6);
		figur.loesche();
		
		// Zug (2,7) nach (3,6)
		figur = speicher.gibFigur(2, 7);
		TurtleWelt.warte(4000);
		figur.loesche();
		
		figur = speicher.gibFigur(3, 6);
		figur.setzeFarbe("weiss");
		figur.erneutZeichnen();
		
		// Zug (4,5) nach (2,7)
		figur = speicher.gibFigur(4, 5);
		TurtleWelt.warte(4000);
		figur.loesche();
						
		figur = speicher.gibFigur(2, 7);
		figur.setzeFarbe("rot");
		figur.erneutZeichnen();
				
		figur = speicher.gibFigur(3, 6);
		figur.loesche();
		TurtleWelt.warte(4000);
		
		// das wars auch schon
		TurtleWelt.globaleWelt.loescheAlleSpuren();
		// @todo Text schreiben
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Main.getInstance().start();
	}
}
