package net.minecraft.src;

public class VIPPlayers {

	private static String[] admins = new String[] {"Andypandy89",
			"ks07",
			"ryanclancy000"};
	private static String[] gms = new String[] {"frej93",
			"HariboPenguin",
			"Sk8r2K10",
			"TheCameraman",
			"Gweldor"};
	private static String[] mod = new String[] {"MrAbrman",
			"Mistar_E",
			"iAlek",
			"Siniestrado",
			"TheJaxnn",
			"Murreey",
			"jake0830",
			"Kangermoo",
			"Aresd25",
			"Co7in",
			"FlaredDARKRAVen",
			"Weeryan678",
			"Milemaker",
			"fallstherain",
			"Leonardo7777"};
	private static String[] dev = new String[] {"Rob4001",
			"andersonhc"};
	private static String[] cdev = new String[] {"gravypod"};
	private static String[] kewl = new String[] {"smitened"};


	public static int getColor(String s) {
		ChatColor c = ChatColor.WHITE;
		
		for (String name : admins){
			if (name.equalsIgnoreCase(s)) c = ChatColor.DARK_RED;
		}
		for (String name : kewl){
			if (name.equalsIgnoreCase(s)) c = ChatColor.GREEN;
		}
		for (String name : gms){
			if (name.equalsIgnoreCase(s)) c = ChatColor.RED;
		}
		for (String name : mod){
			if (name.equalsIgnoreCase(s)) c = ChatColor.BLUE;
		}
		for (String name : dev){
			if (name.equalsIgnoreCase(s)) c = ChatColor.DARK_AQUA;
		}
		for (String name : cdev){
			if (name.equalsIgnoreCase(s)) c = ChatColor.AQUA;
		}
		return convert (c);
	}
	private static int convert(ChatColor c) {
		switch (c) {
			case AQUA:
				return 0x55FFFF;
			case BLACK:
				return 0x000000;
			case BLUE:
				return 0x5555FF;
			case DARK_AQUA:
				return 0x00AAAA;
			case DARK_BLUE:
				return 0x0000AA;
			case DARK_GRAY:
				return 0x555555;
			case DARK_GREEN:
				return 0x00AA00;
			case DARK_PURPLE:
				return 0xAA00AA;
			case DARK_RED:
				return 0xAA0000;
			case GOLD:
				return 0xFFAA00;
			case GRAY:
				return 0xAAAAAA;
			case GREEN:
				return 0x55FF55;
			case LIGHT_PURPLE:
				return 0xFF55FF;
			case RED:
				return 0xFF5555;
			case WHITE:
				return 0xFFFFFF;
			case YELLOW:
				return 0xFFFF55;
		}
		return -1;
	}
}