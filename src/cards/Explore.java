package cards;

import user.Player;

public class Explore implements Cards {

	private String cardName = "EXPLORE";

	@Override
	public void execute(Player player, int instanceOfCard) {
		// Implement Execute
	}

	@Override
	public String getName(){
		return this.cardName;
	}

}
