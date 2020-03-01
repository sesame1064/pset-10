package pak;
import java.io.*;
import com.google.gson.*;
import java.util.ArrayList;
import java.util.Collections;

import pak.definitions;

public class words {
	private int wordId;
	public static int nextId = -1;
	public String word;
	
	ArrayList<definitions> definitions = new ArrayList<definitions>();
	ArrayList<String> synonyms = new ArrayList<String>();
	ArrayList<String> antonyms = new ArrayList<String>();
	
	public Words(String word, definitions definitions, ArrayList<String> synonyms, ArrayList<String> antonyms) throws JsonSyntaxExceptio, JsonIOException, FileNotFoundException{
		this.word = word;
		this.definitions.add(definitions);
		Collections.copy(this.synonyms, synonyms);
		Collections.copy(this.antonyms, antonyms);
		this.wordId = nextId + 1;
		nextId++;
	}
}
