package it.uniba.app;
/**
 * Classe che contiene le impostazioni di gioco.
 */
public class Settings {
    private static final  int CASE1 = 1;
    private static final  int CASE2 = 2;
    private static final  int CASE3 = 3;
    private static final  int INITDIFF = 1;
    private static final  int INITTIME = 5;
    private static final  int FOWTIME = 10;
    private static final  int DIFFSEMPLICE = 50;
    private static final  int DIFFMEDIA = 30;
    private static final  int DIFFDIFFICILE = 10;
    private int difficulty;
    private int timeMax;
    private int failableShots;

/**
 * Costruttore della classe Settings, per inizializzare ad uno stato iniziale le impostazioni.
 */
    Settings() {
        difficulty = INITDIFF;
        timeMax = INITTIME;
        switch (this.difficulty) {
            case CASE1:
                this.failableShots = DIFFSEMPLICE;
                break;
            case CASE2:
                this.failableShots = DIFFMEDIA;
                break;
            case CASE3:
                this.failableShots = DIFFDIFFICILE;
                break;
            default:
                System.out.println("Errore inaspettato, riavvia il gioco");
        }
    }

/**
 * Metodo che restituisce la variabile difficulty.
 */
    public int getDifficulty() {
        return difficulty;
    }
/**
 * Metodo che modifica la variabile difficulty.
 */
    public void modDifficulty(final int diff) {
        this.difficulty = diff;
    }
/**
 * Metodo che stampa la variabile difficulty.
 */
    public String printDifficulty() {
        switch (difficulty) {
            case CASE1:
                return "Facile";
            case CASE2:
                return "Medio";
            case CASE3:
                return "Difficile";
            default:
                return "Errore inaspettato, riavvia il gioco";
        }
    }
/**
 * Metodo che restituisce la variabile timeMax.
 */
    public int getTimeMax() {
        return timeMax;
    }

/**
 * Metodo che modifica la variabile timeMax.
 */
    public void modTimeMax(final int time) {
        switch (time) {
            case INITTIME:
                this.timeMax = time;
                break;
            case FOWTIME:
                this.timeMax = time;
                break;
            default:
                System.out.println("Valore non valido, riprova");
        }
    }

/**
 * Metodo che stampa la variabile timeMax.
 */
    public String printTimeMax() {
        return "Tempo massimo a disposizione: " + timeMax;
    }

/**
* Metodo che restituisce la variabile failableShots.
*/
    public int getFailableShots() {
        return this.failableShots;
    }
}
