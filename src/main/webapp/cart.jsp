<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, com.fooddilivery.module.Cart, com.fooddilivery.module.CartItem,com.fooddilivery.module.User" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Cart</title>
</head>
    <link rel="stylesheet" href="cart.css">
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
	    <input type="submit" value="View Cart">
		</form>
            <a href="LogoutServlet">Logout</a> 
            </div>
        <% } %>
       
    </nav>
</header>


    <h1>Your Cart</h1>
    <div class="cart-items">
        <%
        Cart cart = (Cart)session.getAttribute("cart");
        if (cart != null && !cart.getItems().isEmpty()) {
            for (CartItem item : cart.getItems().values()) {
        %>
            <div class="cart-item">
                <h3><%= item.getName() %></h3>
                <p>&#x20B9; <%= item.getPrice() %></p>
                <form action="cart" method="post">
                    <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                    Quantity: <input type="number" name="quantity" value="<%= item.getQuantity() %>" min="1">
                    <input type="submit" name="action" value="update" class="update-btn">
                    <input type="submit" name="action" value="remove" class="remove-btn">
                </form>
            </div>
        <%
            }
        } else {
        %>
            <p>Your cart is empty.</p>
        <%
        }
        %>
        
        <a href="MenuServlete?restaurantId=<%= session.getAttribute("restaurantId") %>" class="btn add-more-items-btn">Add more items</a>
        
        <%
        if (cart != null && !cart.getItems().isEmpty()) {
        %>
            <form action="checkout.jsp" method="post">
                <input type="submit" value="Proceed to Checkout" class="btn proceed-to-checkout-btn">
            </form>
        <%
        }
        %>
    </div>
</body>
</html>
