import java.util.ArrayList;
import java.util.List;

public class HangmanDisplayStatus {
    List<String> hangmanStages = new ArrayList<>();

    {
        hangmanStages.add(
                "  +---+\n" +
                "  |   |\n" +
                "      |\n" +
                "      |\n" +
                "      |\n" +
                "      |\n" +
                "=======\n"
        );
        hangmanStages.add(
                "  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                "      |\n" +
                "      |\n" +
                "      |\n" +
                "=======\n"
        );
        hangmanStages.add(
                "  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                "  |   |\n" +
                "      |\n" +
                "      |\n" +
                "=======\n"
        );
        hangmanStages.add(
                "  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                " /|   |\n" +
                "      |\n" +
                "      |\n" +
                "=======\n"
        );
        hangmanStages.add(
                "  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                " /|\\ |\n" +
                "      |\n" +
                "      |\n" +
                "=======\n"
        );
        hangmanStages.add(
                "  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                " /|\\ |\n" +
                " /    |\n" +
                "      |\n" +
                "=======\n"
        );
        hangmanStages.add(
                "  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                " /|\\ |\n" +
                " / \\ |\n" +
                "      |\n" +
                "=======\n"
        );
    }
}