package it.uniba.app;
/**
 * &#60; Entity &#62;
 * <p>
 * Classe che rappresenta la nave Corazzata.
 */
public class Corazzata extends Ship {
    private static final int SIZECORAZZATA = 4;
    /**
     * Costruttore della classe Corazzata.
     */
    Corazzata() {
        super("Corazzata", SIZECORAZZATA);
    }
}
