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
		int[][] sectorBuilderOne = {{1,2},{3,7,4},{8,5}};
		Sector sectorOne = new Sector(sectorBuilderOne);

		//Secteur centre
		int[][] sectorBuilderTwo = {{2,2},{10,7,4},{5,5}};
		Sector sectorTwo = new Sector(sectorBuilderTwo);

		//Secteur droite
		int[][] sectorBuilderThree = {{2,2},{10,7,4},{5,5}};
		Sector sectorThree = new Sector(sectorBuilderThree);

					 /* DEUXIEME LIGNE */

		//Secteur gauche
		int[][] sectorBuilderFour = {{3,7,4},{6,6},{3,7,4}};
		Sector sectorFour = new Sector(sectorBuilderFour);
		
		//Secteur centre
		int[][] sectorBuilderFive = {{10,11,4},{4,11,3},{10,7,4}};
		Sector sectorFive = new Sector(sectorBuilderFive);
		
		//Secteur droite
		int[][] sectorBuilderSix = {{10,7,4},{5,5},{10,7,4}};
		Sector sectorSix = new Sector(sectorBuilderSix);

					/* TROISIEME LIGNE */

		//Secteur gauche
		int[][] sectorBuilderSeven = {{8,5},{3,7,4},{8,5}};
		Sector sectorSeven = new Sector(sectorBuilderSeven);
		
		//Secteur centre
		int[][] sectorBuilderEight = {{5,5},{10,7,4},{5,5}};
		Sector sectorEight = new Sector(sectorBuilderEight);
		
		//Secteur droite
		int[][] sectorBuilderNine = {{5,5},{10,7,4},{5,5}};
		Sector sectorNine = new Sector(sectorBuilderNine);

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
