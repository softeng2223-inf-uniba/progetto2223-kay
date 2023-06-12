package it.uniba.app;
import java.util.Random;

/**
 * Classe che gestisce la board di TempoGioco.
 */
public class Board {
    private static final int STANDARDSIZE = 10;
    private static final int LARGESIZE = 18;
    private static final int EXTRASIZE = 26;
    private int boardSize;
    private static final double BOOLRAND = 0.5;
    private char[ ][ ] boardGame;
    private char[ ][ ] boardShots;
    private Random ran = new Random();
/**
 * Costruttore della classe Board.
 * Inizializza la boardGame e la boardShots.
 */
    Board(int size) {  
        this.boardSize = size;    
        this.boardGame = new char[boardSize][boardSize];
        this.boardShots = new char[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                this.boardGame[i][j] = 'O';
                this.boardShots[i][j] = 'O';
            }
        }
    }
/**
 * Metodo che resituisce il valore presente alla coordinata x, y.
 */
public char getValue(int x, int y) {
    return boardGame[x][y];
}
/**
 * Metodo che modifica il contenuto della cella x, y (a seguito di un attacco in x,y).
 */
public void modBoard(int x, int y) {
    boardGame[x][y] = 'X';
}
/**
 * Metodo che genera la boardGame.
 */
    public void generateShipsOnBoard(final Ship ship) {
        boolean placed = false;
        while (!placed) {
            int x = ran.nextInt(boardSize);
            int y = ran.nextInt(boardSize);
            boolean horizontal = Math.random() < BOOLRAND;

            if (canPlaceShip(x, y, horizontal, ship)) {
                placeShip(x, y, horizontal, ship);
                placed = true;
            }
        }
    }


/**
 * Metodo che returna un booleano che indica se Ã¨ possibile posizionere la nave in x,y.
 */
    private boolean canPlaceShip(final int x, final int y, final boolean horizontal, final Ship ship) {
        if (horizontal) {
            if (y + ship.getSize() > boardSize) {
                return false;
            } else {
                    for (int i = y; i < y + ship.getSize(); i++) {
                     if (boardGame[x][i] != 'O') {
                         return false;
                    }
                }
            }
        } else {
            if (x + ship.getSize() > boardSize) {
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

        switch(boardSize){
            case STANDARDSIZE:
                System.out.println("  A B C D E F G H I J");
                for (int i = 0; i < boardSize; i++) {
                    System.out.print(i + " ");
                    for (int j = 0; j < boardSize; j++) {
                        System.out.print(boardGame[i][j] + " ");
                    }
                    System.out.println();
                }
                break;
            case LARGESIZE:
                System.out.println("  A B C D E F G H I J K L M N O P Q R");
                for (int i = 0; i < boardSize; i++) {
                    System.out.print(i + " ");
                    for (int j = 0; j < boardSize; j++) {
                        System.out.print(boardGame[i][j] + " ");
                    }
                    System.out.println();
                }
                break;
            case EXTRASIZE:
                System.out.println("  A B C D E F G H I J K L M N O P Q R S T U V W X Y Z");
                for (int i = 0; i < boardSize; i++) {
                    System.out.print(i + " ");
                    for (int j = 0; j < boardSize; j++) {
                        System.out.print(boardGame[i][j] + " ");
                    }
                    System.out.println();
                }
                break;
        }

    }
    // void showBoardShots()
/**
 * Metodo che returna un valore in char in base al valore in int passato.
 */
    public char convertIntToChar(final int val) {
        return (char) ('A' + val );
    }

/**
 * Metodo che returna un valore intero che rappresenta l'ordine in alfabeto del carattere passato in input.
 */
public int convertStringToInt(final String y) {

    char colonna = y.charAt(0);
    int col = colonna - 'A';
    return col;
}
}