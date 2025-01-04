package game_engine;

import java.util.ArrayList;
import java.util.List;

import board.Gameboard;
import board.Sector;

public class Main {

	public static void main(String[] args) {

		/* -_-_-_-_-_-_-_- INSTANCES -_-_-_-_-_-_-_- */

					 /* PREMIERE RANGEE */
		
		//Secteur gauche
		int[][] sectorBuilderOne = {{1,2},{3,7,4},{8,5}};
		Sector sectorLeft = new Sector(sectorBuilderOne);

		//Secteur centre
		int[][] sectorBuilderTwo = {{2,2},{10,7,4},{5,5}};
		Sector sectorMiddle = new Sector(sectorBuilderTwo);

		//Secteur droite
		int[][] sectorBuilderThree = {{2,2},{10,7,4},{5,5}};
		Sector sectorRight = new Sector(sectorBuilderThree);

					 /* DEUXIEME RANGEE */

		//Secteur gauche
		int[][] sectorBuilderFour = {{1,2},{3,7,4},{8,5}};
		Sector sectorFour = new Sector(sectorBuilderFour);
		
		//Secteur centre
		int[][] sectorBuilderFive = {{2,2},{10,7,4},{5,5}};
		Sector sectorFive = new Sector(sectorBuilderFive);
		
		//Secteur droite
		int[][] sectorBuilderSix = {{2,2},{10,7,4},{5,5}};
		Sector sectorSix = new Sector(sectorBuilderSix);

					/* TROISIEME RANGEE */

		//Secteur gauche
		int[][] sectorBuilderSeven = {{1,2},{3,7,4},{8,5}};
		Sector sectorSeven = new Sector(sectorBuilderSeven);
		
		//Secteur centre
		int[][] sectorBuilderEight = {{2,2},{10,7,4},{5,5}};
		Sector sectorEight = new Sector(sectorBuilderEight);
		
		//Secteur droite
		int[][] sectorBuilderNine = {{2,2},{10,7,4},{5,5}};
		Sector sectorNine = new Sector(sectorBuilderNine);

		//Gameboard
		List<Sector> temp = new ArrayList<Sector>();
		temp.add(sectorRight);
		temp.add(sectorMiddle);
		temp.add(sectorLeft);

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
