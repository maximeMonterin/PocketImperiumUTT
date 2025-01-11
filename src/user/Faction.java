package user;

import java.util.ArrayList;
import java.util.List;

public class Faction {
	
	private int reserve;
	private List<String> hexFactionList = new ArrayList<String>();
	private Color color;
	private char shipColor;
	private String colorCode;
	private int score;
	
	public Faction(Color color) {
		this.color = color;
		this.reserve = 15;

		switch (color) {
			case ROUGE:
				this.colorCode = "\u001B[31m";
				this.shipColor = 'r';
				break;
			case JAUNE :
				this.colorCode = "\u001B[33m";
				this.shipColor = 'j';
				break;
			case VERT :
				this.colorCode = "\u001B[32m";
				this.shipColor = 'v';
				break;
			case BLEU :
				this.colorCode = "\u001B[34m";
				this.shipColor = 'b';
			default:
				break;
		}
	}

	
	
	
	
	/* -_-_-_-_-_-_-_- METHODS -_-_-_-_-_-_-_- */
	
	public void addToReserve(int newShip) {
		this.reserve += newShip;
	}
	
	public void addHexInList(String hex) {
		this.hexFactionList.add(hex);
	}
	

	public void addPoints(int value){
		this.score += value;
	}
	
	
	/* -_-_-_-_-_-_-_- GETTERS & SETTERS -_-_-_-_-_-_-_- */
	
	public int getReserve() {
		return reserve;
	}

	public void setReserve(int reserve) {
		this.reserve = reserve;
	}

	public void removeToReserve(int numberOfShip){
		this.reserve -= numberOfShip;
	}

	public List<String> getHexList() {
		return hexFactionList;
	}

	public void setHexList(List<String> hexList) {
		this.hexFactionList = hexList;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getColorCode(){
		return this.colorCode;
	}

	public char getShipColor(){
		return this.shipColor;
	}
	
}
