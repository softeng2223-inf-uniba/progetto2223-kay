package it.uniba.app;
/**
 * Classe che rappresenta la nave Corazzata.
 */
public class Corazzata extends Ship {
    private static final int SIZECORAZZATA = 4;
    private static final int NUMCORAZZATA = 2;
    Corazzata() {
        super("Corazzata", SIZECORAZZATA, NUMCORAZZATA, 0);
    }
}
