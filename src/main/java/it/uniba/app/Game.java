package it.uniba.app;
import java.util.Timer;
/**
 * Classe che gestisce il gioco TempoGioco.
 */
public class Game {
    private static final int NRCACCIA = 4;
    private static final int NRINCROCIATORE = 3;
    private static final int NRCORAZZATA = 2;
    private static final int NRPORTAEREI = 1;
    private Player player;
    private Board board;
    private int turno;
    private Timer timer;
    private boolean end;
    private int difficulty;
    private Ship[] cacciatorpediniere;
    private Ship[] incrociatore;
    private Ship[] corazzata;
    private Ship[] portaerei;

/**
 * Costruttore della classe Game, per iniare una nuova partita da zero.
 */
    Game(final Player plyr, final Board brd, final Settings set) {
        this.player = plyr;
        this.board = brd;
        this.turno = 0;
        this.timer = new Timer();
        this.end = false;
        this.difficulty = set.getDifficulty();
        this.cacciatorpediniere = new Ship[NRCACCIA];
        this.incrociatore = new Ship[NRINCROCIATORE];
        this.corazzata = new Ship[NRCORAZZATA];
        this.portaerei = new Ship[NRPORTAEREI];
    }
/**
 * Metodo che restituisce il giocatore.
 */
    public Player getPlayer() {
        return this.player;
    }
/**
 * Metodo che restituisce la board.
 */
    public Board getBoard() {
        return this.board;
    }
/**
 * Metodo che restituisce il turno.
 */
    public int getTurno() {
        return this.turno;
    }
/**
 * Metodo che restituisce il timer.
 */
    public Timer getTimer() {
        return this.timer;
    }
/**
 * Metodo che restituisce la variabile end.
 */
    public boolean getEnd() {
        return this.end;
    }
/**
 * Metodo che restituisce la variabile difficulty.
 */
    public int getDifficulty() {
        return difficulty;
    }
/**
 * metodo che restituisce la corazzata.
 */
    public Ship getCorazzata(final int index) {
        return this.cacciatorpediniere[index];
    }
/**
 * metodo che restituisce l'incrociatore.
 */
    public Ship getIncrociatore(final int index) {
        return this.incrociatore[index];
    }
/**
 * metodo che restituisce la portaerei.
 */
    public Ship getPortaerei(final int index) {
        return this.portaerei[index];
    }
/**
 * metodo che restituisce il cacciatorpediniere.
 */
    public Ship getCacciatorpediniere(final int index) {
        return this.cacciatorpediniere[index];
    }

/**
 * Metodo che restituisce il numero di navi corazzata.
 */
    public static int getNrCorazzata() {
        return NRCORAZZATA;
    }
/**
 * Metodo che restituisce il numero di navi incrociatore.
 */
    public static int getNrIncrociatore() {
        return NRINCROCIATORE;
    }
/**
 * Metodo che restituisce il numero di navi portaerei.
 */
    public static int getNrPortaerei() {
        return NRPORTAEREI;
    }
/**
 * Metodo che restituisce il numero di navi cacciatorpediniere.
 */
    public static int getNrCacciatorpediniere() {
        return NRCACCIA;
    }
/**
 * Metodo che setta il campo da gioco andando a caricare le navi, sulla board.
 */
    public void shipPlacement() {
        //Ckecka se ci sono altre partite in corso
        //Genera le navi sul campo di gioco
        for (int i = 0; i < NRCACCIA; i++) {
            this.cacciatorpediniere[i] = new Cacciatorpediniere();
        }
        for (int i = 0; i < NRCORAZZATA; i++) {
            this.corazzata[i] = new Corazzata();
        }
        for (int i = 0; i < NRINCROCIATORE; i++) {
            this.incrociatore[i] = new Incrociatore();
        }
        for (int i = 0; i < NRPORTAEREI; i++) {
            this.portaerei[i] = new Portaerei();
        }
        //Posiziona le navi sul campo di gioco
        for (int i = 0; i < NRCACCIA; i++) {
            this.board.generateShipsOnBoard(cacciatorpediniere[i]); // 4 navi da 2
        }
        for (int i = 0; i < NRCORAZZATA; i++) {
            this.board.generateShipsOnBoard(corazzata[i]); // 2 navi da 4
        }
        for (int i = 0; i < NRINCROCIATORE; i++) {
            this.board.generateShipsOnBoard(incrociatore[i]); // 3 navi da 3
        }
        for (int i = 0; i < NRPORTAEREI; i++) {
            this.board.generateShipsOnBoard(portaerei[i]); // 1 nave da 5
        }
        System.out.println("[!] Le navi sono state posizionate sul campo di gioco");
    }
/**
* Metodo che si occupa di attaccare la boardGame.
*/
    public void attack(final int row, final String col, final Settings set) {
        int line = row - 1;
        int column = board.convertStringToInt(col);
        set.getPlayer().incrementShots();
        if (board.getValue(line, column) == 'O') {
            board.modBoardWater(line, column);
            getBoard().showBoardShots();
            System.out.println("Tentativi effettuati: " + set.getPlayer().getShots());
            System.out.println("Acqua!");
            set.decrementFailableShots();
            set.getPlayer().incrementFailedShots();
        }
        if (board.getValue(line, column) == '|' || board.getValue(line, column) == '-') {
            board.modBoardHit(line, column);
            Ship shipHitted = guessShip(line, column);
            shipHitted.setTrueHits();
            getBoard().showBoardShots();
            if (shipHitted.isSunk()) {
                    System.out.println("Colpita e affondata!");
            } else {
                System.out.println("Colpita!");
            }
            System.out.println("Tentativi effettuati: " + set.getPlayer().getShots());
    }
        if (set.getFailableShots() == 0) {
            System.out.println("Partita terminata. Hai esaurito i tentativi a disposizione :( ");
        }
    }
/**
 * Metodo che scopre quale nava è posizionata in una determinata posizione x, y.
 */
    public Ship guessShip(final int row, final  int col) {
        char column = board.convertIntToChar(col);
        String coordinate = String.valueOf(column).concat(String.valueOf(row));
        for (int i = 0; i < NRCACCIA; i++) {
            String[] posCacciatorpediniere = cacciatorpediniere[i].getCurrentPosition();
            for (int j = 0; j < posCacciatorpediniere.length; j++) {
                if (posCacciatorpediniere[j].equals(coordinate)) {
                    return cacciatorpediniere[i];
                }
            }
        }
        for (int i = 0; i < NRCORAZZATA; i++) {
            String[] posCorazzata = corazzata[i].getCurrentPosition();
            for (int j = 0; j < posCorazzata.length; j++) {
                if (posCorazzata[j].equals(coordinate)) {
                    return corazzata[i];
                }
            }
        }
        for (int i = 0; i < NRPORTAEREI; i++) {
            String[] posPortaerei = portaerei[i].getCurrentPosition();
            for (int j = 0; j < posPortaerei.length; j++) {
                if (posPortaerei[j].equals(coordinate)) {
                    return portaerei[i];
                }
            }
        }
        for (int i = 0; i < NRINCROCIATORE; i++) {
            String[] posIncrociatore = incrociatore[i].getCurrentPosition();
            for (int j = 0; j < posIncrociatore.length; j++) {
                if (posIncrociatore[j].equals(coordinate)) {
                    return incrociatore[i];
                }
            }
        }
        System.out.println("Errore inaspettato!");
        return null;
    }
/**
 * Metodo che restituisce il numero di cacciatorpedinieri disponibili.
 */
    public int getNrAvailableCT() {
        int count = 0;
        for (int i = 0; i < getNrCacciatorpediniere(); i++) {
            if (!(this.getCacciatorpediniere(i).isSunk())) {
                count++;
            }
        }
        return count;
    }
/**
 * Metodo che restituisce il numero di incrociatori disponibili.
 */
    public int getNrAvailableIC() {
        int count = 0;
        for (int i = 0; i < getNrIncrociatore(); i++) {
            if (!(this.getIncrociatore(i).isSunk())) {
                count++;
            }
        }
        return count;
    }
/**
 * Metodo che restituisce il numero di corazzate disponibili.
 */
    public int getNrAvailableCZ() {
        int count = 0;
        for (int i = 0; i < getNrCorazzata(); i++) {
            if (!(this.getCorazzata(i).isSunk())) {
                count++;
            }
        }
        return count;
    }
/**
 * Metodo che restituisce il numero di portaerei disponibili.
 */
    public int getNrAvailablePT() {
        int count = 0;
        for (int i = 0; i < getNrPortaerei(); i++) {
            if (!(this.getPortaerei(i).isSunk())) {
                count++;
            }
        }
        return count;
    }
}
