package game_engine;

import java.util.ArrayList;
import java.util.List;

import Command.Command;
import board.Gameboard;
import user.Player;
import java.util.Collections;
import java.util.Iterator;

public class Game {
	
	private List<Player> players = new ArrayList<Player>();
	private Gameboard gameboard;
	private int actualRound;
	private int actualDirection;
	
	private static final Game INSTANCE = new Game();
	
	private Game() {}
	
	public static Game getInstance() {
		return INSTANCE;
	}
	
	
	
	/* -_-_-_-_-_-_-_- METHODS -_-_-_-_-_-_-_- */
	
	public void startGame() {
		Collections.shuffle(this.players);
		Iterator<Player> iter = this.players.iterator();
		while(iter.hasNext()){
			System.out.println("Choisissez un hexagone de niveau 1 inoccupé.");
			Command.askInteger(0, 999, "mauvais hexagone");
		}
	}
	
	public void playRound() {this.cardReveal();}
	
	public void endGame() {}
	
	private void cardReveal() {}
	
	public void saveIntoJSON() {}
	
	public void loadJSON() {}
	
	
	/* -_-_-_-_-_-_-_- GETTERS & SETTERS -_-_-_-_-_-_-_- */
	
	public List<Player> getPlayers() {
		return players;
	}
	
	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Gameboard getGameboard() {
		return gameboard;
	}

	public void setGameboard(Gameboard gameboard) {
		this.gameboard = gameboard;
	}

	public int getActualRound() {
		return actualRound;
	}

	public void setActualRound(int actualRound) {
		this.actualRound = actualRound;
	}

	public int getActualDirection() {
		return actualDirection;
	}

	public void setActualDirection(int actualDirection) {
		this.actualDirection = actualDirection;
	}
	
	
	
}
