package pak;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.ScrollPane;
import java.awt.TextField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class mainPage {

	private JFrame frmAmysDictionary;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainPage window = new mainPage();
					window.frmAmysDictionary.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAmysDictionary = new JFrame();
		frmAmysDictionary.setTitle("Amy's Dictionary");
		frmAmysDictionary.setBounds(100, 100, 746, 464);
		frmAmysDictionary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAmysDictionary.getContentPane().setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(0, 0, 89, 23);
		frmAmysDictionary.getContentPane().add(btnAdd);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(99, 0, 89, 23);
		frmAmysDictionary.getContentPane().add(btnRemove);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(204, 10, 500, 376);
		frmAmysDictionary.getContentPane().add(scrollPane);
		
		TextField textField = new TextField();
		textField.setText("search");
		textField.setBounds(0, 29, 198, 23);
		frmAmysDictionary.getContentPane().add(textField);
		
		JRadioButton rdbtnAsc = new JRadioButton("asc");
		rdbtnAsc.setBounds(26, 58, 57, 23);
		frmAmysDictionary.getContentPane().add(rdbtnAsc);
		
		JRadioButton rdbtnDes = new JRadioButton("des");
		rdbtnDes.setBounds(85, 58, 109, 23);
		frmAmysDictionary.getContentPane().add(rdbtnDes);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 91, 178, 284);
		frmAmysDictionary.getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}
}
