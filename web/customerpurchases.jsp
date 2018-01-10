<%-- 
    Document   : customerpurchases
    Created on : 3 Dec, 2017, 8:32:39 PM
    Author     : doodl
--%>

<%@page contentType="text/html" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
        <link href="customerpurchases.css" rel="stylesheet" type="text/css">
        <title>Your Purchases</title>
    </head>
        <%        String name=(String)session.getAttribute("name");
            List purchases=(List)session.getAttribute("purchase");
           Iterator itr;
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
						</li>
                                                <li>
                                                <a href="tp.jsp"><span class="glyphicon glyphicon-log-out"></span>Logout</a>
                                                </li>
					</ul>
				</div>
		</nav>
	</div>
                                                <br />
                                                <div id="section1" class="container-fluid">
                                                <div class="container">
                                                    <div class="container jumbotron" style="opacity: 0.9;">
                                                    <h1 style="color: black; text-align: center;">Your Purchases</h1>
       <div class="container table-responsive table-striped">
      <div style="overflow-x: auto; overflow-y: auto;">
       <table id="myTable">
            <tr>
                <th><h3>Purchase ID</h3></th>
                <th><h3>Purchase Date</h3></th>
                <th><h3>Hardware ID</h3></th>
                <th><h3>Shop ID</h3></th>
                <th><h3>Quantity</h3></th>
                <th><h3>Total Price</h3></th>
            </tr>
            <% 
                for(itr=purchases.iterator();itr.hasNext();)
                {
                    %>
                    <tr>
                        <td><%=itr.next()%></td>
                        <td><%=itr.next()%></td>
                        <td><%=itr.next()%></td>
                        <td><%=itr.next()%></td>
                        <td><%=itr.next()%></td>
                        <td>&#x20B9;<%=itr.next()%></td>
                    </tr>
                    <%
                }
%>
        </table>
        <br />
        <form action="customerpostlogin.jsp">
    <button class="btn btn-primary" name="back"><span class="glyphicon glyphicon-menu-left"></span></button>
</form>
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
