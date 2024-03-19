
package com.fooddelivery.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fooddilivery.module.Menu;
import com.fooddilivery.module.Order;
import com.fooddivery.dao.MenuDao;

public class MenuDaoImpl implements MenuDao {
	private static Connection connection =null;
	private static PreparedStatement prepareStatement =null;
	private ResultSet res =null;
	Statement statement = null;
	
	private final static String INSERT_QUERY = "insert into `menu`(`RestuarantID`, `ItemName`, `Description`, `Price`, `Ratings`, `isAvailable`, `ImagePath`)values(?,?,?,?,?,?,?)";
	private final static String SELECT_QUERY ="select * from `menu`  where `MenuID`=?";
	private final static String DELETE_QUERY ="delete from `menu` where `MenuID`=? ";
	private final static String UPDATE_QUERY ="update `menu` set `RestuarantID`=?, `ItemName`=?, `Description`=?,`Price`=?, `Ratings`=?,`isAvailable`=? where `MenuID`=? ";
	private final static String SELECT_ALL_QUERY ="select * from `menu` where `RestuarantID`= ?";
	
	public MenuDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_delivery","root","root");			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void addMenu(Menu menu) {
		try {
			 prepareStatement = connection.prepareStatement(INSERT_QUERY);
			 prepareStatement.setInt(1,menu.getMenuId());
			 prepareStatement.setInt(2, menu.getRestuarantId());
			 prepareStatement.setString(3, menu.getItemName());
			 prepareStatement.setString(4,menu.getDescription());
			 prepareStatement.setDouble(5, menu.getPrice());
			 prepareStatement.setDouble(6, menu.getRating());
			 prepareStatement.setBoolean(7, menu.isAvailable());
			 prepareStatement.setString(8, menu.getImagePath());
			 prepareStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public Menu getMenu(int menuId) {
		try {
			
			
			 prepareStatement = connection.prepareStatement(SELECT_QUERY);
			 prepareStatement.setInt(1, menuId);
			  res = prepareStatement.executeQuery();
			  while(res.next()) {
				  int menuId1=res.getInt("MenuID");
				  int resId= res.getInt("RestuarantID");
				  String itemName=res.getString("ItemName");
				  String description =res.getString("Description");
				  Double price =res.getDouble("Price");
				  Double rating =res.getDouble("Ratings");
				  Boolean isAvailable= res.getBoolean("isAvailable");
				  String imagePath =res.getString("ImagePath");
				 Menu menu = new Menu(menuId1, resId, itemName, description, menuId1, resId, isAvailable, imagePath);
				    System.out.println("Retrieved Menu: " + menu);
				 return menu;
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateMenu(Menu menu) {
		
			
			try {
				 prepareStatement = connection.prepareStatement(UPDATE_QUERY);
				 prepareStatement.setInt(1,menu.getRestuarantId());
				 prepareStatement.setString(2, menu.getItemName());
				 prepareStatement.setString(3, menu.getDescription());
				 prepareStatement.setDouble(4, menu.getPrice());
				 prepareStatement.setDouble(5, menu.getRating());
				 prepareStatement.setBoolean(6, menu.isAvailable());
				 prepareStatement.setInt(7, menu.getMenuId());
				  prepareStatement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		
		
		
	}

	@Override
	public void deleteMenu(int menuId) {
		try {
			 prepareStatement = connection.prepareStatement(DELETE_QUERY);
			 prepareStatement.setInt(1,menuId);
			    prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public List<Menu> getAllMenusByRestaurant(int restaurantId) {
		ArrayList<Menu> menuList = new ArrayList<Menu>();
		try {
			 prepareStatement = connection.prepareStatement(SELECT_ALL_QUERY);
			 prepareStatement.setInt(1, restaurantId);
			  res = prepareStatement.executeQuery();
			  
			  while(res.next()) {
				  int menuId=res.getInt("MenuID");
				  int resId= res.getInt("RestuarantID");
				  String itemName=res.getString("ItemName");
				  String description =res.getString("Description");
				  Double price =res.getDouble("Price");
				  Double rating =res.getDouble("Ratings");
				  Boolean isAvailable= res.getBoolean("isAvailable");
				  String imagePath =res.getString("ImagePath");
				  Menu menu = new Menu(menuId, resId, itemName, description,price,rating, isAvailable, imagePath);
				  menuList.add(menu);
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menuList;
	}

}
