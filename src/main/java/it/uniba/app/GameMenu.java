package it.uniba.app;
import java.util.Scanner;
/**
 * Classe che rappresenta il menu di gioco.
 */
public class GameMenu {
    private static Scanner scanner = new Scanner(System.in);
/**
 * Menu che viene stampato solo quando la partita non è ancora iniziata.
 */
    static void printMenuPreGame(final Settings set) {
        System.out.println("| BATTLESHIP |");
        System.out.println("DIGITA /help PER LA LISTA DEI COMANDI");
        String command = scanner.nextLine();
        processCommandPreGame(command, set);
    }
/**
 * menu che viene stampato solo quando la partita è iniziata.
 */
    private static void printMenuInGame(final Game game) {
        System.out.println("DIGITA /help PER LA LISTA DEI COMANDI");
        String command = scanner.nextLine();
        processCommandInGame(command, game);
    }
/**
 * menu che viene stampato al comando /help
 */
    public static void displayHelp(){
        System.out.println("Benvenuto nella battaglia navale programmata dal gruppo Kay anno accademico 2022/23, lo scopo è quello di vincere la partita abbattendo tutte le navi avversarie prima che vengano affondate le tue...");
        System.out.println("Qui sotto troverai tutte le funzioni utilizzabili per questo gioco:");
        System.out.println("/gioca");
        System.out.println("esci");
        System.out.println("mostra livello");
        System.out.println("mostra navi");
        System.out.println("svela griglia");
        System.out.println("esegui un comando per iniziare");
    } 
    
/**
 * processa i comandi che vengono inseriti prima che la partita venga avviata.
 */
    private static void processCommandPreGame(final String command, final Settings set) {
        switch (command) {
            case "/help":
                displayHelp();
                printMenuPreGame(set);
                break;
            //case "/facile":
            //case "/medio":
            //case "/difficile":
            //case "/mostralivello":
            case "/gioca": // in questo case andrà avviata la partita e stampato il menu in game
                //String difficult = "facile";
                //difficult = selectDifficulty();
                Game game = new Game(new Player(), new Board(), set);
                game.shipPlacement();
                printMenuInGame(game);
                break;
            case "/esci":
                System.exit(0);
                break;
            default:
                System.out.println("Comando non valido");
                printMenuPreGame(set);
                break;
        }
    }
/**
 * processa i comandi che vengono inseriti dopo che la partita è stata avviata.
 */
    private static void processCommandInGame(final String command, final Game game) {
        switch (command) {
            case "/help":
                displayHelp();
                printMenuInGame(game);
                break;
            case "/svelagriglia":
                game.getBoard().showBoardGame();
                break;
            //case "/mostranavi":
                //showShips();
            case "/esci":
                System.exit(0);
                break;
            default:
                System.out.println("Comando non valido");
                printMenuInGame(game);
        }

    }
/**
 * metodo main.
 */
    public static void main(final String[] args) {
        printMenuPreGame(new Settings());
    }

}
