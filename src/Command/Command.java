package Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import board.Gameboard;
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
        
        System.out.println(Command.instanceString + " Joueur " + currentPlayer + ", veuillez choisir la couleur qui représentera votre faction, parmi " + colors + " : ");
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

    public static void setPlayerShips(Player player, Gameboard gameboard){
        System.out.println(Command.instanceString + player.getFaction().getColorCode() + " [" + player.getName() + "]" + "\u001B[0m" + ", veuillez choisir un carre que vous souhaitez controler : ");
        String ask = scanner.nextLine();
        String position = "";

        for(int i = 0; i < gameboard.getSectorList().size(); ++i){
            for(int y = 0; y < gameboard.getSectorList().get(i).size(); ++y){
                for(int x = 0; x < gameboard.getSectorList().get(i).get(y).getHexlist().size(); ++x){
                    for(int z = 0; z < gameboard.getSectorList().get(i).get(y).getHexlist().get(x).size(); ++z){

                        int line = z + 1;
                        
                        position += line + gameboard.getSectorList().get(i).get(y).getHexlist().get(x).get(z).getPosition().get(z);

                        while(position != ask && gameboard.getSectorList().get(i).get(y).getHexlist().get(x).get(z).getLevel() != 1){
                            System.out.println(Command.instanceString + player.getFaction().getColorCode() + " [" + player.getName() + "]" + "\u001B[0m" + ", veuillez choisir un carre valide aux criteres demandes : ");
                            ask = scanner.nextLine();
                        }

                        String master = gameboard.getSectorList().get(i).get(y).getHexlist().get(x).get(z).getSkin().get(3);
                        String target = "      ";
                        String replacement = "  ..  ";
                        String proceed = master.replace(target, replacement);
                        gameboard.getSectorList().get(i).get(y).getHexlist().get(x).get(z).getSkin().replace(3, proceed);
                    }
                }
            }
        }
    }

}