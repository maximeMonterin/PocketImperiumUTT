package user;

import java.util.ArrayList;
import java.util.List;

import cards.Cards;

public class Player {
	
	private String name;
	private boolean isPlayerOne;
	private boolean isIA;
	private List<Cards> cards = new ArrayList<Cards>();
	private Faction faction;
	
	public Player(String name, Faction faction) {
		super();
		this.name = name;
		this.faction = faction;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", factionColor=" + faction.getColor() + "]";
	}
	
	
	
	
	/* -_-_-_-_-_-_-_- METHODS -_-_-_-_-_-_-_- */
	
	public void setup() {}
	
	public List<Cards> selectCards(){
		return this.getCards();
	}
	
	
	
	/* -_-_-_-_-_-_-_- GETTERS & SETTERS -_-_-_-_-_-_-_- */
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPlayerOne() {
		return isPlayerOne;
	}

	public void setPlayerOne(boolean isPlayerOne) {
		this.isPlayerOne = isPlayerOne;
	}

	public boolean isIA() {
		return isIA;
	}

	public void setIA(boolean isIA) {
		this.isIA = isIA;
	}

	public List<Cards> getCards() {
		return cards;
	}

	public void setCards(List<Cards> cards) {
		this.cards = cards;
	}

	public Faction getFaction() {
		return faction;
	}

	public void setFaction(Faction faction) {
		this.faction = faction;
	}

}
