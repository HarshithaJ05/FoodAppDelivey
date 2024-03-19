package com.food.servelets;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.naming.NameParserImpl;

import com.food.util.PasswordUtils;
import com.fooddelivery.daoImpl.UserDaoImpl;
import com.fooddilivery.module.User;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String name = request.getParameter("name");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        long number =  Long.parseLong(request.getParameter("number")) ;
        String role = request.getParameter("role");

        String hashedPassword = PasswordUtils.hashPassword(password);
        
        User user = new User(name, userName, hashedPassword, email, number, null, role);


        UserDaoImpl userDaoImpl = new UserDaoImpl();
        
        userDaoImpl.addUser(user);
        response.sendRedirect("login1.jsp");
    }
}

