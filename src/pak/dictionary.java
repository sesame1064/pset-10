package pak;
import com.google.gson.*;
import java.util.ArrayList;
import java.io.*;

public class dictionary {
	
	@SuppressWarnings("rawtypes")
	public static ArrayList[] wordList;
	
	public static void allWords() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		wordList = new Gson().fromJson(new FileReader("words.json"), ArrayList[]);
	}
    public static ArrayList<String> listWords() {
        ArrayList<String> listOfWords = new ArrayList<String>();
        for(ArrayList[] word : wordList) {
            listOfWords.add(word.getSpelling());
        }
        return listOfWords;
    }
}
