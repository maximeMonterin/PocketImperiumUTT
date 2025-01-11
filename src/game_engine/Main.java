package game_engine;

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
		}
		
	}
		
}
