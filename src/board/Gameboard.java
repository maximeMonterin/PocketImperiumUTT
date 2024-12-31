package board;

import java.util.ArrayList;
import java.util.List;


public class Gameboard {
	private List<Sector> sectorList = new ArrayList<Sector>();
	private static final Gameboard INSTANCE = new Gameboard();
	
	private Gameboard() {}
	
	public static Gameboard getInstance() {
		return INSTANCE;
	}
	
	
	/* -_-_-_-_-_-_-_- METHODS -_-_-_-_-_-_-_- */
	
	public void addSectorInList(Sector sector) {
		this.sectorList.add(sector);
	}
	
	
	/* -_-_-_-_-_-_-_- GETTERS & SETTERS -_-_-_-_-_-_-_- */

	public List<Sector> getSectorList() {
		return sectorList;
	}

	public void setSectorList(List<Sector> sectorList) {
		this.sectorList = sectorList;
	}
	
	

}
