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
	// Enth�lt ein Main Objekt.
	private static Main _instance;
	
	// Enth�lt ein Damebrett.
	private final Damebrett _damebrett;
	
	// Enth�lt die Kantenl�nge.
	private final int _kantenlaenge;
	
	// Enth�lt die x Position.
	private final int _xPosition;
	
	// Enth�lt die y Position.
	private final int _yPosition;
	
	/**
	 * Gibt ein Objekt von Main zur�ck.
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
	private Main()
	{
		_xPosition = 50;
		_yPosition = 50;
		_kantenlaenge = 30;
		_damebrett = new Damebrett(_kantenlaenge, _xPosition, _yPosition);
	}
	
	/**
	 * Startet die TGCC-Animation.
	 */
	public void start()
	{
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Main.getInstance().start();
	}
}
