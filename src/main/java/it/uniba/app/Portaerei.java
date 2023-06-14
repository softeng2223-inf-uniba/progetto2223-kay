package it.uniba.app;
/**
 * &#60; Entity &#62;
 * <p>
 * Classe che rappresenta la nave Portaerei.
 */
public class Portaerei extends Ship {
    private static final int SIZEPORTAEREI = 5;
    /**
     * Costruttore della classe Portaerei.
     */
    Portaerei() {
        super("Portaerei", SIZEPORTAEREI);
    }
}
