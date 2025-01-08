package Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import user.Color;

public class Command {
    /**
     * Attribut permettant de créer qu'une instance de Scanner pour toute la partie
     */
    public static Scanner scanner = new Scanner(System.in);
    public static String instanceString = "\u001B[34m" + "[PocketImperium]" + "\u001B[0m";
    private static int currentPlayer;
    private static List<String> colors = new ArrayList<>(Arrays.asList("Rouge", "Bleu", "Jaune", "Vert"));
        
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
        System.out.println(colors);

        Color color;
        
        System.out.println(Command.instanceString + " Joueur " + currentPlayer + ", veuillez choisir la couleur qui représentera votre faction : ");
        String ask = scanner.nextLine();

        while(!colors.contains(ask)){
            System.out.println(Command.instanceString + " Joueur " + currentPlayer + ", veuillez une couleur valide ET/OU disponible : ");
            ask = scanner.nextLine();
        }

        colors.remove(ask);

        switch (ask) {
			case "Rouge":
				color = Color.ROUGE;
				break;
			case "Jaune" :
                color = Color.JAUNE;
				break;
			case "Vert" :
                color = Color.VERT;
				break;
			case "Bleu" :
                color = Color.BLEU;
			default:
                color = Color.BLEU;
				break;

        }

        return color;

    }

}