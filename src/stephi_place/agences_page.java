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
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class agences_page extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					agences_page frame = new agences_page();
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
	
	AGENCES agences = new AGENCES();

	public agences_page() {
		setBounds(100, 100, 883, 536);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnGestionAgences = new JTextPane();
		txtpnGestionAgences.setBounds(329, 11, 343, 49);
		txtpnGestionAgences.setText("Gestion agences");
		txtpnGestionAgences.setForeground(Color.WHITE);
		txtpnGestionAgences.setFont(new Font("Tahoma", Font.BOLD, 35));
		txtpnGestionAgences.setBackground(Color.DARK_GRAY);
		contentPane.add(txtpnGestionAgences);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				
				int rIndex = table.getSelectedRow();
				
				textField.setText(model.getValueAt(rIndex, 0).toString());
				textField_1.setText(model.getValueAt(rIndex, 1).toString());
				textField_2.setText(model.getValueAt(rIndex, 2).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "Nom", "Adresse"},
			},
			new String[] {
				"ID", "Nom", "Adresse"
			}
		)
		);
		table.setBounds(329, 71, 514, 383);
		contentPane.add(table);
		
		JButton button = new JButton("Refresh");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//clear le tableau
				table.setModel(new DefaultTableModel(null, new Object[] {"ID", "Nom", "Adresse"}));
				//puis on le rerempli
				agences.fillClientJTable(table);
			}
		});
		button.setBounds(329, 465, 514, 21);
		contentPane.add(button);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("Champs à remplir");
		textPane.setForeground(Color.WHITE);
		textPane.setFont(new Font("Tahoma", Font.BOLD, 20));
		textPane.setBackground(Color.DARK_GRAY);
		textPane.setBounds(10, 11, 218, 32);
		contentPane.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("ID");
		textPane_1.setBounds(10, 54, 92, 19);
		contentPane.add(textPane_1);
		
		textField = 
				new JTextField();
		textField.setColumns(10);
		textField.setBounds(112, 54, 165, 19);
		contentPane.add(textField);
		
		JTextPane txtpnAdresse = new JTextPane();
		txtpnAdresse.setText("Adresse agences");
		txtpnAdresse.setBounds(10, 87, 92, 19);
		contentPane.add(txtpnAdresse);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(112, 87, 165, 19);
		contentPane.add(textField_1);
		
		JTextPane txtpnNomAgences = new JTextPane();
		txtpnNomAgences.setText("Nom agences");
		txtpnNomAgences.setBounds(10, 117, 92, 19);
		contentPane.add(txtpnNomAgences);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(112, 117, 165, 19);
		contentPane.add(textField_2);
		
		JButton button_1 = new JButton("Ajouter agences");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ajouter une nouvel agence
				
				//obtenir les informations des fields
				String fnom = textField_1.getText();
				String fadresse = textField_2.getText();				

				
				if(fnom.trim().equals("") ||fadresse.trim().equals(""))
				{
					JOptionPane.showMessageDialog(rootPane, "Champ requis -> Nom et adresse", "Champ Vide", JOptionPane.WARNING_MESSAGE);
				}
				else {
					if(agences.addAgence(fnom, fadresse))
				{
					JOptionPane.showMessageDialog(rootPane, "Nouvel Agence ajoute avec succes", "Ajouter Agence", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(rootPane, "Echec de l'ajout de l'Agence", "Erreur Ajouter Agence", JOptionPane.ERROR_MESSAGE);
				}
					
				}

			}
		});
		button_1.setBounds(10, 433, 128, 21);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Supprimer");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//modifier l'user selectionne
				
				//obtenir les info depuis les champs
				int id_agences = Integer.valueOf(textField.getText());
				String fnom = textField_1.getText();
				String fadresse = textField_2.getText();		

				
				if(fnom.trim().equals("") ||fadresse.trim().equals("") )
				{
					JOptionPane.showMessageDialog(rootPane, "Champ requis -> Nom, Adresse", "Champ Vide", JOptionPane.WARNING_MESSAGE);
				}
				else {
					if(agences.editAgence(id_agences, fnom, fadresse))
				{
					JOptionPane.showMessageDialog(rootPane, "Agence modifie avec succes", "Modifier Agence", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(rootPane, "Echec de la mofication de l'agent", "Erreur modification Agence", JOptionPane.ERROR_MESSAGE);
				}
					
				}
			}
		});
		button_2.setBounds(156, 433, 121, 21);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Modifier");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button_3.setBounds(10, 464, 128, 21);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("Vider champs");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//supprime le text des jtextfields
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		button_4.setBounds(156, 465, 121, 21);
		contentPane.add(button_4);
	}

}
