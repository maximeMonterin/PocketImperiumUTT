package cards;

import user.Player;
import Command.Command;
import board.Gameboard;
import board.Square;

public class Exterminate implements Cards {

	private String cardName = "EXTERMINATE";

	@Override
	public void execute(Player player, int instanceOfCard) {
		System.out.println(Command.instanceString + player.getFaction().getColorCode() + " [" + player.getName() + "]" + "\u001B[0m" + " Entrez les coordonnees du carre de depart : " + player.getFaction().getHexList().toString());
		String ask = Command.scanner.nextLine().replaceAll("\\s+", "");

		while(!player.getFaction().getHexList().contains(ask)){
			System.out.println(Command.instanceString + " Veuillez entrer une coordonnee valide");
			ask = Command.scanner.nextLine().replaceAll("\\s+", "");
		}

		final Square squareOne = Gameboard.getHexFromCoordinates(ask);

		System.out.println(Command.instanceString + player.getFaction().getColorCode() + " [" + player.getName() + "]" + "\u001B[0m" + " Entrez les coordonnees du carre a exterminer : ");
		String extAsk = Command.scanner.nextLine().replaceAll("\\s+", "");

		Square squareTwo = Gameboard.getHexFromCoordinates(extAsk);

		while (!extAsk.matches("^[a-z][1-3][1-3]$") || squareTwo.getShipsIn().size() == 0 || squareTwo.getShipsIn().get(0) == player.getFaction().getShipColor()) {
			System.out.println(Command.instanceString + " Veuillez entrer une coordonnee valide");
			extAsk = Command.scanner.nextLine();

			squareTwo = Gameboard.getHexFromCoordinates(extAsk);
		}

		final int nbShipsToRemove = Math.min(squareOne.getShipsIn().size(), squareTwo.getShipsIn().size());

		final Player playerAttacked = squareTwo.getPlayer();

		squareOne.removeShipsInList(nbShipsToRemove, ask);
		squareTwo.removeShipsInList(nbShipsToRemove, extAsk);

		if(squareOne.getShipsIn().size() == 0 && squareTwo.getShipsIn().size() == 0){
			System.out.printf("%s\u001B[0m Egalite entre les joueurs %s[%s]\u001B[0m et %s[%s]\u001B[0m !%n", Command.instanceString, player.getFaction().getColorCode(), player.getName(), playerAttacked.getFaction().getColorCode(), playerAttacked.getName());
		}
		else if (squareOne.getShipsIn().size() == 0){
			System.out.printf("%s%s [%s]\u001B[0m Vous avez remporte le combat !%n", Command.instanceString, playerAttacked.getFaction().getColorCode(), playerAttacked.getName());
		}
		else {
			System.out.printf("%s%s [%s]\u001B[0m Vous avez remporte le combat !%n", Command.instanceString, player.getFaction().getColorCode(), player.getName());
		}
	}

	@Override
	public String getName(){
		return this.cardName;
	}

}
