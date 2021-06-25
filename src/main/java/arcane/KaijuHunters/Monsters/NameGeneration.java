package arcane.KaijuHunters.Monsters;

public class NameGeneration {


	public static String generate(Monster baseMonster) {
		String x = "";
		int highestStat = baseMonster.highestStat();
		switch (highestStat) {
		case 1:
			x += "Indominable ";
			break;
		case 2:
			x += "Tireless ";
			break;
		case 3:

			x += "Vicious ";
			break;
		case 4:

			x += "Inpenetrable ";
			break;
		case 5:

			x += "Hiretical ";
			break;
		case 6:

			x += "Resistant ";
			break;
		case 7:

			x += "Terrible ";
			break;
		case 8:

			x += "Swift ";
			break;
		default:
			break;
		}
		
		return x + baseMonster.name;
	}
}
