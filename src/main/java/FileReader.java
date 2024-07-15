import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    static final String FILE_NOT_FOUND_ERROR_MESSAGE = "File not found";
    private List<String> words;

    public void loadWordsFromFile(){
        words = new ArrayList<>();

        try{
            File fileWords = new File("src/main/resources/listOfWords.txt");
            Scanner fileScanner = new Scanner(fileWords);

            while (fileScanner.hasNextLine()){
                words.add(fileScanner.nextLine().toLowerCase());
            }

            fileScanner.close();
        }
        catch (FileNotFoundException error){
            System.out.println(FILE_NOT_FOUND_ERROR_MESSAGE);
        }
    }

    public List<String> getWords(){
        return words;
    }
}