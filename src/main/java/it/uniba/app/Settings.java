package it.uniba.app;
/**
 * &#60; Control &#62;
 * <p>
 * Classe che contiene le impostazioni di gioco.
 */
public class Settings {
    private static final  int CASE1 = 1;
    private static final  int CASE2 = 2;
    private static final  int CASE3 = 3;
    private static final  int CASE4 = 4;
    private static final  int INITDIFF = 1;
    private static final  int INITTIME = 5;
    private static final  int DIFFSEMPLICE = 50; // intervallo tra 40 a 60
    private static final  int DIFFMEDIA = 30; // intervallo da 20 a 39
    private static final  int DIFFDIFFICILE = 10; // intervallo da 5 a 19
    private static final  int INITBOARD = 10;
    private static final  int SECINMIN = 60;
    private static final  int DIMBOARDSTANDARD = 10;
    private static final  int DIMBOARDLARGE = 18;
    private static final  int DIMBOARDSEXTRALARGE = 26;
    private int difficulty;
    private int timeMax; //in secondi
    private int failableShots;
    private int boardSize;
    /**
     * Costruttore della classe Settings, per inizializzare ad uno stato iniziale le impostazioni.
     */
    Settings() {
        this.boardSize = INITBOARD;
        this.difficulty = INITDIFF;
        this.timeMax = INITTIME * SECINMIN;
        this.failableShots = DIFFSEMPLICE;
    }
    /**
     * Metodo che restituisce la variabile difficulty.
     */
    public int getDifficulty() {
        return difficulty;
    }
    /**
     * Metodo che modifica la variabile difficulty.
     *
     * @param diff      variabile con cui cambiare il valore della difficoltà
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
            case CASE4:
                return "Custom";
            default:
                return "[!] Errore inaspettato, riavvia il gioco";
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
     *
     * @param time      variabile con cui cambiare il valore del tempo massimo
     */
    public void modTimeMax(final int time) {
        if (time > 0) {
            this.timeMax = time * SECINMIN;
        } else {
            System.out.println("[!] Valore non valido");
        }
    }
    /**
     * Metodo che stampa la variabile timeMax.
     */
    public String printTimeMax() {
        return "Tempo massimo a disposizione: " + timeMax;
    }
    /**
     * Metodo che imposta il numero di colpi fallibile.
     *
     * @param falShots   variabile con cui cambiare il valore dei tentativi fallibili
     */
    public void setFailableShots(final int falShots) {
        this.failableShots = falShots;
    }
    /**
     * Metodo che imposta il numero di default dei colpi fallibili in base alla difficoltà.
     *
     * @param diff      variabile che indica la difficoltà che sta per essere impostata
     */
    public void setFailableShotsDefault(final int diff) {
        switch (diff) {
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
                System.out.println("[!] Errore inaspettato!");
                break;
        }
    }
    /**
     * Metodo che restituisce la variabile failableShots.
     */
    public int getFailableShots() {
        return this.failableShots;
    }
    /**
     * Metodo che modifica la dimensione della boardGame.
     *
     * @param dim       stringa indicante la dimensione che vogliamo impostare
     */
    public void editDimension(final String dim) {
        switch (dim) {
        case "/standard":
            if (this.boardSize == DIMBOARDSTANDARD) {
                System.out.print("\nLa griglia è già impostata a Standard 10x10");
            } else {
                this.boardSize = DIMBOARDSTANDARD;
            }
            break;
        case "/large":
            if (this.boardSize == DIMBOARDLARGE) {
                System.out.print("\nLa griglia è già impostata a Large 18x18");
             } else {
                 this.boardSize = DIMBOARDLARGE;
             }
             break;
        case "/extralarge":
            if (this.boardSize == DIMBOARDSEXTRALARGE) {
                 System.out.print("\nLa griglia è già impostata a Extralarge 26x26");
            } else {
              this.boardSize = DIMBOARDSEXTRALARGE;
            }
            break;
        default:
            System.out.println("\n[!] Comando non valido\n");
            break;
    }
}
    /**
     * Metodo che stampa la dimensione della boardGame.
     */
    public int printDimension() {
        return boardSize;
    }
    /**
     * Metodo che restituisce la dimensione della boardGame.
     */
    public int getBoardSize() {
        return boardSize;
    }
}
