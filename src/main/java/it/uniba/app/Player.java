package it.uniba.app;
/**
 * Classe che rappresenta il giocatore.
 */
public class Player {
    //private String name;
    private int failed_shots;
    private int shots;

    /**
     * Restituisce il numero di colpi eseguiti (andati a buon fine e non).
     */
    public int getShots() {
        return shots;
    }

    /**
     * Restituisce il numero di colpi non andati a buon fine.
     */
    public int showFailShots () {
        return failed_shots;
    }
}
