package it.uniba.app;
import java.util.Arrays;
/**
 * Classe astratta che rappresenta una nave.
 */
public abstract class Ship {
    private String nameShip;
    private int size;
    private int nrShips;
    private int shipsPositioned; //numero di navi posizionate di quella specifica istanza
    private String[] currentPosition; // contiene le coordinate della nave, esempio: [A1, A2, A3, A4, A5]
    private boolean[] hits; 
/**
 * Costruttore della classe Ship.
 */
    Ship(final String name, final int size, final int nr, final int shipsPos) {
        this.nameShip = name;
        this.size = size;
        this.nrShips = nr;
        this.shipsPositioned = shipsPos;
        this.currentPosition = new String[size];
        Arrays.fill(currentPosition, "");
        this.hits = new boolean[size];
        Arrays.fill(hits, false);
    };
/**
 * Metodo che returna il nome della nave.
 */
    public String getNameShip() {
        return this.nameShip;
    }
/**
 * Metodo che returna la dimensione della nave.
 */
    public int getSize() {
        return this.size;
    }
/**
 * Metodo che returna il numero di navi.
 */
    public int getNrShips() {
        return this.nrShips;
    }
/**
 * Metodo che returna il numero di navi posizionate.
 */
    public int getShipsPositioned() {
        return this.shipsPositioned;
    }
/**
 * Metodo che returna le coordinate della nave.
 */
    public String[] getCurrentPosition() {
        return this.currentPosition;
    }
/**
 * Metodo che returna se le posizioni della nave sono state colpite o meno.
 */
    public boolean[] getHits() {
        return this.hits;
    }
/**
 * Metodo che setta le coordinate della nave.
 */
    public void setCurrentPosition(final String position, final int i) {
        this.currentPosition[i] = position;
    }
/**
 * Metodo che incrementa il numero di navi posizionate.
 */
    public void setShipPositioned() {
        this.shipsPositioned++;
    }
}
