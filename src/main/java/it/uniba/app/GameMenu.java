package it.uniba.app;
import java.util.Scanner;
/**
 * Classe che rappresenta il menu di gioco.
 */
final class GameMenu {
    private static final  int CASE1 = 1;
    private static final  int CASE2 = 2;
    private static final  int CASE3 = 3;
    private static Scanner scanner = new Scanner(System.in, "UTF-8");
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
                printMenuPreGame(set);
                break;
            case "/medio":
                set.modDifficulty(CASE2);
                System.out.println("OK, " + set.printDifficulty());
                printMenuPreGame(set);
                break;
            case "/difficile":
                set.modDifficulty(CASE3);
                System.out.println("OK, " + set.printDifficulty());
                printMenuPreGame(set);
                break;
            case "/mostralivello":
                System.out.println(set.printDifficulty());
                System.out.println("[!] Tentativi fallibili: " + set.getFailableShots());
                printMenuPreGame(set);
                break;
            case "/gioca": // in questo case andrà avviata la partita e stampato il menu in game
                //String difficult = "facile";
                //difficult = selectDifficulty();
                Game game = new Game(new Player(), new Board(), set);
                game.shipPlacement();
                printMenuInGame(game);
                break;
            case "/mostranavi":
                showShipsPreGame();
                printMenuPreGame(set);
                break;
            case "/esci":
                System.exit(0);
                break;
            default:
                System.out.println("[!] Comando non valido");
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
                break;
            case "/svelagriglia":
                game.getBoard().showBoardGame();
                printMenuInGame(game);
                break;
            case "/esci":
                System.exit(0);
                break;
            default:
                System.out.println("[!] Comando non valido");
                printMenuInGame(game);
        }

    }

    public static void showShipsPreGame(){
        Ship caccia = new Cacciatorpediniere();
        System.out.println("[*] Il nome della prima nave è: " + caccia.getNameShip());
        System.out.println("[*] Occupa " + caccia.getSize() + " quadrati");
        System.out.println("[*] Ce ne sono " + caccia.getNrShips() + " disponibili");
        Ship incrociatore = new Incrociatore();
        System.out.println("[*] Il nome della seconda nave è: " + incrociatore.getNameShip());
        System.out.println("[*] Occupa " + incrociatore.getSize() + " quadrati");
        System.out.println("[*] Ce ne sono " + incrociatore.getNrShips() + " disponibili");
        Ship corazzata = new Corazzata();
        System.out.println("[*] Il nome della terza nave è: " + corazzata.getNameShip());
        System.out.println("[*] Occupa " + corazzata.getSize() + " quadrati");
        System.out.println("[*] Ce ne sono " + corazzata.getNrShips() + " disponibili");
        Ship portaerei = new Portaerei();
        System.out.println("[*] Il nome della quarta nave è: " + portaerei.getNameShip());
        System.out.println("[*] Occupa " + portaerei.getSize() + " quadrati");
        System.out.println("[*] Ce ne sono " + portaerei.getNrShips() + " disponibili");
    }
/**
 * metodo visualizza, per ogni tipo di nave, la dimensione in quadrati e il numero di esemplari da affondare.
 */
    public static void showShips(final Game game) {
        System.out.println("[*] Il nome della prima nave è: " + game.getCacciatorpediniere().getNameShip());
        System.out.println("[*] Occupa " + game.getCacciatorpediniere().getSize() + " quadrati");
        System.out.println("[*] Ce ne sono " + game.getCacciatorpediniere().getNrShips() + " disponibili");
        System.out.println("[*] Ne sono posizionate "
        + game.getCacciatorpediniere().getShipsPositioned() + " nella griglia");
        System.out.println("[*] Il nome della seconda nave è: " + game.getIncrociatore().getNameShip());
        System.out.println("[*] Occupa " + game.getIncrociatore().getSize() + " quadrati");
        System.out.println("[*] Ce ne sono " + game.getIncrociatore().getNrShips() + " disponibili");
        System.out.println("[*] Ne sono posizionate " + game.getIncrociatore().getShipsPositioned() + " nella griglia");
        System.out.println("[*] Il nome della terza nave è: " + game.getCorazzata().getNameShip());
        System.out.println("[*] Occupa " + game.getCorazzata().getSize() + " quadrati");
        System.out.println("[*] Ce ne sono " + game.getCorazzata().getNrShips() + " disponibili");
        System.out.println("[*] Ne sono posizionate " + game.getCorazzata().getShipsPositioned() + " nella griglia");
        System.out.println("[*] Il nome della quarta nave è: " + game.getPortaerei().getNameShip());
        System.out.println("[*] Occupa " + game.getPortaerei().getSize() + " quadrati");
        System.out.println("[*] Ce ne sono " + game.getPortaerei().getNrShips() + " disponibili");
        System.out.println("[*] Ne sono posizionate " + game.getPortaerei().getShipsPositioned() + " nella griglia");
    }

/**
 * menu che viene stampato al comando /help.
 */
    public static void displayHelp() {
        System.out.println("//Benvenuto nella battaglia navale programmata dal gruppo Kay anno accademico 2022/23,"
        + " \n l'obiettivo del gioco è quello di affondare le navi nemiche entro i tentativi disponibili.//");
        System.out.println("//Comandi disponibili:");
        System.out.println("[*] Imposta la difficoltà facile (solo prima della partita): /facile");
        System.out.println("[*] Imposta la difficoltà medio (solo prima della partita): /medio");
        System.out.println("[*] Imposta la difficoltà difficile (solo prima della partita): /difficile");
        System.out.println("[*] Mostra la difficoltà attuale (solo prima della partita): /mostralivello");
        System.out.println("[*] Avvia partita: /gioca");
        System.out.println("[*] Esci dal gioco: /esci");
        System.out.println("[*] Mostra le navi da abbattare e il loro numero (solo in partita): /mostranavi");
        System.out.println("[*] Svela la griglia di gioco (solo in partita): /svelagriglia");
        System.out.println("[!] Esegui un comando per iniziare: ");
    }
/**
 * metodo main.
 */
    public static void main(final String[] args) {
        printMenuPreGame(new Settings());
    }

}
