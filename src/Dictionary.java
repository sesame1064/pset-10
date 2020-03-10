import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.event.ListSelectionEvent;
import javax.swing.BorderFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import pak.Utils;
import pak.Words;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.swing.JFrame;

public class Dictionary {

	private JFrame frmDictionary;
	private JTextField txtSearch;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		getWords();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dictionary window = new Dictionary();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	 private static DefaultListModel<String> getWords() throws FileNotFoundException{
		    Gson gson = new Gson();
		        String classpathDirectory = Utils.getClasspathDir();
		        BufferedReader br = new BufferedReader(new FileReader(classpathDirectory + "words.json"));
		        Words[] words = gson.fromJson(br, Words[].class);
		        System.out.println(words.length + " words added");
		        DefaultListModel<String> listOfWords = new DefaultListModel<String>();
		        for (Words word : words) {
		          listOfWords.addElement(word.getWord());
		        }
		       ;
		        return  Utils.sortWordsAsc(listOfWords);
		  }
	  @SuppressWarnings("unused")
	private static ArrayList<Words> getWordClass() throws FileNotFoundException{
		    Gson gson = new Gson();
		        String classpathDirectory = Utils.getClasspathDir();
		        BufferedReader br = new BufferedReader(new FileReader(classpathDirectory + "words.json"));
		        Words[] words = gson.fromJson(br, Words[].class);
		        ArrayList<Words> listOfWords = new ArrayList<Words>();
		        for (Words word : words) {
		          listOfWords.add(word);
		        }
		       ;
		        return listOfWords;
		  }

	/**
	 * Create the application.
	 */
	public Dictionary() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		 frmDictionary = new JFrame();
		 frmDictionary.setResizable(false);
		 frmDictionary.setTitle("Dictionary");
		 frmDictionary.setBounds(100, 100, 800, 600);
		 frmDictionary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frmDictionary.getContentPane().setLayout(null);
	}

}
