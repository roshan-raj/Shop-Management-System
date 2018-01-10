<%-- 
    Document   : viewitemstobedeleted
    Created on : 23 Nov, 2017, 10:03:50 PM
    Author     : doodl
--%>

<%@page contentType="text/html" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
<title>Shopkeeper | View Products</title>
<link href="viewitemstobeedited.css" rel="stylesheet" type="text/css">
</head>

            <body  bgcolor="beige" data-spy="scroll" data-target=".navbar" data-offset="50">
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
                //Integer shop_id=(Integer)session.getAttribute("shop_id");
   Iterator itr;
   List data=(List)request.getAttribute("list");
   int i=2;
   int j=2;
   %>
                    <div id="section1" class="container-fluid">
                                                <div class="container">
                                                    <div class="container jumbotron" style="opacity: 0.9;">
                                                    <h1 style="color: black; text-align: center;">Edit Your Products</h1>
       <div class="container table-responsive table-striped">
                                                    <div style="overflow-x: auto; overflow-y: auto;">
       <input type="text" id="myInput" onkeyup="searching()" placeholder="Search for Hardware name.." title="Type name">
       <% 
           if((Integer)session.getAttribute("status")==1)
       {
           %>
           <table id="myTable">
       <tr>
           <th><h4>STOCK</h4></th>
           <th><h4>NAME</h4></th>
           <th><h4>HARDWARE_ID</h4></th>
           <th><h4>EDIT</h4></th>
       </tr>
           <%
               for(itr=data.iterator();itr.hasNext();)
               {
                   %>
                   
                   
                    <tr>
                       <form action="UpdateStockPrice" method="get">
            <td><input type="number" name="stockorprice" value="<%=itr.next()%>" min="10"></td>
            <td><%=itr.next()%></td>
            <td><input type="hidden" name="hardware_id" value="<%=data.get(i)%>"><%=itr.next()%></td>
            <td><input type="submit" value="Change"></td>
             </form>
            </tr>
                  
                 <% 
                     i+=3;
               }
               %>
           </table>
                                                    </div>
               <%
       }
%>
<% 
           if((Integer)session.getAttribute("status")==2)
       {
           %>
           <table id="myTable">
       <tr>
           <th><h4>STOCK</h4></th>
           <th><h4>NAME</h4></th>
           <th><h4>HARDWARE_ID</h4></th>
           <th><h4>EDIT</h4></th>
       </tr>
           <%
               for(itr=data.iterator();itr.hasNext();)
               {
                   %>
                  <tr>
                       <form action="UpdateStockPrice" method="get">
            <td><input type="number" name="stockorprice" value="<%=itr.next()%>" min="10"></td>
            <td><%=itr.next()%></td>
            <td><input type="hidden" name="hardware_id" value="<%=data.get(j)%>"><%=itr.next()%></td>
            <td><input type="submit" value="Change"></td>
             </form>
            </tr>
                 <%
                     j+=3;
               }
               %>
           </table>
               <%
       }
%>
      </div>
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
    td = tr[i].getElementsByTagName("td")[1];
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
<h1 style="color: white;"><%=(Integer)session.getAttribute("status")%></h1>
       <div id="foot">
<footer>
<address>
<center><br> Department Of CSE, MITE <br>Database Management System Mini Project </cecnter>
</address>
</footer>
</div>
    </body>
</html>
