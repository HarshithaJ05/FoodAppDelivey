<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Signup</title>
</head>
<link rel="stylesheet" href="signup.css">
<body>

<div class="container">
    <div class="box">
        <h2>Signup</h2>

        <form action="home">

            <div class="input_box">
                <input type="text" name="userName" required>
                <label>Username</label>
            </div>

            <div class="input_box_pass">
                <label>Password</label>
                <input type="password" required name="password">
            </div>

            <div class="input_box">
                <input type="text" name="email" required>
                <label>Email</label>
            </div>
            
            <div class="input_box">
                <input type="text" name="phoneNum" required>
                <label>PhoneNumber</label>
            </div>
            
            <input class="signup_button" type="submit" value="Submit">

            <div class="login_link"><a href="login.jsp">Already have an Account ?</a></div>
        </form>
    </div>
</div>

</body>
</html>
