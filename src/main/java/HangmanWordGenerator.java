import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HangmanWordGenerator {

    HangmanData data = new HangmanData();
    File fileWords;
    Scanner fileScanner;
    List<String> words;
    List<String> selectedWords;
    int randomNumber;

    public void createListOfWords(){
        words = new ArrayList<>();

        try{
            fileWords = new File("src/main/resources/listOfWords.txt");
            fileScanner = new Scanner(fileWords);

            while (fileScanner.hasNextLine()){
                words.add(fileScanner.nextLine());
            }
        }
        catch (FileNotFoundException error){
            System.out.println("File not found");
            return;
        }

        words.replaceAll(String::toLowerCase);
        fileScanner.close();
    }

    public String getRandomWord(){

        if (words == null || words.isEmpty()) {
            throw new IllegalStateException("Word list is not initialized or empty");
        }

        selectedWords = new ArrayList<>();
        randomNumber = (int) (Math.random() * words.size());
        selectedWords.add(words.get(randomNumber));
        words.remove(randomNumber);

        return selectedWords.get(data.count);
    }
}