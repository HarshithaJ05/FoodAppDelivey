package com.food.servelets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fooddelivery.daoImpl.MenuDaoImpl;
import com.fooddilivery.module.Menu;

@WebServlet("/MenuServlete")
public class MenuServlete extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int restaurantId = Integer.parseInt(request.getParameter("restaurantId"));

        MenuDaoImpl menuDao = new MenuDaoImpl();

        List<Menu> menuList = menuDao.getAllMenusByRestaurant(restaurantId);

        request.setAttribute("menuList", menuList);

        RequestDispatcher rd = request.getRequestDispatcher("/menus.jsp");
        rd.include(request, response);
    }
}
