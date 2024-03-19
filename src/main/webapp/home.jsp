<%@page import="com.fooddilivery.module.Restaurant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List, com.fooddilivery.module.Restaurant,com.fooddilivery.module.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Restaurants</title>
</head>
    <link rel="stylesheet" href="menu.css">
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
<h1>Restaurants</h1>
<div class="container">

    <%
    List<Restaurant> restaurants = (List<Restaurant>)request.getAttribute("restaurantList");
    if (restaurants != null) {
        for(Restaurant res :restaurants) {
    %>
    <a href="MenuServlete?restaurantId=<%= res.getResturantId()%>" class="restaurant">
        <img alt="<%=res.getName() %>" src="<%=res.getImagePath()%>">
        <p><%= res.getName()%></p>
        <p><%= res.getRating()%></p>
        <p>ETA:<%= res.getEta()%> </p>
        <p>Cuisine Type:<%=res.getCousineType() %></p>
        <p>isActive:<%=res.getIsActive()%></p>
        <p>Phone Number:<%=res.getPhoneNum()%></p>
        
    </a>
    <%
        }
    } else {
        out.println("<p>No restaurants available.</p>");
    } 
    %>
</div>
</body>
</html>
