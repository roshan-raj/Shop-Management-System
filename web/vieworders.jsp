<%-- 
    Document   : viewtables
    Created on : 6 Nov, 2017, 4:16:49 PM
    Author     : doodl
--%>

<%@page contentType="text/html" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!doctype html>
<html>
<head>
<style>.round {border-radius: 50%;}</style>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
<title>Shopkeeper | View Products</title>
<link href="viewtables.css" rel="stylesheet" type="text/css">
</head>
    <body bgcolor="beige" data-spy="scroll" data-target=".navbar" data-offset="50">
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
						<li> <a href="tp.jsp"> <span class="glyphicon glyphicon-log-out"></span>Logout </a></li>
					</ul>
				</div>
		</nav>
	</div>
            <%
   Iterator itr;
   List data=(List)request.getAttribute("orders");
   int i=0;
   %>
   <div id="section1" class="container-fluid">
       <div class="container">
                                                    <div class="container jumbotron" style="opacity: 0.9;">
                                                    <h1 style="color: black; text-align: center;">My Orders</h1>
      <div style="overflow-x: auto; overflow-y: auto;">
       <input type="text" id="myInput" onkeyup="searching()" placeholder="Search for Customer Id.." title="Type name">
   <table id="myTable">
       <tr>
           <th>Order ID</th>
           <th>Order Date</th>
           <th>Customer ID</th>
           <th>Hardware ID</th>
           <th>Email</th>
           <th>Phone Number</th>
           <th>Shop ID</th>
           <th>Quantity</th>
           <th>Amount</th>
           <th>Accept</th>
       </tr>
   <%
   for(itr=data.iterator();itr.hasNext();)
           {
            %>            

            <tr>
            <form action="TransferOrdersToPurchase">
            <td><input type="hidden" name="orderid" value="<%=data.get(i++)%>"><%=itr.next()%></td>
            <td><input type="hidden" name="orderdate" value="<%=data.get(i++)%>"><%=itr.next()%></td>
            <td><input type="hidden" name="customerid" value="<%=data.get(i++)%>"><%=itr.next()%></td>
            <td><input type="hidden" name="hardwareid" value="<%=data.get(i++)%>"><%=itr.next()%></td>
            <td><input type="hidden" name="email" value="<%=data.get(i++)%>"><%=itr.next()%></td>
            <td><input type="hidden" name="phoneno" value="<%=data.get(i++)%>"><%=itr.next()%></td>
            <td><input type="hidden" name="shopid" value="<%=data.get(i++)%>"><%=itr.next()%></td>
            <td><input type="hidden" name="quantity" value="<%=data.get(i++)%>"><%=itr.next()%></td>
            <td><input type="hidden" name="amount" value="<%=data.get(i++)%>">&#x20B9;<%=itr.next()%></td>
            <td><button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-ok"></span></button></td>
            </form>
            </tr>     
            <% }
%>
   </table>
</div>
<% 
    int shop_id=Integer.parseInt(request.getParameter("shop_id"));
    %>
    <form action="ViewtablesToShopkeeperJSP">
        <br />
        <button class="btn btn-primary" type="submit" name="shop_id" value="<%=shop_id%>"><span class="glyphicon glyphicon-menu-left"></span></button>
 </form>
                                                    </div>
       </div>
   </div>
   <script>
function searching() {
  var input, filter, table, tr, td, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[2];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}
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
