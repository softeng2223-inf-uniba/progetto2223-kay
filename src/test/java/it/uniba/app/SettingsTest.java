package it.uniba.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class SettingsTest {

/**
 * Metodo per verificare che la difficoltà sia facile
 */
    @Test
    public void printEasyDifficultyTest(){
        Settings set = new Settings();
        set.modDifficulty(1);
        String dif = set.printDifficulty();
        assertEquals(dif, "Facile");
    }
/**
 * Metodo per verificare che la difficoltà sia media
 */
    @Test
    public void printMediumDifficultyTest(){
        Settings set = new Settings();
        set.modDifficulty(2);
        String dif = set.printDifficulty();
        assertEquals(dif, "Medio");
    }
/**
 * Metodo per verificare che la difficoltà sia difficile
 */
    @Test
    public void printDifficultDifficultyTest(){
        Settings set = new Settings();
        set.modDifficulty(3);
        String dif = set.printDifficulty();
        assertEquals(dif, "Difficile");
    }
    /**
     * Metodo per verificare che la difficoltà sia difficile
     */
    @Test
    public void printCustomDifficultyTest(){
        Settings set = new Settings();
        set.modDifficulty(4);
        String dif = set.printDifficulty();
        assertNotEquals(dif, "Facile");
    }

/**
 * Metodo che testa il metodo per cambiare il tempo massimo di gioco
 */
    @Test
    public void modTimeMaxTest(){
        Settings set = new Settings();
        set.modTimeMax(8);
        assertNotEquals(set.getTimeMax(),8);
    }
}
