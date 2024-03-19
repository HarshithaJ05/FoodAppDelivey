<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.fooddilivery.module.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Checkout</title>
</head>
<link rel="stylesheet" href="checkout.css">
<body>


<header>
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
	    <input type="submit" value="View Cart" class="view-cart-btn">
		</form>
            <a href="LogoutServlet">Logout</a> 
            </div>
        <% } %>
       
    </nav>
</header>
    <h1>Checkout</h1>
    <form action="CheckOutServlet" method="post">
        <label for="deliveryAddress">Delivery Address:</label>
        <textarea id="deliveryAddress" name="deliveryAddress" required></textarea>

        <br>

        <label for="paymentMode">Payment Mode:</label>
        <select id="paymentMode" name="paymentMode" required>
        
            <option value="UPI">UPI</option>
            <option value="Cash">Cash</option>
            <option value="Debit Card">Debit Card</option>
            <option value="Credit Card">Credit Card</option>
        </select>

        <br>

        <input type="submit" value="Place Order">
    </form>
</body>
</html>
