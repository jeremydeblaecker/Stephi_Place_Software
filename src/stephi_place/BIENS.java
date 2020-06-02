package stephi_place;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BIENS {
	
	connection my_connection = new connection();

	public void fillType_Biens_JTable(JTable table)
	 {
		 PreparedStatement ps;
		 ResultSet rs;
		 String selectQuery = "SELECT * FROM `type`";
		 
		 try {
			 
		 ps = connection.getConnection().prepareStatement(selectQuery);
		 
		 rs = ps.executeQuery();
		 
		 DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
		 
		 Object[] row;
		 
		 while(rs.next())
		 {
			 row = new Object[3];
			 row[0] = rs.getInt(1);
			 row[1] = rs.getString(2);
			 row[2] = rs.getString(3);
			 
			 tableModel.addRow(row);
		 }
		 
		 }catch(SQLException ex){
			 Logger.getLogger(BIENS.class.getName()).log(Level.SEVERE, null, ex);
		 }
		 
	}
	
	public void fillType_Chambre_JCombobox(JComboBox comboBoxType)
	 {
		 PreparedStatement ps;
		 ResultSet rs;
		 String selectQuery = "SELECT * FROM `type`";
		 
		 try {
			 
		 ps = connection.getConnection().prepareStatement(selectQuery);
		 
		 rs = ps.executeQuery();
		 
		 Object[] row;
		 
		 while(rs.next())
		 {
			 comboBoxType.addItem(rs.getInt(1));
		 }
		 
		 }catch(SQLException ex){
			 Logger.getLogger(BIENS.class.getName()).log(Level.SEVERE, null, ex);
		 }
		 
	}
	//creer une fonction qui permet d'jouter une chambre
	public boolean addBiens(int TypeBiens, String fsurface, String fadresse, String fcode, String fnbrpieces, String descrip, String prix)
	 
	 {
		 PreparedStatement st;
		 String addQuery = "INSERT INTO `biens`(`surface`, `adresse`, `code_postal`, `nbr_pieces`, `description`, `prix`, `type_bien`) VALUES (?,?,?,?,?,?,?)";
		 
		 try {
			 
		 st = connection.getConnection().prepareStatement(addQuery);
		 
		 st.setString(1, fsurface);
		 st.setString(2, fadresse);
		 st.setString(3, fcode);
		 st.setString(4, fnbrpieces);
		 st.setString(5, descrip);
		 st.setString(6, prix);
		 st.setInt(7, TypeBiens);
	
		 return (st.executeUpdate()>0);
	

		 }catch (SQLException ex) {
			 Logger.getLogger(BIENS.class.getName()).log(Level.SEVERE, null, ex);
			 return false;
		 }
		 
	 }
	//creer une fonction qui modifie la chambre selectionne
		 public boolean editBiens(int TypeBiens, String fsurface, String fadresse, String fcode, String fnbrpieces, String descrip, String prix, int id)
		 {
			 PreparedStatement st;
			 String editQuery = "UPDATE `biens` SET `surface`=?,`adresse`=?,`code_postal`=?,`nbr_pieces`=?,`description`=?,`prix`=?,`type_bien`=? WHERE `id`=?";
			 
			 try {
				 
			 st = connection.getConnection().prepareStatement(editQuery);
			 
			 st.setString(1, fsurface);
			 st.setString(2, fadresse);
			 st.setString(3, fcode);
			 st.setString(4, fnbrpieces);
			 st.setString(5, descrip);
			 st.setString(6, prix);
			 st.setInt(7, TypeBiens);	
			 st.setInt(8, id);		 


			 return (st.executeUpdate()>0);


			 }catch (SQLException ex) {
				 Logger.getLogger(BIENS.class.getName()).log(Level.SEVERE, null, ex);
				 return false;
			 }
			 
		 }
		 
		//creer une fonction qui supprime le bien selectionne
		 public boolean removeBiens(int id) 
		 {
			 PreparedStatement st;
			 String deleteQuery = "DELETE FROM `biens` WHERE `id`=?";
			 
			 try {
				 
			 st = connection.getConnection().prepareStatement(deleteQuery);
			 
			 st.setInt(1, id);

			 return (st.executeUpdate()>0);


			 }catch (SQLException ex) {
				 Logger.getLogger(BIENS.class.getName()).log(Level.SEVERE, null, ex);
				 return false;
			 }
		 }
		 
		//creer une fonction qui remplit le tableau de biens grace a la bdd
		 public void fillBiensJTable(JTable table)
		 {
			 PreparedStatement ps;
			 ResultSet rs;
			 String selectQuery = "SELECT * FROM `biens`";
			 
			 try {
				 
			 ps = connection.getConnection().prepareStatement(selectQuery);
			 
			 rs = ps.executeQuery();
			 
			 DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
			 
			 Object[] row;
			 
			 while(rs.next())
			 {
				 row = new Object[8];
				 row[0] = rs.getInt(1);
				 row[1] = rs.getString(2);
				 row[2] = rs.getString(3);
				 row[3] = rs.getString(4);
				 row[4] = rs.getString(5);
				 row[5] = rs.getString(6);
				 row[6] = rs.getString(7);
				 row[7] = rs.getString(8);

				 
				 tableModel.addRow(row);
			 }
			 
			 }catch(SQLException ex){
				 Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
			 }
			 
		}
}
