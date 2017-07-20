package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.User;

public class DaoImpl implements Dao{
	
	
	private static final String USERNAME = "student_teacher_db";
	private static final String PASSWORD = "p4ssw0rd";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	

	@Override
	public User getUser(User user) {
		User returnedUser = null;
		String sql = "SELECT * FROM st_user WHERE username = ?";
		
			try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
		
		try(Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
		
			PreparedStatement ps = connect.prepareStatement(sql);
			connect.setAutoCommit(false);
			System.out.println(user.getUsername());
			ps.setString(1, user.getUsername());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				 returnedUser = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
			}
			connect.commit();
			return returnedUser;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void createUser(User user) {
		String sql = "INSERT INTO st_user(username, first_name, last_name, pw, user_role_id)"
		+ " VALUES(?, ?, ?, ? ,?)";
		
		try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		try(Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			PreparedStatement ps = connect.prepareStatement(sql);
			connect.setAutoCommit(false);
			System.out.println(user.getUsername());
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getFirst_name());
			ps.setString(3, user.getLast_name());
			ps.setString(4, user.getPw());
			ps.setInt(5, user.getUser_role_id());
			ps.executeUpdate();
			
			connect.commit();
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
		
	}

}
