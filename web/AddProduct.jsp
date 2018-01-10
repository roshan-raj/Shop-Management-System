<!doctype html>
<%@page language="java" import="javax.servlet.RequestDispatcher"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link href="AddProduct.css" rel="stylesheet" type="text/css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>Shopkeeper | Add Product</title>
<style>
    form { display: inline;}
</style>
</head>
<script src="ajs/angular.min.js"></script>
<body bgcolor="beige" data-spy="scroll" data-target=".navbar" data-offset="50">
    <% String s_id=(String)request.getAttribute("shop_id");     
           int shop_id=Integer.parseInt(s_id);
            %>
            <h1><%=s_id%></h1>
	<div class="container-fluid">
		<nav class="navbar navbar-inverse navbar-fixed-top">
				<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
                                   </div>
				<div class="navbar-collapse collapse" id="myNavbar">
					<ul class="nav navbar-nav pull-right">
						<li> <a href="MainPage.html"> <span class="glyphicon glyphicon-log-out"></span>Logout </a></li>
					</ul>
				</div>
		</nav>
	</div>
<div id="section4" class="container-fluid">
 	  <div class="page-header">
		  <h1 style="color: white;"> Add Products </h1>  
	  </div>
	  <div class="pager">
	  	<h3 style="text-shadow: 5px 5px 5px black;"><strong>Hello there shopkeeper! Add products here. </strong> </h3>
	  	<div class="container">
	  	<div class="col-md-6" >
                    
        <div id="logbox">
	  	<form id="addproduct" action="AddedHardware">
	  		<h1> Add a Product </h1>
	  		<input name="name" type="text" placeholder="Enter the Name" class="input pass" required/>
	  		<input name="hardware_id" type="text" placeholder="Enter the Hardware Id" class="input pass" required/>
	  		<input name="price" type="number" placeholder="Enter the Price" class="input pass" required/>
                        <input name="stock" type="number" placeholder="Enter the Stock" class="input pass" required/>
                        <button type="submit" name="add" value="<%=shop_id%>" class="btn btn-default btn-sm">
            Add Product
            <span class="glyphicon glyphicon-plus"></span> 
            </button>
            </form>
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
            <form action="AddedHardware"><button type="submit" name="shop_id" value="<%=shop_id%>" class="btn btn-default btn-sm" >
            Cancel  
            <span class="glyphicon glyphicon-minus"></span> 
                    
			</button>
	  	  	</form>
			 </div>
		  </div>
		  </div>
	  </div>
</div>
</body>
<div id="foot">
<footer>
<address>
<center><br> Department Of CSE, MITE <br>Database Management System Mini Project </cecnter>
</address>
</footer>
</html>
