package it.uniba.app;
import static it.uniba.app.GameMenu.displayHelp;
/**
 *  Class that contains the main method.
 */
public final class App {
    /**
     * Get a greeting sentence.
     *
     * @return the "Hello World!" string.
     */
    public String getGreeting() {
        return "Hello World!!!";
    }
    /**
     * Metodo per gestire il comando --help parametrizzato.
     *
     * @param args  argomento passato dalla CLI
     */
    public static void helpManager(final String[] args) {
        int count = 0;
        for (int i = 0; i < args.length && count < 1; i++) {
            if (args[i] == "--help" || args[i] == "-h") {
                displayHelp();
                count++;
            }
        }
    }
    /**
     * Entrypoint of the application.
     *
     * @param args  command line arguments
     */
    public static void main(final String[] args) {
        helpManager(args);
        Settings sett = new Settings();
        GameMenu.printMenuPreGame(sett);
    }
}
