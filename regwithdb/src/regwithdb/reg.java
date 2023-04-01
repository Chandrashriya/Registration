package regwithdb;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class reg {

	private JFrame frame;
	private JTextField n1;
	private JTextField em1;
	private JTextField m1;
	private JPasswordField p1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reg window = new reg();
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
	public reg() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 523, 421);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(163, 11, 151, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(39, 99, 105, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(39, 146, 105, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Set Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(39, 197, 127, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Marks");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(39, 250, 105, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		n1 = new JTextField();
		n1.setBounds(180, 88, 112, 20);
		frame.getContentPane().add(n1);
		n1.setColumns(10);
		
		em1 = new JTextField();
		em1.setBounds(180, 146, 112, 20);
		frame.getContentPane().add(em1);
		em1.setColumns(10);
		
		m1 = new JTextField();
		m1.setBounds(180, 238, 112, 20);
		frame.getContentPane().add(m1);
		m1.setColumns(10);
		
		p1 = new JPasswordField();
		p1.setBounds(180, 197, 112, 20);
		frame.getContentPane().add(p1);
		
		JButton o1 = new JButton("OK");
		o1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=n1.getText();
				String email=em1.getText();
				String pass =p1.getText();
				String marks=m1.getText();
			}
			
		});
		o1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		o1.setBounds(130, 303, 89, 23);
		frame.getContentPane().add(o1);
	}

}
