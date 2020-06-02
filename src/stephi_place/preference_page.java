package stephi_place;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class preference_page extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					preference_page frame = new preference_page();
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
	public preference_page() {
		setBounds(100, 100, 295, 270);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnPrfrences = new JTextPane();
		txtpnPrfrences.setText("Pr\u00E9f\u00E9rences");
		txtpnPrfrences.setForeground(Color.WHITE);
		txtpnPrfrences.setFont(new Font("Tahoma", Font.BOLD, 35));
		txtpnPrfrences.setBackground(Color.DARK_GRAY);
		txtpnPrfrences.setBounds(10, 11, 337, 43);
		contentPane.add(txtpnPrfrences);
		
		JTextPane txtpnNom = new JTextPane();
		txtpnNom.setToolTipText("");
		txtpnNom.setText("Nom");
		txtpnNom.setBounds(10, 65, 52, 19);
		contentPane.add(txtpnNom);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(72, 65, 165, 19);
		contentPane.add(textField);
		
		JTextPane txtpnMail = new JTextPane();
		txtpnMail.setToolTipText("");
		txtpnMail.setText("Mail");
		txtpnMail.setBounds(10, 95, 52, 19);
		contentPane.add(txtpnMail);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(72, 95, 165, 19);
		contentPane.add(textField_1);
		
		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setToolTipText("");
		txtpnPassword.setText("Password");
		txtpnPassword.setBounds(10, 125, 52, 19);
		contentPane.add(txtpnPassword);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(72, 125, 165, 19);
		contentPane.add(textField_2);
		
		JTextPane txtpnPrnom = new JTextPane();
		txtpnPrnom.setToolTipText("");
		txtpnPrnom.setText("Pr\u00E9nom");
		txtpnPrnom.setBounds(10, 155, 52, 19);
		contentPane.add(txtpnPrnom);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(72, 155, 165, 19);
		contentPane.add(textField_3);
		
		JButton btnSauvegarder = new JButton("Sauvegarder");
		btnSauvegarder.setBounds(10, 198, 114, 23);
		contentPane.add(btnSauvegarder);
	}
}
