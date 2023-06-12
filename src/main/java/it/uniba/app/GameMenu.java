package it.uniba.app;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import static it.uniba.app.Game.getNrCacciatorpediniere;
import static it.uniba.app.Game.getNrCorazzata;
import static it.uniba.app.Game.getNrIncrociatore;
import static it.uniba.app.Game.getNrPortaerei;
/**
 * Classe che rappresenta il menu di gioco.
 */
final class GameMenu {
    private static final  int CASE1 = 1;
    private static final  int CASE2 = 2;
    private static final  int CASE3 = 3;
    private static final  int CASE4 = 4;
    private static final  int LOWRANGEEASY = 40;
    private static final  int HIGHRANGEEASY = 60;
    private static final  int LOWRANGEMEDIUM = 20;
    private static final  int HIGHRANGEMEDIUM = 39;
    private static final  int LOWRANGEDIFF = 5;
    private static final  int HIGHRANGEDIFF = 19;
    private static final  int TOMILLISECONDS = 1000;
    private static final  int TOMINUTES = 60;
    private static Scanner scanner = new Scanner(System.in, "UTF-8");
    // Errori Checkstyle non risolti: pattern necessari per il funzionamento del menu
    private static final String regexPre = new String(".*\\d");
    private static final String regexIn = new String("[0-9][0-9]?-[A-Z]");
    private static Timer timer = new Timer();
    private static long startingTime;
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
    private static void printMenuInGame(final Game game, final Settings set) {
        System.out.println("DIGITA /help PER LA LISTA DEI COMANDI");
        String command = scanner.nextLine();
        processCommandInGame(command, game, set);
    }
/**
 * processa i comandi che vengono inseriti prima che la partita venga avviata.
 */
    private static void processCommandPreGame(final String command, final Settings set) {
        int number = 0;
        String regCommand = command;
        Pattern pattern = Pattern.compile(regexPre);
        Matcher matcher = pattern.matcher(command);
        if (matcher.matches()) {
            String numb = new String(findInt(command));
            try {
                number = Integer.parseInt(numb);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
            regCommand = new String(findText(command));
        }
        switch (regCommand) {
            case "/tempo":
                set.modTimeMax(number);
                System.out.println("OK");
                printMenuPreGame(set);
                break;
            case "/help":
                displayHelp();
                printMenuPreGame(set);
                break;
            case "/tentativi":
                if (number == 0) {
                    System.out.println("Il comando /tentativi deve essere seguito da un numero.");
                } else {
                    set.modDifficulty(CASE4);
                    set.setFailableShots(number);
                    System.out.println("OK, " + set.printDifficulty());
                    System.out.println("Tentativi Fallibili: " + set.getFailableShots());
                }
                printMenuPreGame(set);
                break;
            case "/facile":
                if (number >= LOWRANGEEASY && number <= HIGHRANGEEASY) {
                    set.modDifficulty(CASE1);
                    set.setFailableShots(number);
                    System.out.println("OK, " + set.printDifficulty());
                    System.out.println("Tentativi Fallibili: " + set.getFailableShots());
                } else if (number == 0) {
                    set.modDifficulty(CASE1);
                    set.setFailableShotsDefault(CASE1);
                    System.out.println("OK, " + set.printDifficulty());
                    System.out.println("Tentativi Fallibili: " + set.getFailableShots());
                } else {
                    System.out.println("Il numero di tentativi fallibili non rispetta il range [da 40 a 60]");
                }
                printMenuPreGame(set);
                break;
            case "/medio":
                if (number >= LOWRANGEMEDIUM && number <= HIGHRANGEMEDIUM) {
                    set.modDifficulty(CASE2);
                    set.setFailableShots(number);
                    System.out.println("OK, " + set.printDifficulty());
                    System.out.println("Tentativi Fallibili: " + set.getFailableShots());
                } else if (number == 0) {
                    set.modDifficulty(CASE2);
                    set.setFailableShotsDefault(CASE2);
                    System.out.println("OK, " + set.printDifficulty());
                    System.out.println("Tentativi Fallibili: " + set.getFailableShots());
                } else {
                    System.out.println("Il numero di tentativi fallibili non rispetta il range [da 20 a 39]");
                }
                printMenuPreGame(set);
                break;
            case "/difficile":
                if (number >= LOWRANGEDIFF && number <= HIGHRANGEDIFF) {
                    set.modDifficulty(CASE3);
                    set.setFailableShots(number);
                    System.out.println("OK, " + set.printDifficulty());
                    System.out.println("Tentativi Fallibili: " + set.getFailableShots());
                } else if (number == 0) {
                    set.modDifficulty(CASE3);
                    set.setFailableShotsDefault(CASE3);
                    System.out.println("OK, " + set.printDifficulty());
                    System.out.println("Tentativi Fallibili: " + set.getFailableShots());
                } else {
                    System.out.println("Il numero di tentativi fallibili non rispetta il range [da 5 a 19]");
                }
                printMenuPreGame(set);
                break;
            case "/mostralivello":
                System.out.println(set.printDifficulty());
                System.out.println("[!] Tentativi fallibili: " + set.getFailableShots());
                printMenuPreGame(set);
                break;
            case "/standard":
                set.editDimension(command);
                System.out.println("OK dimensione attuale " + set.printDimension() + "x" + set.printDimension());
                printMenuPreGame(set);
                break;
            case "/large":
                set.editDimension(command);
                System.out.println("OK dimensione attuale " + set.printDimension() + "x" + set.printDimension());
                printMenuPreGame(set);
                break;
            case "/extralarge":
                set.editDimension(command);
                System.out.println("OK dimensione attuale " + set.printDimension() + "x" + set.printDimension());
                printMenuPreGame(set);
                break;
            case "/gioca":
                Game game = new Game(new Player(), new Board(set.getBoardSize()), set);
                game.shipPlacement();
                //comincia il timer
                timer.schedule(new TimerTask() {
                    public void run() {
                    System.out.println("\nTempo terminato, partita finita!");
                    timer.cancel();
                    System.exit(0);
                    }
                }, set.getTimeMax() * TOMILLISECONDS);
                startingTime = System.currentTimeMillis();
                System.out.println("AVVISO: Per effettuare un attacco alla griglia bisogna"
                + " digitare il numero della riga '-' lettera di colonna. (Es. 5-B)");
                printMenuInGame(game, set);
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
    private static void processCommandInGame(final String command, final Game game, final Settings set) {

        Pattern pattern = Pattern.compile(regexIn);
        Matcher matcher = pattern.matcher(command);
        String regCommand = command;

        int row = 0;
        String col = "";
        if (matcher.matches()) {
            String nrow = new String(findInt(regCommand));
            try {
                row = Integer.parseInt(nrow);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
            col = new String(extractColumn(regCommand));
            regCommand = new String("/attacco");
        }
        switch (regCommand) {
            case "/mostratempo":
                long elapsedTime = System.currentTimeMillis() - startingTime;
                long elapsedSeconds = elapsedTime / TOMILLISECONDS;
                long secondsDisplay = elapsedSeconds % TOMINUTES;
                long elapsedMinutes = elapsedSeconds / TOMINUTES;
                long availableMinutes;
                long availableSeconds;
                if (secondsDisplay == 0) {
                    availableMinutes = set.getTimeMax() / TOMINUTES - elapsedMinutes;
                    availableSeconds = 0;
                } else {
                    availableMinutes = set.getTimeMax() / TOMINUTES - elapsedMinutes - 1;
                    availableSeconds = TOMINUTES - secondsDisplay;
                }
                System.out.println("Tempo trascorso: " + elapsedMinutes
                + " minuti e " + secondsDisplay + " secondi");
                System.out.println("Tempo disponibile: " + availableMinutes + " minuti e "
                + availableSeconds + " secondi");
                printMenuInGame(game, set);
                break;
            case "/attacco":
                if (set.getFailableShots() > 0) {
                    game.attack(row, col, set);
                }
                printMenuInGame(game, set);
                break;
            case "/help":
                displayHelp();
                printMenuInGame(game, set);
                break;
            case "/mostranavi":
                showShips(game);
                printMenuInGame(game, set);
                break;
            case "/svelagriglia":
                game.getBoard().showBoardGame();
                printMenuInGame(game, set);
                break;
            case "/mostragriglia":
                game.getBoard().showBoardShots();
                printMenuInGame(game, set);
                break;
            case "/abbandona":
                System.out.print("Sei sicuro di voler abbandonare la partita?"
                + " \n-/si per confermare,\n-/no per tornare al gioco\nabbanDigita: ");
                String answer = scanner.nextLine();
                if (answer.equals("/si")) {
                    System.out.println("[!]Partita terminata\n");
                    game.getBoard().showBoardGame();
                    timer.cancel();
                    printMenuPreGame(set);
                } else if (answer.equals("/no")) {
                    printMenuInGame(game, set);
                } else {
                    System.out.println("[!] Comando non valido");
                    printMenuInGame(game, set);
                }
                break;
            case "/mostratentativi":
                System.out.println("--MENU TENTATIVI--");
                System.out.println("Tentativi effettuati: " + set.getPlayer().getShots());
                System.out.println("Tentativi falliti: " + set.getPlayer().getFailedShots());
                System.out.println("Tentativi fallibili rimasti: " + set.getFailableShots());
                printMenuInGame(game, set);
                break;
            case "/esci":
                System.exit(0);
                break;
            default:
                System.out.println("[!] Comando non valido");
                printMenuInGame(game, set);
        }
    }
/**
 * mostra le navi disponibili e le loro caratteristiche.
 */
    public static void showShipsPreGame() {
        Ship caccia = new Cacciatorpediniere();
        System.out.println("[*] Il nome della prima nave è: " + caccia.getNameShip());
        System.out.println("[*] Occupa " + caccia.getSize() + " quadrati");
        System.out.println("[*] Ce ne sono " + getNrCacciatorpediniere() + " disponibili");
        Ship incrociatore = new Incrociatore();
        System.out.println("[*] Il nome della seconda nave è: " + incrociatore.getNameShip());
        System.out.println("[*] Occupa " + incrociatore.getSize() + " quadrati");
        System.out.println("[*] Ce ne sono " + getNrIncrociatore() + " disponibili");
        Ship corazzata = new Corazzata();
        System.out.println("[*] Il nome della terza nave è: " + corazzata.getNameShip());
        System.out.println("[*] Occupa " + corazzata.getSize() + " quadrati");
        System.out.println("[*] Ce ne sono " + getNrCorazzata() + " disponibili");
        Ship portaerei = new Portaerei();
        System.out.println("[*] Il nome della quarta nave è: " + portaerei.getNameShip());
        System.out.println("[*] Occupa " + portaerei.getSize() + " quadrati");
        System.out.println("[*] Ce ne sono " + getNrPortaerei() + " disponibili");
    }
/**
 * metodo visualizza, per ogni tipo di nave, la dimensione in quadrati e il numero di esemplari da affondare.
 */
    public static void showShips(final Game game) {
        System.out.println("[*] Il nome della prima nave è: " + game.getCacciatorpediniere(0).getNameShip());
        System.out.println("[*] Occupa " + game.getCacciatorpediniere(0).getSize() + " quadrati");
        System.out.println("[*] Ce ne sono " + getNrCacciatorpediniere() + " disponibili");
        System.out.println("[*] Ne sono posizionate " + getNrCacciatorpediniere() + " nella griglia");
        System.out.println("[*] Il nome della seconda nave è: " + game.getIncrociatore(0).getNameShip());
        System.out.println("[*] Occupa " + game.getIncrociatore(0).getSize() + " quadrati");
        System.out.println("[*] Ce ne sono " + getNrIncrociatore() + " disponibili");
        System.out.println("[*] Ne sono posizionate " + getNrIncrociatore() + " nella griglia");
        System.out.println("[*] Il nome della terza nave è: " + game.getCorazzata(0).getNameShip());
        System.out.println("[*] Occupa " + game.getCorazzata(0).getSize() + " quadrati");
        System.out.println("[*] Ce ne sono " + getNrCorazzata() + " disponibili");
        System.out.println("[*] Ne sono posizionate " + getNrCorazzata() + " nella griglia");
        System.out.println("[*] Il nome della quarta nave è: " + game.getPortaerei(0).getNameShip());
        System.out.println("[*] Occupa " + game.getPortaerei(0).getSize() + " quadrati");
        System.out.println("[*] Ce ne sono " + getNrPortaerei() + " disponibili");
        System.out.println("[*] Ne sono posizionate " + getNrPortaerei() + " nella griglia");
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
        System.out.println("[*] Modifica la dimensione della board a 10x10(solo prima della partita): /standard");
        System.out.println("[*] Modifica la dimensione della board a 18x18(solo prima della partita): /large");
        System.out.println("[*] Modifica la dimensione della board a 26x26(solo prima della partita): /extralarge");
        System.out.println("[*] Avvia partita: /gioca");
        System.out.println("[*] Esci dal gioco: /esci");
        System.out.println("[*] Mostra le navi da abbattare e il loro numero (solo in partita): /mostranavi");
        System.out.println("[*] Svela la griglia di gioco (solo in partita): /svelagriglia");
        System.out.println("[!] Esegui un comando per iniziare: ");
    }
/**
 * Funzione che prende una stringa in input e ne restituisce una in cui è presente solo la parte numerica.
 */
    static String findInt(final String str) {
        String check  = str;
        check = str.replaceAll("[^\\d]", " ");
        check = str.trim();
        check = str.replaceAll(" +", " ");
        if (check.equals("")) {
            return "-1";
        }
        return check;
    }
/**
 * Funzione che prende una stringa in input e ne restituisce una in cui è presente solo la parte testuale.
 */
    static String findText(final String str) {
        String check  = str;
        check = str.replaceAll("[\\d]", " ");
        check = str.trim();
        check = str.replaceAll(" +", " ");
        if (str.equals("")) {
            return "-1";
        }
        return check;
    }
/**
 * Funzione che prende una stringa in input e restituisce soltanto il carattere dopo il -.
 */
    static String extractColumn(final String str) {
        String check  = str;
        check = str.replaceAll("-", " ");
        check = str.replaceAll("[\\d]", " ");
        check = str.trim();
        check = str.replaceAll(" +", " ");
        if (str.equals("")) {
            return "-1";
        }
        return check;
    }
}
