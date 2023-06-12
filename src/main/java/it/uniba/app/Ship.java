package it.uniba.app;
import java.util.Arrays;
/**
 * Classe astratta che rappresenta una nave.
 */
public abstract class Ship {
    private String nameShip;
    private int size;
    private String[] currentPosition; // contiene le coordinate della nave, esempio: [A1, A2, A3, A4, A5]
    private boolean[] hits;

/**
 * Costruttore della classe Ship.
 */
    Ship(final String name, final int sze) {
        this.nameShip = name;
        this.size = sze;
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
 * Metodo che returna le coordinate della nave.
 */
    public String[] getCurrentPosition() {
        return this.currentPosition.clone();
    }
/**
 * Metodo che returna se le posizioni della nave sono state colpite o meno.
 */
    public boolean[] getHits() {
        return this.hits.clone();
    }
/**
 * Metodo che setta le coordinate della nave.
 */
    public void setCurrentPosition(final String position, final int i) {
        this.currentPosition[i] = position;
    }
/**
 * Metodo che setta a true una posizione del vettore hits.
 */
public void setTrueHits() {
    for (int i = 0; i<hits.length; i++) {
        if (hits[i] == false) {
            hits[i] = true;
            break;
        }
    }
}
/**
 * Metodo che verifica se una nave è affondata.
 */
public boolean isSunk() {
    for (int i = 0; i<hits.length; i++) {
        if (hits[i] == false) {
            return false;
        }
    }
    return true;
}
}
