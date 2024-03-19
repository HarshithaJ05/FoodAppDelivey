<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List, com.fooddilivery.module.Menu,com.fooddilivery.module.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>menu</title>
</head>
<link rel="stylesheet" href="menu1.css">
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

<div class="container">
    <%
    List<Menu> menuList = (List<Menu>) request.getAttribute("menuList");
    if (menuList != null) {
        for(Menu menu : menuList) {
    %>
    <div class="menu">
        <img alt="<%=menu.getItemName() %>" src="<%=menu.getImagePath()%>">
        <p><%= menu.getItemName() %></p>
        <p><%= menu.getDescription() %></p>
        <p>Price:&#x20B9; <%= menu.getPrice() %></p>
        <p>Rating: <%= menu.getRating() %></p>
        <p>Available: <%= menu.isAvailable() ? "Yes" : "No" %></p>
        
         
                <form action="cart" method="post">
    Quantity: <input type="number" name="quantity" value="1" min="1">
    <input type="submit" name="action" value="AddtoCart" class="add-to-cart-btn">
    <input type="hidden" name="itemId" value="<%= menu.getMenuId()%>">
</form>
                
        </div>
    <%
        }
    } else {
        out.println("<p>No menu items available.</p>");
    } 
    %>
</div>


</body>
</html>