/**
 * Schreibt Text mithilfe eines Turtles.
 * @author		Jim Martens
 * @copyright	2012 Jim Martens
 * @license		http://www.gnu.org/licenses/gpl-3.0 GNU General Public License, version 3
 * @version		02.12.2012
 */
public class Textzeichner
{
	// Enthaelt den zu schreibenden Text.
	private final String _text;
	
	// Enthaelt die anfaengliche x Position.
	private final double _xPosition;
	
	// Enthaelt die anfaenfliche y Position.
	private final double _yPosition;
	
	// Enthaelt die aktuelle x Position.
	private double _currentXPosition;
	
	// Enthaelt die aktuelle y Position.
	private double _currentYPosition;
	
	// Enthaelt ein Turtle.
	private final Turtle _turtle;
	
	/**
	 * Initialisiert ein neues Text-Objekt.
	 * @param text
	 * @param xPosition 
	 * @param yPosition 
	 */
	public Textzeichner(String text, double xPosition, double yPosition)
	{
		_text = text.toUpperCase();
		_xPosition = xPosition;
		_yPosition = yPosition;
		_currentXPosition = _xPosition;
		_currentYPosition = _yPosition;
		_turtle = new Turtle(_xPosition, _yPosition);
	}
	
	/**
	 * Zeichnet den Text.
	 */
	public void zeichneText()
	{
		int laenge = _text.length();
		for (int i = 0; i < laenge; ++i)
		{
			char zeichen = _text.charAt(i);
			switch (zeichen)
			{
				case 'E':
					zeichneE();
					break;
				case 'N':
					zeichneN();
					break;
				case 'D':
					zeichneD();
					break;
			}
		}
	}
	
	/**
	 * Zeichnet ein E.
	 */
	private void zeichneE()
	{
		_turtle.setzeRichtung(0);
		_turtle.geheVor(10); // oberer Strich
		_turtle.hinterlasseKeineSpur();
		_turtle.geheZu(_currentXPosition, _currentYPosition);
		_turtle.drehe(90);
		_turtle.hinterlasseSpur();
		_turtle.geheVor(10); // obere Haelfte linker Strich
		_turtle.drehe(-90);
		_turtle.geheVor(10); // mittlerer Strich
		_turtle.hinterlasseKeineSpur();
		_turtle.geheZu(_currentXPosition, _currentYPosition + 10);
		_turtle.drehe(90);
		_turtle.hinterlasseSpur();
		_turtle.geheVor(10); // untere Haelft linker Strich
		_turtle.drehe(-90);
		_turtle.geheVor(10); // unterer Strich
		
		_turtle.hinterlasseKeineSpur();
		_turtle.geheZu(_currentXPosition + 15, _currentYPosition);
		_currentXPosition = _turtle.gibX();
		_currentYPosition = _turtle.gibY();
		_turtle.hinterlasseSpur();
	}
	
	/**
	 * Zeichnet ein N.
	 */
	private void zeichneN()
	{
		double zielHoehe = _currentYPosition + 20;
		_turtle.setzeRichtung(90);
		_turtle.geheVor(20);
		_turtle.hinterlasseKeineSpur();
		_turtle.geheZu(_currentXPosition, _currentYPosition);
		_turtle.drehe(-25);
		_turtle.hinterlasseSpur();
		
		while (_turtle.gibY() < zielHoehe)
		{
			_turtle.geheVor(0.5);
		}
		
		_turtle.setzeRichtung(-90);
		_turtle.geheVor(20);
		
		_turtle.hinterlasseKeineSpur();
		_currentXPosition = _turtle.gibX() + 5;
		_turtle.geheZu(_currentXPosition, _currentYPosition);
		_turtle.hinterlasseSpur();
	}
	
	/**
	 * Zeichnet ein D.
	 */
	private void zeichneD()
	{
		_turtle.setzeRichtung(90);
		_turtle.geheVor(20);
		_turtle.setzeRichtung(335);
		
		for (int winkel = 335; winkel > 205; --winkel)
		{
			_turtle.geheVor(0.2);
			_turtle.drehe(-1);
			
			if (winkel == 270)
			{
				_currentXPosition = _turtle.gibX() + 5;
			}
		}
		
		_turtle.hinterlasseKeineSpur();
		_turtle.geheZu(_currentXPosition, _currentYPosition);
		_turtle.setzeRichtung(0);
		_turtle.hinterlasseSpur();
	}
}
