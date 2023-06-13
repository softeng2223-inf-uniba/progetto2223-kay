package it.uniba.app;
import java.util.Random;
import static it.uniba.app.GameMenu.findInt;
import static it.uniba.app.GameMenu.findText;;
/**
 * &#60; Entity &#62;
 * <p>
 * Classe che gestisce la board di TempoGioco.
 */
public class Board {
    private static final int CASE8 = 8;
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
    Board(final int size) {
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
 * Metodo che resituisce il valore presente alla coordinata x, y della boardGame.
 *
 * @param x             variabile contenente la coordinata della riga
 * @param y             variabile contenente la coordinata della colonna
 */
    public char getGameValue(final int x, final int y) {
        return boardGame[x][y];
    }
/**
 * Metodo che resituisce il valore presente alla coordinata x, y della boardGame.
 *
 * @param x             variabile contenente la coordinata della riga
 * @param y             variabile contenente la coordinata della colonna
 */
    public char getShotsValue(final int x, final int y) {
        return boardShots[x][y];
    }
/**
 * Metodo che modifica il contenuto della cella x, y (a seguito di un attacco in x,y).
 *
 * @param x             variabile contenente la coordinata della riga
 * @param y             variabile contenente la coordinata della colonna
 */
    public void modBoardHit(final int x, final int y) {
        boardShots[x][y] = 'X';
    }
/**
 * Metodo che modifica il contenuto della cella x, y (a seguito di un attacco in x,y).
 *
 * @param x             variabile contenente la coordinata della riga
 * @param y             variabile contenente la coordinata della colonna
 */
    public void modBoardWater(final int x, final int y) {
        boardShots[x][y] = 'W';
    }
/**
 * Metodo che posiziona una nave sulla board.
 *
 * @param ship          oggetto contenente la nave da posizionare
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
 * Metodo che returna un booleano che indica se è possibile posizionere la nave in x,y.
 *
 * @param x             variabile contenente la coordinata della riga
 * @param y             variabile contenente la coordinata della colonna
 * @param horizontal    variabile che indica se una nave è orizzontale o meno
 * @param ship          oggetto contenente la nave da posizionare
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
 * Metodo che posiziona la nave in x,y.
 *
 * @param x             variabile contenente la coordinata della riga
 * @param y             variabile contenente la coordinata della colonna
 * @param horizontal    variabile che indica se una nave è orizzontale o meno
 * @param ship          oggetto contenente la nave da posizionare
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
        System.out.println();
        switch (boardSize) {
            case STANDARDSIZE:
                System.out.println("   A B C D E F G H I J");
                for (int i = 0; i < boardSize; i++) {
                    if (i > CASE8) {
                        System.out.print((i + 1) + " ");
                    } else {
                        System.out.print((i + 1) + "  ");
                    }
                    for (int j = 0; j < boardSize; j++) {
                        System.out.print(boardGame[i][j] + " ");
                    }
                    System.out.println();
                }
                break;
            case LARGESIZE:
                System.out.println("   A B C D E F G H I J K L M N O P Q R");
                for (int i = 0; i < boardSize; i++) {
                    if (i > CASE8) {
                        System.out.print((i + 1) + " ");
                    } else {
                        System.out.print((i + 1) + "  ");
                    }
                    for (int j = 0; j < boardSize; j++) {
                        System.out.print(boardGame[i][j] + " ");
                    }
                    System.out.println();
                }
                break;
            case EXTRASIZE:
                System.out.println("   A B C D E F G H I J K L M N O P Q R S T U V W X Y Z");
                for (int i = 0; i < boardSize; i++) {
                    if (i > CASE8) {
                        System.out.print((i + 1) + " ");
                    } else {
                        System.out.print((i + 1) + "  ");
                    }
                    for (int j = 0; j < boardSize; j++) {
                        System.out.print(boardGame[i][j] + " ");
                    }
                    System.out.println();
                }
                break;
            default:
                System.out.println("Errore nella stampa della board");
                break;
        }
        System.out.println();
    }
/**
 * Metodo che stampa a video la board con navi colpite o affondate.
 */
    public void showBoardShots() {
        System.out.println();
        switch (boardSize) {
            case STANDARDSIZE:
                System.out.println("   A B C D E F G H I J");
                for (int i = 0; i < boardSize; i++) {
                    if (i > CASE8) {
                        System.out.print((i + 1) + " ");
                    } else {
                        System.out.print((i + 1) + "  ");
                    }
                    for (int j = 0; j < boardSize; j++) {
                        System.out.print(boardShots[i][j] + " ");
                    }
                    System.out.println();
                }
                break;
            case LARGESIZE:
                System.out.println("   A B C D E F G H I J K L M N O P Q R");
                for (int i = 0; i < boardSize; i++) {
                   if (i > CASE8) {
                        System.out.print((i + 1) + " ");
                    } else {
                        System.out.print((i + 1) + "  ");
                    }
                    for (int j = 0; j < boardSize; j++) {
                        System.out.print(boardShots[i][j] + "  ");
                    }
                    System.out.println();
                }
                break;
            case EXTRASIZE:
                System.out.println("   A B C D E F G H I J K L M N O P Q R S T U V W X Y Z");
                for (int i = 0; i < boardSize; i++) {
                    if (i > CASE8) {
                        System.out.print((i + 1) + " ");
                    } else {
                        System.out.print((i + 1) + "  ");
                    }
                    for (int j = 0; j < boardSize; j++) {
                        System.out.print(boardShots[i][j] + " ");
                    }
                    System.out.println();
                }
                break;
            default:
                System.out.println("Errore nella stampa della board");
        }
        System.out.println();
    }
/**
 * Metodo che returna un valore in char in base al valore in int passato.
 */
    public char convertIntToChar(final int val) {
        return (char) ('A' + val);
    }
/**
 * Metodo che returna un valore intero che rappresenta l'ordine in alfabeto del carattere passato in input.
 */
    public int convertStringToInt(final String y) {
        char colonna = y.charAt(0);
        int col = colonna - 'A';
        return col;
    }
/**
 * Metodo che cambia i caratteri sulla boardShots di una nave affondata da X a S.
 *
 * @param ship          oggetto che contiene la nave di cui cambiare i caratteri
 */
    public void modBoardSunk(final Ship ship) {
        String[] posToChange = ship.getCurrentPosition();
        for (int i = 0; i < posToChange.length; i++) {
            String line = findInt(posToChange[i]);
            String column = findText(posToChange[i]);
            int row = 0;
            try {
                row = Integer.parseInt(line);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
            int col = convertStringToInt(column);
            boardShots[row][col] = 'S';
        }
    }
}
