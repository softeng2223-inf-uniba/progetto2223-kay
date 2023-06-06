package it.uniba.app;
import java.util.Random;

/**
 * Classe che gestisce la board di TempoGioco.
 */
public class Board {
    private static final int CASE0 = 0;
    private static final int CASE1 = 1;
    private static final int CASE2 = 2;
    private static final int CASE3 = 3;
    private static final int CASE4 = 4;
    private static final int CASE5 = 5;
    private static final int CASE6 = 6;
    private static final int CASE7 = 7;
    private static final int CASE8 = 8;
    private static final int CASE9 = 9;
    private static final int BOARDSIZE = 10;
    private static final double BOOLRAND = 0.5;
    private char[ ][ ] boardGame;
    private char[ ][ ] boardShots;
    private Random ran = new Random();
/**
 * Costruttore della classe Board.
 * Inizializza la boardGame e la boardShots.
 */
    Board() {
        this.boardGame = new char[BOARDSIZE][BOARDSIZE];
        this.boardShots = new char[BOARDSIZE][BOARDSIZE];
        for (int i = 0; i < BOARDSIZE; i++) {
            for (int j = 0; j < BOARDSIZE; j++) {
                this.boardGame[i][j] = 'O';
                this.boardShots[i][j] = 'O';
            }
        }
    }
/**
 * Metodo che genera la boardGame.
 */
    public void generateShipsOnBoard(final Ship ship) {
        while (ship.getShipsPositioned() < ship.getNrShips()) {
            int x = ran.nextInt(BOARDSIZE);
            int y = ran.nextInt(BOARDSIZE);
            boolean horizontal = Math.random() < BOOLRAND;

            if (canPlaceShip(x, y, horizontal, ship)) {
                placeShip(x, y, horizontal, ship);
                ship.setShipPositioned();
            }
        }
    }
/**
 * Metodo che returna un booleano che indica se è possibile posizionere la nave in x,y.
 */
    private boolean canPlaceShip(final int x, final int y, final boolean horizontal, final Ship ship) {
        if (horizontal) {
            if (y + ship.getSize() > BOARDSIZE) {
                return false;
            } else {
                    for (int i = y; i < y + ship.getSize(); i++) {
                     if (boardGame[x][i] != 'O') {
                         return false;
                    }
                }
            }
        } else {
            if (x + ship.getSize() > BOARDSIZE) {
                return false;
            }
            for (int i = x; i < x + ship.getSize(); i++) {
                if (boardGame[i][y] != 'O') {
                    return false;
                }
            }
        }

        return true;
    }
/**
 *  Metodo che posiziona la nave in x,y.
 */
    private void placeShip(final int x, final int y, final boolean horizontal, final Ship ship) {

        int index = 0;
        char column;
        if (horizontal) {
            for (int i = y; i < y + ship.getSize(); i++) {
                boardGame[x][i] = '-';
                column = convertIntToChar(i);
                ship.setCurrentPosition(column + Integer.toString(x), index);
                index++;
            }
        } else {
                column = convertIntToChar(y);
                for (int i = x; i < x + ship.getSize(); i++) {
                boardGame[i][y] = '|';
                ship.setCurrentPosition(column + Integer.toString(i), index);
                index++;
            }
        }
    }
/**
 * Stampa a video la board di gioco.
 */
    public void showBoardGame() {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < BOARDSIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < BOARDSIZE; j++) {
                System.out.print(boardGame[i][j] + " ");
            }
            System.out.println();
        }
    }
    // void showBoardShots()
/**
 * Metodo che returna un valore in char in base al valore in int passato.
 */
    public char convertIntToChar(final int val) {
        switch (val) {
            case CASE0: return 'A';
            case CASE1: return 'B';
            case CASE2: return 'C';
            case CASE3: return 'D';
            case CASE4: return 'E';
            case CASE5: return 'F';
            case CASE6: return 'G';
            case CASE7: return 'H';
            case CASE8: return 'I';
            case CASE9: return 'L';
            default: return 'M';
        }
    }
}
