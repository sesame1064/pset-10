package pak;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JTextField;

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
	 */
	public static void main(String[] args) {
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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
