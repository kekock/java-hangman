public class DisplayStatus {
    private final String[] hangmanStages  = new String[] {
            "  +---+\n" +
            "      |\n" +
            "      |\n" +
            "      |\n" +
            "      |\n" +
            "      |\n" +
            "=======\n",
            "  +---+\n" +
            "  |   |\n" +
            "      |\n" +
            "      |\n" +
            "      |\n" +
            "      |\n" +
            "=======\n",
            "  +---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            "      |\n" +
            "      |\n" +
            "      |\n" +
            "=======\n",
            "  +---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            "  |   |\n" +
            "      |\n" +
            "      |\n" +
            "=======\n",
            "  +---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            " /|   |\n" +
            "      |\n" +
            "      |\n" +
            "=======\n",
            "  +---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            " /|\\ |\n" +
            "      |\n" +
            "      |\n" +
            "=======\n",
            "  +---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            " /|\\ |\n" +
            " /    |\n" +
            "      |\n" +
            "=======\n",
            "  +---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            " /|\\ |\n" +
            " / \\ |\n" +
            "      |\n" +
            "=======\n"
    };

    public String getStages(int index) {
        return hangmanStages[index];
    }
}