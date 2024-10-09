import java.util.Scanner;

public class Menu {

    private static final String START_GAME_OPTION = "1";
    private static final String EXIT_GAME_OPTION = "2";
    private static final String WELCOME_MESSAGE = "Welcome to the hangman game! Insert number 1 to start or 2 to exit.";
    private static final String GOODBYE_MESSAGE = "Thanks for playing!";
    private static final String INVALID_INPUT_MESSAGE = "Invalid input. Try again.";
    private static final String RESTART_MESSAGE = " Would you like to restart? (y/n)";
    private static final String COMMAND_RESTART = "y";
    private static final String COMMAND_QUIT = "n";

    private Game game;
    private FileReader reader;
    private Scanner input;

    public void initialize(Game game, FileReader reader, Scanner input) {
        this.game = game;
        this.reader = reader;
        this.input = input;
    }

    public void show() {
        System.out.println(WELCOME_MESSAGE);
        while (true) {
            String PLAYER_CHOICE = input.nextLine();

            if (PLAYER_CHOICE.equals(START_GAME_OPTION)) {
                reader.loadWordsFromFile();
                game.start();
            } else if (PLAYER_CHOICE.equals(EXIT_GAME_OPTION)) {
                System.out.println(GOODBYE_MESSAGE);
                break;
            } else {
                System.out.println(INVALID_INPUT_MESSAGE);
            }
        }
    }

    public void restartGame() {
        System.out.printf("You have won %d time(s) and lost %d time(s).", game.getWins(), game.getLosses());
        System.out.println(RESTART_MESSAGE);
        while (true) {
            String decision = input.nextLine();
            if (decision.equals(COMMAND_RESTART)) {
                game.resetGameData();
            } else if (decision.equals(COMMAND_QUIT)) {
                System.out.println(GOODBYE_MESSAGE);
                System.exit(0);
            } else {
                System.out.println(INVALID_INPUT_MESSAGE);
            }
        }
    }
}