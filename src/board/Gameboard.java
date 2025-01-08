package board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gameboard {

	private List<List<Sector>> sectorList = new ArrayList<List<Sector>>();
	private int gameboardLineKey = 1;
	private static List<Sector> tempList = new ArrayList<Sector>();
	private HashMap<Integer, String> gameboardSkin = new HashMap<Integer, String>();
	private static final Gameboard INSTANCE = new Gameboard();
		
	private Gameboard() {}
		
	public static Gameboard getInstance() {
		return INSTANCE;
	}

	public void init(List<Sector> test){
		Gameboard.tempList = test;

		int sectorNumber = test.size();
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
		
	//Méthode qui permet de construire la Map du skin du secteur
	public void gameboardSkinBuilder() {
		
		for(int i = 0; i < this.getSectorList().size(); ++i) {

			gameboardLineStringBuilder(this.getSectorList().get(i));
		} 
			
	}

	//Méthode qui permet de construire chaque ligne du skin du gameboard
	private void gameboardLineStringBuilder(List<Sector> param) {
		
		String line = "";
		int skinKey = 1;
			
		//On crée une boucle while qui permet de parcourir dans l'entiereté les maps des skins des carrés (ayant des id allant de 1 à 5)
		while(skinKey <= 20) {
				
			for(int i = 0; i < param.size(); ++i) {
					
				if(param.get(i).getSectorSkin().get(skinKey) == null) {
					line += "";
				} else {
					line += param.get(i).getSectorSkin().get(skinKey);
				}
			}
				
				/*if(skinKey != sizeSkin + 1) {
					line += '\r';
				}*/

			if(!line.isEmpty()) {
				this.gameboardSkin.put(this.gameboardLineKey, line);
				++this.gameboardLineKey;
			}

			line = "";
			++skinKey;
				
		}
	
	}

	public void displayGameboardSkin(){

		String skin = "";

		for(int i = 1; i <= this.gameboardSkin.size(); ++i){
			skin += this.gameboardSkin.get(i);
			skin += '\n';

		}

		System.out.println('\n' + skin);
	}
			
			
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

	public Map<Integer, String> getGameboardSkin(){
		return this.gameboardSkin;
	}

	public String text(){
		return this.getSectorList().toString();
	}
	
	

}
