package game_engine;

import java.util.ArrayList;
import java.util.List;

import board.Gameboard;
import board.Sector;

public class Main {

	public static void main(String[] args) {

		/* -_-_-_-_-_-_-_- INSTANCES -_-_-_-_-_-_-_- */

					 /* PREMIERE LIGNE */
		
		//Secteur gauche
		int[][] levelSectorOne = {{2,0},{0,1,0},{0,1}};
		int[][] sectorBuilderOne = {{1,2},{3,7,4},{8,5}};
		Sector sectorOne = new Sector(sectorBuilderOne, levelSectorOne, 'a');

		//Secteur centre
		int[][] levelSectorTwo = {{1,0},{0,1,0},{2,0}};
		int[][] sectorBuilderTwo = {{2,2},{10,7,4},{5,5}};
		Sector sectorTwo = new Sector(sectorBuilderTwo, levelSectorTwo, 'b');

		//Secteur droite
		int[][] levelSectorThree = {{1,1},{0,0,0},{0,2}};
		int[][] sectorBuilderThree = {{2,2},{10,7,4},{5,5}};
		Sector sectorThree = new Sector(sectorBuilderThree, levelSectorThree, 'c');

					 /* DEUXIEME LIGNE */

		//Secteur gauche
		int[][] levelSectorFour = {{0,2,0},{1,0},{0,1,0}};
		int[][] sectorBuilderFour = {{3,7,4},{6,6},{3,7,4}};
		Sector sectorFour = new Sector(sectorBuilderFour, levelSectorFour, 'd');
		
		//Secteur centre
		int[][] levelSectorFive = {{0,3,0},{3,3,3},{0,3,0}};
		int[][] sectorBuilderFive = {{10,11,4},{4,12,3},{10,13,4}};
		Sector sectorFive = new Sector(sectorBuilderFive, levelSectorFive, 'e');
		
		//Secteur droite
		int[][] levelSectorSix = {{0,1,0},{0,2},{0,1,0}};
		int[][] sectorBuilderSix = {{10,7,4},{5,5},{10,7,4}};
		Sector sectorSix = new Sector(sectorBuilderSix, levelSectorSix, 'f');

					/* TROISIEME LIGNE */

		//Secteur gauche
		int[][] levelSectorSeven = {{1,1},{0,2,0},{0,0}};
		int[][] sectorBuilderSeven = {{8,5},{3,7,4},{8,5}};
		Sector sectorSeven = new Sector(sectorBuilderSeven, levelSectorSeven, 'g');
		
		//Secteur centre
		int[][] levelSectorEight = {{0,1},{0,2,0},{0,1}};
		int[][] sectorBuilderEight = {{5,5},{10,7,4},{5,5}};
		Sector sectorEight = new Sector(sectorBuilderEight, levelSectorEight, 'h');
		
		//Secteur droite
		int[][] levelSectorNine = {{0,0},{0,2,0},{1,1}};
		int[][] sectorBuilderNine = {{5,5},{10,7,4},{5,5}};
		Sector sectorNine = new Sector(sectorBuilderNine, levelSectorNine, 'i');

		//Gameboard
		List<Sector> temp = new ArrayList<Sector>();
		temp.add(sectorOne);
		temp.add(sectorTwo);
		temp.add(sectorThree);

		temp.add(sectorFour);
		temp.add(sectorFive);
		temp.add(sectorSix);

		temp.add(sectorSeven);
		temp.add(sectorEight);
		temp.add(sectorNine);


		Gameboard gameboard = Gameboard.getInstance();
		gameboard.init(temp);

		gameboard.gameboardSkinBuilder();
		gameboard.displayGameboardSkin();


		/* -_-_-_-_-_-_-_- TESTS -_-_-_-_-_-_-_- */

		//gameboard.skinGameboardBuilder();
		//System.out.println('\r' + gameboard.getGameboardSkin());

	}
		
}
