package regwithdb;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class registration {

	private JFrame frmRegistrationForm;
	private JTextField n;
	private JTextField em;
	private JPasswordField p;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registration window = new registration();
					window.frmRegistrationForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistrationForm = new JFrame();
		frmRegistrationForm.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmRegistrationForm.setForeground(Color.LIGHT_GRAY);
		frmRegistrationForm.setTitle("REGISTRATION FORM");
		frmRegistrationForm.setBounds(100, 100, 591, 470);
		frmRegistrationForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistrationForm.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration Form");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(192, 11, 210, 39);
		frmRegistrationForm.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(31, 96, 71, 14);
		frmRegistrationForm.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(31, 133, 82, 14);
		frmRegistrationForm.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(31, 177, 82, 14);
		frmRegistrationForm.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Gender");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(31, 202, 71, 30);
		frmRegistrationForm.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Program");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(31, 243, 82, 33);
		frmRegistrationForm.getContentPane().add(lblNewLabel_5);
		
		n = new JTextField();
		n.setBounds(146, 96, 152, 20);
		frmRegistrationForm.getContentPane().add(n);
		n.setColumns(10);
		
		em = new JTextField();
		em.setBounds(146, 133, 152, 20);
		frmRegistrationForm.getContentPane().add(em);
		em.setColumns(10);
		
		p = new JPasswordField();
		p.setBounds(146, 177, 152, 20);
		frmRegistrationForm.getContentPane().add(p);
		
		JRadioButton r1 = new JRadioButton("Male");
		r1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		r1.setBounds(143, 209, 89, 23);
		frmRegistrationForm.getContentPane().add(r1);
		
		JRadioButton r2 = new JRadioButton("Female");
		r2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		r2.setBounds(247, 209, 89, 23);
		frmRegistrationForm.getContentPane().add(r2);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(r1);
        bg.add(r2);
        
		JComboBox c1 = new JComboBox();
		c1.setModel(new DefaultComboBoxModel(new String[] {"Select", "C", "Java", "C++", "Python", "HTML", "CSS"}));
		c1.setBounds(146, 251, 152, 22);
		frmRegistrationForm.getContentPane().add(c1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String name=n.getText();
			String email=em.getText();
			String password=p.getText();
			String program=(String) c1.getSelectedItem();
			String gender;
			if(r1.isSelected()) {
				gender="female";
			}
			else if(r2.isSelected()){
				gender="Male";
			}
			else {
				gender="Invalid";
			}
			try {
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/3year","root","mrec");
				String q="Insert into student values('"+name+"','"+email+"','"+password+"','"+gender+"','"+program+"')";
				Statement sta=con.createStatement();
				sta.executeUpdate(q);
				con.close();
				JOptionPane.showMessageDialog(btnNewButton,"Done!");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(102, 321, 89, 23);
		frmRegistrationForm.getContentPane().add(btnNewButton);
	}
}
