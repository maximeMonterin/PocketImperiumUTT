package board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import utils.SkinManager;

public class Sector {
	
	
	/* -_-_-_-_-_-_-_- ATTRIBUTS -_-_-_-_-_-_-_- */
	
	//Liste contenant les carrés qui composent le secteur
	private List<List<Square>> hexlist = new ArrayList<List<Square>>();
	//Map qui représente l'apparence du secteur
	private HashMap<Integer, String> sectorSkin = new HashMap<Integer, String>();
	//Le tableau d'integer qui permet d'associer aux carrés un skin en fonction des chiffres stockés
	private int[][] sectorBuilder;
	//Int qui sert à la construction de sectorSkin, ça sera la clé associé aux lignes présentent dans la map
	private int sectorLineKey = 1;
	private LinePosition linePosition;
	
	
	/* -_-_-_-_-_-_-_- CONSTRUCTOR -_-_-_-_-_-_-_- */
	
	
	public Sector(int[][] sectorBuilder) {
		this.setSectorBuilder(sectorBuilder);
		
		//On parcours notre liste de liste d'integer 
		for(int i = 0; i < this.getSectorBuilder().length; ++i) {
			
			//Pour chaque liste trouvée dans sectorBuilder, on instancie une liste temporaire qui va stocker nos carrés
			List<Square> tempList = new ArrayList<Square>();
			
			//On parcours ensuite chaque liste présente dans notre liste de liste
			for(int y = 0; y < this.getSectorBuilder()[i].length; ++y) {
				
				//Pour chaque integer trouvé, on instancie un carré et on l'ajoute à notre liste temporaire
				Square hexa = new Square();
				tempList.add(hexa);

				this.addSkinToHex(hexa, this.getSectorBuilder()[i][y]);
			}
			
			//Une fois que le parcours d'une liste est terminé, on ajoute notre liste temporaire dans notre liste de liste de carré
			this.getHexlist().add(tempList);
		}

		//AMELIORATION => Appeler directement this.skinSectorBuilder() à cet endroit (ig ?), pour supprimer l'appel du main
		
		
	}
	
	
	/* -_-_-_-_-_-_-_- METHODS -_-_-_-_-_-_-_- */
	
	
	//Méthode qui permet de construire la Map du skin du secteur
	public void skinSectorBuilder() {
		
		//On parcours notre liste de liste de carré
		for(int i = 0; i < this.getHexlist().size(); ++i) {

			//Pour chaque liste trouvée, on appel this.sectorLineStringBuilder()
			sectorLineStringBuilder(this.getHexlist().get(i));
		} 
			
	}
	
	//Méthode qui permet de construire chaque ligne du skin du secteur
	public void sectorLineStringBuilder(List<Square> param) {
		
		//Variable permettant de stocker le string de la ligne du secteur en cours
		String line = "";
		//Variable qui permet de 
		int skinKey = 1;
		//int sizeSkin = 0;
		
		//On crée une boucle while qui permet de parcourir dans l'entiereté les maps des skins des carrés (ayant des id allant de 1 à 5)
		while(skinKey <= 5) {
			
			//On parcours notre liste de carré donnée en paramètre
			for(int i = 0; i < param.size(); ++i) {
				
				//sizeSkin = param.get(i).getSkin().size();
				
				//Si le carré actuel ne possède pas dans sa map de skin un composant stocké avec l'id courant (en gros si sa map possède 4 lignes et non 5)
				if(param.get(i).getSkin().get(skinKey) == null) {
					//Alors on ajoute rien au string de la ligne courante, le problème c'est que ça va créer une ligne vide dans notre string du coup on l'enlevera un peu après
					line += "";
				} else {
					//Sinon on ajoute le composant du skin stocké sur l'id courant dans notre string de la ligne courante !
					line += param.get(i).getSkin().get(skinKey);
				}
			}
			
			/*if(skinKey != sizeSkin + 1) {
				line += '\r';
			}*/

			//Ensuite on check simplement si la ligne n'est pas vide
			if(!line.isEmpty()) {
				//Et si ce n'est pas le cas alors on ajoute notre ligne dans la map du skin du secteur, et si la ligne est vide on ne le fait pas 
				this.sectorSkin.put(this.sectorLineKey, line);
				//Ici on incrémente la clé de la map, ça permet d'avoir en théorie une infinité de clé et éviter les doublons (qui sont automatiquement supprimé par Java, un peu relou)
				++this.sectorLineKey;
			}

			//Ici on réinitialise le String de la ligne pour la prochaine 
			line = "";
			//Et on passe à la ligne du skin suivant
			++skinKey;
			
		}

	}
	
	//Méthode qui permet d'ajouter des skins aux carrés présents dans this.hexlist
	public void addSkinToHex(Square square, int number) {
		
		//On instancie un objet SkinManager pour avoir accès à la base de données des skins
		SkinManager skinManager = new SkinManager();

		switch(number) {
			case 1:
				square.setSkin(skinManager.getSkinOne());
				break;
			case 2:
				square.setSkin(skinManager.getSkinTwo());
				break;
			case 3:
				square.setSkin(skinManager.getSkinThree());
				break;
			case 4:
				square.setSkin(skinManager.getSkinFour());
				break;
			case 5:
				square.setSkin(skinManager.getSkinFive());
				break;
			case 6:
				square.setSkin(skinManager.getSkinSix());
				break;
			case 7:
				square.setSkin(skinManager.getSkinSeven());
				break;
			case 8:
				square.setSkin(skinManager.getSkinEight());
				break;
		}
	}
	
	
	/* -_-_-_-_-_-_-_- GETTERS & SETTERS -_-_-_-_-_-_-_- */
	

	public LinePosition getLinePosition() {
		return linePosition;
	}

	public void setLinePosition(LinePosition linePosition) {
		this.linePosition = linePosition;
	}

	public int[][] getSectorBuilder() {
		return sectorBuilder;
	}

	public void setSectorBuilder(int[][] sectorBuilder) {
		this.sectorBuilder = sectorBuilder;
	}


	public List<List<Square>> getHexlist() {
		return hexlist;
	}


	public void setHexlist(List<List<Square>> hexlist) {
		this.hexlist = hexlist;
	}


	public HashMap<Integer, String> getSectorSkin() {
		return sectorSkin;
	}


	public void setSectorSkin(HashMap<Integer, String> sectorSkin) {
		this.sectorSkin = sectorSkin;
	}
	
	
	
}
