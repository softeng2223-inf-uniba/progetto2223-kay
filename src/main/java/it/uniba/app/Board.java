package it.uniba.app;
public class Board {
    private char[ ][ ] boardGame;
    private char[ ][ ] boardShots;
    private final int boardSize = 10;

    Board() {
        this.boardGame = new char[boardSize][boardSize];
        this.boardShots = new char[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                this.boardGame[i][j] = 'v';
                this.boardShots[i][j] = 'v';
            }
        }
    }
    /*
     * Funzione principale che posiziona le navi (30 slot) sulla boardGame
     */
    public void generateShipsOnBoard(final Ship ship) {
        while (ship.getShipsPositioned() < ship.getNrShips()) {
            int x = (int) (Math.random() * boardSize);
            int y = (int) (Math.random() * boardSize);
            boolean horizontal = Math.random() < 0.5;

            if (canPlaceShip(x, y, horizontal, ship)) {
                placeShip(x, y, horizontal, ship);
                ship.setShipPositioned();
            }
        }
    }
    private boolean canPlaceShip(final int x, final int y, final boolean horizontal, final Ship ship) {
        if (horizontal) {
            if (y + ship.getSize() > boardSize) {
                return false;
            } else {
                    for (int i = y; i < y + ship.getSize(); i++) {
                     if (boardGame[x][i] != 'v') {
                         return false;
                    }
                }
            }
        } else {
            if (x + ship.getSize() > boardSize) {
                return false;
            }
            for (int i = x; i < x + ship.getSize(); i++) {
                if (boardGame[i][y] != 'v') {
                    return false;
                }
            }
        }

        return true;
    }
    private void placeShip(final int x, final int y, final boolean horizontal, final Ship ship) {

        int index = 0;
        char column;
        if (horizontal) {
            for (int i = y; i < y + ship.getSize(); i++) {
                boardGame[x][i] = '1';
                column = convertIntToChar(i);
                ship.setCurrentPosition(column + Integer.toString(x), index);
                index++;
            }
        } else {
                column = convertIntToChar(y);
                for (int i = x; i < x + ship.getSize(); i++) {
                boardGame[i][y] = '1';
                ship.setCurrentPosition(column + Integer.toString(i), index);
                index++;
            }
        }
    }
    public void showBoardGame() {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < boardSize; i++) {
            System.out.print(i+" ");
            for (int j = 0; j<boardSize; j++) {
                System.out.print(boardGame[i][j] + " ");
            }
            System.out.println();
        }
    }
    // void showBoardShots()
    public char convertIntToChar(final int val) {
        switch (val) {
            case 0: return 'A';
            case 1: return 'B';
            case 2: return 'C';
            case 3: return 'D';
            case 4: return 'E';
            case 5: return 'F';
            case 6: return 'G';
            case 7: return 'H';
            case 8: return 'I';
            case 9: return 'L';
            default: return 'M';
        }
    }
}
