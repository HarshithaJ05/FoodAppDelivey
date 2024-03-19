<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.fooddilivery.module.OrderHistory" %>
<%@ page import="com.fooddilivery.module.User" %>
<%@ page import="com.fooddivery.dao.OrderHistoryDao" %>
<%@ page import="com.fooddelivery.daoImpl.OrderHistoryDaoImpl" %>

<%
    // Get the user ID from the session
    int userId = ((User) session.getAttribute("username")).getUserID();

    // Retrieve order history from the database
    OrderHistoryDao orderHistoryDao = new OrderHistoryDaoImpl();
    List<OrderHistory> orderHistoryList = orderHistoryDao.getOrderHistoriesByUser(userId);
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order History</title>
    <link rel="stylesheet" href="orderHistory.css">
</head>
<body>



<div class="order-history">
    <h1>Order History</h1>

    <% if (orderHistoryList != null && !orderHistoryList.isEmpty()) { %>
        <table border="1">
            <tr>
                <th>Order ID</th>
                <th>Order Date</th>
                <th>Total Amount</th>
                <th>Status</th>
            </tr>
            <% for (OrderHistory orderHistory : orderHistoryList) { %>
                <tr>
                    <td><%= orderHistory.getOrderId() %></td>
                    <td><%= orderHistory.getOrderDate() %></td>
                    <td>&#x20B9; <%= orderHistory.getTotalAmount() %></td>
                    <td><%= orderHistory.getStatus() %></td>
                </tr>
            <% } %>
        </table>
    <% } else { %>
        <p>No order history available.</p>
    <% } %>

    <a href="home">Back to Home</a>
</div>

</body>
</html>
