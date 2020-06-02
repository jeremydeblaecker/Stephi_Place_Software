package stephi_place;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.util.logging.Level;


public class CLIENT { //la classe client
	 connection my_connection = new connection();

	 //creer une function qui ajoute le client
	 public boolean addClient(String fprenom, String fnom,  String fUsername, String fPass,String fRole, String fcode, String ftel, String fEmail, String fAdresse )
	 
	 {
		 PreparedStatement st;
		 String addQuery = "INSERT INTO `utilisateurs`(`prenom`, `nom`, `username`, `password`, `role`, `code_postal`, `telephone`, `email`, `adresse`) VALUES (?,?,?,?,?,?,?,?,?)";
		 
		 try {
			 
		 st = connection.getConnection().prepareStatement(addQuery);
				 
		 st.setString(1, fprenom);
		 st.setString(2, fnom);
		 st.setString(3, fUsername);
		 st.setString(4, fPass);
		 st.setString(5, fRole);
		 st.setString(6, fcode);
		 st.setString(7, ftel);
		 st.setString(8, fEmail);
		 st.setString(9, fAdresse);
		 
		 return (st.executeUpdate()>0);
	

		 }catch (SQLException ex) {
			 Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
			 return false;
		 }
		 
	 }
	 //creer une fonction qui modifie le client selectionne
	 public boolean editClient(int id, String fnom, String fprenom, String ftel, String fUsername, String fPass, String fRole, String fAdresse, String fEmail, int fcode)
	 {
		 PreparedStatement st;
		 String editQuery = "UPDATE `utilisateurs` SET `nom`=?,`prenom`=?,`username`=?,`password`=? ,`role`=?,`code_postal`=?,`telephone`=?,`email`=? ,`adresse`=? WHERE`id`=?";
		 
		 try {
			 
		 st = connection.getConnection().prepareStatement(editQuery);
		 
		 st.setString(1, fprenom);
		 st.setString(2, fnom);
		 st.setString(3, fUsername);
		 st.setString(4, fPass);
		 st.setString(5, fRole);
		 st.setInt(6, fcode);
		 st.setString(7, ftel);
		 st.setString(8, fEmail);
		 st.setString(9, fAdresse);
		 st.setInt(10, id);

		 return (st.executeUpdate()>0);


		 }catch (SQLException ex) {
			 Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
			 return false;
		 }
		 
	 }
	 //creer une fonction qui supprime le client selectionne
	 public boolean removeClient(int id) 
	 {
		 PreparedStatement st;
		 ResultSet rs;
		 String deleteQuery = "DELETE FROM `utilisateurs` WHERE `id`=?";
		 
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
		 String selectQuery = "SELECT * FROM `utilisateurs`";
		 
		 try {
			 
		 ps = connection.getConnection().prepareStatement(selectQuery);
		 
		 rs = ps.executeQuery();
		 
		 DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
		 
		 Object[] row;
		 
		 while(rs.next())
		 {
			 row = new Object[11];
			 row[0] = rs.getInt(1); 
			 row[1] = rs.getString(2); 
			 row[2] = rs.getString(3); 
			 row[3] = rs.getString(4);
			 row[4] = rs.getString(5); 
			 row[5] = rs.getString(6); 
			 row[6] = rs.getString(7);
			 row[7] = rs.getString(8);
			 row[8] = rs.getString(9);
			 row[9] = rs.getString(10);



			 
			 tableModel.addRow(row);
		 }
		 
		 }catch(SQLException ex){
			 Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
		 }
		 
	}
	 
}
