package it.uniba.app;
import java.util.Scanner;
/**
 * Classe che rappresenta il menu di gioco.
 */
final class GameMenu {
    private static final  int CASE1 = 1;
    private static final  int CASE2 = 2;
    private static final  int CASE3 = 3;
    private static Scanner scanner = new Scanner(System.in);
/**
 * Costruttore della classe GameMenu.
 */
    private GameMenu() { }
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
            case "/help":
                displayHelp();
                printMenuPreGame(set);
                break;
            case "/facile":
                set.modDifficulty(CASE1);
                System.out.println("OK, " + set.printDifficulty());
                break;
            case "/medio":
                set.modDifficulty(CASE2);
                System.out.println("OK, " + set.printDifficulty());
                break;
            case "/difficile":
                set.modDifficulty(CASE3);
                System.out.println("OK, " + set.printDifficulty());
                break;
            case "/mostralivello":
                System.out.println(set.printDifficulty());
                System.out.println("Tentativi fallibili: " + set.getFailableShots());
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
            case "/mostranavi":
                showShips(game);
                printMenuInGame(game);
            case "/svelagriglia":
                game.getBoard().showBoardGame();
                printMenuInGame(game);
                break;
            case "/esci":
                System.exit(0);
                break;
            default:
                System.out.println("Comando non valido");
                printMenuInGame(game);
        }

    }
/**
 * metodo visualizza, per ogni tipo di nave, la dimensione in quadrati e il numero di esemplari da affondare.
 */
    public static void showShips(final Game game) {
        System.out.println("Il nome della quarta nave è: " + game.getCacciatorpediniere().getNameShip());
        System.out.println("Occupa " + game.getCacciatorpediniere().getSize() + " quadrati");
        System.out.println("Ce ne sono " + game.getCacciatorpediniere().getNrShips() + " disponibili");
        System.out.println("Ne sono posizionate "
        + game.getCacciatorpediniere().getShipsPositioned() + " nella griglia");
        System.out.println("Il nome della seconda nave è: " + game.getIncrociatore().getNameShip());
        System.out.println("Occupa " + game.getIncrociatore().getSize() + " quadrati");
        System.out.println("Ce ne sono " + game.getIncrociatore().getNrShips() + " disponibili");
        System.out.println("Ne sono posizionate " + game.getIncrociatore().getShipsPositioned() + " nella griglia");
        System.out.println("Il nome della prima nave è: " + game.getCorazzata().getNameShip());
        System.out.println("Occupa " + game.getCorazzata().getSize() + " quadrati");
        System.out.println("Ce ne sono " + game.getCorazzata().getNrShips() + " disponibili");
        System.out.println("Ne sono posizionate " + game.getCorazzata().getShipsPositioned() + " nella griglia");
        System.out.println("Il nome della terza nave è: " + game.getPortaerei().getNameShip());
        System.out.println("Occupa " + game.getPortaerei().getSize() + " quadrati");
        System.out.println("Ce ne sono " + game.getPortaerei().getNrShips() + " disponibili");
        System.out.println("Ne sono posizionate " + game.getPortaerei().getShipsPositioned() + " nella griglia");
    }

/**
 * menu che viene stampato al comando /help.
 */
    public static void displayHelp() {
        System.out.println("Benvenuto nella battaglia navale programmata dal gruppo Kay."
        + "Lo scopo è quello di vincere la partita abbattendo tutte le navi");
        System.out.println("Qui sotto troverai tutte le funzioni utilizzabili per questo gioco:");
        System.out.println("gioca -> /gioca");
        System.out.println("esci -> /esci");
        System.out.println("mostra la difficoltà -> /mostralivello");
        System.out.println("mostra navi -> /mostranavi");
        System.out.println("svela griglia -> /svelagriglia");
        System.out.println("esegui un comando per iniziare: ");
    }
/**
 * metodo main.
 */
    public static void main(final String[] args) {
        printMenuPreGame(new Settings());
    }

}
