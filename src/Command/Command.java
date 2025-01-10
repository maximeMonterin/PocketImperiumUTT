package Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import board.Square;
import cards.Expand;
import cards.Explore;
import cards.Exterminate;
import game_engine.Game;
import user.Color;
import user.Player;

public class Command {
    /**
     * Attribut permettant de créer qu'une instance de Scanner pour toute la partie
     */
    public static Scanner scanner = new Scanner(System.in);
    public static String instanceString = "\u001B[34m" + "[PocketImperium]" + "\u001B[0m";
    private static int currentPlayer;
    private static List<String> colors = new ArrayList<>(Arrays.asList("ROUGE", "BLEU", "JAUNE", "VERT"));
    private static List<String> allLevelOneSquarePos = new ArrayList<>();
    private static List<Square> allLevelOneSquareList = new ArrayList<>();
    private static HashMap<Square, String> allLevelOneSquareMap = new HashMap<>();
    private static String position = "";
    private static String squarePositionInGameboard = "";
        
            /**
             * Permet de centraliser les interactions avec l'utilisateur et la gestion d'erreur dans une seule méthode.
             * @param boundInf
             * @param boundSup
             * @param errMessage
             * @return
             */
    public static int askInteger(int boundInf, int boundSup, String errMessage) {
        int ans = -2;
        int i=0;
        while (ans <= boundInf || ans >= boundSup) {
            if (i>0){
                System.out.println(errMessage + ". Resaisissez");
            }
            try {
                ans = scanner.nextInt();
            } catch (Exception e) {
                ans = -2;
                scanner.next();
            }
            i++;
        }
        return ans;
    }
        
    public static String askPlayerName(int player){
                
        System.out.println(Command.instanceString + " Joueur " + player + ", veuillez choisir votre pseudo: ");
        currentPlayer = player;
        String ask = scanner.nextLine();

        return ask;
    }
    
    public static Color askColor(){
        Color color;
        
        System.out.println(Command.instanceString + " Joueur " + currentPlayer + ", veuillez choisir la couleur qui representera votre faction, parmi " + colors + " : ");
        String ask = scanner.nextLine();

        while(!colors.contains(ask.toUpperCase())){
            System.out.println(Command.instanceString + " Joueur " + currentPlayer + ", veuillez une couleur valide ET/OU disponible : ");
            ask = scanner.nextLine();
        }

        colors.remove(ask.toUpperCase());

        switch (ask.toUpperCase()) {
			case "ROUGE":
				color = Color.ROUGE;
				break;
			case "JAUNE" :
                color = Color.JAUNE;
				break;
			case "VERT" :
                color = Color.VERT;
				break;
			case "BLEU" :
                color = Color.BLEU;
			default:
                color = Color.BLEU;
				break;

        }

        return color;

    }

    public static void getLevelOneSquare(){

        //Liste de secteurs
        for(int i = 0; i < Game.gameboard.getSectorList().size(); ++i){
            System.out.println(Game.gameboard.getSectorList().get(i).size());
            //Liste de liste de secteur
            for(int y = 0; y < Game.gameboard.getSectorList().get(i).size(); ++y){
                //Liste des carrés
                for(int x = 0; x < Game.gameboard.getSectorList().get(i).get(y).getHexlist().size(); ++x){
                    //Liste de liste de carré
                    for(int z = 0; z < Game.gameboard.getSectorList().get(i).get(y).getHexlist().get(x).size(); ++z){

                        if(Game.gameboard.getSectorList().get(i).get(y).getHexlist().get(x).get(z).getLevel() == 1){
                            squarePositionInGameboard = String.valueOf(i) + String.valueOf(y) + String.valueOf(x) + String.valueOf(z);
                            allLevelOneSquareList.add(Game.gameboard.getSectorList().get(i).get(y).getHexlist().get(x).get(z));
                            allLevelOneSquareMap.put(Game.gameboard.getSectorList().get(i).get(y).getHexlist().get(x).get(z), squarePositionInGameboard);

                            int line = z + 1;

                            position += Game.gameboard.getSectorList().get(i).get(y).getSectorPosition()+String.valueOf(x+1)+ String.valueOf(line) ;
                            position = String.valueOf(position);

                            allLevelOneSquarePos.add(position);

                            position = "";
                        }
                    }
                }
            }
        }
    }

    public static void setPlayerShips(Player player){

            System.out.println(Command.instanceString + player.getFaction().getColorCode() + " [" + player.getName() + "]" + "\u001B[0m" + ", veuillez choisir un carre que vous souhaitez controler parmi : " + allLevelOneSquarePos.toString());
            String ask = scanner.nextLine();

            while(!allLevelOneSquarePos.contains(ask)){
                System.out.println(Command.instanceString + " Veuillez entrer une autre valeur de carre : ");
                position = "";
                ask = scanner.nextLine();                
            }

            System.out.println(Command.instanceString + " Votre flotte prepare son installation...");

            Square squareTemp = allLevelOneSquareList.get(allLevelOneSquarePos.indexOf(ask));

            for(int i = 0; i < 2; ++i){
                squareTemp.addShipInList(player.getFaction().getShipColor());
            }

            player.getFaction().removeToReserve(2);

            String master = "";
            int indexOfSkin = 3;
            
            if(squareTemp.getSkin().size() == 5){
                indexOfSkin = 4;
            }

            master = squareTemp.getSkin().get(indexOfSkin);

            String target = "      ";
            String replacement = "  " + player.getFaction().getColorCode() + ".." + "\u001B[0m" + "  ";
            String proceed = master.replace(target, replacement);
            squareTemp.getSkin().replace(indexOfSkin, proceed);

            for (int i = allLevelOneSquarePos.size() - 1; i >= 0; i--) {
                if (allLevelOneSquarePos.get(i).charAt(0) == ask.charAt(0)) {
                    allLevelOneSquarePos.remove(i);
                    allLevelOneSquareList.remove(i);
                }
            }

            System.out.println(player.getFaction().getReserve());
            System.out.println(squareTemp.getShipsIn());

            ask = "";
        }

        public static void orderCards(Player player){
            List<Character> charUsed = new ArrayList<>();
            System.out.println(Command.instanceString + player.getFaction().getColorCode() + " [" + player.getName() + "]" + "\u001B[0m" + ", veuillez choisir l'ordre dans lequel vous souhaitez jouer vos cartes, parmi : [1 EXTERMINATE, 2 EXPLORE, 3 EXPAND]" );
            String ask = scanner.nextLine();

            for(final char number : ask.toCharArray()){
                if (charUsed.contains(number)){
                    ask = "";
                } else {
                    charUsed.add(number);
                }
            }

            while (!ask.matches("^[1-3][1-3][1-3]$")) {
                charUsed.clear();
                System.out.println(Command.instanceString + " Veuillez entrer un ordre de carte valide : ");
                ask = scanner.nextLine();
                
                for(final char number : ask.toCharArray()){
                    if (charUsed.contains(number)){
                        ask = "";
                    } else {
                        charUsed.add(number);
                    }
                }
            }

            
            for(final char number : ask.toCharArray()){
                if(number == '1'){
                    player.addCardsToList(new Exterminate());
                }
                if(number == '2'){
                    player.addCardsToList(new Explore());
                }
                if(number == '3'){
                    player.addCardsToList(new Expand());
                }
            }

            System.out.println(Command.instanceString + " Choix enregistre !");

        }

}