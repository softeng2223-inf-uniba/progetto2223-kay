package it.uniba.app;
import java.util.Scanner;

public class GameMenu {
    private static Scanner scanner = new Scanner(System.in);


    // menu che viene stampato solo quando la partita non è ancora iniziata
    static void printMenuPreGame(final Settings set) {
        System.out.println("| BATTLESHIP |");
        System.out.println("DIGITA /help PER LA LISTA DEI COMANDI");
        String command = scanner.nextLine();
        processCommandPreGame(command, set);
    }

    // menu che viene stampato solo quando la partita è iniziata
    private static void printMenuInGame(final Game game) {
        System.out.println("DIGITA /help PER LA LISTA DEI COMANDI");
        String command = scanner.nextLine();
        processCommandInGame(command, game);
    }

    // comandi disponibili solo prima che una partita venga avviata
    private static void processCommandPreGame(final String command, final Settings set) {
        switch (command) {
            //case "/help":
                //displayHelp();
            //case "/facile":
            //case "/medio":
            //case "/difficile":
            //case "/mostralivello":
            //case "/gioca": // in questo case andrà avviata la partita e stampato il menu in game
            default:
                System.out.println("Comando non valido");
                printMenuPreGame(set);
                break;
        }
    }

    // comandi disponibili solo dopo che una partita è stata avviata
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

    public static void main(final String[] args) {
        printMenuPreGame(new Settings());
    }

}
