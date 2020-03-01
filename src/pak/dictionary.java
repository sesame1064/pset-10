package pak;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import com.google.gson.*;


public class dictionary {
	public static Words[] wordList;
	
	public static Words[] addAllWords() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		wordList = new Gson().fromJson(new FileReader(".\\Json\\words.json"), words[].class);
		return wordList;
	}

}
