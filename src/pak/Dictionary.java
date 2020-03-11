package pak;
import pak.*;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.Font;

public class Dictionary {

	  private JFrame frmDictionary;
	  private JTextField txtSearch;
	  private final ButtonGroup buttonGroup = new ButtonGroup();
	  private JTextField textField;
	  private JTextField txtDefinitions;
	  private JTextField textField_2;
	  private JTextField textField_1;
	  private JTextField textField_3;


	/**
	 * Launch the application.
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		getWords();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dictionary window = new Dictionary();
					window.frmDictionary.setVisible(true);
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
	        Word[] words = gson.fromJson(br, Word[].class);
	        System.out.println(words.length + " words added");
	        DefaultListModel<String> listOfWords = new DefaultListModel<String>();
	        for (Word word : words) {
	          listOfWords.addElement(word.getWord());
	        }
	       ;
	        return  Utils.sortWordsAsc(listOfWords);
	  }
	private static ArrayList<Word> getWordClass() throws FileNotFoundException{
	    Gson gson = new Gson();
	        String classpathDirectory = Utils.getClasspathDir();
	        BufferedReader br = new BufferedReader(new FileReader(classpathDirectory + "words.json"));
	        Word[] words = gson.fromJson(br, Word[].class);
	        ArrayList<Word> listOfWords = new ArrayList<Word>();
	        for (Word word : words) {
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
		JFrame frame = new JFrame();
		frame.setTitle("Dictionary");
		frame = frame;
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
