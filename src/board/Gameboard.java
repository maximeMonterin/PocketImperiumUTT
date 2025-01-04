package board;

import java.util.ArrayList;
import java.util.List;

public class Gameboard {

	private List<List<Sector>> sectorList = new ArrayList<List<Sector>>();
	private static List<Sector> tempList = new ArrayList<Sector>();
	private String skin = "";
	private static final Gameboard INSTANCE = new Gameboard();
		
	private Gameboard() {}
		
	public static Gameboard getInstance() {
		return INSTANCE;
	}

	public void init(List<Sector> test){
		Gameboard.tempList = test;

		int sectorNumber = 9;
		List<Sector> temp = new ArrayList<Sector>();
	
		for(int i = 0; i < sectorNumber; ++i){
				
			if(i == 3 || i == 6){
				this.getSectorList().add(temp);
				temp = new ArrayList<Sector>();
			}

			temp.add(tempList.get(i));
	
			if(i == sectorNumber - 1){
				this.getSectorList().add(temp);
			}
		}
	}
			
			
			/* -_-_-_-_-_-_-_- METHODS -_-_-_-_-_-_-_- */
		
			/* 
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
					
			}*/
			
			
	/* -_-_-_-_-_-_-_- GETTERS & SETTERS -_-_-_-_-_-_-_- */
		
	public List<List<Sector>> getSectorList() {
		return sectorList;
	}
		
	public void setSectorList(List<List<Sector>> sectorList) {
		this.sectorList = sectorList;
	}
		
	public static void setTempList(List<Sector> test){
		tempList = test;
	}

	public String getGameboardSkin(){
		return this.skin;
	}

	public String text(){
		return this.getSectorList().toString();
	}
	
	

}
