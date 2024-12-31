package board;

import java.util.ArrayList;
import java.util.List;

public class Gameboard {

	private List<Sector> sectorList = new ArrayList<Sector>();
	private String skin = "";
	private static final Gameboard INSTANCE = new Gameboard();
	
	private Gameboard() {}
	
	public static Gameboard getInstance() {
		return INSTANCE;
	}
	
	
	/* -_-_-_-_-_-_-_- METHODS -_-_-_-_-_-_-_- */
	
	public void addSectorInList(Sector sector) {
		this.sectorList.add(sector);
	}

	public void skinGameboardBuilder() {

		int skinKey = 1;
		
		//On crée une boucle while qui permet de parcourir dans l'entiereté les maps des skins des carrés (ayant des id allant de 1 à 5)
		while(skinKey <= 13) {

			for(int i = 0; i < this.getSectorList().size(); ++i) {

				this.skin += this.getSectorList().get(i).getSectorSkin().get(skinKey);

			}

			++skinKey;
			this.skin += '\n';
		}
			
	}
	
	
	/* -_-_-_-_-_-_-_- GETTERS & SETTERS -_-_-_-_-_-_-_- */

	public List<Sector> getSectorList() {
		return sectorList;
	}

	public void setSectorList(List<Sector> sectorList) {
		this.sectorList = sectorList;
	}

	public String getGameboardSkin(){
		return this.skin;
	}
	
	

}
