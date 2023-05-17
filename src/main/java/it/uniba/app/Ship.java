package it.uniba.app;
import java.util.Arrays;

public abstract class Ship {
    private String nameShip;
    private int size;
    private int nrShips;
    private int shipsPositioned; //numero di navi posizionate di quella specifica istanza 
    private String[] currentPosition; // contiene le coordinate della nave, esempio: [A1, A2, A3, A4, A5]
    private boolean[] hits; // array che è lungo quanto è lunga la nave, e che contiene true se la nave è stata colpita in quella posizione, false altrimenti

    Ship(String name, int size, int nr, int shipsPos) {
        this.nameShip = name;
        this.size = size;
        this.nrShips = nr;
        this.shipsPositioned = shipsPos;
        this.currentPosition = new String[size];
        Arrays.fill(currentPosition, "");
        this.hits = new boolean[size];
        Arrays.fill(hits, false);
    };

    public String getNameShip() {
        return this.nameShip;
    }

    public int getSize() {
        return this.size;
    }

    public int getNrShips() {
        return this.nrShips;
    }   

    public int getShipsPositioned() {
        return this.shipsPositioned;
    }   

    public String[] getCurrentPosition() {
        return this.currentPosition;
    }

    public boolean[] getHits() {
        return this.hits;
    }
    
    public void setCurrentPosition(String position, int i) {
        this.currentPosition[i] = position;
    }

    public void setShipPositioned() {
        this.shipsPositioned++;
    }
}
