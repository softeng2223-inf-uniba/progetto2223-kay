package it.uniba.app;
import java.util.Timer;
//import java.util.TimerTask;

public class Game {

    private Player player;
    private Board board;
    private int turno;
    private Timer timer;
    private boolean end;
    private String difficult;
    //private final int TempoGioco1=5;
    //private final int TempoGioco2=10;
    
    Game(Player player,Board board,String difficult)
    {
        this.player = player;
        this.board = board;
        this.turno = 0;
        this.timer = new Timer();
        this.end = false;
        this.difficult = difficult;
    }

    Game(Player player,Board  board, int turno, Timer timer, boolean end, String difficult)
    {
        this.player = player;
        this.board = board;
        this.turno = turno;
        this.timer = timer;
        this.end = end;
        this.difficult = difficult;        
    }

    public Player getPlayer(){
        return this.player;
    }

    public Board getBoard()
    {
        return this.board;
    }

    public int getTurno()
    {
        return this.turno;
    }

    public Timer getTimer()
    {
        return this.timer;
    }

    public boolean getEnd()
    {
        return this.end;
    }

    public String difficult()
    {
        return this.difficult;
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
        
        
    }
 */
    public void ShipPlacement()
    {
        //Ckecka se ci sono altre partite in corso
        Board campoDiGioco = new Board();
        //Genera le navi sul campo di gioco
        Ship corazzata = new Corazzata();
        Ship incrociatore = new Incrociatore();
        Ship portaerei = new Portaerei();
        Ship cacciatorpediniere = new Cacciatorpediniere();
        //Posiziona le navi sul campo di gioco
        campoDiGioco.generateShipsOnBoard(corazzata); // 2 navi da 4
        campoDiGioco.generateShipsOnBoard(incrociatore); // 3 navi da 3
        campoDiGioco.generateShipsOnBoard(portaerei); // 1 nave da 5
        campoDiGioco.generateShipsOnBoard(cacciatorpediniere); // 4 navi da 2

        System.out.println("[!] Le navi sono state posizionate sul campo di gioco");
        //Mostra il campo di gioco
        campoDiGioco.showBoardGame();
    }

    public static void main(String[] args) {

        Game game = new Game(new Player(), new Board(), "facile");

        game.ShipPlacement();
    }

}