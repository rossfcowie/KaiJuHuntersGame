package arcane.KaijuHunters.Monsters.datastorage;

import java.util.ArrayList;

public class NameGeneration {
	static ArrayList<String> used = new ArrayList<>();

	public static String generate(Monster baseMonster) { 
		String x = "";
		int highestStat = (int) (Math.random()*10+1);
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

	public static String classify(Monster baseMonster) {
		if(baseMonster.code !=null) {

			return baseMonster.code;
		}else {
			
			String[] x = baseMonster.name.split(" ");
			String y = "";
			int mod = 2;
			boolean ran = false;
			boolean fresh = false;
			boolean cut =  false;
			while (fresh==false) {
				
				y = "";
				if(cut) {
					String c = baseMonster.name.toUpperCase();
					c = c.replaceAll("A", "");
					c =c.replaceAll("E", "");
					c = c.replaceAll("I", "");
					c = c.replaceAll("O", "");
					c = c.replaceAll("U", "");
					x = c.split(" ");
					if(ran) {
						int r = (int) (Math.random() *(c.length()-mod));
						if(x.length<2) {
							y=c.substring(r,r+mod);
						}else {
							for (int i = 0; i < x.length; i++) {
								r = (int) (Math.random() *(x[i].length()-mod));
								
								y+=x[i].substring(r,r+mod/2);
							}
						}
					}else {
						if(x.length<2) {
							y=c.substring(0,2);
						}else {
							for (int i = 0; i < x.length; i++) {
								System.out.println(x[i]);
								
								y+=x[i].substring(0,1);
							}
						}
					}
				}else {
					if(ran) {
						int r = (int) (Math.random() *(baseMonster.name.length()-mod));
						if(x.length<2) {
							y=baseMonster.name.substring(r,r+mod);
						}else {
							for (int i = 0; i < x.length; i++) {
								r = (int) (Math.random() *(x[i].length()-mod));
								
								y+=x[i].substring(r,r+mod/2);
							}
						}
					}else {
						if(x.length<2) {
							y=baseMonster.name.substring(0,2);
						}else {
							for (int i = 0; i < x.length; i++) {
								System.out.println(x[i]);
								
								y+=x[i].substring(0,1);
							}
						}
					}
				}
				
				
				if (contains(y)) {
					if(cut) {
						if(ran) {
							mod++;
						}
						ran=true;
					}else {
						cut=true;
					}
					
					
				}else {
					fresh=true;
				}
			}
			used.add(y);
			System.out.println("success");
			System.out.println(used);
			System.out.println(y);
			baseMonster.code = y;
			return y;
		}
		
	}
	private static boolean contains(String s) {
		if (used != null) {
				if(used.contains(s)) {
					return true;
				}
			return false;
		}else {
			return false;
		}
		}

}
