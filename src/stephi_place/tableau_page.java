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

public class tableau_page extends JFrame {

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
					tableau_page frame = new tableau_page();
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
	public tableau_page() {
		setBackground(Color.DARK_GRAY);
		setBounds(100, 100, 670, 254);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnTableauDeBord = new JTextPane();
		txtpnTableauDeBord.setText("Tableau de bord");
		txtpnTableauDeBord.setForeground(Color.WHITE);
		txtpnTableauDeBord.setFont(new Font("Tahoma", Font.BOLD, 35));
		txtpnTableauDeBord.setBackground(Color.DARK_GRAY);
		txtpnTableauDeBord.setBounds(10, 11, 337, 43);
		contentPane.add(txtpnTableauDeBord);
		
		JTextPane txtpnNombreDeVendeurs = new JTextPane();
		txtpnNombreDeVendeurs.setText("Nombre de vendeurs g\u00E9r\u00E9s");
		txtpnNombreDeVendeurs.setBounds(10, 65, 337, 19);
		contentPane.add(txtpnNombreDeVendeurs);
		
		JTextPane txtpnNombreDeBiens = new JTextPane();
		txtpnNombreDeBiens.setText("Nombre de biens en ventes en cours");
		txtpnNombreDeBiens.setBounds(10, 95, 337, 19);
		contentPane.add(txtpnNombreDeBiens);
		
		JTextPane txtpnNombreDeBiens_1 = new JTextPane();
		txtpnNombreDeBiens_1.setText("Nombre de biens en ventes r\u00E9\u00E9alis\u00E9s au cours du ternier trimestre");
		txtpnNombreDeBiens_1.setBounds(10, 125, 337, 19);
		contentPane.add(txtpnNombreDeBiens_1);
		
		JTextPane txtpnNombreTotalDe = new JTextPane();
		txtpnNombreTotalDe.setText("Nombre total de ventes");
		txtpnNombreTotalDe.setBounds(10, 155, 337, 19);
		contentPane.add(txtpnNombreTotalDe);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(357, 65, 281, 19);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(357, 95, 281, 19);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(357, 125, 281, 19);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(357, 155, 281, 19);
		contentPane.add(textField_3);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(10, 185, 89, 23);
		contentPane.add(btnRetour);
	}
}
