package game_engine;

import board.Sector;

public class Main {

	public static void main(String[] args) {
		
		int[][] sectorBuilderTest = {{1,2},{3,7,4},{8,5}};
		Sector mySectorTest = new Sector(sectorBuilderTest);
		
		
		mySectorTest.addSkinToHex();
		mySectorTest.skinSectorBuilder();
		
		System.out.println(mySectorTest.getSectorSkin());

	}
		
		

}
