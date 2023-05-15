<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" xml:lang="en">
<head>
<title>Change new password</title>
<link rel = "shortcut icon" href = "" href="/imgs/hotel_images-removebg-preview.png" />
<meta charset="ISO-8859-1">

</head>
<body style="text-align: center; background-image: url('imgs/header1.jpg'); background-size: cover;">
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
  height: 300px;
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

#text3
{width:100%;}
</style>
<div class="back">
    <%
        if (session.getAttribute("message") != null) {
    %>
    <h3>${message}</h3>
    <%
        }
    %>
<!-- password -->
<form style="text-align: justify;" action="/login/process_password" method="POST">
<h4 style="text-align:left;">New password: <br><input type="password" name="password" id="text3" placeholder="enter new password" style="font-size:15px;height:35px;" name="password" required minlength="8" maxlength="15"></h4>
<button class="button button1">Submit</button>
</form>
</div>

</body>
</html>