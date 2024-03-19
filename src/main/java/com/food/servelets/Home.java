package com.food.servelets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fooddelivery.daoImpl.RestaurantDaoImpl;
import com.fooddilivery.module.Restaurant;
@WebServlet("/home")
public class Home extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RestaurantDaoImpl obj = new RestaurantDaoImpl();
		List<Restaurant> restaurants = obj.getAllRestaurant();
		request.setAttribute("restaurantList", restaurants);
		RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
		rd.include(request,response);
	}

}



