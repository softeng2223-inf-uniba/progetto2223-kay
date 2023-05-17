package it.uniba.app;
/**
 * Classe che contiene le impostazioni di gioco.
 */
public class Settings {
    private final static int INITDIFF = 1;
    private final static int INITTIME = 5;
    private int difficulty;
    private int timeMax;

/**
 * Costruttore della classe Settings, per inizializzare ad uno stato iniziale le impostazioni
 */
    Settings() {
        difficulty = INITDIFF;
        timeMax = INITTIME;
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
    public void modDifficulty(int diff) {
        this.difficulty = diff;
    }

/**
 * Metodo che stampa la variabile difficulty.
 */
    public String printDifficulty() {
        switch(difficulty) {
            case 1:
                return "Facile";
            case 2:
                return "Medio";
            case 3:
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
    public void modTimeMax(int time) {
        switch(time) {
            case 5:
                this.timeMax = time;
                break;
            case 10:
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
}
