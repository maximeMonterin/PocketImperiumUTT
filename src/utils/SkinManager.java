package utils;

import java.util.HashMap;

//Base de donnée de tous les skins necessaires à la création des secteurs

public class SkinManager {
	
	public SkinManager() {}
	
	public HashMap<Integer, String> getSkinOne() {
		
		HashMap<Integer, String> skinOne = new HashMap<Integer, String>();
		
		skinOne.put(1, "_________");
		skinOne.put(2, "|       |");
		skinOne.put(3, "|       |");
		skinOne.put(4, "|       |");
		skinOne.put(5, "|_______|");
		
		
		return skinOne;
	}
	
	public HashMap<Integer, String> getSkinTwo() {
		
		HashMap<Integer, String> skinTwo = new HashMap<Integer, String>();
		
		skinTwo.put(1, "________");
		skinTwo.put(2, "       |");
		skinTwo.put(3, "       |");
		skinTwo.put(4, "       |");
		skinTwo.put(5, "_______|");
		
		
		return skinTwo;
	}
	
	public HashMap<Integer, String> getSkinThree() {
		
		HashMap<Integer, String> skinThree = new HashMap<Integer, String>();
		
		skinThree.put(1, "    |");
		skinThree.put(2, "    |");
		skinThree.put(3, "    |");
		skinThree.put(4, "____|");
		
		
		return skinThree;
	}
	
	public HashMap<Integer, String> getSkinFour() {
		
		HashMap<Integer, String> skinFour = new HashMap<Integer, String>();
		
		skinFour.put(1, "|    ");
		skinFour.put(2, "|    ");
		skinFour.put(3, "|    ");
		skinFour.put(4, "|____");
		
		
		return skinFour;
	}
	
	public HashMap<Integer, String> getSkinFive() {
		
		HashMap<Integer, String> skinFive = new HashMap<Integer, String>();
		
		skinFive.put(1, "       |");
		skinFive.put(2, "       |");
		skinFive.put(3, "       |");
		skinFive.put(4, "_______|");
		
		
		return skinFive;
	}
	
	public HashMap<Integer, String> getSkinSix() {
		
		HashMap<Integer, String> skinSix = new HashMap<Integer, String>();
		
		skinSix.put(1, "|       ");
		skinSix.put(2, "|       ");
		skinSix.put(3, "|       ");
		skinSix.put(4, "|_______");
		
		
		return skinSix;
	}
	
	public HashMap<Integer, String> getSkinSeven() {
		
		HashMap<Integer, String> skinSeven = new HashMap<Integer, String>();
		
		skinSeven.put(1, "       ");
		skinSeven.put(2, "       ");
		skinSeven.put(3, "       ");
		skinSeven.put(4, "_______");
		
		
		return skinSeven;
	}
	
	public HashMap<Integer, String> getSkinEight() {
		
		HashMap<Integer, String> skinEight = new HashMap<Integer, String>();
		
		skinEight.put(1, "|       |");
		skinEight.put(2, "|       |");
		skinEight.put(3, "|       |");
		skinEight.put(4, "|_______|");
		
		
		return skinEight;
	}

}
