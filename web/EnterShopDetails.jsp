<%-- 
    Document   : EnterShopDetails
    Created on : Nov 19, 2017, 5:18:21 PM
    Author     : Roshan Raj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <style type="text/css"> @import url("signup.css"); </style>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <title>Enter Shop Details</title>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="MainPage.html">Home</a>
    </div>     
  </div>
</nav> 
        <div class="container container-fluid" >
    <div class="col-md-6" >
        <div id="logbox"  >
            <form action="EnterShopDetails" method="POST">
             <h1> Enter your Shop Details </h1>
             <input name="shop_id" type="text" placeholder="Enter your Shop_id" class="input pass" required/>
             <input name="name" type="text" placeholder="Enter your Shop Name" class="input pass" required/>
             <input name="email" type="email" placeholder="Enter your Email" class="input pass" required/>
             <input name="phone" type="number" placeholder="Enter yout Phone Number" class="input pass" required/>
             <input name="address" type="text" placeholder="Enter your Address" class="input pass" required/>
             <input type="submit" value="Submit" class="inputButton">
         </form>
        </div>
    </div>
        </div>
    </body>
</html>
