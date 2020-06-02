package stephi_place;

import java.awt.Color;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class gestionagent_page extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textID;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	Connection conn;
	ResultSet rs;
	PreparedStatement pst;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestionagent_page frame = new gestionagent_page();
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
	public gestionagent_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 307);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnGestionAgents = new JTextPane();
		txtpnGestionAgents.setText("Gestion agents");
		txtpnGestionAgents.setForeground(Color.WHITE);
		txtpnGestionAgents.setFont(new Font("Tahoma", Font.BOLD, 35));
		txtpnGestionAgents.setBackground(Color.DARK_GRAY);
		txtpnGestionAgents.setBounds(253, 0, 424, 49);
		contentPane.add(txtpnGestionAgents);
		
		AGENTS agent = new AGENTS();

		
		JButton button = new JButton("Vider champs");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//supprime le text des jtextfields
				textID.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
			}
		});
		button.setBounds(10, 237, 112, 21);
		contentPane.add(button);
		
		JButton btnAjouterAgents = new JButton("Ajouter agents");
		btnAjouterAgents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ajouter un agent
				
				//obtenir les informations des fields
				String fprenom = textField_1.getText();
				String fnom = textField_2.getText();				
				String fUsername = textField_3.getText();
				String fpassword = textField_4.getText();

				if(fnom.trim().equals("") ||fprenom.trim().equals("") ||fUsername.trim().equals("") ||fpassword.trim().equals(""))
				{
					JOptionPane.showMessageDialog(rootPane, "Champ requis -> Nom, Prenomn, Username, Password", "Champ Vide", JOptionPane.WARNING_MESSAGE);
				}
				else {
					if(agent.addAgent(fprenom, fnom, fUsername,fpassword))
				{
					JOptionPane.showMessageDialog(rootPane, "Agent ajouté", "Ajouter agent", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(rootPane, "Echec de l'ajout", "Erreur Ajouter Agent", JOptionPane.ERROR_MESSAGE);
				}
					
				}
			}
		});
		btnAjouterAgents.setBounds(10, 205, 112, 21);
		contentPane.add(btnAjouterAgents);
		
		JButton button_1 = new JButton("Supprimer");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//on supprime le client s�lectionn�
				int id_agents = Integer.valueOf(textID.getText());
				
				if(agent.removeAgent(id_agents))
				{
					JOptionPane.showMessageDialog(rootPane, "Agent supprime avec succes", "Supprimer Agent", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(rootPane, "Echec de la suppression", "Erreur Supprimer Agent", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		button_1.setBounds(132, 205, 96, 21);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Modifier");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//modifier l'user selectionne
				
				//obtenir les info depuis les champs
				int id_agents = Integer.valueOf(textID.getText());
				String fnom = textField_1.getText();
				String fprenom = textField_2.getText();				
				String fUsername = textField_3.getText();
				String fpassword = textField_4.getText();


				
				if(fnom.trim().equals("") ||fprenom.trim().equals("") ||fUsername.trim().equals("") ||fpassword.trim().equals(""))
				{
					JOptionPane.showMessageDialog(rootPane, "Champ requis -> Nom, Prenomn, Username, Password", "Champ Vide", JOptionPane.WARNING_MESSAGE);
				}
				else {
					if(agent.editAgent(id_agents, fnom, fprenom, fUsername, fpassword))
				{
					JOptionPane.showMessageDialog(rootPane, "Agent modifie avec succes", "Modifier Agent", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(rootPane, "Echec de la mofication", "Erreur modifier Agent", JOptionPane.ERROR_MESSAGE);
				}
					
				}
			}
		});
		button_2.setBounds(132, 237, 96, 21);
		contentPane.add(button_2);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				
				int rIndex = table.getSelectedRow();
				
				textID.setText(model.getValueAt(rIndex, 0).toString());
				textField_1.setText(model.getValueAt(rIndex, 1).toString());
				textField_2.setText(model.getValueAt(rIndex, 2).toString());
				textField_3.setText(model.getValueAt(rIndex, 3).toString());
				textField_4.setText(model.getValueAt(rIndex, 4).toString());

			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "Pr\u00E9nom", "Nom", "Username", "Password"},
			},
			new String[] {
				"ID", "Pr\u00E9nom", "Nom", "Username", "Password",}
		)
		);
		table.setBounds(263, 60, 364, 166);
		contentPane.add(table);
		
		JButton button_3 = new JButton("Refresh");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//clear le tableau
				table.setModel(new DefaultTableModel(null, new Object[] {"ID", "Pr\u00E9nom", "Nom", "Username", "Password"}));
				//puis on le re-rempli
				agent.fillClientJTable(table);
			}
		});
		button_3.setBounds(263, 237, 364, 21);
		contentPane.add(button_3);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("Champs \u00E0 remplir");
		textPane.setForeground(Color.WHITE);
		textPane.setFont(new Font("Tahoma", Font.BOLD, 20));
		textPane.setBackground(Color.DARK_GRAY);
		textPane.setBounds(10, 11, 218, 32);
		contentPane.add(textPane);
		
		JTextPane txtpnIdagences = new JTextPane();
		txtpnIdagences.setText("ID");
		txtpnIdagences.setBounds(10, 43, 92, 19);
		contentPane.add(txtpnIdagences);
		
		textID = new JTextField();
		textID.setColumns(10);
		textID.setBounds(112, 43, 121, 19);
		contentPane.add(textID);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("Prénom");
		textPane_1.setBounds(10, 73, 92, 19);
		contentPane.add(textPane_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(112, 73, 121, 19);
		contentPane.add(textField_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setText("Nom");
		textPane_2.setBounds(10, 103, 92, 19);
		contentPane.add(textPane_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(112, 103, 121, 19);
		contentPane.add(textField_2);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setText("Username");
		textPane_3.setBounds(10, 132, 92, 19);
		contentPane.add(textPane_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(112, 133, 121, 19);
		contentPane.add(textField_3);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setText("Password");
		textPane_4.setBounds(10, 162, 92, 19);
		contentPane.add(textPane_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(112, 162, 121, 19);
		contentPane.add(textField_4);
	}
}
