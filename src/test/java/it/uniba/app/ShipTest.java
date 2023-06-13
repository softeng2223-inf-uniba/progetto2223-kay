package it.uniba.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShipTest {
/**
 * Test per la verifica del funzionamento di Set True Hits
 */
    @Test
    public void setTrueHitsTest(){
        Ship sUsed = new Incrociatore();
        Ship sNotUsed = new Incrociatore();
        sUsed.setTrueHits();
        assertNotEquals(sUsed, sNotUsed);
    }

    @Test
    public void isSunkTest(){
        Ship sUsed = new Portaerei();
        for(int i = 0; i < sUsed.getHits().length; i++){
            sUsed.setTrueHits();
        }
        boolean result = sUsed.isSunk();
        assertTrue(result);
    }
}
