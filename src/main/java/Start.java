public class Start {

    public static void main(String[] args) {
        FileReader reader = new FileReader();
        reader.loadWordsFromFile();

        DisplayStatus status = new DisplayStatus();
        WordManager manager = new WordManager(reader);
        Menu menu = new Menu();

        Game game = new Game(status, manager, menu);
        menu.setGame(game);
        menu.show();
    }
}
