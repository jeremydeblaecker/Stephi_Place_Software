package stephi_place;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.util.logging.Level;


public class AGENCES { //la classe agences
	 connection my_connection = new connection();

	 //creer une function qui ajoute l'agence
	 public boolean addAgence(String fnom, String fadresse)
	 
	 {
		 PreparedStatement st;
		 String addQuery = "INSERT INTO `agences`(`nom`, `adresse_siege`) VALUES (?,?)";
		 
		 try {
			 
		 st = connection.getConnection().prepareStatement(addQuery);
				 
		 st.setString(1, fnom);
		 st.setString(2, fadresse);

		 
		 return (st.executeUpdate()>0);
	

		 }catch (SQLException ex) {
			 Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
			 return false;
		 }
		 
	 }
	 //creer une fonction qui modifie le client selectionne
	 public boolean editAgence(int id, String fnom, String fadresse)
	 {
		 PreparedStatement st;
		 String editQuery = "UPDATE `agences` SET `nom`=?,`adresse_siege`=? WHERE`id`=?";
		 
		 try {
			 
		 st = connection.getConnection().prepareStatement(editQuery);
		 
		 st.setString(1, fnom);
		 st.setString(2, fadresse);

		 return (st.executeUpdate()>0);


		 }catch (SQLException ex) {
			 Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
			 return false;
		 }
		 
	 }
	 //creer une fonction qui supprime le client selectionne
	 public boolean removeAgence(int id) 
	 {
		 PreparedStatement st;
		 ResultSet rs;
		 String deleteQuery = "DELETE FROM `agences` WHERE `id_agences`=?";
		 
		 try {
			 
		 st = connection.getConnection().prepareStatement(deleteQuery);
		 
		 st.setInt(1, id);

		 return (st.executeUpdate()>0);


		 }catch (SQLException ex) {
			 Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
			 return false;
		 }
	 }
	 //creer une fonction qui remplit le tableau de client grace a la bdd
	 public void fillClientJTable(JTable table)
	 {
		 PreparedStatement ps;
		 ResultSet rs;
		 String selectQuery = "SELECT * FROM `agences`";
		 
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
			 Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
		 }
		 
	}
	 
}
