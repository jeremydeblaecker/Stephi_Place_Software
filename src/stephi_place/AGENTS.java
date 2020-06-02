package stephi_place;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.util.logging.Level;


public class AGENTS { //la classe agents
	 connection my_connection = new connection();

	 //creer une function qui ajoute les agents
	 public boolean addAgent(String fnom, String fprenom, String fUsername, String fpassword)
	 
	 {
		 PreparedStatement st;
		 String addQuery = "INSERT INTO `agents`(`prenom`, `nom`, `username`, `password`) VALUES (?,?,?,?)";
		 
		 try {
			 
		 st = connection.getConnection().prepareStatement(addQuery);
				 
		 st.setString(1, fnom);
		 st.setString(2, fprenom);
		 st.setString(3, fUsername);
		 st.setString(4, fpassword);

		 
		 return (st.executeUpdate()>0);
	

		 }catch (SQLException ex) {
			 Logger.getLogger(AGENTS.class.getName()).log(Level.SEVERE, null, ex);
			 return false;
		 }
		 
	 }
	 //creer une fonction qui modifie le client selectionne
	 public boolean editAgent(int id, String fnom, String fprenom, String fUsername, String fpassword)
	 {
		 PreparedStatement st;
		 String editQuery = "UPDATE `agents` SET `prenom`=?, `nom`=?,`username`=?,`password`=? WHERE`id_agents`=?";
		 
		 try {
			 
		 st = connection.getConnection().prepareStatement(editQuery);
		 
		 st.setString(1, fprenom);
		 st.setString(2, fnom);
		 st.setString(3, fUsername);
		 st.setString(4, fpassword);
		 st.setInt(5, id);

		 return (st.executeUpdate()>0);


		 }catch (SQLException ex) {
			 Logger.getLogger(AGENTS.class.getName()).log(Level.SEVERE, null, ex);
			 return false;
		 }
		 
	 }
	 //creer une fonction qui supprime le client selectionne
	 public boolean removeAgent(int id) 
	 {
		 PreparedStatement st;
		 ResultSet rs;
		 String deleteQuery = "DELETE FROM `agents` WHERE `id_agents`=?";
		 
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
		 String selectQuery = "SELECT * FROM `agents`";
		 
		 try {
			 
		 ps = connection.getConnection().prepareStatement(selectQuery);
		 
		 rs = ps.executeQuery();
		 
		 DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
		 
		 Object[] row;
		 
		 while(rs.next())
		 {
			 row = new Object[5];
			 row[0] = rs.getInt(1); 
			 row[1] = rs.getString(2); 
			 row[2] = rs.getString(3); 
			 row[3] = rs.getString(4); 
			 row[4] = rs.getString(5); 

			 
			 tableModel.addRow(row);
		 }
		 
		 }catch(SQLException ex){
			 Logger.getLogger(AGENTS.class.getName()).log(Level.SEVERE, null, ex);
		 }
		 
	}
	 
}
