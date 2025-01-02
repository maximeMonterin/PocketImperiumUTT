package game_engine;

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

		//Gameboard
		Gameboard gameboard = Gameboard.getInstance();
		gameboard.addSectorInList(sectorLeft);
		gameboard.addSectorInList(sectorMiddle);
		gameboard.addSectorInList(sectorRight);


		/* -_-_-_-_-_-_-_- TESTS -_-_-_-_-_-_-_- */

		gameboard.skinGameboardBuilder();
		System.out.println(gameboard.getGameboardSkin());

	}
		
}
