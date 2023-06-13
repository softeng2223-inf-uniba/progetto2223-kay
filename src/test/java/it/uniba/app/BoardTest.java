package it.uniba.app;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Classe test della classe Board contenuta nel package main.
 */
class BoardTest {
    private static final int BOARDSIZESTD = 10;
    private static final int BOARDSIZELRG = 18;
    private static final int BOARDSIZEXL = 26;
    private static final int EXAMPLEN4 = 4;
    private static final int EXAMPLEN16 = 16;
    /**
     * Test per la generazione automatica delle navi nella board.
     */
    @Test
    void generateShipOnBoardTest() {
        Board bUsed = new Board(BOARDSIZESTD);
        Board bNotUsed = new Board(BOARDSIZESTD);
        Ship cacciatorpediniere = new Cacciatorpediniere();
        bUsed.generateShipsOnBoard(cacciatorpediniere);
        Ship incrociatore = new Incrociatore();
        bUsed.generateShipsOnBoard(incrociatore);
        Ship corazzata = new Corazzata();
        bUsed.generateShipsOnBoard(corazzata);
        Ship portaerei = new Portaerei();
        bUsed.generateShipsOnBoard(portaerei);
        assertNotEquals(bUsed, bNotUsed);
    }
    /**
     * Test per la generazione automatica delle navi nella board da 18.
     */
    @Test
    void generateShipOnBoardOf18Test() {
        Board bUsed = new Board(BOARDSIZELRG);
        Board bNotUsed = new Board(BOARDSIZELRG);
        Ship cacciatorpediniere = new Cacciatorpediniere();
        bUsed.generateShipsOnBoard(cacciatorpediniere);
        Ship incrociatore = new Incrociatore();
        bUsed.generateShipsOnBoard(incrociatore);
        Ship corazzata = new Corazzata();
        bUsed.generateShipsOnBoard(corazzata);
        Ship portaerei = new Portaerei();
        bUsed.generateShipsOnBoard(portaerei);
        assertNotEquals(bUsed, bNotUsed);
    }
    /**
     * Test per la generazione automatica delle navi nella board da 26.
     */
    @Test
    void generateShipOnBoardOf26Test() {
        Board bUsed = new Board(BOARDSIZEXL);
        Board bNotUsed = new Board(BOARDSIZEXL);
        Ship cacciatorpediniere = new Cacciatorpediniere();
        bUsed.generateShipsOnBoard(cacciatorpediniere);
        Ship incrociatore = new Incrociatore();
        bUsed.generateShipsOnBoard(incrociatore);
        Ship corazzata = new Corazzata();
        bUsed.generateShipsOnBoard(corazzata);
        Ship portaerei = new Portaerei();
        bUsed.generateShipsOnBoard(portaerei);
        assertNotEquals(bUsed, bNotUsed);
    }
    /**
     * Primo test convertitore da int a char.
     */
    @Test
    void convert4ToCharETest() {
        Board bUsed = new Board(BOARDSIZESTD);
        char c = bUsed.convertIntToChar(EXAMPLEN4);
        assertEquals('E', c, "Test fallito!");
    }
    /**
     * Secondo test convertitore da int a char.
     */
    @Test
    void convert16ToCharQTest() {
        Board bUsed = new Board(BOARDSIZESTD);
        char c = bUsed.convertIntToChar(EXAMPLEN16);
        assertEquals('Q', c, "Test fallito!");
    }
    /**
     * Terzo test convertitore da int a char.
     */
    @Test
    void oneShouldNotBeCharDTest() {
        Board bUsed = new Board(BOARDSIZESTD);
        char c = bUsed.convertIntToChar(1);
        assertNotEquals('D', c);
    }
    /**
     * Primo test convertitore da string a int.
     */
    @Test
    void convertETo4Test() {
        Board bUsed = new Board(BOARDSIZESTD);
        int n = bUsed.convertStringToInt("E");
        assertEquals(EXAMPLEN4, n, "Test fallito!");
    }
    /**
     * Secondo test convertitore da string a int.
     */
    @Test
    void convertQTo16Test() {
        Board bUsed = new Board(BOARDSIZESTD);
        int n = bUsed.convertStringToInt("Q");
        assertEquals(EXAMPLEN16, n, "Test fallito!");
    }
    /**
     * Terzo test convertitore da string a int.
     */
    @Test
    void stringDShouldNotBeCharOneTest() {
        Board bUsed = new Board(BOARDSIZESTD);
        int n = bUsed.convertStringToInt("D");
        assertNotEquals(1, n);
    }
    /**
     * Test della modifica del carattere sulla board degli shot quando una qualsiasi nave viene affondata.
     */
    @Test
    void modBoardSunkTest() {
        Board boardShotsUsed = new Board(BOARDSIZESTD);
        Board boardShotsNotUsed = new Board(BOARDSIZESTD);
        Ship caccia = new Cacciatorpediniere();
        boardShotsUsed.generateShipsOnBoard(caccia);
        for (int i = 0; i < caccia.getHits().length; i++) {
            caccia.setTrueHits();
        }
        boardShotsUsed.modBoardSunk(caccia);
        assertNotEquals(boardShotsUsed, boardShotsNotUsed);
    }
}
