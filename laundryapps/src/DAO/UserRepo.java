package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import config.Database;
import model.user;

public class UserRepo implements UserDAO{
	private Connection connection;
	final String insert = "INSERT INTO user (name, username, password) VALUES (?,?,?);";
	final String select = "SELECT * FROM user;" ;
	final String delete = "DELETE FROM user WHERE id = ?;";
	final String update = "UPDATE user SET name = ?, username = ?, password = ? WHERE id = ?;";
	
	public UserRepo() {
		connection = Database.getConnection();
		}
	
	@Override
	public void save(user user) {
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(insert);
			st.setString(1, user.getNama());
			st.setString(2, user.getUsername());
			st.setString(3, user.getPassword());
			st.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<user> show(){
		List<user> ls = null;
		try {
			ls = new ArrayList<user>();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(select);
			while(rs.next()) {
				user user = new user();
				user.setId(rs.getString("id"));
				user.setNama(rs.getString("name"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				ls.add(user);
			}
		}catch(SQLException e) {
			Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return ls;
	}
	
	@Override
	public void update (user user) {
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(update);
			st.setString(1, user.getNama());
			st.setString(2, user.getUsername());
			st.setString(3, user.getPassword());
			st.setString(4, user.getId());
			st.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public void delete(String id) {
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(delete);
			st.setString(1, id);
			st.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
