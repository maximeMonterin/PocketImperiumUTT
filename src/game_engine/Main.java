package game_engine;

import Command.Command;
import java.util.Comparator;

import user.Player;

public class Main {

	public static void main(String[] args) {

		/* -_-_-_-_-_-_-_- INSTANCES -_-_-_-_-_-_-_- */

		Game game = Game.getInstance();
		game.initializeGameboard();
		game.startGame();
		game.plan();

		for(int i = 1; i <= 8; ++i){
			if(game.endGame()){
				break;
			}
			game.playRounds(i);
			game.countPoints();
		}

		game.countPoints();

		game.getPlayers().sort(Comparator.comparingInt(player -> player.getFaction().getScore()));

		Player winner = game.getPlayers().get(game.getPlayers().size() -1);
		System.out.println(Command.instanceString + " Le gagnant de cette partie est " + winner.getName() + " !");
		
	}
		
}
