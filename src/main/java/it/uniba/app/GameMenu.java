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
 * processa i comandi che vengono inseriti prima che la partita venga avviata.
 */
    private static void processCommandPreGame(final String command, final Settings set) {
        switch (command) {
            //case "/help":
                //displayHelp();
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
            case "/svelagriglia":
                game.getBoard().showBoardGame();
                break;
            //case "/mostranavi":
                //showShips();
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
