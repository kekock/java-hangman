import java.util.*;

public class Game {
    private final Scanner input = new Scanner(System.in);
    private final DisplayStatus status;
    private final WordManager manager;
    private final Menu menu;

    public Game(DisplayStatus status, WordManager manager, Menu menu) {
        this.status = status;
        this.manager = manager;
        this.menu = menu;
    }
    private int wins = 0;
    private int losses = 0;
    private int remainingAttempts = 7;
    private int incorrectGuesses = 0;
    private Set<String> enteredCharacters;


    public void start() {
        manager.initializeWordLetters();
        enteredCharacters = new HashSet<>();
        showHangman();

        while (remainingAttempts > 0 && manager.getHiddenLetters().contains("#")) {

            System.out.println("The secret word is: " + manager.getHiddenLetters() + ". Now guess the characters!");
            String guess = input.nextLine().toLowerCase();

            if (isInvalidCharacter(guess)) {
                String INVALID_CHARACTER_ERROR = "Please enter a single letter.";
                System.out.println(INVALID_CHARACTER_ERROR);
                continue;
            }

            if (isCharacterAlreadyInserted(guess)) {
                String DUPLICATE_CHARACTER_ERROR = "You already inserted these characters: ";
                System.out.println(DUPLICATE_CHARACTER_ERROR + enteredCharacters);
                continue;
            }

            enteredCharacters.add(guess);

            boolean isCorrect = isCorrectGuess(guess);
            processGuess(isCorrect);

            showHangman();
            checkGameOver(manager.getHiddenLetters(), remainingAttempts);
        }
    }

    private boolean isInvalidCharacter(String userInput) {
        return userInput.length() != 1 || !Character.isLetter(userInput.charAt(0));
    }

    private boolean isCharacterAlreadyInserted(String userInput) {
        return enteredCharacters.contains(userInput);
    }

    private boolean isCorrectGuess(String userInput) {
        boolean isCorrect = false;

        for (int i = 0; i < manager.getCurrentWordLetters().size(); i++) {
            if (manager.getCurrentWordLetters().get(i).equals(userInput)) {
                manager.getHiddenLetters().set(i, userInput);
                isCorrect = true;
            }
        }
        return isCorrect;
    }

    private void processGuess(boolean isCorrect) {

        if (isCorrect) {
            String CORRECT_GUESS_MESSAGE = "You're right! This character exists! The secret word now is ";
            System.out.println(CORRECT_GUESS_MESSAGE + manager.getHiddenLetters());
        } else {
            remainingAttempts--;
            String INCORRECT_GUESS_MESSAGE = "You're wrong! More attempts left: ";
            System.out.println(INCORRECT_GUESS_MESSAGE + remainingAttempts);
            incorrectGuesses++;
        }
    }

    private void showHangman() {
        System.out.println("Actual hangman status: \n" + status.getStages(incorrectGuesses));
    }

    private void checkGameOver(List<String> secretWord, int attemptsLeft) {
        if (!secretWord.contains("#")) {
            String WIN_MESSAGE = "Congratulations! You have guessed the secret word!";
            System.out.println(WIN_MESSAGE);
            wins++;
            menu.restartGame();
        }
        if (attemptsLeft == 0) {
            String LOSS_MESSAGE = "Game Over! The secret word was: ";
            System.out.println(LOSS_MESSAGE + manager.getCurrentWordLetters());
            losses++;
            menu.restartGame();
        }
    }

    public void resetGameData() {
        enteredCharacters.clear();
        remainingAttempts = 7;
        incorrectGuesses = 0;
        start();
    }

    public int getWins(){
        return wins;
    }

    public int getLosses(){
        return losses;
    }
}