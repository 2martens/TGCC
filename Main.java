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
	// Enthaelt ein Main Objekt.
	private static Main _instance;
	
	// Enthaelt ein Damebrett.
	private final Damebrett _damebrett;
	
	// Enthaelt die Kantenlaenge.
	private final int _kantenlaenge;
	
	// Enthaelt die x Position.
	private final int _xPosition;
	
	// Enthaelt die y Position.
	private final int _yPosition;
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Main.getInstance().start();
	}
	
	/**
	 * Gibt ein Objekt von Main zurueck.
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
		boolean weissAmZug = true;
		boolean warte = true;
		// Zug (2,1) nach (3,0)
		_damebrett.setzeFigur(2, 1, 3, 0, warte, weissAmZug);
		
		// Zug (5,6) nach (4,7)
		weissAmZug = false;
		_damebrett.setzeFigur(5, 6, 4, 7, warte, weissAmZug);
		
		// Zug (2,3) nach (3,4)
		weissAmZug = true;
		_damebrett.setzeFigur(2, 3, 3, 4, warte, weissAmZug);
		
		// Zug (5,0) nach (4,1)
		weissAmZug = false;
		_damebrett.setzeFigur(5, 0, 4, 1, warte, weissAmZug);
		
		// Zug (1,4) nach (2,3)
		weissAmZug = true;
		_damebrett.setzeFigur(1, 4, 2, 3, warte, weissAmZug);
		
		// Zug (5,4) nach (4,5)
		weissAmZug = false;
		_damebrett.setzeFigur(5, 4, 4, 5, warte, weissAmZug);
		
		// Zug (3,4) nach (5,6)
		weissAmZug = true;
		_damebrett.setzeFigur(3, 4, 5, 6, warte, weissAmZug);
		_damebrett.loescheFigur(4, 5, warte);
		
		// Zug (6,7) nach (4,5)
		weissAmZug = false;
		_damebrett.setzeFigur(6, 7, 4, 5, warte, weissAmZug);
		_damebrett.loescheFigur(5, 6, warte);
		
		// Zug (2,7) nach (3,6)
		weissAmZug = true;
		_damebrett.setzeFigur(2, 7, 3, 6, warte, weissAmZug);
		
		// Zug (4,5) nach (2,7)
		weissAmZug = false;
		_damebrett.setzeFigur(4, 5, 2, 7, warte, weissAmZug);
		_damebrett.loescheFigur(3, 6, warte);
		
		// das wars auch schon
		TurtleWelt.globaleWelt.loescheAlleSpuren();
		Textzeichner text = new Textzeichner("ENDE", (TurtleWelt.WIDTH / 2) - 20, (TurtleWelt.HEIGHT / 2));
		text.zeichneText();
	}
	
	
}
