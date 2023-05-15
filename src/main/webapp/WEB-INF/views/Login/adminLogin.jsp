<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html  lang="en" xml:lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel = "shortcut icon" href="<%= request.getContextPath() %>/imgs/hotel_images-removebg-preview.png" />
</head>
<body style="background-image: url('<%= request.getContextPath() %>/imgs/header1.jpg'); background-size: cover;">
<br>
<br>
<br>
<style>
.back{

box-shadow: 5px 5px 15px 5px #000000;
box-shadow: 10px 10px 10px 10px #000000;
padding: 16px 24px 24px;
    position: relative;
	background-color: lavender;
opacity: 0.9;
size: auto;
  margin: 00mm 00mm 50mm 125mm;
  width: 400px;
  height: 500px;
}
.center{
text-align: center;
}
.button {
transition-duration: 0.4s;
cursor: pointer;
font-size: 16px;
}
.button1{
background-color: white;
color: black;
border: 2px solid #4CAF50;
width: 50%
}
.button1:hover{
background-color: #4CAF50;
color: white;
}
#text1
{width:100%;}

</style>

<div class="back">
<div class="center">
<h1>Admin Login</h1><br>
<form action="/login/adminLogin" method="post">
	<h3 style ="text-align:left;">Username<br>  <input type="text" name="username" placeholder="username" style="font-size:15px;height:35px;"></h3>
	<h3 style= "text-align:left;">Password <br> <input type="Password" name="password" placeholder="password" style="font-size:15px;height:35px;" ></h3>
<br>
<button class="button button1">Login</button>

</form>
<p style="text-align:right;"><a href="forgotAdmin">Forgot password?</a></p>
<span>Not an Admin? <a href="userLogin">Login as User</a></span>

</div>
</div>


</body>
</html>