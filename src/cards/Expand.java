package cards;

import user.Player;

import Command.Command;
import board.Gameboard;
import board.Square;
public class Expand implements Cards {

	private String cardName = "EXPAND" ;

	@Override
	public void execute(Player player, int instanceOfCard) {
		System.out.println(Command.instanceString + player.getFaction().getColorCode() + " [" + player.getName() + "]" + "\u001B[0m" + " Entrez les coordonnees du carre souhaite parmis : " + player.getFaction().getHexList().toString());
		String ask = Command.scanner.nextLine().replaceAll("\\s+", "");

		while(!player.getFaction().getHexList().contains(ask)){
			System.out.println(Command.instanceString + " Veuillez entrer une coordonnee valide");
			ask = Command.scanner.nextLine().replaceAll("\\s+", "");
		}

		Square square = Gameboard.getHexFromCoordinates(ask);

		int shipsToAddInSquare = 4 - instanceOfCard;

		player.getFaction().removeToReserve(shipsToAddInSquare);
		
		square.addShipInList(shipsToAddInSquare, player);
		
	}

	@Override
	public String getName(){
		return this.cardName;
	}

}
