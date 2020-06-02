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

public class add_client extends JFrame {

	private JPanel contentPane;
	Connection conn;
	ResultSet rs;
	PreparedStatement pst;
	private JTextField txtId;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldUsername;
	private JTextField textFieldTel;
	private JTable table;
	private JTextField textFieldPassword;
	private JTextField textFieldAdresse;
	private JTextField textFieldPostal;
	private JTextField textFieldEmail;
	/**
	 * Launch the application.
	 */
	
	public static void GestiondesClients() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_client frame = new add_client();
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
	public add_client() {
		
		setBounds(100, 100, 910, 564);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtId = new JTextField();
		txtId.setBounds(72, 65, 165, 19);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JTextPane txtpnId = new JTextPane();
		txtpnId.setText("ID");
		txtpnId.setBounds(10, 65, 52, 19);
		contentPane.add(txtpnId);
		
		JTextPane txtpnNom = new JTextPane();
		txtpnNom.setText("Nom");
		txtpnNom.setBounds(10, 122, 52, 19);
		contentPane.add(txtpnNom);
		
		textFieldNom = new JTextField();
		textFieldNom.setColumns(10);
		textFieldNom.setBounds(72, 122, 165, 19);
		contentPane.add(textFieldNom);
		
		JTextPane txtpnPrnom = new JTextPane();
		txtpnPrnom.setText("Pr\u00E9nom");
		txtpnPrnom.setBounds(10, 94, 52, 19);
		contentPane.add(txtpnPrnom);
		
		JTextPane txtpnCin = new JTextPane();
		txtpnCin.setText("Username");
		txtpnCin.setBounds(10, 152, 52, 19);
		contentPane.add(txtpnCin);
		
		JTextPane txtpnTel = new JTextPane();
		txtpnTel.setText("Tel");
		txtpnTel.setBounds(10, 211, 52, 19);
		contentPane.add(txtpnTel);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setColumns(10);
		textFieldPrenom.setBounds(72, 95, 165, 19);
		contentPane.add(textFieldPrenom);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setColumns(10);
		textFieldUsername.setBounds(72, 152, 165, 19);
		contentPane.add(textFieldUsername);
		
		textFieldTel = new JTextField();
		textFieldTel.setColumns(10);
		textFieldTel.setBounds(72, 212, 165, 19);
		contentPane.add(textFieldTel);
		
		JComboBox comboBoxRole = new JComboBox();
		comboBoxRole.setModel(new DefaultComboBoxModel(new String[] {"Choisir", "Acheteur", "Vendeur"}));
		comboBoxRole.setBounds(72, 240, 165, 20);
		contentPane.add(comboBoxRole);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				
				int rIndex = table.getSelectedRow();
				
				txtId.setText(model.getValueAt(rIndex, 0).toString());
				textFieldNom.setText(model.getValueAt(rIndex, 1).toString());
				textFieldPrenom.setText(model.getValueAt(rIndex, 2).toString());
				textFieldUsername.setText(model.getValueAt(rIndex, 3).toString());
				textFieldTel.setText(model.getValueAt(rIndex, 4).toString());
				textFieldPassword.setText(model.getValueAt(rIndex, 5).toString());
				comboBoxRole.setToolTipText(model.getValueAt(rIndex, 6).toString());
				textFieldAdresse.setText(model.getValueAt(rIndex, 7).toString());
				textFieldPostal.setText(model.getValueAt(rIndex, 8).toString());
				textFieldEmail.setText(model.getValueAt(rIndex, 9).toString());

			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "Pr\u00E9nom", "Nom", "Username", "Password", "Role", "Code Postal", "Tel", "Email", "Adresse"},
			},
			new String[] {
				"ID", "Pr\u00E9nom", "Nom", "Username", "Password", "Role", "Code Postal", "Tel", "Email", "Adresse"
			}
		)
		);
		table.setBounds(251, 76, 633, 406);
		contentPane.add(table);
		
		CLIENT client = new CLIENT();
		
		client.fillClientJTable(table);
		JButton btnAjouterClient = new JButton("Ajouter Client");
		btnAjouterClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ajouter un nouveau client
				
				//obtenir les informations des fields
				String fnom = textFieldNom.getText();
				String fprenom = textFieldPrenom.getText();				
				String fUsername = textFieldUsername.getText();
				String ftel = textFieldTel.getText();
				String fPass = textFieldPassword.getText();
				String fRole = String.valueOf(comboBoxRole.getSelectedItem().toString());
				String fAdresse = textFieldAdresse.getText();
				String fEmail = textFieldEmail.getText();
				String fcode = textFieldPostal.getText();

				
				if(fnom.trim().equals("") ||fprenom.trim().equals("") ||fUsername.trim().equals("") ||ftel.trim().equals("")||fPass.trim().equals("") ||fAdresse.trim().equals("") ||fEmail.trim().equals(""))
				{
					JOptionPane.showMessageDialog(rootPane, "Champ requis -> Nom, Prenomn, Username, Telephone, Password, Role, Adresse, Email", "Champ Vide", JOptionPane.WARNING_MESSAGE);
				}
				else {
					if(client.addClient(fprenom, fnom, fUsername, fPass, fRole, fcode,  ftel, fEmail, fAdresse))
				{
					JOptionPane.showMessageDialog(rootPane, "Nouveau Client ajoute avec succes", "Ajouter Client", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(rootPane, "Echec de l'ajout du client", "Erreur Ajouter Client", JOptionPane.ERROR_MESSAGE);
				}
					
				}

			}
		});
		btnAjouterClient.setBounds(10, 461, 112, 21);
		contentPane.add(btnAjouterClient);
		
		JButton buttonSupprimer = new JButton("Supprimer");
		buttonSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//on supprime le client s�lectionn�
				int id_client = Integer.valueOf(txtId.getText());
				
				if(client.removeClient(id_client))
				{
					JOptionPane.showMessageDialog(rootPane, "Client supprime avec succes", "Supprimer Client", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(rootPane, "Echec de la suppression du client", "Erreur Supprimer Client", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		buttonSupprimer.setBounds(129, 461, 109, 21);
		contentPane.add(buttonSupprimer);
		
		JButton buttonModifier = new JButton("Modifier");
		buttonModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//modifier l'user selectionne
				
				//obtenir les info depuis les champs
				int id_client = Integer.valueOf(txtId.getText());
				String fnom = textFieldNom.getText();
				String fprenom = textFieldPrenom.getText();				
				String fUsername = textFieldUsername.getText();
				String ftel = textFieldTel.getText();
				String fPass = textFieldPassword.getText();
				String fRole = String.valueOf(comboBoxRole.getSelectedItem().toString());
				String fAdresse = textFieldAdresse.getText();
				String fEmail = textFieldEmail.getText();
				int fcode = Integer.valueOf(textFieldPostal.getText());

				
				if(fnom.trim().equals("") ||fprenom.trim().equals("") ||fUsername.trim().equals("") ||ftel.trim().equals("")||fPass.trim().equals("") ||fRole.trim().equals("") ||fAdresse.trim().equals("") ||fEmail.trim().equals(""))
				{
					JOptionPane.showMessageDialog(rootPane, "Champ requis -> Nom, Prenomn, Username, Telephone, Password, Role, Adresse, Email", "Champ Vide", JOptionPane.WARNING_MESSAGE);
				}
				else {
					if(client.editClient(id_client, fnom, fprenom, fUsername, ftel, fPass, fRole, fAdresse, fEmail, fcode))
				{
					JOptionPane.showMessageDialog(rootPane, "Client modifie avec succes", "Modifier Client", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(rootPane, "Echec de la mofication du client", "Erreur modifier Client", JOptionPane.ERROR_MESSAGE);
				}
					
				}
			}
		});
		buttonModifier.setBounds(10, 493, 112, 21);
		contentPane.add(buttonModifier);
		
		JButton btnClear = new JButton("Vider champs");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//supprime le text des jtextfields
				txtId.setText("");
				textFieldNom.setText("");
				textFieldPrenom.setText("");
				textFieldUsername.setText("");
				textFieldTel.setText("");
				textFieldPassword.setText("");
				comboBoxRole.setToolTipText("");
				textFieldAdresse.setText("");
				textFieldEmail.setText("");
			}
		});
		btnClear.setBounds(129, 493, 112, 21);
		contentPane.add(btnClear);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//clear le tableau
				table.setModel(new DefaultTableModel(null, new Object[] {"ID", "Nom", "Prenom", "Username", "Tel", "Password", "Role", "Adresse", "Code", "Email"}));
				//puis on le rerempli
				client.fillClientJTable(table);
			}
		});
		btnRefresh.setBounds(251, 493, 633, 21);
		contentPane.add(btnRefresh);
		
		JTextPane txtpnGrerLesClients = new JTextPane();
		txtpnGrerLesClients.setText("G\u00E9rer les clients");
		txtpnGrerLesClients.setForeground(Color.WHITE);
		txtpnGrerLesClients.setFont(new Font("Tahoma", Font.BOLD, 35));
		txtpnGrerLesClients.setBackground(Color.DARK_GRAY);
		txtpnGrerLesClients.setBounds(251, 28, 348, 49);
		contentPane.add(txtpnGrerLesClients);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("Champs \u00E0 remplir");
		textPane.setForeground(Color.WHITE);
		textPane.setFont(new Font("Tahoma", Font.BOLD, 20));
		textPane.setBackground(Color.DARK_GRAY);
		textPane.setBounds(10, 28, 218, 32);
		contentPane.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("Champs \u00E0 remplir");
		textPane_1.setForeground(Color.WHITE);
		textPane_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		textPane_1.setBackground(Color.DARK_GRAY);
		textPane_1.setBounds(10, 418, 218, 32);
		contentPane.add(textPane_1);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(72, 182, 165, 19);
		contentPane.add(textFieldPassword);
		
		textFieldAdresse = new JTextField();
		textFieldAdresse.setColumns(10);
		textFieldAdresse.setBounds(72, 301, 165, 19);
		contentPane.add(textFieldAdresse);
		
		JTextPane textPanePassword = new JTextPane();
		textPanePassword.setText("Password");
		textPanePassword.setBounds(10, 182, 52, 19);
		contentPane.add(textPanePassword);
		
		JTextPane txtpnRole = new JTextPane();
		txtpnRole.setText("Role");
		txtpnRole.setBounds(10, 241, 52, 19);
		contentPane.add(txtpnRole);
		
		
		JTextPane txtpnAdresse = new JTextPane();
		txtpnAdresse.setText("Adresse");
		txtpnAdresse.setBounds(10, 301, 52, 19);
		contentPane.add(txtpnAdresse);
		
		JTextPane txtpnCodePostal = new JTextPane();
		txtpnCodePostal.setText("Code Postal");
		txtpnCodePostal.setBounds(10, 271, 52, 19);
		contentPane.add(txtpnCodePostal);
		
		textFieldPostal = new JTextField();
		textFieldPostal.setColumns(10);
		textFieldPostal.setBounds(72, 271, 165, 19);
		contentPane.add(textFieldPostal);
		
		JTextPane txtpnEmail = new JTextPane();
		txtpnEmail.setText("Email");
		txtpnEmail.setBounds(10, 331, 52, 19);
		contentPane.add(txtpnEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(72, 331, 165, 19);
		contentPane.add(textFieldEmail);
		
	}
}
