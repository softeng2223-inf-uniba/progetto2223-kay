package it.uniba.app;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 * Classe test della classe Ship contenuta nel package main.
 */
class ShipTest {
    /**
     * Test per la verifica del funzionamento di SetTrueHits.
     */
    @Test
    void setTrueHitsTest() {
        Ship sUsed = new Incrociatore();
        Ship sNotUsed = new Incrociatore();
        sUsed.setTrueHits();
        assertNotEquals(sUsed, sNotUsed);
    }
    /**
     * Test per la verifica del funzionamento di isSunk.
     */
    @Test
    void isSunkTest() {
        Ship sUsed = new Portaerei();
        for (int i = 0; i < sUsed.getHits().length; i++) {
            sUsed.setTrueHits();
        }
        boolean result = sUsed.isSunk();
        assertTrue(result, "Test fallito!");
    }
}
