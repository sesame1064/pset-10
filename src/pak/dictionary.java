package pak;

import java.awt.EventQueue;
import java.awt.Window;

import pak.Definitions;
import pak.Words;

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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		
		

		JRadioButton rdbtnAsc = new JRadioButton("Asc");
		rdbtnAsc.setBounds(20, 83, 63, 23);
		frmDictionary.getContentPane().add(rdbtnAsc);
		rdbtnAsc.setSelected(true);
		
		JRadioButton rdbtnDesc = new JRadioButton("Desc");
		rdbtnDesc.setBounds(85, 83, 109, 23);
		frmDictionary.getContentPane().add(rdbtnDesc);
		rdbtnDesc.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				ItemEvent event;
				// TODO Auto-generated method st
	            int state = event.getStateChange();
	            if (state == ItemEvent.SELECTED) {
	                System.out.println("desc");
	                try {
	                  txtSearch.setText("");
	            list.setModel(Utils.reverseOrder(getWords()));
	            doc.remove(0, doc.getLength());
	            doc.insertString(doc.getLength(),"Example Word\n" ,bigWord );
	              doc.insertString(doc.getLength(),"\n" , null );
	              doc.insertString(doc.getLength(),"Definitions\n" ,header );
	              doc.insertString(doc.getLength(),"\n" ,null );
	              doc.insertString(doc.getLength(),"1. Example Word (pos) \n\n    Definition of example word\n\n" ,null );
	              doc.insertString(doc.getLength(),"\n" ,null );
	              doc.insertString(doc.getLength(),"Synonyms\n" ,header );
	              doc.insertString(doc.getLength(),"\n1.Synonym " ,null );
	              doc.insertString(doc.getLength(),"\n\n" ,null );
	              doc.insertString(doc.getLength(),"Antonyms\n" ,header );
	              doc.insertString(doc.getLength(),"\n1.Antonym " ,null );
	          } catch (FileNotFoundException | BadLocationException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	          }

	            } else if (state == ItemEvent.DESELECTED) {
	              System.out.println("asc");
	              try {
	                txtSearch.setText("");
	            list.setModel(getWords());
	            doc.remove(0, doc.getLength());
	            doc.insertString(doc.getLength(),"Example Word\n" ,bigWord );
	              doc.insertString(doc.getLength(),"\n" , null );
	              doc.insertString(doc.getLength(),"Definitions\n" ,header );
	              doc.insertString(doc.getLength(),"\n" ,null );
	              doc.insertString(doc.getLength(),"1. Example Word (pos) \n\n    Definition of example word\n\n" ,null );
	              doc.insertString(doc.getLength(),"\n" ,null );
	              doc.insertString(doc.getLength(),"Synonyms\n" ,header );
	              doc.insertString(doc.getLength(),"\n1.Synonym " ,null );
	              doc.insertString(doc.getLength(),"\n\n" ,null );
	              doc.insertString(doc.getLength(),"Antonyms\n" ,header );
	              doc.insertString(doc.getLength(),"\n1.Antonym " ,null );
	          } catch (FileNotFoundException | BadLocationException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	          }
	            }

			}
			
		});
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(218, 11, 412, 458);
		frmDictionary.getContentPane().add(editorPane);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(10, 112, 188, 354);
		frmDictionary.getContentPane().add(scrollPane);
		
		
	}
}
