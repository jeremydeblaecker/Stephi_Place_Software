package stephi_place;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class admin_page extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_page frame = new admin_page();
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
	public admin_page() {
		setBounds(100, 100, 409, 163);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAgent = new JLabel("ESPACE ADMINISTRATEUR");
		lblAgent.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAgent.setForeground(Color.WHITE);
		lblAgent.setBackground(Color.DARK_GRAY);
		lblAgent.setBounds(10, 11, 224, 14);
		contentPane.add(lblAgent);
		
		JButton btnNewButton = new JButton("Agences");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agences_page ap = new agences_page();
				ap.setVisible(true);
			}
		});
		btnNewButton.setBounds(57, 61, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnAgentsImmobiliers = new JButton("Agents immobiliers");
		btnAgentsImmobiliers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestionagent_page agp = new gestionagent_page();
				agp.setVisible(true);
			}
		});
		btnAgentsImmobiliers.setBounds(184, 61, 148, 23);
		contentPane.add(btnAgentsImmobiliers);
	}
	
	public admin_page(String Uname){
		
	}
}
