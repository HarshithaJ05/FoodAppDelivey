package com.food.servelets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fooddelivery.daoImpl.OrderHistoryDaoImpl;
import com.fooddilivery.module.Order;
import com.fooddilivery.module.OrderHistory;
import com.fooddivery.dao.OrderHistoryDao;

@WebServlet("/OrderHistoryServlet")
public class OrderHistoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve relevant information from the session or request
        Order order = (Order) request.getSession().getAttribute("order");

        // Create an OrderHistory object
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setUserId(order.getUserId());
        orderHistory.setOrderId(order.getOrderId());
        orderHistory.setOrderDate(new Date()); // You may need to adjust this based on your requirements
        orderHistory.setTotalAmount(order.getTotalAmount());
        orderHistory.setStatus(order.getStatus());

         OrderHistoryDaoImpl orderHistoryDao = new OrderHistoryDaoImpl();
        
        orderHistoryDao.addOrderHistory(orderHistory);

        // Forward to the order history JSP page
        request.getRequestDispatcher("orderHistory.jsp").forward(request, response);
    }
}
