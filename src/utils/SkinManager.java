package utils;

import java.util.HashMap;

//Base de donnée de tous les skins necessaires à la création des

public class SkinManager {

	private final String RESET = "\u001B[0m";
	
	public SkinManager() {}

	private String getColorByLevel(int level){

		String color = "";
		if(level == 2){
			color = "\u001B[35m";
		}
		if(level == 1){
			color = "\u001B[33m";
		}

		return color;

	}
	
	public HashMap<Integer, String> getSkinOne(int level) {
		
		String color = this.getColorByLevel(level);
		HashMap<Integer, String> skinOne = new HashMap<Integer, String>();
		
		if(level != 0){
			skinOne.put(1, "_________");
			skinOne.put(2, "|       |");
			skinOne.put(3, "|   " + color + level + this.RESET + "   |");
			skinOne.put(4, "|       |");
			skinOne.put(5, "|_______|");
		} 
		else {
			skinOne.put(1, "_________");
			skinOne.put(2, "|       |");
			skinOne.put(3, "|       |");
			skinOne.put(4, "|       |");
			skinOne.put(5, "|_______|");
		}
		
		
		return skinOne;
	}
	
	public HashMap<Integer, String> getSkinTwo(int level) {
		
		String color = this.getColorByLevel(level);
		HashMap<Integer, String> skinTwo = new HashMap<Integer, String>();
		
		if(level != 0){
			skinTwo.put(1, "________");
			skinTwo.put(2, "       |");
			skinTwo.put(3, "   " + color + level + this.RESET + "   |");
			skinTwo.put(4, "       |");
			skinTwo.put(5, "_______|");
		}
		else {
			skinTwo.put(1, "________");
			skinTwo.put(2, "       |");
			skinTwo.put(3, "       |");
			skinTwo.put(4, "       |");
			skinTwo.put(5, "_______|");
		}
		
		
		return skinTwo;
	}
	
	public HashMap<Integer, String> getSkinThree(int level) {
		
		HashMap<Integer, String> skinThree = new HashMap<Integer, String>();
		
		skinThree.put(1, "    |");
		skinThree.put(2, "    |");
		skinThree.put(3, "    |");
		skinThree.put(4, "____|");
		
		
		return skinThree;
	}
	
	public HashMap<Integer, String> getSkinFour(int level) {
		
		HashMap<Integer, String> skinFour = new HashMap<Integer, String>();
		
		skinFour.put(1, "|    ");
		skinFour.put(2, "|    ");
		skinFour.put(3, "|    ");
		skinFour.put(4, "|____");
		
		
		return skinFour;
	}
	
	public HashMap<Integer, String> getSkinFive(int level) {
		
		String color = this.getColorByLevel(level);
		HashMap<Integer, String> skinFive = new HashMap<Integer, String>();
		
		if(level != 0){
			skinFive.put(1, "       |");
			skinFive.put(2, "   " + color + level + this.RESET + "   |");
			skinFive.put(3, "       |");
			skinFive.put(4, "_______|");
		}
		else {
			skinFive.put(1, "       |");
			skinFive.put(2, "       |");
			skinFive.put(3, "       |");
			skinFive.put(4, "_______|");
		}
		
		
		return skinFive;
	}
	
	public HashMap<Integer, String> getSkinSix(int level) {
		
		String color = this.getColorByLevel(level);
		HashMap<Integer, String> skinSix = new HashMap<Integer, String>();
		
		if(level != 0){
			skinSix.put(1, "|       ");
			skinSix.put(2, "|   " + color + level + this.RESET + "   ");
			skinSix.put(3, "|       ");
			skinSix.put(4, "|_______");			
		}
		else {
			skinSix.put(1, "|       ");
			skinSix.put(2, "|       ");
			skinSix.put(3, "|       ");
			skinSix.put(4, "|_______");
		}
		
		return skinSix;
	}
	
	public HashMap<Integer, String> getSkinSeven(int level) {
		
		String color = this.getColorByLevel(level);
		HashMap<Integer, String> skinSeven = new HashMap<Integer, String>();

		if(level != 0){
			skinSeven.put(1, "       ");
			skinSeven.put(2, "   " + color + level + this.RESET + "   ");
			skinSeven.put(3, "       ");
			skinSeven.put(4, "_______");			
		}
		else{
			skinSeven.put(1, "       ");
			skinSeven.put(2, "       ");
			skinSeven.put(3, "       ");
			skinSeven.put(4, "_______");
		}

		return skinSeven;
	}
	
	public HashMap<Integer, String> getSkinEight(int level) {
		
		String color = this.getColorByLevel(level);
		HashMap<Integer, String> skinEight = new HashMap<Integer, String>();
		
		if(level != 0){
			skinEight.put(1, "|       |");
			skinEight.put(2, "|   " + color + level + this.RESET + "   |");
			skinEight.put(3, "|       |");
			skinEight.put(4, "|_______|");
		}
		else {
			skinEight.put(1, "|       |");
			skinEight.put(2, "|       |");
			skinEight.put(3, "|       |");
			skinEight.put(4, "|_______|");
		}


		
		
		return skinEight;
	}

	public HashMap<Integer, String> getSkinNine(int level) {
		
		HashMap<Integer, String> skinNine = new HashMap<Integer, String>();
		
		skinNine.put(1, "|   ");
		skinNine.put(2, "|   ");
		skinNine.put(3, "|   ");
		skinNine.put(4, "|___");
		
		
		return skinNine;
	}

	public HashMap<Integer, String> getSkinTen(int level) {
		
		HashMap<Integer, String> skinTen = new HashMap<Integer, String>();
		
		skinTen.put(1, "   |");
		skinTen.put(2, "   |");
		skinTen.put(3, "   |");
		skinTen.put(4, "___|");
		
		
		return skinTen;
	}

	public HashMap<Integer, String> getSkinEleven() {
		
		HashMap<Integer, String> skinEleven = new HashMap<Integer, String>();
		
		skinEleven.put(1, "       ");
		skinEleven.put(2, "       ");
		skinEleven.put(3, "       ");
		skinEleven.put(4, "       ");
		
		
		return skinEleven;
	}

	public HashMap<Integer, String> getSkinTwelve() {
		
		String color = "\u001B[32m";
		HashMap<Integer, String> skinTwelve = new HashMap<Integer, String>();
		
		skinTwelve.put(1, "       ");
		skinTwelve.put(2, "   " + color + 3 + this.RESET + "   ");
		skinTwelve.put(3, "       ");
		skinTwelve.put(4, "       ");
		
		
		return skinTwelve;
	}

	public HashMap<Integer, String> getSkinThirteen() {
		
		HashMap<Integer, String> skinSeven = new HashMap<Integer, String>();

			skinSeven.put(1, "       ");
			skinSeven.put(2, "       ");
			skinSeven.put(3, "       ");
			skinSeven.put(4, "_______");

		return skinSeven;
	}

}
