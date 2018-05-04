import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JComboBox;

public class Details extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Details frame = new Details();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Details() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JTextArea a = new JTextArea();
		a.setBackground(UIManager.getColor("Button.light"));
		a.setForeground(Color.BLACK);
		a.setToolTipText("help");
		a.setText("Enter The Details                                    ");
		a.setEditable(false);
		panel.add(a);
		
		String arr[] = {"gs","gs","gs","gs","gs",};
		JComboBox file = new JComboBox(arr);
		file.setEditable(true);
		file.setBackground(UIManager.getColor("Button.light"));
		panel.add(file);
	}

}
