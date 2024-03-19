<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login form</title>
</head>
<link rel="stylesheet" href="longin.css">

<body>
       
    <div class="container">
        <div class="box">
            <h2>Login</h2>
             <form action="#"> 

                <div class="input_box">
                    <input type="text" required name="userName"> 
                    <label>Username</label>
                </div>

                <div class="input_box_pass">
                    <label>Password</label>
                    <input type="password" required name="password">
                </div>

                <div class="forgot_password"><a href="#">Forgot Password ?</a></div>
                <input class="login_button" type="submit" value="Login"> 
                <div class="signup_link"><a href="signup.jsp">Don't have an Account ?</a></div>
            </form>
        </div>
    </div>
</body>
</html>
