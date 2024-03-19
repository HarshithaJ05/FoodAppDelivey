package com.fooddelivery.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fooddilivery.module.User;
import com.fooddivery.dao.UserDao;

public class UserDaoImpl implements UserDao {
	
	
	private static Connection connection =null;
	private static PreparedStatement prepareStatement =null;
	private ResultSet res =null;
	private Statement statement =null;
	private final static String INSERT_QUERY = "insert into `user`(`Name`, `Username`, `Password`, `Email`, "
			+ "`PhoneNumber`, `Adress`, `Role`)values(?,?,?,?,?,?,?)";
	private final static String SELECT_QUERY ="select * from `user`  where `UserID`=?";
	private final static String DELETE_QUERY ="delete from `user` where `UserID`=? ";
	private final static String UPDATE_QUERY ="update `user` set `Name`=?, `Username`=?, `Password`=?, `Email`=?,PhoneNumber`=?,"
			+ "`Adress`=?,`Role`=? where `UserID`=? ";
	private final static String SELECT_ALL_QUERY ="select * from `user`";
	public UserDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_delivery","root","root");			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void addUser(User user) {
		try {
			 prepareStatement = connection.prepareStatement(INSERT_QUERY);
			 prepareStatement.setString(1, user.getName());
			 prepareStatement.setString(2, user.getUserName());
			 prepareStatement.setString(3, user.getPassword());
			 prepareStatement.setString(4, user.getEmail());
			 prepareStatement.setLong(5, user.getPhoneNum());
			 prepareStatement.setString(6, user.getAdress());
			 prepareStatement.setString(7, user.getRole());
			 
			  int i = prepareStatement.executeUpdate();
			  System.out.println(i);
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		
	}

	@Override
	public User getUser(int userId) {
		
		try {
			
			
			 prepareStatement = connection.prepareStatement(SELECT_QUERY);
			 prepareStatement.setInt(1, userId);
			  res = prepareStatement.executeQuery();
			  while(res.next()) {
				int userId1=res.getInt("UserID");
				String name=res.getString("Name");
				String userName=res.getString("Username");
				String password=res.getString("Password");
				String email=res.getString("Email");
				long phoneNum =res.getLong("PhoneNumber");
				String adress=res.getString("Adress");
				String role=res.getString("Role");
				
				return new User(userId1, name, userName, password, email, phoneNum, adress, role);
				  
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public void updateUser(User user) {
		
		 try {
			prepareStatement = connection.prepareStatement(UPDATE_QUERY);
			prepareStatement.setString(1, user.getName());
			prepareStatement.setString(2, user.getUserName());
			prepareStatement.setString(3, user.getPassword());
			prepareStatement.setString(4, user.getEmail());
			prepareStatement.setLong(5, user.getPhoneNum());
			prepareStatement.setString(6, user.getAdress());
			prepareStatement.setString(7, user.getRole());
			prepareStatement.setInt(8, user.getUserID());
			 prepareStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(int userId) {
		 int i =0;
		try {
			 prepareStatement = connection.prepareStatement(DELETE_QUERY);
			 prepareStatement.setInt(1, userId);
			   i = prepareStatement.executeUpdate();
			 
			 
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

	@Override
	public List<User> getallUser() {
		ArrayList<User> userList = new ArrayList();
		
		try {
			 statement = connection.createStatement();
			  res = statement.executeQuery(SELECT_ALL_QUERY);
			  while(res.next()) {
				  int userId=  res.getInt("UserID");
					String name=res.getString("Name");
					String userName=res.getString("Username");
					String password=res.getString("Password");
					String email=res.getString("Email");
					long phoneNum =res.getLong("PhoneNumber");
					String adress=res.getString("Adress");
					String role=res.getString("Role");
					
					
					User user = new User(userId, name, userName, password, email, phoneNum, adress, role);
					userList.add(user);
					
			  }
			 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return userList;
	}
	@Override
	public User getUser(String username) {
	    try {
	        prepareStatement = connection.prepareStatement("SELECT * FROM `user` WHERE `Username` = ?");
	        prepareStatement.setString(1, username);
	        res = prepareStatement.executeQuery();

	        if (res.next()) {
	            int userId = res.getInt("UserID");
	            String name = res.getString("Name");
	            String password = res.getString("Password");
	            String email = res.getString("Email");
	            long phoneNum = res.getLong("PhoneNumber");
	            String address = res.getString("Adress");
	            String role = res.getString("Role");

	            return new User(userId, name, username, password, email, phoneNum, address, role);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}


}
