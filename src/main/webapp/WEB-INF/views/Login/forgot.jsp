<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" xml:lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Forgot password</title>

</head>
<body style="text-align: center; background-image: url('<%= request.getContextPath() %>/imgs/header1.jpg'); background-size: cover;">
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
        if (session.getAttribute("error_message") != null) {
    %>
        <h4 style="color:red">${error_message}</h4>
    <%
        }
    %>

    <%
        if (session.getAttribute("message") != null) {
    %>
    <h4 style="color:red">${message}</h4>
    <%
        }
    %>
<form action="/login/forgot_validate" method="post" >
<h4 style="text-align:left;">Email: <br><input type="email" name="email" id="text3" placeholder="email" style="font-size:15px;height:35px;" required minlength="6" maxlength="25"></h4>
<h4 style="text-align:left;">Keyword: <br><input type="text" name="keyword" id="text3" placeholder="enter the keyword" style="font-size:15px;height:35px;" required minlength="3" maxlength="25"></h4><br>


<button class="button button1">Submit</button>
</form>
</div>
</body>
</html>