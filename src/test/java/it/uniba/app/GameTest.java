package it.uniba.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
/**
 * In questo test vado a creare una board in cui inserisco una sola nave, e un'altra board in cui inserisco
 * tutte le navi. Le vado successivamente a confrontare.
 */
    @Test
    public void shipPlacementTest(){
        Board bNotFull = new Board(10);
        Ship Corazzata = new Corazzata();
        bNotFull.generateShipsOnBoard(Corazzata);

        Board bFull = new Board(10);
        Settings set = new Settings();

        Game g = new Game(bFull, set);
        g.shipPlacement();

        assertNotEquals(bFull,bNotFull);

    }

/**
 * In questo test vado a creare una board in cui inserisco tre navi (di tipo diverso), e un'altra board in cui inserisco
 * tutte le navi. Le vado successivamente a confrontare.
 */
    @Test
    public void shipPlacementTest2(){
        Board bNotFull = new Board(18);
        Ship Corazzata = new Corazzata();
        Ship Incrociatore = new Incrociatore();
        Ship Portaerei = new Portaerei();
        bNotFull.generateShipsOnBoard(Corazzata);
        bNotFull.generateShipsOnBoard(Incrociatore);
        bNotFull.generateShipsOnBoard(Portaerei);

        Board bFull = new Board(18);
        Settings set = new Settings();

        Game g = new Game(bFull, set);
        g.shipPlacement();

        assertNotEquals(bFull,bNotFull);
    }

/**
 * In questo test vado a controllare che la posizione attaccata nella board dei colpi sia stata effettivamente
 * attaccata.
 */
    @Test
    public void attackTest(){
        Board b = new Board(10);
        Settings set = new Settings();
        Game g = new Game(b, set);
        g.shipPlacement();
        g.attack(5,"D", set);
        assertNotEquals(g.getBoard().getShotsValue(4,3), "O");
    }

/**
 * Metodo per testare il funzionamento generale del metodo guessShip
 */
    @Test
    public void guessShipTest(){
        Ship s;
        Board b = new Board(10);
        Settings set = new Settings();
        Game g = new Game(b, set);
        g.shipPlacement();

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(g.getBoard().getGameValue(i, j) != 'O'){
                    s = g.guessShip(i,j);
                    assertNotNull(s);
                }
            }
        }
    }
/**
 * Metodo per testare che guessShip trovi una nave Cacciatorpediniere
 */
    @Test
    public void guessCacciatorPediniereTest(){
        Ship caccia = new Cacciatorpediniere();

        Board b = new Board(10);
        Settings set = new Settings();
        Game g = new Game(b, set);
        g.shipPlacement();
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(g.getBoard().getGameValue(i, j) != 'O'){
                    Ship s = g.guessShip(i,j);
                    if(s.getNameShip() == "Cacciatorpediniere"){
                        assertEquals(caccia.getNameShip(), s.getNameShip());
                    }
                }
            }
        }
    }
/**
 * Metodo per testare che guessShip trovi una nave Corazzata
 */
    @Test
    public void guessCorazzataTest(){
        Ship corazzata = new Corazzata();

        Board b = new Board(10);
        Settings set = new Settings();
        Game g = new Game(b, set);
        g.shipPlacement();
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(g.getBoard().getGameValue(i, j) != 'O'){
                    Ship s = g.guessShip(i,j);
                    if(s.getNameShip() == "Corazzata"){
                        assertEquals(corazzata.getNameShip(), s.getNameShip());
                    }
                }
            }
        }
    }
/**
 * Metodo per testare che guessShip trovi una nave Incrociatore
 */
    @Test
    public void guessIncrociatoreTest(){
        Ship incrociatore = new Incrociatore();

        Board b = new Board(10);
        Settings set = new Settings();
        Game g = new Game(b, set);
        g.shipPlacement();
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(g.getBoard().getGameValue(i, j) != 'O'){
                    Ship s = g.guessShip(i,j);
                    if(s.getNameShip() == "Incrociatore"){
                        assertEquals(incrociatore.getNameShip(), s.getNameShip());
                    }
                }
            }
        }
    }
/**
 * Metodo per testare che guessShip trovi una nave Portaerei
 */
    @Test
    public void guessPortaereiTest(){
        Ship portaerei = new Portaerei();

        Board b = new Board(10);
        Settings set = new Settings();
        Game g = new Game(b, set);
        g.shipPlacement();
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(g.getBoard().getGameValue(i, j) != 'O'){
                    Ship s = g.guessShip(i,j);
                    if(s.getNameShip() == "Portaerei"){
                        assertEquals(portaerei.getNameShip(), s.getNameShip());
                    }
                }
            }
        }
    }

}
