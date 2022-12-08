package com.training.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.training.web.model.User;

public class UserDao {
	
	public List<User> getUserList(){
		
		List<User> userList = new ArrayList<>();
		
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			String url = "jdbc:sqlserver://localhost:1433;"+
						"databaseName=mars_sept";
			
			String user = "sa";
			
			String password = "root";
			
			Connection con = DriverManager.getConnection(url, user, password);
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from user1");
			
			while(rs.next()) {
				//System.out.println(rs.getString(2)+": "+rs.getString(3));
				User usr = new User();
				usr.setUserId(rs.getString(1));
				usr.setUserName(rs.getString(2));
				usr.setPassword(rs.getString(3));
				userList.add(usr);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
		
	}

}
