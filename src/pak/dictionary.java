package pak;

import java.awt.EventQueue;
import pak.Definitions;
import pak.Words;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JRadioButton;
import javax.swing.JEditorPane;
import com.google.gson.Gson;
import pak.Utils;
import java.awt.ScrollPane;

public class Dictionary {

	private JFrame frmDictionary;
	private JTextField textField;

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
        Words[] words = gson.fromJson(br, Words[].class);
        DefaultListModel<String> listOfWords = new DefaultListModel<String>();
        for (Words word : words) {
        	listOfWords.addElement(word.getWord());
        }
       ;
        return  Utils.sortWordsAsc(listOfWords);
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
		frmDictionary.setTitle("Dictionary");
		frmDictionary.setBounds(100, 100, 656, 532);
		frmDictionary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDictionary.getContentPane().setLayout(null);
		frmDictionary.setResizable(false);
		
		
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(10, 11, 89, 23);
		frmDictionary.getContentPane().add(btnAdd);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(109, 11, 89, 23);
		frmDictionary.getContentPane().add(btnRemove);
		
		textField = new JTextField();
		textField.setBounds(10, 53, 188, 23);
		frmDictionary.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		List list = new List();
		list.setBounds(10, 114, 188, 343);
		frmDictionary.getContentPane().add(list);
		
		JRadioButton rdbtnAsc = new JRadioButton("Asc");
		rdbtnAsc.setBounds(20, 83, 63, 23);
		frmDictionary.getContentPane().add(rdbtnAsc);
		
		JRadioButton rdbtnDesc = new JRadioButton("Desc");
		rdbtnDesc.setBounds(85, 83, 109, 23);
		frmDictionary.getContentPane().add(rdbtnDesc);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(218, 11, 412, 458);
		frmDictionary.getContentPane().add(editorPane);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(10, 112, 188, 354);
		frmDictionary.getContentPane().add(scrollPane);
		
		
	}
}
