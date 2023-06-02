package it.uniba.app;
import java.util.Timer;
//import java.util.TimerTask;
/**
 * Classe che rappresenta il gioco.
 */
public class Game {
    private Player player;
    private Board board;
    private int turno;
    private Timer timer;
    private boolean end;
    private int difficulty;
    //private int failableShots;
    private Ship cacciatorpediniere;
    private Ship incrociatore;
    private Ship corazzata;
    private Ship portaerei;
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
        //this.failableShots = set.getFailableShots();
    }
/**
 * Costruttore della classe Game, per continuare una partita salvata in precedenza.
 */
    Game(final Player plyr, final Board brd, final int turn, final Timer tmr,
    final boolean nd, final Settings set) {
        this.player = plyr;
        this.board = brd;
        this.turno = turn;
        this.timer = tmr;
        this.end = nd;
        this.difficulty = set.getDifficulty();
        //this.failableShots = set.getFailableShots();
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
    public Ship getCorazzata() {
        return this.cacciatorpediniere;
    }
/**
 * metodo che restituisce l'incrociatore.
 */
    public Ship getIncrociatore() {
        return this.incrociatore;
    }
/**
 * metodo che restituisce la portaerei.
 */
    public Ship getPortaerei() {
        return this.portaerei;
    }
/**
 * metodo che restituisce il cacciatorpediniere.
 */
    public Ship getCacciatorpediniere() {
        return this.cacciatorpediniere;
    }
/*
    public void TimeSelection(int scelta,Timer timer)
    {
        int secondi;
        if(scelta==1)
        {
            secondi=TempoGioco1*60;
        }
        else
        {
            secondi=TempoGioco1*60;
        }
        this.timer.schedule(new TimerTask()
        {
            public void run()
            {
                System.out.println("Il tempo Ã¨ partito");
                // Dentro qua ci saranno le chiamate a tutti i metodi del gioco
                timer.cancel();

            }
        }, secondi*1000);
    } */
/**
 * Metodo che setta il campo da gioco andando a caricare le navi, sulla board.
 */
    public void shipPlacement() {
        //Ckecka se ci sono altre partite in corso
        //Genera le navi sul campo di gioco
        this.cacciatorpediniere = new Cacciatorpediniere();
        this.incrociatore = new Incrociatore();
        this.corazzata = new Corazzata();
        this.portaerei = new Portaerei();
        //Posiziona le navi sul campo di gioco
        this.board.generateShipsOnBoard(cacciatorpediniere); // 4 navi da 2
        this.board.generateShipsOnBoard(incrociatore); // 3 navi da 3
        this.board.generateShipsOnBoard(corazzata); // 2 navi da 4
        this.board.generateShipsOnBoard(portaerei); // 1 nave da 5
        System.out.println("[!] Le navi sono state posizionate sul campo di gioco");
    }
}
