package it.uniba.app;

public class Board {

    private char boardGame[][];
    private char boardShots[][];
    private int boardSize;
    Board(){
        boardSize = 10;
        this.boardGame = new char[boardSize][boardSize];
        this.boardShots = new char[boardSize][boardSize];
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++) {
                this.boardGame[i][j] = 'v';
                this.boardShots[i][j] = 'v';
            }
        }
    }
    public void generateShipsOnBoard(Ship ship){
        while(ship.getShipsPositioned() < ship.getNrShips()){
            int x = (int) (Math.random() * boardSize);
            int y = (int) (Math.random() * boardSize);
            boolean horizontal = Math.random() < 0.5;
            
            if (canPlaceShip(x, y, horizontal, ship)) {
                placeShip(x, y, horizontal, ship);
                ship.setShipPositioned();
            }
        }
    }

    private boolean canPlaceShip(int x, int y, boolean horizontal, Ship ship) {
        if (horizontal) {
            if (x + ship.getSize() > boardSize) {
                return false;
            }
            else{
                for (int i = x; i < x + ship.getSize(); i++) {
                    if (boardGame[x][i] != 'v') {
                        return false;
                    }
                }
            }

        } 
        else {
            if (y + ship.getSize() > boardSize) {
                return false;
            }
            for (int i = y; i < y + ship.getSize(); i++) {
                if (boardGame[i][y] != 'v') {
                    return false;
                }
            }
        }
        return true;
    }

    private void placeShip(int x, int y, boolean horizontal, Ship ship) {
        int index = 0;
        char column;
        if (horizontal) {
            for (int i = y; i < y + ship.getSize(); i++) {
                boardGame[x][i] = 'n';
                column = convertIntToChar(i);
                ship.setCurrentPosition(column + Integer.toString(x), index);
                index++;
            }
        } 
        else {
            column = convertIntToChar(y);
            for (int i = x; i < x + ship.getSize(); i++) {
                boardGame[i][y] = 'n';
                ship.setCurrentPosition(column + Integer.toString(i), index);
                index++;
            }
        }
    }

    public void showBoardGame(){
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for(int i=0;i<boardSize;i++)
        {
            System.out.print(i+" ");
            for(int j=0;j<boardSize;j++)
            {
                System.out.print(boardGame[i][j]+" ");
            }
            System.out.println();
        }
    }
    // void showBoardShots()
    
    public char convertIntToChar(int val){
        // Metodo ancora non realizzato poiché lo switch non funziona correttamente, da fare quando ci sono gli altri.
        return 'A';
    }   
    
}
