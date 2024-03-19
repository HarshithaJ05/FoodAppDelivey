<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" href="log.css">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body style="background-image: url('imagerestaurant.jpg/log.jpeg');background-repeat:no-repeat;background-size: 100%">
<div class="wrapper">
<h1>Login</h1>
<form action="LoginServlet" method="post">

<div class="input-box">
<input type="text" name="username" placeholder="User Name"required>
<i class='bx bx-user-circle'></i>
</div>

<div class="input-box">
<input type="password" name="password" placeholder="Password" required>
<i class='bx bxs-lock-alt'></i>
</div>

<div class="submit-box">
<input type="submit" value="Login">
</div>
<div class="signup-link">
<% if (request.getAttribute("errorMessage") != null) { %>
                    <p style="color: red;"><%= request.getAttribute("errorMessage") %></p>
                <% } %>
<p>Don't have an account? <a href="signUp1.jsp">SignUp</a>
</div>


</form>

</div>


</body>
</html>