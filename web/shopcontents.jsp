<%-- 
    Document   : shopcontents
    Created on : Nov 17, 2017, 9:19:18 PM
    Author     : Roshan Raj
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link href="shopcontents.css" rel="stylesheet" type="text/css">
        <script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
        <title>Store Items</title>
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
        <div class="container">
        <div class="container jumbotron" style="opacity: 0.9;">
              <h1 style="color: black; text-align: center;">Available Products</h1>
    <div style="overflow-x: auto; overflow-y: auto;">
       <input type="text" id="myInput" onkeyup="searching()" placeholder="Search for Hardware name.." title="Type name">

       <table id="myTable">
       <tr>
           <th>Name</th>
           <th>Stock</th>
           <th>Price</th>
           <th>Place Order</th>
       </tr>
             <%
   Iterator itr;
   int i=2;
   int j=3;
   int z=1;
   List hardware_list=(List)session.getAttribute("data1");	
         for(itr=hardware_list.iterator();itr.hasNext();)
         {
           %>
          <tr><form action="UpdateOrdersTable">
           <td width="119"><input type="hidden" name="tool" value="<%=itr.next()%>"><%=itr.next()%></td>
           <td width="119"><input type="number" min="1" name="stock" value="<%=itr.next()%>"></td>
          <td width="119"><input type="hidden" name="price" value="<%=hardware_list.get(j)%>"> &#8377 <%=itr.next()%></td>
          <td width="119"><button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-shopping-cart"></span> Buy Now </button> </td>
          </tr></form>
          <%
              i+=4;
              j+=4;
              z++;
         }
    %>
              </table>
          
    </div>
                                                    </div>
        </div>
    </div>
<div id="foot">
<footer>
<address>
<center><br> Department Of CSE, MITE <br>Database Management System Mini Project </cecnter>
</address>
</footer>
</div>
<script>
function searching() {
  var input, filter, table, tr, td, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
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
</html>
