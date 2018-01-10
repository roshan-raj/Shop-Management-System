<%@page import="java.util.List"%>
<!doctype html>
<%@page language="java" import="java.lang.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link href="shopkeeper.css" rel="stylesheet" type="text/css">
  <script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
<title>Shopkeeper</title>
</head>
<script src="ajs/angular.min.js"></script>
<body bgcolor="beige" data-spy="scroll" data-target=".navbar" data-offset="50">
	<div class="container-fluid">
		<nav class="navbar navbar-inverse navbar-fixed-top">
				<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand"  href="shopkeeper.jsp" style="font-family: Gill Sans, Gill Sans MT, Myriad Pro, DejaVu Sans Condensed, Helvetica, Arial,' sans-serif'; font-size: 22px">Home</a>
				</div>
				<div class="navbar-collapse collapse" id="myNavbar">
					<ul class="nav navbar-nav pull-right">
                                        <% int shop_id=(Integer)request.getAttribute("shop_id");  
                                            
                                         %>
                
						<li class="dropdown"> <a href="#" class="dropdown-toggle active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> 
                                                <span class="glyphicon glyphicon-user"></span> Signed in as <%=shop_id%> <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li> <a href="#"> My Profile</a></li>
							<li> <a href="#"> Change Password</a></li>
						</ul>
						</li>
						<li> <a href="tp.jsp"> <span class="glyphicon glyphicon-log-out"></span>Logout </a></li>
					</ul>
				</div>
		</nav>
	</div>
<div id="section1" class="container-fluid">
    <div class="page-header">
		  <h1 style="text-shadow: 4px 2px 5px black;"> <%=(String)session.getAttribute("shopname")%> Store</h1> 
                  <h3 style="text-shadow: 5px 5px 5px black;"><strong>Hello there shopkeeper! Manage all your products from here. </strong> </h3>
	  </div>
	  <div class="pager">
	  	
                <form action="ShopkeeperShopTables"><button class="button" name="shop_id" value="<%=shop_id%>" style="vertical-align: middle"><span><strong>View Product </span> </button></form>
	  	<br />
	  	<br />
                <form action="WaytoAddProductJSP">
                    <button class="button" style="vertical-align: middle" name="shop_id" value="<%=shop_id%>"><span>Add Product </span></button> </form>
	  	<br />
	  	<br />
                <button class="button" style="vertical-align: middle" onClick="document.getElementById('id999').style.display='block'"style="width:auto;"><span>Edit Product </span></button>
	  	<br />
	  	<br />
                <form action="WaytoDeleteProductJSP">
                    <button class="button" style="vertical-align: middle" name="shop_id" value="<%=shop_id%>"><span>Delete Product </strong> </span></button></form>
	    <br />
            <form action="ViewOrders"><button class="button" type="submit" name="shop_id" value="<%=shop_id%>" style="vertical-align: middle" ><span><strong>View Orders </strong> </span></button></form>
	  	<br /> 
	  </div>
</div>
</body>
<div id="id999" class="modal"> 
  <form class="modal-content animate" action="EditStockPrice" method="get" >
    <div class="imgcontainer">
      <span onclick="document.getElementById('id999').style.display='none'" class="close" title="Close Modal">&times;</span>
    </div><center style="font-size: 18px;"> <b>What do you want to update? </b></center>
    <div class="pager">
        <input type="radio" name="edit" id="1" value="1"> &nbsp;<label for="1">Stock</label> <br>
        <input type="radio" name="edit" id="2" value="2"> &nbsp;<label for="2">Price</label> <br>
        <button type="submit" style="border-radius: 5px;"><span class="glyphicon glyphicon-edit"></span> &nbsp;Edit</button>
    </div>
</form>
</div>
<script>
var modal = document.getElementById('id999');
window.onclick = function(event) {
    if (event.target=== modal) {
        modal.style.display = "none";
    }
};
</script>
</body>
<div id="foot">
<footer>
<address>
<center><br> Department Of CSE, MITE <br>Database Management System Mini Project </center>
</address>
</footer>
</div>
</html>
