/**
 * Simuliert ein Array mithilfe von Strings und einer kommaseparierten Liste.
 * 
 * @author		Jim Martens
 * @copyright	2012 Jim Martens
 * @license		http://www.gnu.org/licenses/gpl-3.0 GNU General Public License, version 3
 * @version		30.11.2012
 */
public class StringArray
{
	// Enthält die Zeilenwerte.
	private String _zeilen;
	
	// Enthält die aktuelle Zeilennummer.
	private int _aktuelleZeilennummer;
	
	// Enthält die Länge des Arrays.
	private int _laenge;
	
	/**
	 * Initialisiert ein neues StringArray.
	 */
	public StringArray()
	{
		_zeilen = "";
		_aktuelleZeilennummer = 0;
		_laenge = 0;
	}
	
	/**
	 * Fügt eine neue Zeile zum Array hinzu.
	 * @param zeile eine kommaseparierte Liste von Zeileneinträgen
	 */
	public void fuegeZeileHinzu(String zeile)
	{
		if (!_zeilen.isEmpty())
		{
			_zeilen += ";";
		}
		_zeilen += String.valueOf(_aktuelleZeilennummer) + ":" + zeile;
		++_aktuelleZeilennummer;
		++_laenge;
	}
	
	/**
	 * Entfernt die letzte Zeile.
	 */
	public void entferneLetzteZeile()
	{
		String newString = _zeilen.replace(String.valueOf(_aktuelleZeilennummer) + ":.*;", "");
		_zeilen = newString;
		--_aktuelleZeilennummer;
		--_laenge;
	}
	
	/**
	 * Leert das Array komplett.
	 */
	public void leereArray()
	{
		_zeilen = "";
		_aktuelleZeilennummer = 0;
	}
	
	/**
	 * Liest die Zeile mit der angegebenen Nummer.
	 * @param zeilennummer Eine Nummer von 0 bis zur Länge des Arrays - 1.
	 * @return die Zeile mit der angegebenen Nummer
	 */
	public String liesZeile(int zeilennummer)
	{
		if (!(0 <= zeilennummer) || !(zeilennummer < _laenge))
		{
			System.err.println("Die Zeilennummer muss zwischen 0 und " + String.valueOf(_laenge - 1) + " liegen.");
			return "";
		}
		int startIndex = _zeilen.indexOf(zeilennummer + ":");
		String substring = _zeilen.substring(startIndex);
		int endIndex = substring.indexOf(';');
		substring = substring.substring(0, endIndex);
		
		return substring;
	}
}
