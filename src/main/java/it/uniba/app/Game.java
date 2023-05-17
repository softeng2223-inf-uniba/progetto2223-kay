package it.uniba.app;
import java.util.Timer;
//import java.util.TimerTask;

public class Game {

    private Player player;
    private Board board;
    private int turno;
    private Timer timer;
    private boolean end;
    private int difficulty;
    private int failableShots;
    /*
    *scala in base alla difficoltà, per ogni attacco fallito decrementa, se arriva a 0 abbiamo perso
    */
    Game(final Player player, final Board board, final Settings set) {
        this.player = player;
        this.board = board;
        this.turno = 0;
        this.timer = new Timer();
        this.end = false;
        //this.difficulty = set.getDifficulty();
        switch (this.difficulty) {
            case 1:
                this.failableShots = 50;
                break;
            case 2:
                this.failableShots = 30;
                break;
            case 3:
                this.failableShots = 10;
                break;
            default:
                System.out.println("Errore inaspettato, riavvia il gioco");
        }
    }

    Game(final Player player, final Board board, final int turno, final Timer timer, final boolean end, final Settings set) {
        this.player = player;
        this.board = board;
        this.turno = turno;
        this.timer = timer;
        this.end = end;
        //this.difficulty = set.getDifficulty();
        switch (this.difficulty) {
            case 1:
                this.failableShots = 50;
                break;
            case 2:
                this.failableShots = 30;
                break;
            case 3:
                this.failableShots = 10;
                break;
            default:
                System.out.println("Errore inaspettato, riavvia il gioco");
                break;
        }
    }

    public Player getPlayer() {
        return this.player;
    }

    public Board getBoard() {
        return this.board;
    }

    public int getTurno() {
        return this.turno;
    }

    public Timer getTimer() {
        return this.timer;
    }

    public boolean getEnd() {
        return this.end;
    }

    public int getDifficulty() {
        return difficulty;
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
    public void ShipPlacement() {
        //Ckecka se ci sono altre partite in corso
        //Genera le navi sul campo di gioco
        Ship corazzata = new Corazzata();
        Ship incrociatore = new Incrociatore();
        Ship portaerei = new Portaerei();
        Ship cacciatorpediniere = new Cacciatorpediniere();
        //Posiziona le navi sul campo di gioco
        this.board.generateShipsOnBoard(corazzata); // 2 navi da 4
        this.board.generateShipsOnBoard(incrociatore); // 3 navi da 3
        this.board.generateShipsOnBoard(portaerei); // 1 nave da 5
        this.board.generateShipsOnBoard(cacciatorpediniere); // 4 navi da 2

        System.out.println("[!] Le navi sono state posizionate sul campo di gioco");
    }



    public static void main(final String[] args) {

        Game game = new Game(new Player(), new Board(), new Settings());

        game.ShipPlacement();
    }

}
