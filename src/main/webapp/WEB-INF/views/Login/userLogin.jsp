<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel = "shortcut icon" href = "<%= request.getContextPath() %>/imgs/hotel_images-removebg-preview.png" />
<title>Login page</title>
</head>
<body style="background-image: url('<%= request.getContextPath() %>/imgs/header1.jpg'); background-size: cover;">
<br>
<br>
<br>

<style>
.back{

box-shadow: 5px 5px 15px 5px #000000;
padding: 16px 24px 24px;
    position: relative;
	background-color: lavender;
opacity: 0.9;
size: auto;
  margin: 00mm 00mm 50mm 125mm;
  width: 400px;
  height: 400px;
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
<h1>Login</h1><br>

	<div>
		<%
			if (request.getAttribute("message") != null) {
		%>
		<div>
			<h3>${message}</h3>
		</div>
		<%
			}
		%>
	</div>

<form action="/login/userLogin" method="post">
<h3 style ="text-align:left;">Username<br>  <input type="text" name="username" placeholder="username" style="font-size:15px;height:35px;"></h3>
<h3 style= "text-align:left;">Password <br> <input type="Password" name="password" placeholder="password" style="font-size:15px;height:35px;" ></h3>
<br>
<button class="button button1">Login</button>

</form>
<p style="text-align:left;"><a href="/login/newUser">New user </a></p>
<p style="text-align:right;"><a href="/login/forgot">Forgot password?</a></p>

</div>
</div>

</body>
</html>
