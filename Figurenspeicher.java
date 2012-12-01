/**
 * Speichert Figurenreferenzen.
 * @author		Jim Martens
 * @copyright	2012 Jim Martens
 * @license		http://www.gnu.org/licenses/gpl-3.0 GNU General Public License, version 3
 * @version		01.12.2012
 */
public class Figurenspeicher
{
	// Sie müssen public sein, da ansonsten der Trick nicht funktioniert.
	public Damefigur _00;
	public Damefigur _01;
	public Damefigur _02;
	public Damefigur _03;
	public Damefigur _04;
	public Damefigur _05;
	public Damefigur _06;
	public Damefigur _07;
	public Damefigur _08;
	public Damefigur _09;
	
	public Damefigur _10;
	public Damefigur _11;
	public Damefigur _12;
	public Damefigur _13;
	public Damefigur _14;
	public Damefigur _15;
	public Damefigur _16;
	public Damefigur _17;
	
	public Damefigur _20;
	public Damefigur _21;
	public Damefigur _22;
	public Damefigur _23;
	public Damefigur _24;
	public Damefigur _25;
	public Damefigur _26;
	public Damefigur _27;
	
	public Damefigur _30;
	public Damefigur _31;
	public Damefigur _32;
	public Damefigur _33;
	public Damefigur _34;
	public Damefigur _35;
	public Damefigur _36;
	public Damefigur _37;
	
	public Damefigur _40;
	public Damefigur _41;
	public Damefigur _42;
	public Damefigur _43;
	public Damefigur _44;
	public Damefigur _45;
	public Damefigur _46;
	public Damefigur _47;
	
	public Damefigur _50;
	public Damefigur _51;
	public Damefigur _52;
	public Damefigur _53;
	public Damefigur _54;
	public Damefigur _55;
	public Damefigur _56;
	public Damefigur _57;
	
	public Damefigur _60;
	public Damefigur _61;
	public Damefigur _62;
	public Damefigur _63;
	public Damefigur _64;
	public Damefigur _65;
	public Damefigur _66;
	public Damefigur _67;
	
	public Damefigur _70;
	public Damefigur _71;
	public Damefigur _72;
	public Damefigur _73;
	public Damefigur _74;
	public Damefigur _75;
	public Damefigur _76;
	public Damefigur _77;
	
	/**
	 * Setzt die angegebene Figur.
	 * @param reihe
	 * @param feld
	 * @param figur
	 */
	public void setzeFigur(int reihe, int feld, Damefigur figur)
	{
		// Das muss getan werden, da es ansonsten leider nicht zu realisieren ist.
		try
		{
			Figurenspeicher.class.getField("_" + reihe + feld).set(this, figur);
		}
		catch (IllegalArgumentException | IllegalAccessException
				| NoSuchFieldException | SecurityException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Gibt die Figur zurück, die an der angegebenen Stelle gespeichert ist.
	 * @param reihe
	 * @param feld
	 * @return Die Figur an der angegebenen Stelle oder null.
	 */
	public Damefigur gibFigur(int reihe, int feld)
	{
		Damefigur figur = null;
		try
		{
			figur = (Damefigur) Figurenspeicher.class.getField("_" + reihe + feld).get(this);
		}
		catch (IllegalArgumentException | IllegalAccessException
				| NoSuchFieldException | SecurityException e)
		{
			e.printStackTrace();
		}
		return figur;
	}
}

