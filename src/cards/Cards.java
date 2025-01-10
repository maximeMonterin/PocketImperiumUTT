package cards;

import user.Player;

public interface Cards {
	
	public void execute(Player player, int instanceOfCard);

	public String getName();

}
