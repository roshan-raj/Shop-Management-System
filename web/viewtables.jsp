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
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
<title>Shopkeeper | View Products</title>
<link href="viewtables.css" rel="stylesheet" type="text/css">
</head>
            <%
                Integer shop_id=(Integer)request.getAttribute("shop_id");
   Iterator itr;
   List data=(List)request.getAttribute("query");
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
				</div>
				<div class="navbar-collapse collapse" id="myNavbar">
					<ul class="nav navbar-nav pull-right">
                
						<li class="dropdown"> <a href="#" class="dropdown-toggle active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> 
                                                <span class="glyphicon glyphicon-user"></span> Signed in as <%=shop_id%></a>
						</li>
						<li> <a href="tp.jsp"> <span class="glyphicon glyphicon-log-out"></span>Logout </a></li>
					</ul>
				</div>
		</nav>
	</div>
                                                 <div id="section1" class="container-fluid">
                                                <div class="container">
                                                    <div class="container jumbotron" style="opacity: 0.9;">
                                                    <h1 style="color: black; text-align: center;">Your Products</h1>
                                                
  
       <div class="container table-responsive table-striped">
      <div style="overflow-x: auto; overflow-y: auto;">
       <input type="text" id="myInput" onkeyup="searching()" placeholder="Search for Hardware name.." title="Type name">
   <table id="myTable">
       <tr>
           <th><h3>HARDWARE ID</h3></th>
               <th><h3>NAME</h3></th>
               <th><h3>STOCK</h3></th>
               <th><h3>PRICE</h3></th>
       </tr>
   <%
   for(itr=data.iterator();itr.hasNext();)
           {
            %>
            <tr>
                <td><h4><%=itr.next()%></h4></td>
            <td><h4><%=itr.next()%></h4></td>
            <td><h4><%=itr.next()%></h4></td>
            <td><h4>&#x20B9;<%=itr.next()%></h4></td>
            </tr>
            <% }
%>
   </table>
   <br>
   <%List updatedlist=(List)request.getAttribute("updated_list");
   Iterator itr1;
   if(updatedlist!=null)
   {
       %>
       <p>The updated list is</p>
       <table>
           <tr>
               <th><h3>HARDWARE ID</h3></th>
               <th><h3>NAME</h3></th>
               <th><h3>STOCK</h3></th>
               <th><h3>PRICE</h3></th>
           </tr>
           <%
               for(itr1=updatedlist.iterator();itr1.hasNext();)
               {
                   %>
                   <tr>
                       <td><%=itr1.next()%></td>
                       <td><%=itr1.next()%></td>
                       <td><%=itr1.next()%></td>
                       <td>&#x20B9;<%=itr1.next()%></td>
                   </tr>
                <%
               }
                %>
           
       </table>
      </div>
   </div>
<%       
   }
 %> 
 <form action="ViewtablesToShopkeeperJSP">
     <button class="round" type="submit" name="shop_id" value="<%=shop_id%>" style="width:8em; height: 3em; color: black;"><span class="glyphicon glyphicon-menu-left"></span></button>
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
</body>
<footer>
    <address>
<center><br> Department Of CSE, MITE <br>Database Management System Mini Project </center>
    </address>
</footer>
</html>
