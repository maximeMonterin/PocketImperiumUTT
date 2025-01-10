package cards;

import user.Player;

import Command.Command;
import board.Gameboard;
import board.Square;
import game_engine.Game;

public class Explore implements Cards {

	private String cardName = "EXPLORE";

	@Override
	public void execute(Player player, int instanceOfCard) {

		System.out.println(Command.instanceString + player.getFaction().getColorCode() + " [" + player.getName() + "]" + "\u001B[0m" + " Entrez les coordonnees du carre souhaite parmis : " + player.getFaction().getHexList().toString());
		String ask = Command.scanner.nextLine().replaceAll("\\s+", "");

		while(!player.getFaction().getHexList().contains(ask)){
			System.out.println(Command.instanceString + " Veuillez entrer une coordonnee valide");
			ask = Command.scanner.nextLine().replaceAll("\\s+", "");
		}

		final Square squareOne = Gameboard.getHexFromCoordinates(ask);

		System.out.println(Command.instanceString + player.getFaction().getColorCode() + " [" + player.getName() + "]" + "\u001B[0m" + " Entrez les coordonnees du carre de destination : ");
		String adjAsk = Command.scanner.nextLine().replaceAll("\\s+", "");

		Square squareTwo = Gameboard.getHexFromCoordinates(adjAsk);

		while (!adjAsk.matches("^[a-z][1-3][1-3]$") || (squareTwo.getShipsIn().size() > 0 && squareTwo.getShipsIn().get(0) != player.getFaction().getShipColor())) {
			System.out.println(Command.instanceString + " Veuillez entrer une coordonnee valide");
			adjAsk = Command.scanner.nextLine();

			squareTwo = Gameboard.getHexFromCoordinates(adjAsk);
		}

		System.out.println(Command.instanceString + player.getFaction().getColorCode() + " [" + player.getName() + "]" + "\u001B[0m" + " Entrez le nombre de vaisseau a deplacer : ");
		String askShip = Command.scanner.nextLine().replaceAll("\\s+", "");

		while (!askShip.matches("^[1-" + squareOne.getShipsIn().size() + "]$")) {
			System.out.println(Command.instanceString + " Veuillez entrer un numero de vaisseau valide");
			askShip = Command.scanner.nextLine();
		}

		squareOne.removeShipsInList(Integer.parseInt(askShip), player);
		squareTwo.addShipInList(Integer.parseInt(askShip), player);

		Game.gameboard.update();

	}

	@Override
	public String getName(){
		return this.cardName;
	}

}
