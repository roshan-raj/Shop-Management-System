<%-- 
    Document   : viewshopsdetails
    Created on : Nov 17, 2017, 9:01:33 PM
    Author     : Roshan Raj
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link href="viewshopdetails.css" rel="stylesheet" type="text/css">
        <script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
        <title>Shop Details</title>
    </head>
    <% String name=(String)session.getAttribute("name"); %>
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
                                        <a class="navbar-brand"  href="#" style="font-family: Gill Sans, Gill Sans MT, Myriad Pro, DejaVu Sans Condensed, Helvetica, Arial,' sans-serif'; font-size: 22px">Contact Us</a>
				</div>
				<div class="navbar-collapse collapse" id="myNavbar">
					<ul class="nav navbar-nav pull-right">
						<li class="dropdown"> <a href="#" class="dropdown-toggle active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> 
                                                <span class="glyphicon glyphicon-user"></span> Signed in as <%=name%><span class="caret"></span></a>
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
            <div class="pager">
         <% List data=(List)session.getAttribute("data");
           Iterator itr;
           %>
   
         <section id="pricing-table">
             <div class="container">
                 <div class="row">
                  <div class="pricing">
               <%
           for(itr=data.iterator();itr.hasNext();)
         {
           %>

                <div class="col-md-4 col-sm-12 col-xs-12">
                <div class="pricing-table">
                <div class="pricing-header">
                    <p class="pricing-title">Ratings</p>
                    <p class="pricing-rate"><%=itr.next()%><span class="glyphicon glyphicon-star"></span></p>
           <form action="ViewShopDetails">
               <button type="submit" class="btn btn-custom" style="color: black;" name="shop_id" value="<%=itr.next()%>"><%=itr.next()%></button>
                    </form>
                </div>
                    <div class="pricing-list">
                    <ul>
                        <li><span class="glyphicon glyphicon-earphone"> </span><b>Phone Number</b>&nbsp;<%=itr.next()%> </li>
                        <br>
                        <li><span class="glyphicon glyphicon-home"> </span><b>Address </b><%=itr.next()%> </li>
                </ul>
                    </div>
                </div>
                </div>
          <%
         }
%>
                 </div>
             </div>
             </div>
         </section>
            </div>
        </div>
         <div id="foot">
<footer>
<address>
<center><br> Department Of CSE, MITE <br>Database Management System Mini Project </cecnter>
</address>
	</footer>
	</div>
    </body>
</html>
