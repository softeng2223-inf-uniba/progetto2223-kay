package it.uniba.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe test della classe Board contenuta nel package main
 */
public class BoardTest {
/**
 * Test per la generazione automatica delle navi nella board.
 */
    @Test
    public void generateShipOnBoardTest(){
        Board bUsed = new Board(10);
        Board bNotUsed = new Board(10);

        Ship cacciatorpediniere = new Cacciatorpediniere();
        bUsed.generateShipsOnBoard(cacciatorpediniere);
        assertNotEquals(bUsed, bNotUsed);

        Ship Incrociatore = new Incrociatore();
        bUsed.generateShipsOnBoard(Incrociatore);
        assertNotEquals(bUsed, bNotUsed);

        Ship Corazzata = new Corazzata();
        bUsed.generateShipsOnBoard(Corazzata);
        assertNotEquals(bUsed, bNotUsed);

        Ship Portaerei = new Portaerei();
        bUsed.generateShipsOnBoard(Portaerei);
        assertNotEquals(bUsed, bNotUsed);
    }
/**
 * Test per la generazione automatica delle navi nella board da 18.
 */
    @Test
    public void generateShipOnBoardOf18Test(){
        Board bUsed = new Board(18);
        Board bNotUsed = new Board(18);

        Ship cacciatorpediniere = new Cacciatorpediniere();
        bUsed.generateShipsOnBoard(cacciatorpediniere);
        assertNotEquals(bUsed, bNotUsed);

        Ship Incrociatore = new Incrociatore();
        bUsed.generateShipsOnBoard(Incrociatore);
        assertNotEquals(bUsed, bNotUsed);

        Ship Corazzata = new Corazzata();
        bUsed.generateShipsOnBoard(Corazzata);
        assertNotEquals(bUsed, bNotUsed);

        Ship Portaerei = new Portaerei();
        bUsed.generateShipsOnBoard(Portaerei);
        assertNotEquals(bUsed, bNotUsed);
    }
/**
 * Test per la generazione automatica delle navi nella board da 26.
 */
    @Test
    public void generateShipOnBoardOf26Test(){
        Board bUsed = new Board(26);
        Board bNotUsed = new Board(26);

        Ship cacciatorpediniere = new Cacciatorpediniere();
        bUsed.generateShipsOnBoard(cacciatorpediniere);
        assertNotEquals(bUsed, bNotUsed);

        Ship Incrociatore = new Incrociatore();
        bUsed.generateShipsOnBoard(Incrociatore);
        assertNotEquals(bUsed, bNotUsed);

        Ship Corazzata = new Corazzata();
        bUsed.generateShipsOnBoard(Corazzata);
        assertNotEquals(bUsed, bNotUsed);

        Ship Portaerei = new Portaerei();
        bUsed.generateShipsOnBoard(Portaerei);
        assertNotEquals(bUsed, bNotUsed);
    }
/**
 * primo Test convertitore da int a char.
 */
    @Test
    public void convert4ToCharETest(){
        Board bUsed = new Board(10);
        char c = bUsed.convertIntToChar(4);
        assertEquals('E', c);
    }
/**
 * secondo Test convertitore da int a char.
 */
    @Test
    public void convert16ToCharQTest(){
        Board bUsed = new Board(10);
        char c = bUsed.convertIntToChar(16);
        assertEquals('Q', c);
    }
/**
 * terzo Test convertitore da int a char.
 */
    @Test
    public void OneShouldNotBeCharDTest(){
        Board bUsed = new Board(10);
        char c = bUsed.convertIntToChar(1);
        assertNotEquals('D', c);
    }
/**
 * primo Test convertitore da string a int.
 */
    @Test
    public void convertETo4Test(){
        Board bUsed = new Board(10);
        int n = bUsed.convertStringToInt("E");
        assertEquals(4,n);
    }
/**
 * secondo Test convertitore da string a int.
 */
    @Test
    public void convertQTo16Test(){
        Board bUsed = new Board(10);
        int n = bUsed.convertStringToInt("Q");
        assertEquals(16,n);
    }
/**
 * terzo Test convertitore da string a int.
 */
    @Test
    public void DShouldNotBeCharOneTest(){
        Board bUsed = new Board(10);
        int n = bUsed.convertStringToInt("D");
        assertNotEquals(1,n);
    }
/**
 * Test della modifica del carattere sulla board degli shot quando una qualsiasi nave viene affondata.
 */
    @Test
    public void modBoardSunkTest(){
        Board boardShotsUsed = new Board(10);
        Board boardShotsNotUsed = new Board(10);
        Ship caccia = new Cacciatorpediniere();
        boardShotsUsed.generateShipsOnBoard(caccia);
        for(int i = 0; i < caccia.getHits().length; i++){
            caccia.setTrueHits();
        }
        boardShotsUsed.modBoardSunk(caccia);
        assertNotEquals(boardShotsUsed,boardShotsNotUsed);
    }
}
