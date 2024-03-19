package com.food.servelets;

import java.util.List;

import com.fooddelivery.daoImpl.MenuDaoImpl;
import com.fooddelivery.daoImpl.RestaurantDaoImpl;
import com.fooddilivery.module.Menu;
import com.fooddilivery.module.Restaurant;

public class Program {

	public static void main(String[] args) {
//		
//		RestaurantDaoImpl restaurants = new RestaurantDaoImpl();
//		List<Restaurant> restaurant = restaurants.getAllRestaurant();
//		for(Restaurant res     : restaurant) {
//			System.out.println(res.getName());
//		}
		
		MenuDaoImpl menuDaoImpl = new MenuDaoImpl();
		Menu menu = menuDaoImpl.getMenu(2);
		System.out.println(menu);
		
		
		
	}

}
