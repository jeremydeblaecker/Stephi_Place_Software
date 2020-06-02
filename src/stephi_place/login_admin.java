package stephi_place;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;

public class login_admin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_admin frame = new login_admin();
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
	public login_admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 261);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConnexionAdmin = new JLabel("Connexion admin");
		lblConnexionAdmin.setForeground(Color.WHITE);
		lblConnexionAdmin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblConnexionAdmin.setBounds(151, 25, 137, 14);
		contentPane.add(lblConnexionAdmin);
		
		JLabel label = new JLabel("Username");
		label.setForeground(Color.WHITE);
		label.setBounds(83, 69, 98, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(83, 106, 72, 14);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(191, 66, 158, 20);
		contentPane.add(textField);
		
		JButton button = new JButton("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//login
				String uname = textField.getText();
				String pword = passwordField.getText();
				
				if(uname.contentEquals("")|pword.equals("")) {
					JOptionPane.showMessageDialog(getComponent(0), "Champ vide","Error", 1);
				}else {
					try {
						con = connection.getConnection();
						pst = con.prepareStatement("select  * from administrateur where username=? and password=?");
						pst.setString(1, uname);
						pst.setString(2, pword);
						rs = pst.executeQuery();
						if(rs.next()) {
								admin_page ad = new admin_page();
								ad.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(getComponent(0), "Username et password ne correspondent pas", "Error", 1);
						}
					}catch(Exception ex) {
						System.out.println(""+ex);
					}
				}
			}
		});
		button.setBounds(151, 156, 113, 23);
		contentPane.add(button);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(191, 103, 158, 20);
		contentPane.add(passwordField);
	}
}
