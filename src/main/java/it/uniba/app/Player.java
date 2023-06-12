package it.uniba.app;
/**
 * Classe che rappresenta il giocatore.
 */
public class Player {
    private int failedShots;
    private int shots;

    /**
     * Costruttore di Player.
     */
    Player() {
        this.failedShots = 0;
        this.shots = 0;
    }

    /**
     * Restituisce il numero di colpi eseguiti (andati a buon fine e non).
     */
    public int getShots() {
        return shots;
    }

    /**
     * Restituisce il numero di colpi non andati a buon fine.
     */
    public int getFailedShots() {
        return failedShots;
    }

    /**
     * Metodo che incrementa gli shots.
     */
    public void incrementShots() {
        this.shots++;
    }

    /**
     * Metodo che incrementa i failedShots.
     */
    public void incrementFailedShots() {
        this.failedShots++;
    }
}
