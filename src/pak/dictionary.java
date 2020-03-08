package pak;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import com.google.gson.*;
import pak.words;



public class dictionary {
	public static words[] wordList;
	
	public static words[] addAllWords() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		wordList = new Gson().fromJson(new FileReader(".\\Json\\words.json"), words[].class);
		return wordList;
	}
	
	public static ArrayList<String> listVocab(Boolean ascending) {
		ArrayList<String> listOfWords = new ArrayList<String>();
		
		for (words word : wordList) {
			listOfWords.add(word.getVocab());
		}
		
		if (ascending) {
			Collections.sort(listOfWords, Collections.reverseOrder());	
		} else {
			Collections.sort(listOfWords);
		}
		return listOfWords;
	}
	public static ArrayList<words> sortObj(Boolean ascending) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		
		ArrayList<String> sortedSpellings = listVocab(ascending);
		wordList = addAllWords();
		ArrayList<words> sortedObj = new ArrayList<words>();
		for (int i = 0; sortedObj.size() < wordList.length; i++) {
		
			for (words word : wordList) {
				if (sortedSpellings.get(i).equals(word.getVocab())) {
					sortedObj.add(word);
					break;
				}
				
		}
		
	}
		return sortedObj;	
	}

}
