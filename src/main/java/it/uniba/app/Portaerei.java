package it.uniba.app;
/**
 * Classe che rappresenta la nave Portaerei.
 */
public class Portaerei extends Ship {
    private static final int SIZEPORTAEREI = 3;
    private static final int NUMPORTAEREI = 2;
    Portaerei() {
        super("Portaerei", SIZEPORTAEREI, NUMPORTAEREI, 0);
    }
}
