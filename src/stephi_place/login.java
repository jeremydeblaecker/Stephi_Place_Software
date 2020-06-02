package stephi_place;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;


public class login {

	protected static final Component parentComponent = null;
	JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JPasswordField TextField_1;
	
	
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
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 449, 323);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Connexion agents immobiliers");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(87, 24, 266, 23);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(87, 78, 98, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(87, 109, 72, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(195, 75, 158, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//login
				String uname = textField.getText();
				String pword = TextField_1.getText();
				
				if(uname.contentEquals("")|pword.equals("")) {
					JOptionPane.showMessageDialog(parentComponent, "Champ vide","Error", 1);
				}else {
					try {
						con = connection.getConnection();
						pst = con.prepareStatement("select  * from agents where username=? and password=?");
						pst.setString(1, uname);
						pst.setString(2, pword);
						rs = pst.executeQuery();
						if(rs.next()) {
								agent_page ad = new agent_page();
								ad.setVisible(true);
								//frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
						}else {
							JOptionPane.showMessageDialog(parentComponent, "Username et password ne correspondent pas", "Error", 1);
						}
					}catch(Exception ex) {
						System.out.println(""+ex);
					}
				}
			}
		});
		btnNewButton.setBounds(161, 137, 113, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnEspaceAdmin = new JButton("Espace admin");
		btnEspaceAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login_admin la = new login_admin();
				la.setVisible(true);
			}
		});
		btnEspaceAdmin.setBounds(10, 250, 122, 23);
		frame.getContentPane().add(btnEspaceAdmin);
		
		TextField_1 = new JPasswordField();
		TextField_1.setBounds(195, 106, 158, 20);
		frame.getContentPane().add(TextField_1);
	}
}
