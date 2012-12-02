/**
 * Speichert Figurenreferenzen.
 * @author		Jim Martens
 * @copyright	2012 Jim Martens
 * @license		http://www.gnu.org/licenses/gpl-3.0 GNU General Public License, version 3
 * @version		01.12.2012
 */
public class Figurenspeicher
{
	private Damefigur _00;
	private Damefigur _01;
	private Damefigur _02;
	private Damefigur _03;
	private Damefigur _04;
	private Damefigur _05;
	private Damefigur _06;
	private Damefigur _07;
	
	private Damefigur _10;
	private Damefigur _11;
	private Damefigur _12;
	private Damefigur _13;
	private Damefigur _14;
	private Damefigur _15;
	private Damefigur _16;
	private Damefigur _17;
	
	private Damefigur _20;
	private Damefigur _21;
	private Damefigur _22;
	private Damefigur _23;
	private Damefigur _24;
	private Damefigur _25;
	private Damefigur _26;
	private Damefigur _27;
	
	private Damefigur _30;
	private Damefigur _31;
	private Damefigur _32;
	private Damefigur _33;
	private Damefigur _34;
	private Damefigur _35;
	private Damefigur _36;
	private Damefigur _37;
	
	private Damefigur _40;
	private Damefigur _41;
	private Damefigur _42;
	private Damefigur _43;
	private Damefigur _44;
	private Damefigur _45;
	private Damefigur _46;
	private Damefigur _47;
	
	private Damefigur _50;
	private Damefigur _51;
	private Damefigur _52;
	private Damefigur _53;
	private Damefigur _54;
	private Damefigur _55;
	private Damefigur _56;
	private Damefigur _57;
	
	private Damefigur _60;
	private Damefigur _61;
	private Damefigur _62;
	private Damefigur _63;
	private Damefigur _64;
	private Damefigur _65;
	private Damefigur _66;
	private Damefigur _67;
	
	private Damefigur _70;
	private Damefigur _71;
	private Damefigur _72;
	private Damefigur _73;
	private Damefigur _74;
	private Damefigur _75;
	private Damefigur _76;
	private Damefigur _77;
	
	/**
	 * Setzt die angegebene Figur.
	 * @param reihe
	 * @param feld
	 * @param figur
	 */
	public void setzeFigur(int reihe, int feld, Damefigur figur)
	{
		String figurName = "_" + reihe + feld;
		
		switch (figurName)
		{
			case "_00":
				_00 = figur;
				break;
			case "_01":
				_01 = figur;
				break;
			case "_02":
				_02 = figur;
				break;
			case "_03":
				_03 = figur;
				break;
			case "_04":
				_04 = figur;
				break;
			case "_05":
				_05 = figur;
				break;
			case "_06":
				_06 = figur;
				break;
			case "_07":
				_07 = figur;
				break;
			case "_10":
				_10 = figur;
				break;
			case "_11":
				_11 = figur;
				break;
			case "_12":
				_12 = figur;
				break;
			case "_13":
				_13 = figur;
				break;
			case "_14":
				_14 = figur;
				break;
			case "_15":
				_15 = figur;
				break;
			case "_16":
				_16 = figur;
				break;
			case "_17":
				_17 = figur;
				break;
			case "_20":
				_20 = figur;
				break;
			case "_21":
				_21 = figur;
				break;
			case "_22":
				_22 = figur;
				break;
			case "_23":
				_23 = figur;
				break;
			case "_24":
				_24 = figur;
				break;
			case "_25":
				_25 = figur;
				break;
			case "_26":
				_26 = figur;
				break;
			case "_27":
				_27 = figur;
				break;
			case "_30":
				_30 = figur;
				break;
			case "_31":
				_31 = figur;
				break;
			case "_32":
				_32 = figur;
				break;
			case "_33":
				_33 = figur;
				break;
			case "_34":
				_34 = figur;
				break;
			case "_35":
				_35 = figur;
				break;
			case "_36":
				_36 = figur;
				break;
			case "_37":
				_37 = figur;
				break;
			case "_40":
				_40 = figur;
				break;
			case "_41":
				_41 = figur;
				break;
			case "_42":
				_42 = figur;
				break;
			case "_43":
				_43 = figur;
				break;
			case "_44":
				_44 = figur;
				break;
			case "_45":
				_45 = figur;
				break;
			case "_46":
				_46 = figur;
				break;
			case "_47":
				_47 = figur;
				break;
			case "_50":
				_50 = figur;
				break;
			case "_51":
				_51 = figur;
				break;
			case "_52":
				_52 = figur;
				break;
			case "_53":
				_53 = figur;
				break;
			case "_54":
				_54 = figur;
				break;
			case "_55":
				_55 = figur;
				break;
			case "_56":
				_56 = figur;
				break;
			case "_57":
				_57 = figur;
				break;
			case "_60":
				_60 = figur;
				break;
			case "_61":
				_61 = figur;
				break;
			case "_62":
				_62 = figur;
				break;
			case "_63":
				_63 = figur;
				break;
			case "_64":
				_64 = figur;
				break;
			case "_65":
				_65 = figur;
				break;
			case "_66":
				_66 = figur;
				break;
			case "_67":
				_67 = figur;
				break;
			case "_70":
				_70 = figur;
				break;
			case "_71":
				_71 = figur;
				break;
			case "_72":
				_72 = figur;
				break;
			case "_73":
				_73 = figur;
				break;
			case "_74":
				_74 = figur;
				break;
			case "_75":
				_75 = figur;
				break;
			case "_76":
				_76 = figur;
				break;
			case "_77":
				_77 = figur;
				break;
			
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
		String figurName = "_" + reihe + feld;
		Damefigur figur = null;
		switch (figurName)
		{
			case "_00":
				figur = _00;
				break;
			case "_01":
				figur = _01;
				break;
			case "_02":
				figur = _02;
				break;
			case "_03":
				figur = _03;
				break;
			case "_04":
				figur = _04;
				break;
			case "_05":
				figur = _05;
				break;
			case "_06":
				figur = _06;
				break;
			case "_07":
				figur = _07;
				break;
			case "_10":
				figur = _10;
				break;
			case "_11":
				figur = _11;
				break;
			case "_12":
				figur = _12;
				break;
			case "_13":
				figur = _13;
				break;
			case "_14":
				figur = _14;
				break;
			case "_15":
				figur = _15;
				break;
			case "_16":
				figur = _16;
				break;
			case "_17":
				figur = _17;
				break;
			case "_20":
				figur = _20;
				break;
			case "_21":
				figur = _21;
				break;
			case "_22":
				figur = _22;
				break;
			case "_23":
				figur = _23;
				break;
			case "_24":
				figur = _24;
				break;
			case "_25":
				figur = _25;
				break;
			case "_26":
				figur = _26;
				break;
			case "_27":
				figur = _27;
				break;
			case "_30":
				figur = _30;
				break;
			case "_31":
				figur = _31;
				break;
			case "_32":
				figur = _32;
				break;
			case "_33":
				figur = _33;
				break;
			case "_34":
				figur = _34;
				break;
			case "_35":
				figur = _35;
				break;
			case "_36":
				figur = _36;
				break;
			case "_37":
				figur = _37;
				break;
			case "_40":
				figur = _40;
				break;
			case "_41":
				figur = _41;
				break;
			case "_42":
				figur = _42;
				break;
			case "_43":
				figur = _43;
				break;
			case "_44":
				figur = _44;
				break;
			case "_45":
				figur = _45;
				break;
			case "_46":
				figur = _46;
				break;
			case "_47":
				figur = _47;
				break;
			case "_50":
				figur = _50;
				break;
			case "_51":
				figur = _51;
				break;
			case "_52":
				figur = _52;
				break;
			case "_53":
				figur = _53;
				break;
			case "_54":
				figur = _54;
				break;
			case "_55":
				figur = _55;
				break;
			case "_56":
				figur = _56;
				break;
			case "_57":
				figur = _57;
				break;
			case "_60":
				figur = _60;
				break;
			case "_61":
				figur = _61;
				break;
			case "_62":
				figur = _62;
				break;
			case "_63":
				figur = _63;
				break;
			case "_64":
				figur = _64;
				break;
			case "_65":
				figur = _65;
				break;
			case "_66":
				figur = _66;
				break;
			case "_67":
				figur = _67;
				break;
			case "_70":
				figur = _70;
				break;
			case "_71":
				figur = _71;
				break;
			case "_72":
				figur = _72;
				break;
			case "_73":
				figur = _73;
				break;
			case "_74":
				figur = _74;
				break;
			case "_75":
				figur = _75;
				break;
			case "_76":
				figur = _76;
				break;
			case "_77":
				figur = _77;
				break;
		}
		return figur;
	}
}

