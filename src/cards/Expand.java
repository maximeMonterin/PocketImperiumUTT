package cards;

import user.Player;

public class Expand implements Cards {

	private String cardName = "EXPAND" ;

	@Override
	public void execute(Player player, int instanceOfCard) {
		// Implements Expand
	}

	@Override
	public String getName(){
		return this.cardName;
	}

}
