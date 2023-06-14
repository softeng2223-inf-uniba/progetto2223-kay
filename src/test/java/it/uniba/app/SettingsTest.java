package it.uniba.app;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Classe test della classe Settings contenuta nel package main.
 */
class SettingsTest {
    private static final int VALDIFFICILE = 3;
    private static final int VALCUSTOM = 4;
    private static final int EXAMPLEMIN = 8;
    /**
     * Metodo per verificare che la difficoltà sia facile.
     */
    @Test
    void printEasyDifficultyTest() {
        Settings set = new Settings();
        set.modDifficulty(1);
        String dif = set.printDifficulty();
        assertEquals(dif, "Facile", "Test fallito!");
    }
    /**
     * Metodo per verificare che la difficoltà sia media.
     */
    @Test
    void printMediumDifficultyTest() {
        Settings set = new Settings();
        set.modDifficulty(2);
        String dif = set.printDifficulty();
        assertEquals(dif, "Medio", "Test fallito!");
    }
    /**
     * Metodo per verificare che la difficoltà sia difficile.
     */
    @Test
    void printDifficultDifficultyTest() {
        Settings set = new Settings();
        set.modDifficulty(VALDIFFICILE);
        String dif = set.printDifficulty();
        assertEquals(dif, "Difficile", "Test fallito!");
    }
    /**
     * Metodo per verificare che la difficoltà non sia facile.
     */
    @Test
    void notPrintEasyDifficultyTest() {
        Settings set = new Settings();
        set.modDifficulty(VALCUSTOM);
        String dif = set.printDifficulty();
        assertNotEquals(dif, "Facile");
    }
    /**
     * Metodo che testa il metodo per cambiare il tempo massimo di gioco.
     */
    @Test
    void modTimeMaxTest() {
        Settings set = new Settings();
        set.modTimeMax(EXAMPLEMIN);
        assertNotEquals(set.getTimeMax(), EXAMPLEMIN);
    }
}
