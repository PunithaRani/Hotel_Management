
  <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resort booking form</title>
   
     <link rel="stylesheet" href="<%= request.getContextPath() %>/css/roomform.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
   <style>
    #form{
    background-color:#0080c0;
    height:600px;
    width:400px;
    
    margin: auto;
    margin-top: 100px;
    margin-bottom:100px;
    opacity:0.8;
}
   #submit1-btn{
    margin-top: 300px;
    margin-left: 70px;
   background-color:black;
    color:white;
    width:100px;
    border:1px solid #ff80c0;
    outline:none;
    padding:10px;
    font-size: 20px;
}
  #submit2-btn{
    margin-top: 300px;
    margin-left: 170px;
   background-color:black;
    color:white;
    width:100px;
    border:1px solid #ff80c0;
    outline:none;
    padding:10px;
    font-size: 20px;
}
#profileImage {
  width: 100px;
  height: 100px;
  border-radius: 50%;
  background: black;
  font-size: 50px;
  color: #fff;
  text-align: center;
  line-height: 100px;
  margin: 5px 0;
   border:1px solid #ff80c0;
}
.divright
{
padding-top:50px;
padding-left:150px;
}

   </style>
  
</head>
<body background-img="roombook1.jsp">
<nav id="mainNavbar" class="navbar navbar-dark bg-dark navbar-expand-md py-0 fixed-top">
        
        <button class="navbar-toggler" data-toggle="collapse" data-target="#navLinks" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navLinks">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a  href="/user/room_form" class="nav-link">BOOK YOUR STAY</a>
                </li>
                <li class="nav-item">
                    <a href="/user/user_index" class="nav-link">ROOMS</a>
                </li>
				<li class="nav-item">
                    <a  href="/logout"  class="nav-link">LOGOUT</a>
                </li>
            </ul>
        </div>
    </nav>
      
            <div id="form">
             
                <div class="divright">
                  <div id="profileImage">${profilename }</div>
                  </div>
                <div id="first-group">

                    <div id="content">
                        <i class="fa fa-user-circle" aria-hidden="true"aria-hidden="true"></i>
                        <input type="text" id="input-group" name="firstname" value=${userinfo.getFirstName() } readonly>
                    </div>

                    <div id="content">
                        <i class="fa fa-user-circle" aria-hidden="true"aria-hidden="true"></i>
                        <input type="text" id="input-group" name="lastname" value=${userinfo.getLastName() } readonly>
                    </div>
                  
                     <div id="content">
                        <i class="fa fa-envelope" aria-hidden="true"></i>
                            <input type="text" id="input-group" name="email" value=${userinfo.getEmail() }  readonly>
                    </div>
                    
                      <div id="content">
                        <i class="fa fa-phone" aria-hidden="true"></i>
                        <input type="text"  id="input-group"  name="phone" value=${userinfo.getMobileNumber() }  readonly>
                    </div>
                   
                  
                  
                   

                </div>

               

               <a href="/user/profileEdit"><button type="submit" value="Submit" id="submit1-btn" >EDIT</button> </a> 
                <a href="/user/room_form"><button type="submit" value="Submit" id="submit1-btn" >CLOSE</button> </a> 
            </div>
        </form>
  

</body>
</html>