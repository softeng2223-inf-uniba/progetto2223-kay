package it.uniba.app;
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
     * Entrypoint of the application.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        //System.out.println(new App().getGreeting());
        Settings sett = new Settings();
        GameMenu.printMenuPreGame(sett);
    }
}
