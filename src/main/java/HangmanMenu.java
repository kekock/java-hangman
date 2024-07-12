import java.util.Scanner;

public class HangmanMenu {
    Scanner input = new Scanner(System.in);
    HangmanData data;
    HangmanGame game;

    public HangmanMenu(HangmanData data) {
        this.data = data;
    }

    public static void main(String[] args) {
        HangmanData data = new HangmanData();
        HangmanMenu menu = new HangmanMenu(data);
        menu.game = new HangmanGame(data, menu);
        menu.showMenu();
    }

    public void showMenu() {
        System.out.println("Welcome to the hangman game! What's your name?");
        data.playerName = input.nextLine();
        System.out.println("Hello " + data.playerName + "! Insert number 1 to start or 2 to exit.");
        int playerChoice = input.nextInt();
        input.nextLine();

        if (playerChoice == 1) {
            game.startGame();
        } else {
            System.out.println("Well, good luck!");
        }
    }

    public void restartGame(){
        System.out.println("You have won " + data.wins + " time(s) and lost " + data.losses + " time(s).");
        System.out.println("Would you like to restart? (y/n)");{
            String decision = input.nextLine();
            if(decision.equals("y")){
                data.resetData();
                game.startGame();
            }
            else{
                System.out.println("Thanks for playing!");
            }
        }
    }
}
