<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" xml:lang="en">
    <head>
        <link rel = "shortcut icon" href="<%= request.getContextPath() %>/imgs/hotel_images-removebg-preview.png" />
        <title>New user</title>
        <meta charset="ISO-8859-1">
        <style>
            .center{
                text-align: center;
            }
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
                height: 620px;
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
            #text2
            {width:100%;}
        </style>
    </head>
<body style="background-image: url('<%= request.getContextPath() %>/imgs/header1.jpg'); background-size: cover;">
    <div class="center">
        <div class="back">

        <form action="/login/process_register" method="post">
        <h2>Sign up</h2>
            <%
                if (request.getAttribute("notification") != null) {

            %>
            <%     if (request.getAttribute("option") == "Invalid") {

            %>
                    <h5 style="color:red">${message}</h5>
            <%
                } else {
            %>
                    <h5 style="color:green">${message}</h5>
            <%
                } }
            %>

         <h4 style="text-align:left;">First name*:<br><input type="text" name="firstName" id="text2" placeholder="first name" style="font-size:15px;height:35px;" required minlength="3" maxlength="45"></h4>
         <h4 style="text-align:left;">Last name*:<br><input type="text" name="lastName" id="text2" placeholder="Last name" style="font-size:15px;height:35px;" required minlength="3" maxlength="45"></h4>
        <h4 style="text-align:left;">Email*: <br><input type="email" name="email" id="text2" placeholder="Email" style="font-size:15px;height:35px;"  required minlength="6" maxlength="25"></h4>
        <h4 style="text-align:left;">Mobile no*: <br><input type="text" name="mobileNumber" id="text2" placeholder="Mobile no" style="font-size:15px;height:35px;"  required minlength="10" maxlength="15"></h4>
        <h4 style="text-align:left;">Password*: <br><input type="Password" name="password" id="text2" placeholder="password" style="font-size:15px;height:35px;"  required minlength="8" maxlength="15"></h4>
        <h4 style="text-align:left;">Keyword: <br><input type="text" name="keyword" id="text2" placeholder="enter keyword" style="font-size:15px;height:35px;"  required minlength="3" maxlength="25"></h4><br>

        <button type = "submit" class="button button1">Create</button>

        </form>
            <span>Already registered? <a href="userLogin">Login here</a></span>
        </div>
    </div>

</body>
</html>