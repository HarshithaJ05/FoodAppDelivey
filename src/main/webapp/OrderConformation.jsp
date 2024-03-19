<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.fooddilivery.module.Order,com.fooddilivery.module.CartItem,java.util.Collection" %>
<%@ page import="com.fooddilivery.module.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Confirmation</title>
    <link rel="stylesheet" href="orderConformation.css">
</head>
<body>

<header>
    <div class="header-links">
        <h1>Welcome to Tap Online Food</h1>
        <nav>
            <a href="home">Home</a>
            <% 
            User username = (User)session.getAttribute("username");
            if (username == null) { %>
                <a href="login1.jsp">Login</a>
                <a href="signUp1.jsp">Register</a>
            <% } else { %>
            <div class="user-links">
                <p>Welcome <%= username.getName() %></p>
                <form action="cart" method="post">
                    <input type="hidden" name="action" value="someValue">
                    <input type="submit" value="View Cart">
                </form>
                <a href="LogoutServlet">Logout</a>
            </div>
            <div class="no-more-button">
    <form action="#" method="post">
        <input type="hidden" name="_method" value="post">
        <button type="submit">No More</button>
    </form>
</div>
            <% } %>
        </nav>
    </div>
</header>

<div class="order-confirmation">
    <h1>Order Confirmation</h1>

    <%
        String cartErrorMessage = (String) session.getAttribute("cartErrorMessage");
        if (cartErrorMessage != null) {
    %>
            <p style="color: red;"><%= cartErrorMessage %></p>
    <%
        }
        session.removeAttribute("cartErrorMessage");

        String userErrorMessage = (String) request.getAttribute("userErrorMessage");
        if (userErrorMessage != null) {
    %>
            <p style="color: red;"><%= userErrorMessage %></p>
    <%
        }
        request.removeAttribute("userErrorMessage");
    %>

    <%
        Order order = (Order)session.getAttribute("order");
        if (order != null) {
    %>
        <div class="order-details">
            <h2>Order Details:</h2>
            <p>User ID: <%= order.getUserId() %></p>
            <p>Order ID: <%= order.getOrderId() %></p>
            <p>Order Date: <%= order.getOrderDate() %></p>
            <p>Total Amount: &#x20B9; <%= order.getTotalAmount() %></p>
            <p>Payment Mode: <%= order.getPayementMode() %></p>
            <p>Status: <%= order.getStatus() %></p>
        </div>
    <% } %>

    <div class="order-items">
        <h2>Order Items:</h2>
        <% 
            Collection<CartItem> orderItems = (Collection<CartItem>) session.getAttribute("orderItems");
            if (orderItems != null && !orderItems.isEmpty()) {
                for (CartItem item : orderItems) {
        %>
                    <div class="order-item">
                        <h3><%= item.getName() %></h3>
                        <p>Price: &#x20B9; <%= item.getPrice() %></p>
                        <p>Quantity: <%= item.getQuantity() %></p>
                    </div>
        <% 
                }
            }
        %>
    </div>
</div>

</body>
</html>
