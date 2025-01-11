package game_engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import Command.Command;
import board.Gameboard;
import board.Sector;
import cards.Expand;
import cards.Explore;
import user.Color;
import user.Faction;
import user.Player;

public class Game {
	
	private List<Player> players = new ArrayList<Player>();
	public static Gameboard gameboard;
	private int actualRound;
	private int actualDirection;
	
	private static final Game INSTANCE = new Game();
	
	private Game() {}
	
	public static Game getInstance() {
		return INSTANCE;
	}
	
	
	
	/* -_-_-_-_-_-_-_- METHODS -_-_-_-_-_-_-_- */
	
	public void startGame() {

		this.setUpPlayers();

		Collections.shuffle(players);

		Command.getLevelOneSquare();

		for(int i = 0; i < this.players.size(); ++i){
			Command.setPlayerShips(players.get(i));
		}

		gameboard.update();

		for(int i = this.players.size() - 1; i >=0; --i){
			Command.setPlayerShips(players.get(i));
		}

		Game.gameboard.update();

	}

	private void setUpPlayers(){

		/*  INSTANCES  */
		int playerOrder = 1;

		/* CODE */
		System.out.println('\n');
		System.out.println(Command.instanceString + " Bienvenue dans une partie de Pocket Imperium !");

		while(playerOrder < 4){
			String name = Command.askPlayerName(playerOrder);
			Color colorOfPlayer = Command.askColor();
			Player player = new Player(name, new Faction(colorOfPlayer));

			this.getPlayers().add(player);

			++playerOrder;
		}

		String playerList = "";

		for(int i = 0; i < players.size(); ++i){
			playerList += players.get(i).getFaction().getColorCode() + " [" + players.get(i).getName() + "]" + "\u001B[0m";
		}

		this.getGameboard().displayGameboardSkin();

		System.out.println(Command.instanceString + " Joueurs" + playerList + ", bienvenue a vous !");
		System.out.println(Command.instanceString + " Setup de la partie termine, enclanchement de la prochaine phase");
	}
	
	public void playRounds() {
		this.plan();
		this.perform();


		Player tempPlayer = players.get(0);
		players.remove(0);
		players.add(tempPlayer);
	}

	private void plan(){
		for(int i = 0; i < players.size(); ++i){
			Command.orderCards(players.get(i));
		}
	}

	private void cardReveal(int indexCard){

		List<Player> expandList = new ArrayList<>();
		List<Player> exploreList = new ArrayList<>();
		List<Player> exterminateList = new ArrayList<>();

		for(int i = 0; i < players.size(); ++i){
			System.out.println(Command.instanceString + players.get(i).getFaction().getColorCode() + " [" + players.get(i).getName() + "]" + "\u001B[0m" + " Votre premiere carte est : " + players.get(i).getCards().get(indexCard).getName());

			if(players.get(i).getCards().get(indexCard) instanceof Expand){expandList.add(players.get(i));}
			else if(players.get(i).getCards().get(indexCard) instanceof Explore){exploreList.add(players.get(i));}
			else {exterminateList.add(players.get(i));}

		}

		for(int i = 0; i < expandList.size(); ++i){
			expandList.get(i).getCards().get(indexCard).execute(expandList.get(i), expandList.size());
			gameboard.update();
		}

		for(int i = 0; i < exploreList.size(); ++i){
			exploreList.get(i).getCards().get(indexCard).execute(exploreList.get(i), exploreList.size());
			gameboard.update();
		}

		for(int i = 0; i < exterminateList.size(); ++i){
			exterminateList.get(i).getCards().get(indexCard).execute(exterminateList.get(i), exterminateList.size());
			gameboard.update();
		}

	}

	private void perform(){
		for(int i = 0; i < this.players.get(0).getCards().size(); ++i){
			this.cardReveal(i);
		}
	}
	
	public void endGame() {}
	
	//private void cardReveal() {}
	
	public void saveIntoJSON() {}
	
	public void LoadJSON() {}

	public void initializeGameboard(){
				
		/* -_-_-_-_-_-_-_- INSTANCES -_-_-_-_-_-_-_- */

					 /* PREMIERE LIGNE */
		
		//Secteur gauche
		int[][] levelSectorOne = {{2,0},{0,1,0},{0,1}};
		int[][] sectorBuilderOne = {{1,2},{3,7,4},{8,5}};
		Sector sectorOne = new Sector(sectorBuilderOne, levelSectorOne, 'a');

		//Secteur centre
		int[][] levelSectorTwo = {{1,0},{0,1,0},{2,0}};
		int[][] sectorBuilderTwo = {{2,2},{10,7,4},{5,5}};
		Sector sectorTwo = new Sector(sectorBuilderTwo, levelSectorTwo, 'b');

		//Secteur droite
		int[][] levelSectorThree = {{1,1},{0,0,0},{0,2}};
		int[][] sectorBuilderThree = {{2,2},{10,7,4},{5,5}};
		Sector sectorThree = new Sector(sectorBuilderThree, levelSectorThree, 'c');

					 /* DEUXIEME LIGNE */

		//Secteur gauche
		int[][] levelSectorFour = {{0,2,0},{1,0},{0,1,0}};
		int[][] sectorBuilderFour = {{3,7,4},{6,6},{3,7,4}};
		Sector sectorFour = new Sector(sectorBuilderFour, levelSectorFour, 'd');
		
		//Secteur centre
		int[][] levelSectorFive = {{0,3,0},{3,3,3},{0,3,0}};
		int[][] sectorBuilderFive = {{10,11,4},{4,12,3},{10,13,4}};
		Sector triPrimeSector = new Sector(sectorBuilderFive, levelSectorFive, 'e');
		
		//Secteur droite
		int[][] levelSectorSix = {{0,1,0},{0,2},{0,1,0}};
		int[][] sectorBuilderSix = {{10,7,4},{5,5},{10,7,4}};
		Sector sectorSix = new Sector(sectorBuilderSix, levelSectorSix, 'f');

					/* TROISIEME LIGNE */

		//Secteur gauche
		int[][] levelSectorSeven = {{1,1},{0,2,0},{0,0}};
		int[][] sectorBuilderSeven = {{8,5},{3,7,4},{8,5}};
		Sector sectorSeven = new Sector(sectorBuilderSeven, levelSectorSeven, 'g');
		
		//Secteur centre
		int[][] levelSectorEight = {{0,1},{0,2,0},{0,1}};
		int[][] sectorBuilderEight = {{5,5},{10,7,4},{5,5}};
		Sector sectorEight = new Sector(sectorBuilderEight, levelSectorEight, 'h');
		
		//Secteur droite
		int[][] levelSectorNine = {{0,0},{0,2,0},{1,1}};
		int[][] sectorBuilderNine = {{5,5},{10,7,4},{5,5}};
		Sector sectorNine = new Sector(sectorBuilderNine, levelSectorNine, 'i');

		//Gameboard
		List<Sector> temp = new ArrayList<Sector>();
		temp.add(sectorOne);
		temp.add(sectorTwo);
		temp.add(sectorThree);

		temp.add(sectorFour);
		temp.add(triPrimeSector);
		temp.add(sectorSix);

		temp.add(sectorSeven);
		temp.add(sectorEight);
		temp.add(sectorNine);


		gameboard = Gameboard.getInstance();
		gameboard.init(temp);
		gameboard.gameboardSkinBuilder();
	}
	
	
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

	public void setGameboard(Gameboard param) {
		gameboard = param;
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
