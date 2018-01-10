<%-- 
    Document   : customer
    Created on : Nov 12, 2017, 8:43:18 PM
    Author     : Roshan Raj
--%>
<%@page contentType="text/html" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link href="customer.css" rel="stylesheet" type="text/css">
        <script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
        <title>Customer</title>
    </head>
    <% 
       String name=(String)session.getAttribute("name");
       Integer phone=(Integer)session.getAttribute("phone");
       String email=(String)session.getAttribute("email");
       String cust_id=(String)session.getAttribute("uname");
    %>
    <body bgcolor="beige" data-spy="scroll" data-target=".navbar" data-offset="50">
	<div class="container-fluid">
		<nav class="navbar navbar-inverse navbar-fixed-top">
				<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
                                    <a class="navbar-brand"  href="customerpostlogin.jsp" style="font-family: Gill Sans, Gill Sans MT, Myriad Pro, DejaVu Sans Condensed, Helvetica, Arial,' sans-serif'; font-size: 22px">Home</a>
                                        </div>
				<div class="navbar-collapse collapse" id="myNavbar">
					<ul class="nav navbar-nav pull-right">
						<li class="dropdown"> <a href="#" class="dropdown-toggle active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> 
                                                <span class="glyphicon glyphicon-user"></span> Signed in as <%=name%><span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><b>Email Id:</b><%=email%></li>
                                                        <li><b>User_id:</b><%=cust_id%></li>
                                                        <li><b>Phone_Number:</b><%=phone%></li>
                                                        <li><b>Last Accessed on:</b><%=new Date(session.getLastAccessedTime())%></li>
						</ul>
						</li>
                                                <li>
                                                <a href="tp.jsp"><span class="glyphicon glyphicon-log-out"></span>Logout</a>
                                                </li>
					</ul>
				</div>
		</nav>
	</div>
        <div id="section1" class="container-fluid">
            <div class="page-header">
                <h1 style="color: black"> Welcome <font color="green"> <%=name%> ! </font> </h1>
            </div>
            <div class="container container-fluid">
                <div class="col-md-8" style="float: none; margin: 0 auto;">
                <div class="butbox"> 
                    <div class="pager">
	  	
                <form action="ViewShops">
                <button class="button" name="View" style="vertical-align: middle" onClick="location.href='#';"><span> View Shops </span></button>
                </form>
                <br />
	  	<br />
	  	<form action="CustomerViewPurchases" method="post">
	  	<button class="button" style="vertical-align: middle" onClick="location.href='#';"><span> My Purchases </span></button>
                </form>
                <br />
	  	<br /> 
                    </div>
	  </div> 
                </div>
        </div>
        </div>
        <div id="foot">
<footer>
<address>
<center><br> Department Of CSE, MITE <br>Database Management System Mini Project </center>
</address>
</footer>
</div>
</body>
</html>
