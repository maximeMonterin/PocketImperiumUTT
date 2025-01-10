package cards;

import user.Player;

public class Exterminate implements Cards {

	private String cardName = "EXTERMINATE";

	@Override
	public void execute(Player player, int instanceOfCard) {
		// Implement Execute
	}

	@Override
	public String getName(){
		return this.cardName;
	}

}
