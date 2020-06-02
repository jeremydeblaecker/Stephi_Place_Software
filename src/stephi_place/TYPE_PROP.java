package stephi_place;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class TYPE_PROP extends JFrame {

	private JPanel contentPane;
	private JTable tableType;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TYPE_PROP frame = new TYPE_PROP();
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
	public TYPE_PROP() {
		setBackground(Color.DARK_GRAY);
		setBounds(100, 100, 563, 425);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tableType = new JTable();
		tableType.setBackground(Color.WHITE);
		tableType.setModel(new DefaultTableModel(
			new Object[][] {
				{"TypeID", "Label", "Description"},
			},
			new String[] {
				"TypeID", "Label", "Description"
			}
		));
		tableType.getColumnModel().getColumn(0).setPreferredWidth(101);
		
		BIENS bien = new BIENS();
		bien.fillType_Biens_JTable(tableType);
		tableType.setBounds(36, 36, 477, 308);
		contentPane.add(tableType);
	}

}
