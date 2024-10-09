import java.util.Scanner;

public class Start {
    public static void main(String[] args) {

        FileReader reader = new FileReader();
        DisplayStatus status = new DisplayStatus();
        WordManager manager = new WordManager(reader);
        Scanner input = new Scanner(System.in);

        Menu menu = new Menu();
        Game game = new Game(menu, manager, status, input);

        menu.initialize(game, reader, input);
        menu.show();
    }
}