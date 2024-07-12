import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HangmanGame {

    HangmanDisplayStatus status = new HangmanDisplayStatus();
    HangmanLetterChecker checker = new HangmanLetterChecker();
    HangmanData data;
    HangmanMenu menu;
    Scanner input = new Scanner(System.in);
    Set<String> insertedCharacters = new HashSet<>();

    public HangmanGame(HangmanData data, HangmanMenu menu) {
        this.data = data;
        this.menu = menu;
    }

    public void startGame() {
        checker.setWordLetters();
        checker.setSecretWord();

        while (data.attemptsLeft > 0 && checker.secretLetters.contains("#")) {

            System.out.println("The secret word is: " + checker.secretLetters + ". Now guess the characters!");
            String userInput = input.nextLine().toLowerCase();

            if (userInput.length() != 1 || !Character.isLetter(userInput.charAt(0))) {
                System.out.println("Please enter a single letter.");
                continue;
            }

            if (insertedCharacters.contains(userInput)) {
                System.out.println("This character was already inserted.");
                continue;
            }
            insertedCharacters.add(userInput);

            boolean isCorrect = false;

            for (int i = 0; i < checker.wordLetters.size(); i++) {
                if (checker.wordLetters.get(i).equals(userInput)) {
                    checker.secretLetters.set(i, userInput);
                    isCorrect = true;
                }
            }

            if (isCorrect) {
                System.out.println("You're right! This character exists! The secret word now is " + checker.secretLetters);
            } else {
                data.attemptsLeft--;
                System.out.println("You're wrong! More attempts left: " + data.attemptsLeft);
                System.out.println(status.hangmanStages.get(data.displayTimes));
                data.displayTimes++;
            }

            if (!checker.secretLetters.contains("#")) {
                System.out.println("Congratulations! You have guessed the secret word!");
                data.wins++;
                menu.restartGame();
            }
            if (data.attemptsLeft == 0) {
                System.out.println("Game Over! The secret word was: " + checker.wordLetters);
                data.losses++;
                menu.restartGame();
            }
        }
    }
}
