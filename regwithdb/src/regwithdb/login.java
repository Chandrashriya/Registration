package regwithdb;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class login {

	private JFrame frame;
	private JTextField em;
	private JPasswordField p;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
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
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 550, 427);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("email id");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(78, 76, 89, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("set password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(65, 115, 127, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		em = new JTextField();
		em.setBounds(202, 76, 111, 28);
		frame.getContentPane().add(em);
		em.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("login");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_2.setBounds(164, 11, 149, 35);
		frame.getContentPane().add(lblNewLabel_2);
		
		p = new JPasswordField();
		p.setBounds(202, 115, 111, 28);
		frame.getContentPane().add(p);
		
		JButton l = new JButton("login");
		l.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email=em.getText();
				String pass=p.getText();
			
				
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrec3","root","mrec");
					String q="Insert into login values('"+email+"','"+pass+"')";
					Statement sta=con.createStatement();
					sta.executeUpdate(q);
					con.close();
					JOptionPane.showMessageDialog(l, "Done");
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		l.setFont(new Font("Tahoma", Font.PLAIN, 16));
		l.setBounds(134, 174, 89, 23);
		frame.getContentPane().add(l);
	}
}
