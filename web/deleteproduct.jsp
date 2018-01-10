<%-- 
    Document   : deleteproduct
    Created on : Nov 19, 2017, 7:51:50 PM
    Author     : Roshan Raj
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
        <link href="viewtables.css" rel="stylesheet" type="text/css">
        <title>Delete Products</title>
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
<div id="section1" class="container-fluid">
        <% 
            int shop_id=Integer.parseInt((String)request.getAttribute("shop_id"));
            List ls=(List)request.getAttribute("ls");
            Iterator itr;
            int i=0;
        %>
        <form action="DeleteHardware" method="post">
            <div class="container">
                                                    <div class="container jumbotron" style="opacity: 0.9;">
                                                    <h1 style="color: black; text-align: center;">Delete Products</h1>
       <div class="container table-responsive table-striped">
<div style="overflow-x: auto; overflow-y: auto;">
       <input type="text" id="myInput" onkeyup="searching()" placeholder="Search for Hardware name.." title="Type name">
   <table id="myTable">
            <tr>
                <th><h4>HARDWARE_ID</h4></th>
                <th><h4>NAME</h4></th>
            </tr>
            <%
                for(itr=ls.iterator();itr.hasNext();i+=2)
                {
                    %>
                    <tr>
                        <td><input type="checkbox" name="tools" value="<%=ls.get(i)%>"> &nbsp;<%=itr.next()%></td>
                        <td><%=itr.next()%></label></td>
                    </tr>
               <%
                   
                }
%>
        </table>
</div>
        <br />
<button type="submit" class="btn btn-danger" name="shop_id" value="<%=shop_id%>">DELETE</button>
        </form>
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
    </body>
    <div id="foot">
<footer>
<address>
<center><br> Department Of CSE, MITE <br>Database Management System Mini Project </center>
</address>
</footer>
</div>
</html>