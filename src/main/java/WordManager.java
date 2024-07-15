import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class WordManager {
    static final String WORD_LIST_NOT_INITIALIZED_ERROR = "Word list is not initialized or empty";
    private List<String> currentWordLetters;
    private List<String> hiddenLetters;
    private final FileReader reader;

    public WordManager(FileReader reader) {
        this.reader = reader;
    }

    public void initializeWordLetters(){
        String word = selectRandomWord();
        currentWordLetters = new ArrayList<>();
        for (char index : word.toCharArray()) {
            currentWordLetters.add(String.valueOf(index));
        }
        initializeSecretLetters(word);
    }

    private String selectRandomWord(){

        if (reader.getWords() == null || reader.getWords().isEmpty()) {
            throw new IllegalStateException(WORD_LIST_NOT_INITIALIZED_ERROR);
        }
        int randomNumber = (int) (Math.random() * reader.getWords().size());
        String selectedWord = reader.getWords().get(randomNumber);
        reader.getWords().remove(randomNumber);

        return selectedWord;
    }

    private void initializeSecretLetters(String word){
        hiddenLetters = new ArrayList<>();
        IntStream.range(0, word.length()).forEach(i -> hiddenLetters.add("#"));
    }

    public List<String> getCurrentWordLetters(){
        return currentWordLetters;
    }

    public List<String> getHiddenLetters(){
        return hiddenLetters;
    }
}