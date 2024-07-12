import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class HangmanLetterChecker {
    List<String> wordLetters;
    List<String> secretLetters;
    HangmanWordGenerator wordGenerator = new HangmanWordGenerator();
    String word;

    public void setWordLetters(){
        wordGenerator.createListOfWords();
        word = wordGenerator.getRandomWord();
        wordLetters = new ArrayList<>();

        for (char index : word.toCharArray()) {
            wordLetters.add(String.valueOf(index));
        }
    }

    public void setSecretWord(){
        secretLetters = new ArrayList<>();
        IntStream.range(0, word.length()).forEach(i -> secretLetters.add("#"));
    }
}
