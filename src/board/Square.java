package board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import user.Player;

public class Square {

	private int level;
	private Player player;
	private List<Character> shipsIn = new ArrayList<Character>();
	private HashMap<Integer, String> skin;
	private HashMap<Integer, Character> position = new HashMap<>();
	
	public Square(int level) {this.level = level;}

	
	
	
	
	/* -_-_-_-_-_-_-_- METHODS -_-_-_-_-_-_-_- */
	

	@Override
	public String toString() {
		return "Square [level=" + level + ", shipsIn=" + shipsIn + ", skin=" + skin + "]";
	}

	public Player getPlayer(){
		return this.player;
	}



	public void removeShipsInList(int number, String co){
		for(int i = 0; i < number; ++i){
			this.getShipsIn().remove(this.getShipsIn().size() - 1);
		}

		if(this.getShipsIn().size() == 0){
			this.player.getFaction().getHexList().remove(co);
			player = null;
		}

		this.updateSkin();
	}


	public void addShipInList(int number, Player player) {

		this.player = player;

		for(int i = 0; i < number; ++i){
			this.shipsIn.add(this.player.getFaction().getShipColor());
		}

		this.updateSkin();

	}

	private void updateSkin(){
		String dataToPut = String.valueOf(this.getShipsIn().size());
		if (this.getShipsIn().size() == 0) {
			dataToPut = " ";
		}

		String color = "";

		if(player != null){
			color = this.player.getFaction().getColorCode();
		}


		int indexOfSkin = 3;
		int numberofPipe = 0;
		String replacement = "";

		if(this.getSkin().size() == 5){
			indexOfSkin = 4;
		}

		for(int i = 0; i < this.getSkin().get(indexOfSkin).length(); ++i){
			if(this.getSkin().get(indexOfSkin).charAt(i) == '|'){
				++numberofPipe;
			}
		}

		if(numberofPipe == 2){
			replacement = "|  " + color + dataToPut + "\u001B[0m" + "    |";
		}
		else if(numberofPipe == 1){
			replacement = "  " + color + dataToPut + "\u001B[0m" + "    |";
		}
 		else {
			replacement = "  " + color + dataToPut + "\u001B[0m" + "    ";
		}

		this.getSkin().put(indexOfSkin, replacement);
	}
	
	
	/* -_-_-_-_-_-_-_- GETTERS & SETTERS -_-_-_-_-_-_-_- */
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public List<Character> getShipsIn() {
		return shipsIn;
	}

	public void setShipsIn(List<Character> shipsIn) {
		this.shipsIn = shipsIn;
	}

	public HashMap<Integer, String> getSkin() {
		return skin;
	}

	public void setSkin(HashMap<Integer, String> hashMap) {
		this.skin = hashMap;
	}

	public HashMap<Integer, Character> getPosition() {
		return this.position;
	}
	
}
