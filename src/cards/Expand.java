package cards;

import user.Player;

import java.util.List;

import Command.Command;
import board.Sector;
import board.Square;
import game_engine.Game;

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

		final int indexSector = (int)(ask.charAt(0) - 'a');
		final List<Sector> sectors = Game.gameboard.getSectorList().get(indexSector / 3);
		final Sector sector = sectors.get(indexSector % 3);

		final int row = Integer.parseInt(String.valueOf(ask.charAt(1))) - 1;
		final int column = Integer.parseInt(String.valueOf(ask.charAt(2))) - 1;
		final Square square = sector.getHexlist().get(row).get(column);

		int shipsToAddInSquare = 4 - instanceOfCard;

		player.getFaction().removeToReserve(shipsToAddInSquare);
		
		square.addShipInList(player.getFaction().getShipColor(), shipsToAddInSquare, player);

		Game.gameboard.update();
		
	}

	@Override
	public String getName(){
		return this.cardName;
	}

}
