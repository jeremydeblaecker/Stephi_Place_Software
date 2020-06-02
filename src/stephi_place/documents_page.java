package stephi_place;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;

public class documents_page extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					documents_page frame = new documents_page();
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
	public documents_page() {
		setBounds(100, 100, 633, 441);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnGestionDesDocuments = new JTextPane();
		txtpnGestionDesDocuments.setText("Gestion des documents");
		txtpnGestionDesDocuments.setForeground(Color.WHITE);
		txtpnGestionDesDocuments.setFont(new Font("Tahoma", Font.BOLD, 35));
		txtpnGestionDesDocuments.setBackground(Color.DARK_GRAY);
		txtpnGestionDesDocuments.setBounds(10, 11, 446, 43);
		contentPane.add(txtpnGestionDesDocuments);
	}

}
