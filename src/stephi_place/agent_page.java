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

public class agent_page extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					agent_page frame = new agent_page();
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
	public agent_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 212);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEspaceAgentImmobilier = new JLabel("ESPACE AGENT IMMOBILIER");
		lblEspaceAgentImmobilier.setForeground(Color.WHITE);
		lblEspaceAgentImmobilier.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEspaceAgentImmobilier.setBackground(Color.DARK_GRAY);
		lblEspaceAgentImmobilier.setBounds(10, 11, 263, 14);
		contentPane.add(lblEspaceAgentImmobilier);
		
		JButton btnNewButton = new JButton("Pr\u00E9f\u00E9rences");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				preference_page pp = new preference_page();
				pp.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 56, 154, 23);
		contentPane.add(btnNewButton);
		
		JButton btnGrrLesClients = new JButton("G\u00E9r\u00E9r les clients");
		btnGrrLesClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_client ac = new add_client();
				ac.setVisible(true);
			}
		});
		btnGrrLesClients.setBounds(197, 56, 154, 23);
		contentPane.add(btnGrrLesClients);
		
		JButton btnNewButton_1 = new JButton("Gestion des biens");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				biens_page bp = new biens_page();
				bp.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 102, 154, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnTableauDeBord = new JButton("Tableau de bord");
		btnTableauDeBord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableau_page tp = new tableau_page();
				tp.setVisible(true);
			}
		});
		btnTableauDeBord.setBounds(197, 102, 154, 23);
		contentPane.add(btnTableauDeBord);
		
		JButton btnGestionDesDocuments = new JButton("Gestion des documents");
		btnGestionDesDocuments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				documents_page dp = new documents_page();
				dp.setVisible(true);	
			}
		});
		btnGestionDesDocuments.setBounds(104, 136, 154, 23);
		contentPane.add(btnGestionDesDocuments);
	}
}
