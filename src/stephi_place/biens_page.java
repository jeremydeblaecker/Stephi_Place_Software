package stephi_place;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class biens_page extends JFrame {
	Connection conn;
	ResultSet rs;
	PreparedStatement pst;
	
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					biens_page frame = new biens_page();
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
	public biens_page() {
		setBounds(100, 100, 834, 522);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(111, 310, 165, 20);
		contentPane.add(comboBox);
		BIENS biens = new BIENS();

		JTextPane txtpnGestionBiens = new JTextPane();
		txtpnGestionBiens.setText("Gestion biens");
		txtpnGestionBiens.setForeground(Color.WHITE);
		txtpnGestionBiens.setFont(new Font("Tahoma", Font.BOLD, 35));
		txtpnGestionBiens.setBackground(Color.DARK_GRAY);
		txtpnGestionBiens.setBounds(10, 11, 252, 43);
		contentPane.add(txtpnGestionBiens);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("Champs à remplir");
		textPane.setForeground(Color.WHITE);
		textPane.setFont(new Font("Tahoma", Font.BOLD, 20));
		textPane.setBackground(Color.DARK_GRAY);
		textPane.setBounds(10, 65, 218, 32);
		contentPane.add(textPane);
		
		biens.fillType_Chambre_JCombobox(comboBox);
        
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				
				int rIndex = table.getSelectedRow();

				textField.setText(model.getValueAt(rIndex, 0).toString());
				textField_1.setText(model.getValueAt(rIndex, 1).toString());
				textField_2.setText(model.getValueAt(rIndex, 2).toString());
				textField_3.setText(model.getValueAt(rIndex, 3).toString());
				textField_4.setText(model.getValueAt(rIndex, 4).toString());
				textField_5.setText(model.getValueAt(rIndex, 5).toString());
				textField_6.setText(model.getValueAt(rIndex, 6).toString());
				comboBox.setToolTipText(model.getValueAt(rIndex, 7).toString());
			}});
		
		table.setBounds(286, 11, 514, 429);
		contentPane.add(table);
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{"ID", "Surface", "Adresse", "Code_Postal", "Nbr_Pieces", "Description", "Prix", "Type"},
				},
				new String[] {
					 "ID", "Surface", "Adresse", "Code_Postal", "Nbr_Pieces", "Description", "Prix", "Type"}
			)
			);
		
		JButton button = new JButton("Refresh");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//clear le tableau
				table.setModel(new DefaultTableModel(null, new Object[] {"ID", "Surface", "Adresse", "Code_Postal", "Nbr_Pieces", "Description", "Prix", "Type"}));
				//puis on le re-rempli
				biens.fillBiensJTable(table);
			}
		});
		button.setBounds(286, 451, 514, 21);
		contentPane.add(button);
		
		JButton btnAjouterBien = new JButton("Ajouter bien");
		btnAjouterBien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int TypeBiens = Integer.valueOf(comboBox.getSelectedItem().toString());
				String fsurface = textField_1.getText();
				String fadresse = textField_2.getText();
				String fcode = textField_3.getText();				
				String fnbrpieces = textField_4.getText();
				String descrip = textField_5.getText();
				String prix = textField_6.getText();	

				if(fnbrpieces.trim().equals("") ||fsurface.trim().equals("") ||fadresse.trim().equals("") ||fcode.trim().equals("")||descrip.trim().equals("") ||prix.trim().equals(""))
				{
					JOptionPane.showMessageDialog(rootPane, "Champ requis -> Surface, Adresse, Code_Postal, Nbr_Pieces, Description, Prix, Type", "Champ Vide", JOptionPane.WARNING_MESSAGE);
				}
				else {
					if(biens.addBiens(TypeBiens, fsurface, fadresse, fcode, fnbrpieces, descrip, prix))
				{
					JOptionPane.showMessageDialog(rootPane, "Agent bien", "Ajouter bien", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(rootPane, "Echec de l'ajout", "Erreur Ajouter Bien", JOptionPane.ERROR_MESSAGE);
				}
					
				}
			}
		});
		btnAjouterBien.setBounds(10, 373, 112, 21);
		contentPane.add(btnAjouterBien);
		
		JButton button_1 = new JButton("Supprimer");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//on supprime le bien
				int TypeBiens = Integer.valueOf(comboBox.getSelectedItem().toString());
				String fsurface = textField_1.getText();
				String fadresse = textField_2.getText();
				String fcode = textField_3.getText();				
				String fnbrpieces = textField_4.getText();
				String descrip = textField_5.getText();
				String prix = textField_6.getText();			
				int id = Integer.valueOf(textField.getText());
				
				if(biens.removeBiens(id))
				{
					JOptionPane.showMessageDialog(rootPane, "Bien supprime avec succes", "Supprimer Bien", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(rootPane, "Echec de la suppression", "Erreur Supprimer Bien", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button_1.setBounds(132, 373, 109, 21);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Modifier");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int TypeBiens = Integer.valueOf(comboBox.getSelectedItem().toString());
				String fsurface = textField_1.getText();
				String fadresse = textField_2.getText();
				String fcode = textField_3.getText();				
				String fnbrpieces = textField_4.getText();
				String descrip = textField_5.getText();
				String prix = textField_6.getText();			
				int id = Integer.valueOf(textField.getText());


				
				if(fsurface.trim().equals("") ||fadresse.trim().equals("") ||fcode.trim().equals("") ||fnbrpieces.trim().equals("")||descrip.trim().equals("")||prix.trim().equals(""))
				{
					JOptionPane.showMessageDialog(rootPane, "Champ requis -> Nom, Prenomn, Username, Password", "Champ Vide", JOptionPane.WARNING_MESSAGE);
				}
				else {
					if(biens.editBiens(TypeBiens, fsurface, fadresse, fcode, fnbrpieces, descrip, prix, id))
				{
					JOptionPane.showMessageDialog(rootPane, "Biens modifie avec succes", "Modifier Biens", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(rootPane, "Echec de la mofication", "Erreur modifier Biens", JOptionPane.ERROR_MESSAGE);
				}
					
				}			
				
			}
		});
		button_2.setBounds(10, 404, 112, 21);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Vider champs");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//supprime le text des jtextfields
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
			}
		});
		button_3.setBounds(132, 404, 112, 21);
		contentPane.add(button_3);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("ID");
		textPane_1.setBounds(10, 100, 91, 19);
		contentPane.add(textPane_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(111, 100, 165, 19);
		contentPane.add(textField);
		
		JTextPane txtpnSurface = new JTextPane();
		txtpnSurface.setText("Surface");
		txtpnSurface.setBounds(10, 130, 91, 19);
		contentPane.add(txtpnSurface);
		
		JTextPane txtpnAdresse = new JTextPane();
		txtpnAdresse.setText("Adresse");
		txtpnAdresse.setBounds(10, 160, 91, 19);
		contentPane.add(txtpnAdresse);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(111, 130, 165, 19);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(111, 160, 165, 19);
		contentPane.add(textField_2);
		
		JTextPane txtpnCode = new JTextPane();
		txtpnCode.setText("Code Postal");
		txtpnCode.setBounds(10, 190, 91, 19);
		contentPane.add(txtpnCode);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(111, 190, 165, 19);
		contentPane.add(textField_3);
		
		JTextPane txtpnNbrPieces = new JTextPane();
		txtpnNbrPieces.setText("Nbr Pieces");
		txtpnNbrPieces.setBounds(10, 221, 91, 19);
		contentPane.add(txtpnNbrPieces);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(111, 220, 165, 19);
		contentPane.add(textField_4);
		
		JTextPane txtpnDescription = new JTextPane();
		txtpnDescription.setText("Description");
		txtpnDescription.setBounds(10, 251, 91, 19);
		contentPane.add(txtpnDescription);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(111, 251, 165, 19);
		contentPane.add(textField_5);
		
		JTextPane txtpnPrixMisEn = new JTextPane();
		txtpnPrixMisEn.setText("Prix mis en vente");
		txtpnPrixMisEn.setBounds(10, 281, 91, 19);
		contentPane.add(txtpnPrixMisEn);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(111, 281, 165, 19);
		contentPane.add(textField_6);
		
		JTextPane textPaneType = new JTextPane();
		textPaneType.setText("Type");
		textPaneType.setBounds(10, 311, 91, 19);
		contentPane.add(textPaneType);
	
		
		JButton btnAfficherType = new JButton("Afficher type");
		btnAfficherType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TYPE_PROP TypeBiens = new TYPE_PROP(); 
				TypeBiens.setVisible(true);
				TypeBiens.pack();
				TypeBiens.setLocationRelativeTo(null);
				
				TypeBiens.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
				
			}
		});
		btnAfficherType.setBounds(10, 436, 231, 36);
		contentPane.add(btnAfficherType);
		
		
	}
}
