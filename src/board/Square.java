package board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Square {

	private int level;
	private List<Character> shipsIn = new ArrayList<Character>();
	private HashMap<Integer, String> skin;
	
	public Square() {}

	
	
	
	
	/* -_-_-_-_-_-_-_- METHODS -_-_-_-_-_-_-_- */
	

	@Override
	public String toString() {
		return "Square [level=" + level + ", shipsIn=" + shipsIn + ", skin=" + skin + "]";
	}





	public void addShipInList(char ship) {
		this.shipsIn.add(ship);
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
	
}
