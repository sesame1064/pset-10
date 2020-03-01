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
	
	public void Words(String word, definitions definitions, ArrayList<String> synonyms, ArrayList<String> antonyms) throws JsonSyntaxException, JsonIOException, FileNotFoundException{
		this.word = word;
		this.definitions.add(definitions);
		Collections.copy(this.synonyms, synonyms);
		Collections.copy(this.antonyms, antonyms);
		this.wordId = nextId + 1;
		nextId++;
	}
	
	public void setDefinitions(definitions definitions) {
		this.definitions.add(definitions);
	}
	
	public void addSynonym(String synonym) {
		this.synonyms.add(synonym);
	}
	
	public void addAntonym(String antonym) {
		this.antonyms.add(antonym);
	}
	
	public String getVocab() {
		return this.word;
	}
	
	public int getId() {
		return this.wordId;
	}
	
	public ArrayList<definitions> getDefinition(){
		return this.definitions;
	}
	
	public ArrayList<String> getSynonyms() {
		return this.synonyms;
	}
	
	public ArrayList<String> getAntonyms() {
		return this.antonyms;
	}
	
}
