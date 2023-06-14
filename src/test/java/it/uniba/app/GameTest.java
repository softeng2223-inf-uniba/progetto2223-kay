package it.uniba.app;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
/**
 * Classe test della classe Game contenuta nel package main.
 */
class GameTest {
    private static final int BOARDSIZESTD = 10;
    private static final int BOARDSIZELRG = 18;
    private static final int EXAMPLEN3 = 3;
    private static final int EXAMPLEN4 = 4;
    private static final int EXAMPLEN5 = 5;
    /**
     * In questo test vado a creare una board in cui inserisco una sola nave, e un'altra board in cui inserisco
     * tutte le navi. Le vado successivamente a confrontare.
     */
    @Test
    void shipPlacementTest() {
        Board bNotFull = new Board(BOARDSIZESTD);
        Ship corazzata = new Corazzata();
        bNotFull.generateShipsOnBoard(corazzata);
        Board bFull = new Board(BOARDSIZESTD);
        Settings set = new Settings();
        Game g = new Game(bFull, set);
        g.shipPlacement();
        assertNotEquals(bFull, bNotFull);

    }
    /**
     * In questo test vado a creare una board in cui inserisco tre navi (di tipo diverso), e un'altra board in cui
     * inserisco tutte le navi. Le vado successivamente a confrontare.
     */
    @Test
    void shipPlacementTest2() {
        Board bNotFull = new Board(BOARDSIZELRG);
        Ship corazzata = new Corazzata();
        Ship incrociatore = new Incrociatore();
        Ship portaerei = new Portaerei();
        bNotFull.generateShipsOnBoard(corazzata);
        bNotFull.generateShipsOnBoard(incrociatore);
        bNotFull.generateShipsOnBoard(portaerei);
        Board bFull = new Board(BOARDSIZELRG);
        Settings set = new Settings();
        Game g = new Game(bFull, set);
        g.shipPlacement();
        assertNotEquals(bFull, bNotFull);
    }
    /**
     * In questo test vado a controllare che la posizione attaccata nella board dei colpi sia stata effettivamente
     * attaccata.
     */
    @Test
    void attackTest() {
        Board b = new Board(BOARDSIZESTD);
        Settings set = new Settings();
        Game g = new Game(b, set);
        g.shipPlacement();
        g.attack(EXAMPLEN5, "D", set);
        assertNotEquals(g.getBoard().getShotsValue(EXAMPLEN4, EXAMPLEN3), "O");
    }
    /**
     * Metodo per testare il funzionamento generale del metodo guessShip.
     */
    @Test
    void guessShipTest() {
        Ship s;
        Board b = new Board(BOARDSIZESTD);
        Settings set = new Settings();
        Game g = new Game(b, set);
        g.shipPlacement();
        for (int i = 0; i < BOARDSIZESTD; i++) {
            for (int j = 0; j < BOARDSIZESTD; j++) {
                if (g.getBoard().getGameValue(i, j) != 'O') {
                    s = g.guessShip(i, j);
                    assertNotNull(s, "Test fallito!");
                }
            }
        }
    }
    /**
     * Metodo per testare che guessShip trovi una nave Cacciatorpediniere.
     */
    @Test
    void guessCacciatorPediniereTest() {
        Ship caccia = new Cacciatorpediniere();
        Board b = new Board(BOARDSIZESTD);
        Settings set = new Settings();
        Game g = new Game(b, set);
        g.shipPlacement();
        for (int i = 0; i < BOARDSIZESTD; i++) {
            for (int j = 0; j < BOARDSIZESTD; j++) {
                if (g.getBoard().getGameValue(i, j) != 'O') {
                    Ship s = g.guessShip(i, j);
                    if (s.getNameShip() == "Cacciatorpediniere") {
                        assertEquals(caccia.getNameShip(), s.getNameShip(), "Test fallito!");
                    }
                }
            }
        }
    }
    /**
     * Metodo per testare che guessShip trovi una nave Corazzata.
     */
    @Test
    void guessCorazzataTest() {
        Ship corazzata = new Corazzata();
        Board b = new Board(BOARDSIZESTD);
        Settings set = new Settings();
        Game g = new Game(b, set);
        g.shipPlacement();
        for (int i = 0; i < BOARDSIZESTD; i++) {
            for (int j = 0; j < BOARDSIZESTD; j++) {
                if (g.getBoard().getGameValue(i, j) != 'O') {
                    Ship s = g.guessShip(i, j);
                    if (s.getNameShip() == "Corazzata") {
                        assertEquals(corazzata.getNameShip(), s.getNameShip(), "Test fallito!");
                    }
                }
            }
        }
    }
    /**
     * Metodo per testare che guessShip trovi una nave Incrociatore.
     */
    @Test
    void guessIncrociatoreTest() {
        Ship incrociatore = new Incrociatore();
        Board b = new Board(BOARDSIZESTD);
        Settings set = new Settings();
        Game g = new Game(b, set);
        g.shipPlacement();
        for (int i = 0; i < BOARDSIZESTD; i++) {
            for (int j = 0; j < BOARDSIZESTD; j++) {
                if (g.getBoard().getGameValue(i, j) != 'O') {
                    Ship s = g.guessShip(i, j);
                    if (s.getNameShip() == "Incrociatore") {
                        assertEquals(incrociatore.getNameShip(), s.getNameShip(), "Test fallito!");
                    }
                }
            }
        }
    }
    /**
     * Metodo per testare che guessShip trovi una nave Portaerei.
     */
    @Test
    void guessPortaereiTest() {
        Ship portaerei = new Portaerei();
        Board b = new Board(BOARDSIZESTD);
        Settings set = new Settings();
        Game g = new Game(b, set);
        g.shipPlacement();
        for (int i = 0; i < BOARDSIZESTD; i++) {
            for (int j = 0; j < BOARDSIZESTD; j++) {
                if (g.getBoard().getGameValue(i, j) != 'O') {
                    Ship s = g.guessShip(i, j);
                    if (s.getNameShip() == "Portaerei") {
                        assertEquals(portaerei.getNameShip(), s.getNameShip(), "Test fallito!");
                    }
                }
            }
        }
    }
}
