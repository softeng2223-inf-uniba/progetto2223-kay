package it.uniba.app;
/**
 * Classe che rappresenta la nave Portaerei.
 */
public class Portaerei extends Ship {
    private static final int SIZEPORTAEREI = 5;
    private static final int NUMPORTAEREI = 1;
    Portaerei() {
        super("Portaerei", SIZEPORTAEREI, NUMPORTAEREI, 0);
    }
}
