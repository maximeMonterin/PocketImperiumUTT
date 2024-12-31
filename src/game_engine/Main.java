package game_engine;

import board.Sector;

public class Main {

	public static void main(String[] args) {

		/*
		 * La création du plateau de jeu se fait par des secteurs, c'est ce qui est écrit dans le pdf de PocketImperium.
		 * Pour créer un secteur, on a besoin d'une liste de liste d'integer. Chaque liste dans la liste représente une ligne d'un secteur.
		 * Un secteur pour rappel est composé de 3 lignes, d'où les 3 listes dans la liste "sectorBuilder" ci-dessous (cf. le pdf de PocketImperium).
		 * Chaque chiffre représente une apparence (appelée skin dans le code, cf utils.SkinManager) qui une fois assemblée (cf. board.Sector.skinSectorBuilder()) correspond à l'apparence d'un secteur.
		 * Un skin est donc un élément graphique, qui dans le code est représentée par une map (cf utils.SkinManager). On choisit ici une map et pas simplement un String car ça simplifie enormément l'affichage dans le terminal.
		 */


		
		//Pour créer un secteur, on utilise une liste de liste de integer qui représentent les skins, c'est comme des lego
		int[][] sectorBuilder = {{1,2},{3,7,4},{8,5}};
		//On passe notre liste en paramètre du constructeur de notre Secteur, qui s'occupera ensuite d'associer les chiffres à de vrais carrés (cf board.Sector.Sector()) 
		Sector mySectorTest = new Sector(sectorBuilder);
		
		//Ensuite, pour chaque carré instancié par le constructeur, on leur associe un skin (en fonction du numéro qui est dans sectorBuilder)
		mySectorTest.addSkinToHex();
		//Et on construie la map du skin du secteur
		mySectorTest.skinSectorBuilder();
		
		System.out.println(mySectorTest.getSectorSkin());

	}
		
		

}
