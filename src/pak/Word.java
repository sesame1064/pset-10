package pak;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import pak.Definitions;

import javax.swing.DefaultListModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Word {
	private String word;
	private ArrayList<Definitions> definitions;
	private ArrayList<String> synonyms;
	private ArrayList<String> antonyms;
	
	public Word(String word, ArrayList<Definitions> definitions,ArrayList<String> synonyms, ArrayList<String> antonyms) {
		this.word = word;
		this.definitions = definitions;
		this.synonyms = synonyms;
		this.antonyms = antonyms; 
	}
	
	public String getWord() {
		return this.word;
	}
	
	public void setWord(String word){
		this.word = word;
	} 
	
	public ArrayList<Definitions> getDefinitions() {
		return this.definitions;
	}
	
	public void setDefinitions(ArrayList<Definitions> definitions) {
		this.definitions = definitions;
	}
	
	public ArrayList<String> getSynonyms() {
		return this.synonyms;
	}
	
	public void setSynonyms(ArrayList<String> synonyms) {
		this.synonyms = synonyms;
	}
	
	public ArrayList<String> getAntonyms() {
		return this.antonyms;
	}
	
	public void setAntonyms(ArrayList<String> antonyms) {
		this.antonyms = antonyms;
	}
}